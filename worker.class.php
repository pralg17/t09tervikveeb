<?php

class Worker
{

    private $connection;

    function __construct($mysqli)
    {

        $this->connection = $mysqli;

    }
    function savewarehouse($amount, $id){

        $stmt = $this->connection->prepare("UPDATE ladu SET olemasolev_kogus=(olemasolev_kogus-?) WHERE id=?");

        echo $this->connection->error;

        $stmt->bind_param("ii",$amount, $id);

        if ($stmt->execute()) {
            location: ("?success");
        } else {
            echo "ERROR " . $stmt->error;
        }
    }
    function getData(){

        $stmt = $this->connection->prepare("
			SELECT id,toiduaine, olemasolev_kogus, alampiir,juurde
            FROM ladu
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


    function getDatafordropdown(){

        $stmt = $this->connection->prepare("
			SELECT id,toiduaine, olemasolev_kogus, alampiir
            FROM ladu
		");
        echo $this->connection->error;

        $stmt->bind_result($id,$food,$amount,$lower_limit);
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

            array_push($result, $warehouse);
        }

        $stmt->close();

        return $result;
    }
    function sendwish($id){

        $stmt = $this->connection->prepare("UPDATE ladu SET juurde=1 WHERE id=?");

        echo $this->connection->error;

        $stmt->bind_param("i",$id);

        if ($stmt->execute()) {
            location: ("?success");
        } else {
            echo "ERROR " . $stmt->error;
        }
    }




}
?>