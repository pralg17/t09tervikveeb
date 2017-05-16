<?php
require("functions.php");
$fooderror = "";
$food = "";
$amount = "";
$amounterror = "";
$lower_limit = "";
$lower_limiterror = "";
$soov = "";
$sooverror = "";

if (isset ($_POST ["food"])) {
    if (empty($_POST ["food"])) {
        $fooderror = "Sisesta toiduaine nimetus!";
    } else {
        $food = $_POST ["food"];
    }
}
if (isset ($_POST ["amount"])) {
    if (empty($_POST ["amount"])) {
        $amounterror = "Sisesta kogus mis laost võtsid!";
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
if (isset ($_POST ["soov"])) {
    if (empty($_POST ["soov"])) {
        $sooverror = "Sisesta miinimumpiir!";
    } else {
        $soov = $_POST ["soov"];
    }
}
if( isset($_POST["amount"]) &&
    isset($_POST["id"]) &&
    !empty($_POST["amount"]) &&
    !empty($_POST["id"])
)	{
    $Worker->savewarehouse($_POST["amount"], $_POST["id"]);
    header("Location: worker.php");
    exit();
}
if( isset($_POST["soov"]) &&
    !empty($_POST["soov"])
)	{
    $Worker->sendwish($_POST ["soov"]);
    header("Location: worker.php");
    exit();
}


$warehouse = $Worker->getData();
$dropdown = $Worker->getDatafordropdown();

?>
<?php require("header.php");?>
<?php require("CSS.php");?>


    <nav class="navbar navbar-light bg-faded navbar-fixed-top" style="background-color: rgba(30, 144, 255, 0.33)">
        <ul class="nav navbar-nav">
            <li class="disabled">
                <a class="nav-link" href="worker.php" ><span class="glyphicon glyphicon-user"></span> Töötaja</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="admin.php" style="color: maroon"><span class="glyphicon glyphicon-user"></span> Laohoidja</a>
            </li>
        </ul>
        <div class="collapse navbar-collapse">

        </div>
    </nav>



    <br><br><br>
<center><h1>Töötaja</h1></center><br><br>

    <div class="container">
        <div class="row">
            <div class="col-sm-6 col-md-4 col-sm-offset-1 col-md-offset-1">
                <center><form  method="POST" style="width: 300px">
                        <h3>Võta laost:</h3>
                        <select name="id" type="text" class="form-control">
                            <?php

                            $listHtml = "";
                            foreach($dropdown as $d){
                                $listHtml .= '<option href="?" value='.$d->id.'>'.strtoupper($d->food).'</option>';
                            }
                            echo $listHtml;

                            ?>
                        </select><br>
                        <p style="color: maroon"><?php echo $amounterror; ?></p>
                    <input class="form-control" placeholder="Kogus" name="amount" type="text"><br>
                        <input class='btn btn-success btn-lg' style="width: 300px;height: 50px" type="submit">
                </form>
                    <form  method="POST" style="width: 300px"><br>
                        <h3>Soovita tellimus:</h3><br>
                        <select name="soov" type="text" class="form-control">
                            <?php

                            $listHtml = "";
                            foreach($dropdown as $d){
                                $listHtml .= '<option href="?" value='.$d->id.'>'.strtoupper($d->food).'</option>';
                            }
                            echo $listHtml;

                            ?>
                        </select><br>
                        <input class="form-control" placeholder="soovikogus" name="juurde" type="text"><br>
                        <input class='btn btn-warning btn-lg' style="width: 300px;height: 50px" type="submit">
                    </form>
                </center>
            </div>
            <div class="col-sm-6 col-md-4 col-sm-offset-1 col-md-offset-2">
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
                        $html .= "<td><center><text >$P->lower_limit</text></center></td>";
                        $html .= "</tr>";
                    }else if(($P->amount - $P->lower_limit)<=3 && ($P->amount - $P->lower_limit)>0){
                        $html .= "<tr style='background-color: rgba(255,197,51,0.28)'>";
                        $html .= "<td><center><text style='color:#ff911e;font-weight: bold'>".strtoupper($P->food)."</text></center></td>";
                        $html .= "<td><center><text style='color:#ff911e;font-weight: bold'>$P->amount</text></center></td>";
                        $html .= "<td><center><text >$P->lower_limit</text></center></td>";
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
        </div>
    </div>




    <br><br><br><br>








<?php require("footer.php");?>