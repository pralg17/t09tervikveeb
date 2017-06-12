<?php
require("shapes.php");
$circle = new Circle($_GET["circle_radius"]);
$square = new Square($_GET["cube_l"]);

?>

<!doctype html>
<html style="background: gray; margin: 0; overflow: hidden;">
<body style="max-width: 768px; margin: 0 auto; background: snow; height: 100vh; padding: 15px;">
  <h1>Kujundite arvutaja</h1>
  <p>Vali järgnevast nimistust üks kujund, mida tahaksid arvutada. Sisesta selle kujundi
     identifitseeriv väärtus, ning rakendus leiab selle järgi teised väärtused.</p>
  <h2>Ringi arvutaja</h2>
  <form id="circle">
    <p>Ringi puhul on identifitseerivaks väärtuseks raadius.</p>
    <label>Raadius:</label>
    <input type="text" name="circle_radius"><br>
    <label>Diameeter: <?=$circle->getDiameter()?> üh</label><br>
    <label>Ümbermõõt: <?=$circle->getCircum()?> üh</label><br>
    <label>Pindala: <?=$circle->getArea()?> üh</label><br>
    <br><input type="submit" value="Arvuta">
  </form>
  <h2>Ruudu arvutaja</h2>
  <form id="cube">
    <p>Ruudu puhul on vajalik info ruudu külje pikkus.</p>
    <label>Küljepikkus:</label>
    <input type="text" name="cube_l"><br>
    <label>Ümbermõõt: <?=$square->getCircum()?> üh</label><br>
    <label>Pindala: <?=$square->getArea()?> üh</label><br>
    <br><input type="submit" value="Arvuta">
  </form>
  <br>
  <a href="autotest.php">Automaattestid klassidele on siin.</a>
</body>
</html>
