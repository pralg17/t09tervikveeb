var inputRadius;
var inputHeight;
var volume = document.getElementById("volume");
var baseArea = document.getElementById("baseArea");
var sideArea = document.getElementById("sideArea");
var totalArea = document.getElementById("totalArea");

window.onload = function(){
	performTest();
	document.getElementById("radius").addEventListener("change", getResults);
	document.getElementById("height").addEventListener("change", getResults);
}

function performTest(){
	const cyl = new Cylinder(3,4);
	var testVolume = cyl.volume.toFixed(3);
	var testTotalArea = (cyl.baseArea+cyl.sideArea).toFixed(3);
	if(testVolume == "113.097" && testTotalArea == "103.673"){
		document.getElementById("testResult").innerHTML = "Test successful";
	}else{
		document.getElementById("testResult").innerHTML = "TEST FAILED!";
	}
}

function getResults(){
	inputRadius = document.getElementById("radius").value;
	inputHeight = document.getElementById("height").value;
	const c = new Cylinder(inputRadius, inputHeight);
	volume.innerHTML = c.volume.toFixed(3);
	baseArea.innerHTML = c.baseArea.toFixed(3);
	sideArea.innerHTML = c.sideArea.toFixed(3);
	totalArea.innerHTML = (c.baseArea+c.sideArea).toFixed(3);
	
}

class Cylinder{
	constructor(radius, height){
		this.radius = radius;
		this.height = height;
	}
	//volume
	get volume(){
		return this.calcVolume();
	}

	calcVolume(){
		return Math.PI*Math.pow(this.radius, 2)*this.height;
	}
	
	//baseArea
	get baseArea(){
		return this.calcBaseArea();
	}

	calcBaseArea(){
		return Math.PI*Math.pow(this.radius, 2);
	}
	
	//sideArea
	get sideArea(){
		return this.calcSideArea();
	}

	calcSideArea(){
		return 2*Math.PI*this.radius*this.height;
	}
}