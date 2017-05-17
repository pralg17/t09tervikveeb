<?php

 	require_once("kristel/config.php");

 	$database = "if16_krisr12_uus";

 	function getSingleNoteData($edit_id){

 		//echo "id on ".$edit_id;

 		$mysqli = new mysqli($GLOBALS["serverHost"], $GLOBALS["serverUsername"], $GLOBALS["serverPassword"], $GLOBALS["database"]);

 		$stmt = $mysqli->prepare("SELECT busline, departuredate, departuretime FROM bustimes WHERE id=? AND deleted IS NULL");

 		$stmt->bind_param("i", $edit_id);
 		$stmt->bind_result( $busline, $departuredate, $departuretime);
 		$stmt->execute();

 		//tekitan objekti
 		$n = new Stdclass();

 		//saime �he rea andmeid
 		if($stmt->fetch()){
 			// saan siin alles kasutada bind_result muutujaid
 			$n->busline = $busline;
 			$n->departuredate = $departuredate;
			$n->departuretime = $departuretime;


 		}else{
 			// ei saanud rida andmeid k�tte
 			// sellist id'd ei ole olemas
 			// see rida v�ib olla kustutatud
 			//header("Location: page.php");
 			//exit();
 		}

 		$stmt->close();
 		$mysqli->close();

 		return $n;

 	}


 	function updateNote($id, $busline, $departuredate, $departuretime, $busdriver){

 		$mysqli = new mysqli($GLOBALS["serverHost"], $GLOBALS["serverUsername"], $GLOBALS["serverPassword"], $GLOBALS["database"]);

 		$stmt = $mysqli->prepare("UPDATE bustimes SET busline=?, departuredate=?, departuretime=?, busdriver=? WHERE id=? AND deleted IS NULL");
 		$stmt->bind_param("ssss", $busline, $departuredate, $departuretime, $busdriver, $id);

 		// kas �nnestus salvestada
 		if($stmt->execute()){
 			// �nnestus
 			echo "salvestus �nnestus!";
 		}

 		$stmt->close();
 		$mysqli->close();

 	}
	function deletenote($id){

 		$mysqli = new mysqli($GLOBALS["serverHost"], $GLOBALS["serverUsername"], $GLOBALS["serverPassword"], $GLOBALS["database"]);

 		$stmt = $mysqli->prepare("UPDATE bustimes
		SET deleted=NOW() WHERE id=? AND deleted IS NULL");
 		$stmt->bind_param("i", $id);

 		// kas �nnestus salvestada
 		if($stmt->execute()){
 			// �nnestus
 			echo "salvestus �nnestus!";
 		}

 		$stmt->close();
 		$mysqli->close();

 	}


 ?>
