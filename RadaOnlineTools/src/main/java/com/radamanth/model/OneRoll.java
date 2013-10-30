package com.radamanth.model;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: radamanth
 * Date: 25/10/13
 * Time: 21:15
 * To change this template use File | Settings | File Templates.
 */

@XmlRootElement
@JsonAutoDetect
public class OneRoll {
    private Integer nbRoll = 1;

    private String dice = "";

    private String comment = "";

    private ArrayList<Integer> results = new ArrayList<Integer>();
	// produce a wrapper XML element around this collection
	@XmlElementWrapper(name="resutlsList")
	// map each member of this list to an XML element named appointment
	@XmlElement(name="results")
    public ArrayList<Integer> getResults() {
        return results;
    }

    public void setResults(ArrayList<Integer> results) {
        this.results = results;
    }

    public Integer getNbRoll() {
        return nbRoll;
    }

    public void setNbRoll(Integer nbRoll) {
        this.nbRoll = nbRoll;
    }

    public String getDice() {
        return dice;
    }

    public void setDice(String dice) {
        this.dice = dice;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
