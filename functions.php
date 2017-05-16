<?php
require("../../../config.php");
//functions.php

$database = "if16_ALARI_VEREV";
$mysqli = new mysqli( $serverHost, $serverUsername, $serverPassword, $database);

require("worker.class.php");
$Worker = new Worker($mysqli);

require("admin.class.php");
$Admin = new Admin($mysqli);

session_start();

?>