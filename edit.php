<?php
	require("functions.php");
	require("editFunctions.php");

	/// kas aadressireal on delete
	if(isset($_GET["delete"])){
		// saadan kaasa aadressirealt id
		deleteNote($_GET["id"]);
		header("Location: page.php");
		exit();

	}

	//kas kasutaja uuendab andmeid
	if(isset($_POST["update"])){

		updateNote(cleanInput($_POST["id"]), cleanInput($_POST["busline"]), cleanInput($_POST["departuredate"]), cleanInput($_POST["departuretime"]), cleanInput($_POST["busdriver"]));

		header("Location: edit.php?id=".$_POST["id"]."&success=true");
        exit();

	}

	//saadan kaasa id
	$c = getSingleNoteData($_GET["id"]);
	//var_dump($c);

?>
<br><br>
<a href="page.php"> tagasi </a>

<h2>Muuda bussiaegu</h2>

  <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>" method="post" >
	<input type="hidden" name="id" value="<?=$_GET["id"];?>" >
  	<label for="busline" >Sisesta uus marsuut:</label><br>
	<textarea  id="busline" name="busline"><?php echo $c->busline;?></textarea><br>

  	<label for="departuredate" >V�ljumise kuup�ev:</label><br>
	<input id="departuredate" name="departuredate" type="date" value="<?=$c->departuredate;?>"><br><br>

	<label for="departuretime" >Kellaaeg:</label><br>
	<input id="departuretime" name="departuretime" type="time" value="<?=$c->departuretime;?>"><br><br>

	<label>Soovi korral lisa ka bussijuht:</label><br>
			<select name="busdriver" >
				<option value= "busdriver" selected> Timo Kuusk</option>
				<option value= "busdriver"> Tarmo Ratas</option>
				<option value= "busdriver"> Kersti Rool</option>
				<option value= "busdriver"> Maie Pedaal</option>
			</select>
	<br><br>

	<input type="submit" name="update" value="Salvesta">
  </form>

<br>
<br>
<a href="?id=<?=$_GET["id"];?>&delete=true">kustuta</a>
