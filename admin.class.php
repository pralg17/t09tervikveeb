<?php

class Admin
{

    private $connection;

    function __construct($mysqli)
    {

        $this->connection = $mysqli;

    }
    function checkForFood($food){

        $stmt = $this->connection->prepare("
                SELECT toiduaine 
                FROM ladu
                WHERE toiduaine LIKE ?
            ");
        echo $this->connection->error;

        $stmt->bind_param("s",$food);

        $stmt->bind_result($food);
        $stmt->execute();

        if ($stmt->fetch()) {
            $_SESSION["foodExists"]= 1;
        }else {
            exit();
        }

        $stmt->close();

    }
    function updatefood($food, $amount){

        $stmt = $this->connection->prepare("UPDATE ladu SET olemasolev_kogus=olemasolev_kogus+? WHERE toiduaine=?");
        $stmt->bind_param("is", $amount, $food);

        // kas õnnestus salvestada
        if ($stmt->execute()) {
            // õnnestus
            header("location: admin.php");
        }

        $stmt->close();

    }
    function deleteFromList($food){

        $stmt = $this->connection->prepare("UPDATE ladu SET juurde = NULL WHERE toiduaine=?");
        $stmt->bind_param("s", $food);

        // kas õnnestus salvestada
        if ($stmt->execute()) {
            // õnnestus
            header("location: admin.php");
            location: ("?.$food.");
        }

        $stmt->close();

    }
    function savefood($food, $amount, $lower_limit){

        $stmt = $this->connection->prepare("INSERT INTO ladu (toiduaine,olemasolev_kogus,alampiir) 
                                            VALUES (?, ?, ?)");

        echo $this->connection->error;

        $stmt->bind_param("sii", $food, $amount, $lower_limit);

        if ($stmt->execute()) {
            location: ("?success");
        } else {
            echo "ERROR " . $stmt->error;
        }
    }
    function getneededData(){

        $stmt = $this->connection->prepare("
			SELECT id,toiduaine, olemasolev_kogus, alampiir, juurde
            FROM ladu
            WHERE olemasolev_kogus=alampiir or olemasolev_kogus<alampiir or olemasolev_kogus-alampiir<=3 or juurde=1
		");
        echo $this->connection->error;

        $stmt->bind_result($id,$food,$amount,$lower_limit,$asked);
        $stmt->execute();


        //tekitan massiivi
        $result = array();

        // tee seda seni, kuni on rida andmeid
        // mis vastab select lausele
        while ($stmt->fetch()) {

            //tekitan objekti
            $warehouse = new StdClass();
            $warehouse->id = $id;
            $warehouse->food = $food;
            $warehouse->amount = $amount;
            $warehouse->lower_limit = $lower_limit;
            $warehouse->asked = $asked;

            array_push($result, $warehouse);
        }

        $stmt->close();

        return $result;
    }



}
?>