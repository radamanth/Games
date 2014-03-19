<html>
<head>
    <%@ include file="common.jsp" %>
         
    <script src="scripts/diceRoller.js"></script>
    

</head>

<body>
<div data-role="page" id="dice" data-theme="b" data-mini="true">
    <div data-role="header">
        <h1>Rada Dice Roller</h1>
        <a href="cypher.jsp" data-ajax="false" class="ui-btn ui-shadow ui-corner-all">Cypher</a>
    </div><!-- /header -->
    <div data-role="panel" id="mailPanel" data-position="left" data-display="overlay"  data-theme="b" data-visible="true">
        <div class="panel-content">
            <label for="idAuthor" data-theme="b">Auteur</label>
            <input id="idAuthor" type="email" data-bind="value: author" data-theme="b" />
            <label for="idDest1" data-theme="b">Destinataire 1</label>
            <input id="idDest1" type="email" data-bind="value: dest1"   data-theme="b" />
            <label for="idDest2" data-theme="b">Destinataire 2</label>
            <input id="idDest2" type="email" data-bind="value: dest2"   data-theme="b" />
            <label for="idDest3" data-theme="b">Destinataire 3</label>
            <input id="idDest3" type="email" data-bind="value: dest3"   data-theme="b" />
            <label for="idDest4" data-theme="b">Destinataire 4</label>
            <input id="idDest4" type="email" data-bind="value: dest4"   data-theme="b" />
            <label for="idDest5" data-theme="b">Destinataire 5</label>
            <input id="idDest5" type="email" data-bind="value: dest5"   data-theme="b" />
            <a href="#checkMailPopup" id="checkMailButton" data-theme="b" data-role="button" data-rel="popup" data-position-to="window" data-mini="true" >Check Mail</a>
            <a href="#mailPanel" data-theme="b" data-role="button" data-mini="true" >Close</a>
            <div data-role="popup" id="checkMailPopup" data-overlay-theme="a" data-theme="b" data-corners="false" data-tolerance="15,15">
                <label for="idMailContent" data-theme="b">Message</label>
                <textarea id="idMailContent" name="mailContentName" placeholder="Paste mail content here" data-bind="value: verifyMail().mailContent"></textarea>
                <label for="idMailKey" data-theme="b">Key</label>
                <input id="idMailKey" type="text" placeholder="Paste key here" data-bind="value: verifyMail().key"/>
                <span data-bind="text: verifyMail().resultMessage"></span>
                <a href="#" id="btnCheckMail" data-theme="b" data-role="button" data-bind="click: checkMailContent" data-mini="true">Check!</a>
				<a href="#"  data-theme="b" data-role="button" data-rel="back"  data-mini="true" >Close</a>
            </div>
        </div>   <!-- Panel content -->
    </div>   <!-- MailPanel-->

    <div data-role="panel" id="resultsPanel" data-position="right" data-display="overlay" data-swipe-close="true" data-theme="b" >
        <div class="panel-content">
            <h3>Résultats</h3>
            <!-- ko  if: roll1().rollData().results().length -->
	            <div data-bind="with: roll1 " >
	                <h4><span data-bind="  text: title"></span></h4>
	                <h5><span data-bind="  text: rollData().nbRoll"></span> roll(s) de <span data-bind="  text: rollData().dice"></span></h5>
	                <h5><span data-bind="  text: rollData().comment"></span></h5>
	                <ul data-role="listview" data-theme="b"  data-bind=" foreach: rollData().results">
	                    <li data-bind="text: $data"></li>
	                </ul>
	            </div>
            <!-- /ko -->
            <!-- ko  if: roll2().rollData().results().length -->
            <div data-bind="with: roll2">
                <h4><span data-bind="  text: title"></span></h4>
                <h5><span data-bind="  text: rollData().nbRoll"></span> roll(s) de <span data-bind="  text: rollData().dice"></span></h5>
                <h5><span data-bind="  text: rollData().comment"></span></h5>
                <ul data-role="listview" data-theme="b" id="res2" data-bind=" foreach: rollData().results">
                    <li data-bind="text: $data"></li>
                </ul>
            </div>
            <!-- /ko -->
            <!-- ko  if: roll3().rollData().results().length -->
            <div data-bind="with: roll3">
                <h4><span data-bind="  text: title"></span></h4>
                <h5><span data-bind="  text: rollData().nbRoll"></span> roll(s) de <span data-bind="  text: rollData().dice"></span></h5>
                <h5><span data-bind="  text: rollData().comment"></span></h5>
                <ul data-role="listview" data-theme="b" id="res3" data-bind=" foreach: rollData().results">
                    <li data-bind="text: $data"></li>
                </ul>
            </div>
            <!-- /ko -->
            <!-- ko  if: roll4().rollData().results().length -->
            <div data-bind="with: roll4">
                <h4><span data-bind="  text: title"></span></h4>
                <h5><span data-bind="  text: rollData().nbRoll"></span> roll(s) de <span data-bind="  text: rollData().dice"></span></h5>
                <h5><span data-bind="  text: rollData().comment"></span></h5>
                <ul data-role="listview" data-theme="b" id="res4" data-bind=" foreach: rollData().results">
                    <li data-bind="text: $data"></li>
                </ul>
            </div>
            <!-- /ko -->
            <!-- ko  if: roll5().rollData().results().length -->
            <div data-bind="with: roll5">
                <h4><span data-bind="  text: title"></span></h4>
                <h5><span data-bind="  text: rollData().nbRoll"></span> roll(s) de <span data-bind="  text: rollData().dice"></span></h5>
                <h5><span data-bind="  text: rollData().comment"></span></h5>
                <ul data-role="listview" data-theme="b"  data-bind=" foreach: rollData().results">
                    <li data-bind="text: $data"></li>
                </ul>
            </div>
            <!-- /ko -->

        </div><!-- /content wrapper for padding -->
    </div><!-- /resultsPanel -->

    <div data-role="content">
        <form id="diceRollForm" name="diceRollForm" method="post">

            <div id="diceSet" data-role="collapsible-set" data-theme="b" data-content-theme="b" data-mini="true"  >

                <div data-role="collapsible" data-collapsed="false" data-theme="b" data-bind="with: roll1">
                    <h3><span data-bind="text: title"></span></h3>
                    <fieldset>
                        <label data-bind="attr: {for: nbRollsId}" data-theme="b" >Nombre de roll :</label>
                        <input type="number" data-bind="attr: {name: nbRollsName, id: nbRollsId}, value: rollData().nbRoll" min="0"  max="20" data-theme="b" />

                        <label data-bind="attr :{for: rollId}" data-theme="b">Roll :</label>
                        <input type="text" data-bind="attr : {name: rollName, id: rollId, pattern: rollPattern}, value: rollData().dice" placeholder="Ex : 3D6+12R1B2"   data-theme="b" />

                        <label data-bind="attr : {for: rollTitleId}" data-theme="b">Titre du roll : </label>
                        <input type="text" data-bind="attr {name: rollTitleName, id: rollTitleId}, value: rollData().comment " data-theme="b"  />
                        
