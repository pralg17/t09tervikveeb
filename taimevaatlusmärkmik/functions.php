<?php 

	require("/home/joosjuha/config.php");
	
	// see fail peab olema siis seotud k�igiga kusb
	// tahame sessiooni kasutada
	// saab kasutada n��d $_SESSION muutujat
	session_start();
	
	$database = "if16_jsander";
    $mysqli = new mysqli($serverHost, $serverUsername, $serverPassword, $database);

?>