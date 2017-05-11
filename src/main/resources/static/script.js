function sendData() {
    var ruut = document.getElementById("ruut-kulg").value;
    var kolmnurk_kulg = document.getElementById("kolmnurk-alus").value;
    var kolmnurk_kaatet = document.getElementById("kolmnurk-kulg").value;

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("vastus").innerHTML = xhttp.responseText;
        }else if(this.readyState == 4 && this.status == 400){
            document.getElementById("vastus").innerHTML = "Sisestage andmed.";
        }
    };
    xhttp.open("GET", "/createpyramid?ruut_kulg=" + ruut + "&kolmnurk_alus=" + kolmnurk_kulg + "&kolmnurk_kaatet=" + kolmnurk_kaatet, true);
    xhttp.send();

}
