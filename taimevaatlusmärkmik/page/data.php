<?php 

	//ühendan sessiooniga
	require("../functions.php");
	
	require("../class/Event.class.php");
	$Event = new Event($mysqli);
	
	
	/*{
		echo "Saved.";
		saveEvent(($_POST["observer"]),($_POST["plant_species"]), ($_POST["obs_spot"]));
	}*/
	
	//Save on error and incomplete form errors
	$observer = "";
	$plant_species = "";
	$obs_spot = "";

	$emptyObserver = "*";
	$emptySpecies = "*";
	$emptyObs = "*";

	
	if ( isset($_POST["observer"]) && 
		 isset($_POST["plant_species"]) &&
		 isset($_POST["obs_spot"]) &&
		 !empty($_POST["observer"]) &&
		 !empty($_POST["plant_species"]) &&
		 !empty($_POST["obs_spot"]) 
	) {
		$Event->saveEvent(($_POST["observer"]),($_POST["plant_species"]), ($_POST["obs_spot"]));
	}
	
	
	// otsib
	if (isset($_GET["q"])) {
		
		$q = $_GET["q"];
	
	} else {
		//ei otsi
		$q = "";
	}
	
	//vaikimisi, kui keegi mingit linki ei vajuta
	$sort = "id";
	$order = "ASC";
	
	if (isset($_GET["sort"]) && isset($_GET["order"])) {
		$sort = $_GET["sort"];
		$order = $_GET["order"];
	}
	
	$people = $Event->getAllObservations($q, $sort, $order);
	
	
	
?>

<?php require("../header.php"); ?>


<h2>Save an observation</h2>
<form method="POST" >

	<label>Observer</label><br>
	<input name="observer" type="text"
	<br>

	<br><br>
	<label>Plant species</label><br>
	<input name="plant_species" type="text"
	<br>
	
	<br><br>
	<label>Observed at</label><br>
	<input name="obs_spot" type="text"
	
	<br><br>
	
	<input type="submit" value="Save">

</form>

    <h3><a href="observers.php">Observer list</a></h3>

<h2>Observations</h2>

<form>
	<input type="search" name="q" value="<?=$q;?>">
	<input type="submit" value="Search">
</form>

<?php 

	
	$html = "<table class='table table-striped table-condensed'>";
	
		$html .= "<tr>";
			$html .= "<th>ID</th>";
			
			$orderObserver = "ASC";
			if (isset($_GET["order"]) && 
				$_GET["order"] == "ASC" &&
				$_GET["sort"] == "observer" ) {
					
				$orderObserver = "DESC";
			}
		
			$html .= "<th>
						<a href='?q=".$q."&sort=observer&order=".$orderObserver."'>
							Observer
						</a>
					 </th>";
			
			
			$orderPlant = "ASC";
			if (isset($_GET["order"]) && 
				$_GET["order"] == "ASC" &&
				$_GET["sort"] == "plant_species" ) {
					
				$orderPlant = "DESC";
			}
		
			$html .= "<th>
						<a href='?q=".$q."&sort=plant_species&order=".$orderPlant."'>
							Plant species
						</a>
					 </th>";
			
			
			$orderObs = "ASC";
			if (isset($_GET["order"]) && 
				$_GET["order"] == "ASC" &&
				$_GET["sort"] == "obs_spot" ) {
					
				$orderObs = "DESC";
			}
		
			$html .= "<th>
						<a href='?q=".$q."&sort=obs_spot&order=".$orderObs."'>
							Observed at
						</a>
					 </th>";
			
			
		$html .= "</tr>";
		
		//iga liikme kohta massiivis
		foreach ($people as $p) {
			
			$html .= "<tr>";
				$html .= "<td>".$p->id."</td>";
				$html .= "<td>".$p->observer."</td>";
				$html .= "<td>".$p->plant_species."</td>";
				$html .= "<td>".$p->obs_spot."</td>";
				$html .= "<td>
						<a class='btn' href='data.php?q=".$p->observer."'>
						Select Observer
						<span class='glyphicon glyphicon-user'></span>
						</a>
						</td>";
			$html .= "</tr>";
		
		} //    <h3><a href="observers.php">Observer list</a></h3>
		
	$html .= "</table>";
	
	echo $html;

?>

<?php require("../footer.php"); ?>