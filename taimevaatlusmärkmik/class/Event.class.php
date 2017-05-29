<?php
class Event
{

    private $connection;

    function __construct($mysqli)
    {
        $this->connection = $mysqli;
    }


    function saveEvent($observer, $plant_species, $obs_spot) {

        $stmt = $this->connection->prepare("INSERT INTO plantlife (observer, plant_species, obs_spot) VALUES (?, ?, ?)");
        echo $this->connection->error;

        $stmt->bind_param("sss", $observer, $plant_species, $obs_spot);
        header("Location: data.php");

        if ($stmt->execute() ) {
            echo "Saved!";
        } else {
            echo "ERROR " . $stmt->error;
        }

    }


    function getAllObservations($q, $sort, $order) {
	
		$allowedSort = ["observer", "plant_species", "obs_spot"];
	
	// sort ei kuulu lubatud tulpade sisse 
		if(!in_array($sort, $allowedSort)){
			$sort = "observer";
		}
		
		$orderBy = "ASC";

		if($order == "DESC") {
			$orderBy = "DESC";
		}
		
		echo "Sorting: ".$sort." ".$orderBy." ";
	
	
		if ($q != "") {
			//otsin
			echo "Searching: ".$q;
			
			$stmt = $this->connection->prepare("
				SELECT id, observer, plant_species, obs_spot
				FROM plantlife
				WHERE (observer LIKE ? OR plant_species LIKE ? OR obs_spot LIKE ?)
				ORDER BY $sort $orderBy
			");
			
			$searchWord = "%".$q."%";
			
			$stmt->bind_param("sss", $searchWord, $searchWord, $searchWord);
			
		} else {
			//ei otsi
			$stmt = $this->connection->prepare("
				SELECT id, observer, plant_species, obs_spot
				FROM plantlife
				ORDER BY $sort $orderBy
			");
		}

        $stmt->bind_result($id, $observer, $plant_species, $obs_spot);
        $stmt->execute();

        $results = array();

        // tsükli sisu tehakse nii mitu korda, mitu rida
        // SQL lausega tuleb
        while ($stmt->fetch()) {

            $people = new StdClass();
            $people->id = $id;
            $people->observer= $observer;
			$people->plant_species = $plant_species;
			$people->obs_spot = $obs_spot;

            //echo $color."<br>";
            array_push($results, $people);

        }

        return $results;
    }
	
	function observerList() {

        $stmt = $this->connection->prepare("
			SELECT observer,
			COUNT(*) AS plant_count FROM plantlife
			GROUP BY observer
		");
		
		//SELECT observer, COUNT(*) AS plant_count FROM plantlife GROUP BY observer;

        $stmt->bind_result($observer, $plant_count);
        $stmt->execute();

        $results = array();

        // tsükli sisu tehakse nii mitu korda, mitu rida
        // SQL lausega tuleb
        while ($stmt->fetch()) {

            $obs = new StdClass();
            $obs->observer= $observer;
			$obs->plant_count = $plant_count;

            //echo $color."<br>";
            array_push($results, $obs);

        }

        return $results;
    }
}
?>