<!--                         <div data-role="collapsible" data-collapsed="false" data-theme="b" >
                            <h5>Results</h5>
                            <ul data-role="listview" data-theme="b" data-mini="true" data-bind="foreach: rollData().results">
                                <li data-mini="true" data-bind="text: $data"></li>
                            </ul>
                        </div>
 -->                        
                    </fieldset>
                </div>
                <div data-role="collapsible" data-collapsed="true" data-theme="b" data-bind="with: roll2">
                    <h3><span data-bind="text: title"></span></h3>
                    <fieldset>
                        <label data-bind="attr: {for: nbRollsId}" data-theme="b" >Nombre de roll :</label>
                        <input type="number" data-bind="attr: {name: nbRollsName, id: nbRollsId}, value: rollData().nbRoll" min="0"  max="20" data-theme="b" />

                        <label data-bind="attr :{for: rollId}" data-theme="b">Roll :</label>
                        <input type="text" data-bind="attr : {name: rollName, id: rollId, pattern: rollPattern}, value: rollData().dice" placeholder="Ex : 3D6+12R1B2"   data-theme="b" />

                        <label data-bind="attr : {for: rollTitleId}" data-theme="b">Titre du roll : </label>
                        <input type="text" data-bind="attr {name: rollTitleName, id: rollTitleId}, value: rollData().comment " data-theme="b"  />
    <!--                     <div data-role="collapsible" data-collapsed="true" data-theme="b" >
                            <h1>results</h1>
                            <ul data-role="listview" data-theme="b"  data-bind="foreach: rollData().results">
                                <li data-bind="text: $data"></li>
                            </ul>
                        </div> -->
                    </fieldset>
                </div>
                <div data-role="collapsible" data-collapsed="true" data-theme="b" data-bind="with: roll3">
                    <h3><span data-bind="text: title"></span></h3>
                    <fieldset>
                        <label data-bind="attr: {for: nbRollsId}" data-theme="b" >Nombre de roll :</label>
                        <input type="number" data-bind="attr: {name: nbRollsName, id: nbRollsId}, value: rollData().nbRoll" min="0"  max="20" data-theme="b" />

                        <label data-bind="attr :{for: rollId}" data-theme="b">Roll :</label>
                        <input type="text" data-bind="attr : {name: rollName, id: rollId, pattern: rollPattern}, value: rollData().dice" placeholder="Ex : 3D6+12R1B2"   data-theme="b" />

                        <label data-bind="attr : {for: rollTitleId}" data-theme="b">Titre du roll : </label>
                        <input type="text" data-bind="attr {name: rollTitleName, id: rollTitleId}, value: rollData().comment " data-theme="b"  />
                        <!-- <div data-role="collapsible" data-collapsed="true" data-theme="b" >
                            <h1>results</h1>
                            <ul data-role="listview" data-theme="b"  data-bind="foreach: rollData().results">
                                <li data-bind="text: $data"></li>
                            </ul>
                        </div> -->
                    </fieldset>
                </div>
                <div data-role="collapsible" data-collapsed="true" data-theme="b" data-bind="with: roll4">
                    <h3><span data-bind="text: title"></span></h3>
                    <fieldset>
                        <label data-bind="attr: {for: nbRollsId}" data-theme="b" >Nombre de roll :</label>
                        <input type="number" data-bind="attr: {name: nbRollsName, id: nbRollsId}, value: rollData().nbRoll" min="0"  max="20" data-theme="b" />

                        <label data-bind="attr :{for: rollId}" data-theme="b">Roll :</label>
                        <input type="text" data-bind="attr : {name: rollName, id: rollId, pattern: rollPattern}, value: rollData().dice" placeholder="Ex : 3D6+12R1B2"   data-theme="b" />

                        <label data-bind="attr : {for: rollTitleId}" data-theme="b">Titre du roll : </label>
                        <input type="text" data-bind="attr {name: rollTitleName, id: rollTitleId}, value: rollData().comment " data-theme="b"  />
                        <!-- <div data-role="collapsible" data-collapsed="true" data-theme="b" >
                            <h1>results</h1>
                            <ul data-role="listview" data-theme="b"  data-bind="foreach: rollData().results">
                                <li data-bind="text: $data"></li>
                            </ul>
                        </div> -->
                    </fieldset>
                </div>
                <div data-role="collapsible" data-collapsed="true" data-theme="b" data-bind="with: roll5" >
                    <h3><span data-bind="text: title"></span></h3>
                    <fieldset>
                        <label data-bind="attr: {for: nbRollsId}" data-theme="b" >Nombre de roll :</label>
                        <input type="number" data-bind="attr: {name: nbRollsName, id: nbRollsId}, value: rollData().nbRoll" min="0"  max="20" data-theme="b" />

                        <label data-bind="attr :{for: rollId}" data-theme="b">Roll :</label>
                        <input type="text" data-bind="attr : {name: rollName, id: rollId, pattern: rollPattern}, value: rollData().dice" placeholder="Ex : 3D6+12R1B2"   data-theme="b" />

                        <label data-bind="attr : {for: rollTitleId}" data-theme="b">Titre du roll : </label>
                        <input type="text" data-bind="attr {name: rollTitleName, id: rollTitleId}, value: rollData().comment " data-theme="b"  />
                       <!--  <div data-role="collapsible" data-collapsed="true" data-theme="b" >
                            <h1>results</h1>
                            <ul data-role="listview" data-theme="b"  data-bind="foreach: rollData().results">
                                <li data-bind="text: $data"></li>
                            </ul>
                        </div> -->
                    </fieldset>
                </div>
            </div>
        </form>
        <div data-role="controlgroup" data-mini="true">
        	<legend>Display results ? </legend>
			<input type="checkbox" name="displayresult" id="displayresult"   data-bind="checked: mailOnly" data-theme="b"/>
			<label for="displayresult">No I don't want to know ! </label>
            <a href="#" id="btnRoll" data-theme="b" data-role="button" data-bind="click: rollthedice">Roll the Dice !</a>
            <a href="#resultsPanel" data-theme="b" data-role="button">Open results</a>
            <a href="#mailPanel" data-theme="b" data-role="button">Open mail</a>
        </div>

    </div><!-- /content -->
</div><!--  page dice -->


</body>
</html>
