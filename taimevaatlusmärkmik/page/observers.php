<?php

	require("../functions.php");

	require("../class/Event.class.php");
	$Event = new Event($mysqli);
	
	$obs = $Event->observerList();
	
?>

<?php require("../header.php"); ?>

<h5><a href="data.php"> Back</a></h5>

<h2>Observers</h2>

<?php 

	
	$html = "<table class='table table-striped table-condensed'>";
	
		$html .= "<tr>";
			$html .= "<th>Observer</th>";
			$html .= "<th>Plant species observed</th>";
		$html .= "</tr>";
		
		//iga liikme kohta massiivis
		foreach ($obs as $o) {
			
			$html .= "<tr>";
				$html .= "<td>".$o->observer."</td>";
				$html .= "<td>".$o->plant_count."</td>";
			$html .= "</tr>";
		
		}
		
	$html .= "</table>";
	
	echo $html;

?>

<?php require("../footer.php"); ?>