package com.radamanth.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.WebApplicationContext;

import com.radamanth.cryptotron.Cryptotron;
import com.radamanth.dice.DiceRoller;
import com.radamanth.model.CryptotronBean;
import com.radamanth.model.OneRoll;
import com.radamanth.model.RollTheDiceFormBean;
import com.radamanth.model.VerifyMailBean;
import com.radamanth.security.HMAC;
import com.radamanth.service.IRadaDiceService;
import com.radamanth.utils.StringUtils;

/**
 * Classe de service de lancement de dés
 */
@Service
public class RadaDiceService implements IRadaDiceService  {

    /**
	 * 
	 */
	private static final String GEN_DIRECTORY = "gen";
	/**
	 * 
	 */
	private static final String HMAC_SHA1 = "HmacSHA1";
	/**
	 * 
	 */
	private static final String SEC_KEY = "This is my fucking great 1st key!";
	private static final Logger logger = Logger.getLogger(RadaDiceService.class.getName());
    public static final String END_OF_MAIL = "==END==";
    public static final String START_OF_MAIL = "==START==\n";
    
    @Autowired
	MailSender mailSender;
	
	@Autowired
    private SimpleMailMessage preConfiguredMessage;
	
	
	@Autowired
	private WebApplicationContext webAppCtx;
	
	
	
    /**
     *
     * @param dicePattern
     * @return
     * @throws IllegalArgumentException
     */
	@Override
	public int rollTheDice(String dicePattern) throws IllegalArgumentException {
		return DiceRoller.rollDice(dicePattern);
	}

	@Override
	public RollTheDiceFormBean rollTheRoller(RollTheDiceFormBean request)
			throws IllegalArgumentException {
		if (request == null)
			throw new IllegalArgumentException(
					"les données d'entrée ne peuvent être nulle.");
		RollTheDiceFormBean results = request;
		List<OneRoll> rolls = request.getRequestedRoll();
		results.setRequestedRoll(new ArrayList<OneRoll>());		
        for (OneRoll one:rolls) {
			OneRoll oneres = new OneRoll();
			
            String dice = one.getDice();
            Integer nb = one.getNbRoll();
            ArrayList<Integer> res = new ArrayList<Integer>();
            if (nb == null )
                nb = 1;
            if (DiceRoller.DICE_PATTERN.matcher(dice).matches()) {
                for (int i = 0; i < nb; i++) {
                    res.add(DiceRoller.rollDice(dice));
                }
            }
			oneres.setResults(res);
			oneres.setDice(dice);
			oneres.setNbRoll(nb);
			oneres.setComment(one.getComment());
			results.getRequestedRoll().add(oneres);
        }
        
        if (results.getAuthor() != null && StringUtils.isEmail(results.getAuthor()) )  {
        	SimpleMailMessage message = new SimpleMailMessage(preConfiguredMessage);
        	StringBuffer text = new StringBuffer();
        	text.append(START_OF_MAIL);
        	for (OneRoll one : results.getRequestedRoll() ) {
        		text.append("Roll : " +one.getComment() +"\n");
        		text.append("NB : " + one.getNbRoll() );
        		text.append(" : " );
        		text.append(one.getDice());
        		text.append("\n");
        		for (Integer i : one.getResults())
        			text.append(i + " /");
        		text.append("\n\n\n");
        		
        	}
        	text.append(END_OF_MAIL);
        	String digest = HMAC.hmacDigest(text.toString(), SEC_KEY, HMAC_SHA1);
        	text.append("\n"+digest);
        	message.setText(text.toString()); 
        	message.setTo(results.getAuthor());
        	
        	List<String> ccTab = new ArrayList<String>();
        	
        	String cc= results.getDest1();
        	if(cc != null && StringUtils.isEmail(cc)  ) {
        		ccTab.add(cc);
        	}
        	cc= results.getDest2();
        	if(cc != null && StringUtils.isEmail(cc)  ) {
        		ccTab.add(cc);
        	}
        	cc= results.getDest3();
        	if(cc != null && StringUtils.isEmail(cc)  ) {
        		ccTab.add(cc);
        	}
        	cc= results.getDest4();
        	if(cc != null && StringUtils.isEmail(cc)  ) {
        		ccTab.add(cc);
        	}
        	cc= results.getDest5();
        	if(cc != null && StringUtils.isEmail(cc)  ) {
        		ccTab.add(cc);
        	}
        	if (!CollectionUtils.isEmpty(ccTab))
        		message.setCc(ccTab.toArray(new String[ccTab.size()]));
        	logger.info("Sending mail to : " + message.getTo() + " cc: " +message.getCc());
        	mailSender.send(message);
        		
        	
        }
		return results;
	}



