<html>
<head>
    <title>RadaDiceRoller</title>

    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <meta charset="UTF-8" />
    <link rel="shortcut icon" href="images/d20.ico" />
    <link rel="stylesheet" href="scripts/libs/jquery.mobile-1.4.2.min.css" />

    <script src="scripts/libs/jquery-1.10.2.min.js" ></script>
    <script src="scripts/libs/jquery.mobile-1.4.2.min.js"></script>
    <script src="scripts/libs/knockout-3.0.0.js"></script>
    <script src="scripts/cypher.js"></script>

</head>

<body>
<div data-role="page" id="home" data-theme="b" data-mini="true">
    <div data-role="header">
        <h1>Rada Cypher</h1>
    </div><!-- /header -->
    

    <div data-role="content">
        <form id="cryptoform" name="cryptoform" method="post" data-with="">
 				<label for="idSourceContent" data-theme="b">Source :</label>
                <textarea id="idSourceContent" name="SourceContentName" placeholder="Paste content here" data-bind="value: data().src"></textarea>
                <label for="idKey" data-theme="b" >clef de cryptage (X/Y/Z) :</label>
                <input type="text" data-bind=" value: data().key" pattern="/^[1-9]{1}[0-9]*([/]{1}[1-9]{1}[0-9]*)*$/g" placeholder="Ex : 17/13/24" data-theme="b" />
                <label for="idPercent" data-theme="b" >Pourcentage Cryptage :</label>
				<input type="range" id="idPercent" data-bind="value: data().percentage" min="0"  max="100" data-theme="b" />
				<label for="idResContent" data-theme="b">Résultat : </label>
				<textarea id="idResContent" name="ResContentName" data-bind="value: data().res" readonly="readonly"></textarea>
				<!-- ko  if: data().fileRelativePath -->
            	<a data-bind="attr : {href: data().fileRelativePath}" download>Download txt</a>
            	<!-- /ko -->
        </form>
        <div data-role="controlgroup" data-mini="true">
        	<a href="#" id="btnCypher" data-theme="b" data-role="button" data-bind="click: cypher">Cypher!</a>
            <a href="#" id="btnDeCypher" data-theme="b" data-role="button" data-bind="click: decypher">Decipher</a>
        </div>
        
    </div><!-- /content -->
</div><!--  page home -->

</body>
<iframe id="dldiv" style="display:none"></iframe>
</html>
