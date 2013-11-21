<html>
<head>
    <title>RadaDiceRoller</title>

    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link rel="shortcut icon" href="images/d20.ico" />
    <link rel="stylesheet" href="scripts/libs/jquery.mobile-1.3.2.min.css" />

    <script src="scripts/libs/jquery-1.10.2.min.js" ></script>
    <script src="scripts/libs/jquery.mobile-1.3.2.min.js"></script>
    <script src="scripts/libs/knockout-3.0.0.js"></script>
    <script src="scripts/cypher.js"></script>

</head>

<body>
<div data-role="page" id="home" data-theme="a" data-mini="true">
    <div data-role="header">
        <h1>Rada Cypher</h1>
    </div><!-- /header -->
    

    <div data-role="content">
        <form id="cryptoform" name="cryptoform" method="post">

            
        </form>
        <div data-role="controlgroup" data-mini="true">
            <a href="#" id="btnCypher" data-theme="a" data-role="button" data-bind="click: cypher">Cypher!</a>
            <a href="#" data-theme="a" data-role="button">Decipher</a>
            <a href="#" data-theme="a" data-role="button">Open mail</a>
        </div>

    </div><!-- /content -->
</div><!--  page home -->

</body>
</html>
