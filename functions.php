<?php
	require_once("kristel/config.php");
	session_start();

	$database = "if16_krisr12_uus";
	$mysqli = new mysqli ($serverHost, $serverUsername, $serverPassword, $database);

	function saveBus($busline, $departuredate, $departuretime) {

		$mysqli = new mysqli($GLOBALS["serverHost"], $GLOBALS["serverUsername"],  $GLOBALS["serverPassword"],  $GLOBALS["database"]);
		$stmt = $mysqli->prepare("INSERT INTO bustimes (busline, departuredate, departuretime) VALUES (?, ?, ?)");
		echo $mysqli->error;

		$stmt->bind_param("sss", $busline, $departuredate, $departuretime );
		if ( $stmt->execute() ) {
			echo "salvestamine �nnestus";
		} else {
			echo "ERROR ".$stmt->error;
		}

	}

	function getAllData() {

		$mysqli = new mysqli($GLOBALS["serverHost"], $GLOBALS["serverUsername"],  $GLOBALS["serverPassword"],  $GLOBALS["database"]);
		$stmt = $mysqli->prepare("
			SELECT id, busline, departuredate, departuretime, busdriver
			FROM bustimes WHERE deleted IS NULL
		");

		$stmt->bind_result($id, $busline, $departuredate, $departuretime, $busdriver);
		$stmt->execute();

		$result = array();

		// ts�kkel t��tab seni, kuni saab uue rea AB'i
		// nii mitu korda palju SELECT lausega tuli
		while ($stmt->fetch()) {
			//echo $note."<br>";

			$object = new StdClass();
			$object->id = $id;
			$object->busline = $busline;
			$object->departuredate = $departuredate;
			$object->departuretime = $departuretime;
			$object->busdriver = $busdriver;


			array_push($result, $object);

		}

		return $result;

	}

	function cleanInput ($input) {

		// "   tere tulemast    "
		$input = trim($input);
		// "tere tulemast"

		// "tere \\tulemast"
		$input = stripslashes($input);
		// "tere tulemast"

		// "<"
		$input = htmlspecialchars($input);
		// "&lt;"

		return $input;
	}
?>
