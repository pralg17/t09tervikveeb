var connection=new XMLHttpRequest();
connection.onreadystatechange=receivedData;
function change(){
    var artist = document.getElementById("paintings").value.split(",")[0];
    var painting = document.getElementsByName("painting")[0].value;
    var genre = document.getElementsByName("genre")[0].value;
    connection.open("GET", "/change?artist="+artist+"&painting="+painting+"&genre="+genre, true);
    connection.send();
}
function receivedData(){
    console.log("received");
}
