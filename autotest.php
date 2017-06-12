<?php
require("shapes.php");
$circle = new Circle(3.5);
$square = new Square(6);

function testResult($expected, $real) {
  $exptected = (float) $expected;
  $real = (float) $real;
  echo "Eeldatav väärtus: ".$expected."<br>Tegelik väärtus: ".$real."<br>";
  if ($exptected == $real) {
    echo "Test OK.";
  } else {
    echo "Test nurjus.";
  }
}

?>

<!doctype html>
<html style="background: gray; margin: 0; overflow: hidden;">
<body style="max-width: 768px; margin: 0 auto; background: snow; height: 96vh; padding: 15px; overflow-y: auto;">
  <h1>Kujundite arvutaja</h1>
  <h2>Automaattestidest</h2>
  <p>Automaattestid on tehtud kindlate arvude järgi. Automaattestid testivad ainult
    <i>background</i>-arvutamist ning objekt-orienteeritud koodi töötamist.
  <br>
  Automaattestide arvutamiseks anti klassidele ette järgmised arvud:
  <br>
  Ringi raadius: 3.5 üh;<br>
  Ruudu külg: 6 üh.
</p>

<h2>Automaattestide tulemused</h2>
  <p>Ringi diameeter<br><?=testResult(7, $circle->getDiameter())?><br></p>
  <p>Ringi ümbermõõt<br><?=testResult(21.98, $circle->getCircum())?><br></p>
  <p>Ringi pindala<br><?=testResult(38.465, $circle->getArea())?><br></p>
  <br>
  <p>Ruudu diameeter<br><?=testResult(6, $square->getLength())?><br></p>
  <p>Ruudu ümbermõõt<br><?=testResult(24, $square->getCircum())?><br></p>
  <p>Ruudu pindala<br><?=testResult(36, $square->getArea())?><br></p>


  <br>
  <a href="index.php">Tagasi pealehele.</a>
  <br><br>
</body>
</html>
