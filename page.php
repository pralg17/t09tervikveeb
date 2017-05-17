<?php

	require ("functions.php");
	
	if (isset($_POST["busline"]) &&
		isset ($_POST ["departuredate"]) &&
		isset ($_POST ["departuretime"]) &&
		!empty($_POST["busline"]) && 
		!empty($_POST["departuredate"]) && 
		!empty($_POST["departuretime"]) 
	) {
		
		//$data = cleanInput($_POST["note"]);
		saveBus($_POST["busline"], $_POST["departuredate"], $_POST["departuretime"]);
		
	}
	
	$data = getAllData();
	
	
?>

<h1><i>Bussiajad</i></h1>
		
<form method="POST">
		
		<label>Sisesta kust kuhu s6idad:</label><br>
		<input name="busline" type="text">

		<br><br>
		
		<label>Sisesta kuup2ev:</label><br>
		<input name="departuredate" type="date">
			
		<br><br>
		
		<label>Sisesta kellaaeg:</label><br>
		<input name="departuretime" type="time">
		
		<br><br>
		
		<input type="submit">
		
</form>
		
<h2 style="clear:both;">Bussiaegade tabel: </h2>
<?php 
	$html = "<table>";
		
		$html .= "<tr>";
			$html .= "<th>id</th>";
			$html .= "<th>Marsuut:</th>";
			$html .= "<th>Kuupäev</th>";
			$html .= "<th>Aeg:</th>";
			$html .= "<th>Saabumise aeg:</th>";
			$html .= "<th>Bussijuht:</th>";
		$html .= "</tr>";
	foreach ($data as $a) {
			$style = "text-align:centered; font-size:13px;";
			$html .= "<tr>";
			$html .= "<td>".$a->id."</td>";
			$html .= "<td>".$a->busline."</td>";
			$html .= "<td>".$a->departuredate."</td>";
			$html .= "<td>".$a->departuretime."</td>";
			$endTime = strtotime("+150 minutes", strtotime($a->departuretime));
			$html .= "<td>".date('h:i:s', $endTime)."</td>";
			$html .= "<td>".$a->busdriver."</td>";
			$html .= "<td><a href='edit.php?id=".$a->id."'>Muuda</a></td>";
		$html .= "</tr>";
	}
	
	$html .= "</table>";
	
	echo $html;
?>