	@Override
    @Produces("text/plain; charset=UTF-8")
    public String usage() {
		
		return DiceRoller.usage("");
	}

	/**
	 * @see com.radamanth.service.IRadaDiceService#verifyMail(com.radamanth.model.VerifyMailBean)
	 */
	@Override
	public VerifyMailBean verifyMail(VerifyMailBean mail)
			throws IllegalArgumentException {
		if (mail == null)
			return null;
		if (StringUtils.isEmpty(mail.getMailContent())) 
			throw new IllegalArgumentException("Le mail à vérifier doit avoir du contenu");
		if (StringUtils.isEmpty(mail.getKey())) 
			throw new IllegalArgumentException("Le mail à vérifier doit avoir une clef de comparaison");
		String res = HMAC.hmacDigest(mail.getMailContent(), SEC_KEY, HMAC_SHA1);
		if (mail.getKey().compareTo(res) == 0) {
			mail.setResult(true);
			mail.setResultMessage("Message valide.");
		} else {
			mail.setResult(false);
			mail.setResultMessage("Mmmm ça sent la gruge ici !!!!");
		}
				
		return mail;
	}

	/** 
	 * @see com.radamanth.service.IRadaDiceService#cryptotron(com.radamanth.model.CryptotronBean)
	 */
	@Override
	public CryptotronBean cryptotron(CryptotronBean request)
			throws IllegalArgumentException {
		if (request == null)
			return null;
		if (request.getSrc()== null || request.getSrc().isEmpty() )
			return request;
		
		List<Integer> caesar = new ArrayList<>();
		for (int i :request.getKey())
			caesar.add(i);
		Cryptotron crypto = new Cryptotron(request.getSrc(),Cryptotron.CryptModeEnum.valueOf(request.getMode().name()), request.getPercentage(), caesar );
		String result = crypto.cypher();
		request.setRes(result);
		
		String fileName = generateResultFile(result);
		
		request.setFileRelativePath(fileName);
		return request;
		
	}

	/**
	 *  Génère le fichier à télécharger.
	 */
	private String generateResultFile(String content)  {
		
		BufferedWriter bw = null;
		try {
			if (content == null || webAppCtx == null) 
				return null;
			String realDirectoryPath = webAppCtx.getServletContext().getRealPath(GEN_DIRECTORY);
			if (realDirectoryPath == null) 
				return null;
			File directoryFile = new File(realDirectoryPath);
			
			if (directoryFile != null && (directoryFile.exists() || directoryFile.mkdirs() ) ) {
				String fileName = GEN_DIRECTORY+"/cypher-"+System.currentTimeMillis()+".txt";
				String realPath = webAppCtx.getServletContext().getRealPath(fileName);
				File file = new File(realPath);
				if (!file.exists())
					file.createNewFile();
				FileOutputStream fos = new FileOutputStream(file);
				bw = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8") );
				
				bw.write(content);
				bw.flush();
				bw.close();
				return fileName;
			} 
			
			
			
			
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erreur lors de la génération du fichier de sortie.", e);
		} finally {
			if (bw != null)
				try {
					bw.close();
				} catch (IOException e) {
					logger.log(Level.SEVERE, "Erreur lors de la génération du fichier de sortie.", e);
				}
		}
		return null;
	}

	
	
	

}
