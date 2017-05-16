<?php
require("functions.php");
$fooderror = "";
$food = "";
$amount = "";
$amounterror = "";
$lower_limit = "";
$lower_limiterror = "";
$addOld="op1";
$addNew="op0";

if (isset ($_POST ["food"])) {
    if (empty($_POST ["food"])) {
        $fooderror = "Sisesta toiduaine nimetus!";
    } else {
        $food = $_POST ["food"];
    }
}
if (isset ($_POST ["amount"])) {
    if (empty($_POST ["amount"])) {
        $amounterror = "Sisesta laos olev kogus!";
    } else {
        $amount = $_POST ["amount"];
    }
}
if (isset ($_POST ["lower_limit"])) {
    if (empty($_POST ["lower_limit"])) {
        $lower_limiterror = "Sisesta miinimumpiir!";
    } else {
        $lower_limit = $_POST ["lower_limit"];
    }
}
if (isset ($_POST ["delete"])) {
    if (empty($_POST ["delete"])) {
        echo "siin";
        $deleteError = "";
    } else {
        $delete = $_POST ["delete"];
        $_SESSION["delete"]=$_POST ["delete"];
        var_dump($_SESSION["delete"]);
        $Admin->deleteFromList($_POST ["delete"]);
    }
}
if( isset($_POST["food"]) &&
    isset($_POST["amount"]) &&
    isset($_POST["lower_limit"]) &&
    !empty($_POST["food"]) &&
    !empty($_POST["amount"]) &&
    !empty($_POST["lower_limit"])
)	{
    $Admin->checkForFood($_POST["food"]);
    if($_SESSION["foodExists"]==1) {
        $Admin->updatefood(strtolower($_POST["food"]) , $_POST["amount"], $_POST["lower_limit"]);
        $_SESSION["foodExists"]="";
    }else {
        $Admin->savefood(strtolower($_POST["food"]), $_POST["amount"], $_POST["lower_limit"]);
        header("Location: admin.php");
    }
    exit();
}

$dropdown = $Worker->getDatafordropdown();
$warehouse = $Worker->getData();
$needed = $Admin->getneededData();

$dropdown;
?>
<?php require("header.php");?>
<?php require("CSS.php");?>


    <nav class="navbar navbar-light bg-faded navbar-fixed-top" style="background-color: rgba(30, 144, 255, 0.33)">
    <ul class="nav navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="worker.php" style="color: maroon"><span class="glyphicon glyphicon-user"></span> Töötaja</a>
        </li>
        <li class="disabled">
            <a class="nav-link" href="admin.php"><span class="glyphicon glyphicon-user"></span> Laohoidja</a>
        </li>
    </ul>
    <div class="collapse navbar-collapse">

    </div>
</nav>



    <br><br><br>
    <center><h1>Laohoidja</h1></center><br><br>

    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-6 col-md-4">
                <center>

                    <h3>Lisa lattu toiduaineid:</h3>

                        <form  method="POST" style="width: 300px" >
                            <p style="color: maroon;"><?php echo $fooderror; ?></p>
                            <input class="form-control" placeholder="Toiduaine" name="food" type="text"><br>
                            <p style="color: maroon"><?php echo $amounterror; ?></p>
                            <input class="form-control" placeholder="kogus" name="amount" type="text"><br>
                            <p style="color: maroon"><?php echo $lower_limiterror; ?></p>
                            <input class="form-control" placeholder="koguse alampiir" name="lower_limit" type="text"><br>
                            <input class='btn btn-success btn-lg' style="width: 300px;height: 50px" type="submit">
                        </form>
                </center>
            </div>
            <div class="col-sm-6 col-md-4">
                <center><h3>Ladu:</h3>
                    <?php

                    $html = "<table style='width: 20%' class='table table-striped'>";
                    $html .= "<tr>";

                    $html .= "<th><center><text style='font-size: 20px' > Toiduaine</center></th>";
                    $html .= "<th><center><text style='font-size: 20px' > Laos (kg)</center></th>";
                    $html .= "<th><center><text style='font-size: 20px' > Alampiir(kg)</center></th>";



                    foreach($warehouse as $P){
                        if(($P->amount - $P->lower_limit)<=0) {
                            $html .= "<tr style='background-color: rgba(255,0,0,0.28)'>";
                            $html .= "<td><center><text style='color:red;font-weight: bold'>".strtoupper($P->food)."</text></center></td>";
                            $html .= "<td><center><text style='color:red;font-weight: bold'>$P->amount</text></center></td>";
                            $html .= "<td><center><text style='color:red'>$P->lower_limit</text></center></td>";
                            $html .= "</tr>";
                        }else if(($P->amount - $P->lower_limit)<=3 && ($P->amount - $P->lower_limit)>0){
                            $html .= "<tr style='background-color: rgba(255,197,51,0.28)'>";
                            $html .= "<td><center><text style='color:#ff911e;font-weight: bold'>".strtoupper($P->food)."</text></center></td>";
                            $html .= "<td><center><text style='color:#ff911e;font-weight: bold'>$P->amount</text></center></td>";
                            $html .= "<td><center><text style='color:#ff911e'>$P->lower_limit</text></center></td>";
                            $html .= "</tr>";
                        }else if($P->asked==1){
                            $html .= "<tr style='background-color: rgba(1,199,1,0.28)'>";
                            $html .= "<td><center><text style='color:darkgreen;font-weight: bold'>".strtoupper($P->food)."</text></center></td>";
                            $html .= "<td><center><text style='color:darkgreen;font-weight: bold'>$P->amount</text></center></td>";
                            $html .= "<td><center><text style='color:darkgreen'>$P->lower_limit</text></center></td>";
                            $html .= "</tr>";
                        }else{
                            $html .= "<tr>";
                            $html .= "<td><center><text >".strtoupper($P->food)."</text></center></td>";
                            $html .= "<td><center><text >$P->amount</text></center></td>";
                            $html .= "<td><center><text >$P->lower_limit</text></center></td>";
                            $html .= "</tr>";
                        }
                    }
                    $html .= "</Table>";
                    echo $html;

                    ?></center>
            </div>
            <div class="col-sm-6 col-md-4 col-md-offset-0">
                <h3>Vaja tellida:</h3>
                    <?php

                    $listHtml = "<ul>";

                    foreach($needed as $i) {
                        if($i->amount-$i->lower_limit<=0){
                            $listHtml .= "<li style='color: red; font-size: 25px;font-weight: bold'><form method='post'>".strtoupper($i->food)."</form></li>";
                        }else if(($i->amount-$i->lower_limit)<=3 && ($i->amount-$i->lower_limit)>0){
                            $listHtml .= "<li style='color: #ff911e; font-size: 25px;font-weight: bold'><form method='post'>" .strtoupper($i->food). "</form></li>";
                        }else if($i->asked==1){
                            $listHtml .= "<li style='color: darkgreen; font-size: 25px;font-weight: bold'><form method='post'>" .strtoupper($i->food). "<button name='delete' value='$i->food' style='font-size:10px;margin-left:10px'>DELETE</button></form></li>";
                        }
                    }


                    $listHtml .= "</ul>";

                    echo $listHtml;

                    ?>

            </div>
        </div>
    </div>




    <br><br><br><br>








<?php require("footer.php");?>