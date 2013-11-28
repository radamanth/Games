<html>
<head>
    <title>RadaDiceRoller</title>

    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link rel="shortcut icon" href="images/d20.ico" />
    <link rel="stylesheet" href="scripts/libs/jquery.mobile-1.3.2.min.css" />

    <script src="scripts/libs/jquery-1.10.2.js" ></script>
    <script src="scripts/libs/jquery.mobile-1.3.2.js"></script>
    <script src="scripts/libs/knockout-3.0.0.debug.js"></script>
    <script src="scripts/cypher.js"></script>

</head>

<body>
<div data-role="page" id="home" data-theme="a" data-mini="true">
    <div data-role="header">
        <h1>Rada Cypher</h1>
    </div><!-- /header -->
    

    <div data-role="content">
        <form id="cryptoform" name="cryptoform" method="post">
 				<label for="idSourceContent" data-theme="a">Source :</label>
                <textarea id="idSourceContent" name="SourceContentName" placeholder="Paste content here" data-bind="value: src"></textarea>
                <label for="idKey" data-theme="a" >clef de cryptage (X/Y/Z) :</label>
                <input type="text" data-bind=" value: key" placeholder="Ex : 17/13/24" data-theme="a" />
                <label for="idPercent" data-theme="a" >Nombre de roll :</label>
				<input type="range" id="idPercent" data-bind="value: percentage" min="0"  max="100" data-theme="a" />
            
        </form>
        <div data-role="controlgroup" data-mini="true">
            <a href="#" id="btnCypher" data-theme="a" data-role="button" data-bind="click: cypher">Cypher!</a>
            <a href="#" id="btnDeCypher" data-theme="a" data-role="button" data-bind="click: decypher">Decipher</a>
        </div>
        <div id="resultPanel" data-bind="text: res">
        	
        </div>

    </div><!-- /content -->
</div><!--  page home -->

</body>
</html>
