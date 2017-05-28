t09tervikveeb

Spring veebirakenduse näide, kus

Osa tegevusi/arvutusi on koondatud klasside sisse
Arvutuste tulemusi testitakse
Võimalusel talletatakse tegevuste ajalugu andmebaasi
Võimalusel luuakse eraldi HTML-leht, mille kaudu pöördutakse REST teenuste poole

Käsud:

scl enable rh-maven33 bash
mvn package
java -jar target/menyy-1.jar
PORT: 12236
