<?php

class Circle {
  private $radius;

  public function __construct($radius) {
    $this->radius = $radius;
  }

  public function getRadius() {
    return $this->radius;
  }

  public function getDiameter() {
    return $this->radius*2;
  }

  public function getCircum() {
    return $this->radius*2*3.14;
  }

  public function getArea() {
    return $this->radius*$this->radius*3.14;
  }

}

class Square {
  private $length;

  public function __construct($length) {
    $this->length = $length;
  }

  public function getLength() {
    return $this->length;
  }

  public function getCircum() {
    return $this->length*4;
  }

  public function getArea() {
    return $this->length*$this->length;
  }

}


 ?>
