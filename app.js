"use strict"

const express = require('express')
const app = express()
const bodyParser = require('body-parser')

app.use(bodyParser.urlencoded({ extended: false }))
app.use(bodyParser.json())

var joogid = []
var joogipudelid = []
var joogivaadid = []

app.listen(3000, ()=>{
  console.log('Server jookseb pordil 3000')
})

class Jook {
    constructor(nimetus, liitri_omahind, erikaal) {
        this.nimetus = nimetus
        this.liitri_omahind = liitri_omahind
        this.erikaal = erikaal
        joogid.push(this);
    }
    toString() {
        return `
        Joogi nimetus: ${this.nimetus}
        <br> Liitri hind: ${this.liitri_omahind}€
        <br> Kaal liitri kohta: ${this.erikaal}kg<hr>
        `
    }
}

class Joogipudel {
    constructor(kood, jook = 0, maht, pudelimass, taarahind) {
    	this.kood = kood
    	this.jook = jook
        this.maht = maht
        this.pudelimass = pudelimass
        this.taarahind = taarahind
        if(this.jook){
        	this.kogumass = this.pudelimass + (this.jook.erikaal*this.maht)
        	this.koguhind = this.taarahind + (this.jook.liitri_omahind*this.maht)
        	this.taidetud = true
        } else {
        	this.kogumass = this.pudelimass
        	this.koguhind = this.taarahind
        	this.taidetud = false
        }
        joogipudelid.push(this);
        // console.log(this)
    }
    taidaPudel(jook){
    	this.jook = jook;
    	this.kogumass = parseFloat(this.pudelimass) + parseFloat(this.jook.erikaal)*parseFloat(this.maht);
       	this.koguhind = parseFloat(this.taarahind) + parseFloat(this.jook.liitri_omahind)*parseFloat(this.maht);
    	this.taidetud = true;
    }
    toString() {
        return `
        Unikaalne kood: ${this.kood}
        <br>Sisaldatav jook: ${this.jook.nimetus || "ei sisalda veel jooki"}
        <br> Pudeli maht: ${this.maht}l
        <br> Pudeli netomass: ${this.pudelimass}kg
        <br> Taarahind: ${this.taarahind}€
        <br> Kogumass sisaldusega: ${this.kogumass}kg
        <br> Koguhind sisaldusega: ${this.koguhind}€
        <br> Täidetud: ${this.taidetud}<hr>
        `
    }
}

class Joogivaat {
    constructor(kood, ruumala, jook=0) {
    	this.kood = kood
    	this.jook = jook
    	this.ruumala = ruumala
    	this.hetkeseis = 0
    	joogivaadid.push(this);
        // console.log(this)
    }
    toString() {
        return `
        Joogivaadi ruumala: ${this.ruumala}m3
        <br>Ta mahutab: ${this.ruumala*1000}l 
        <br>Hetkel sisaldab: ${this.jook.nimetus || "ei sisalda veel jooki"} 
        <br>Hetkeseis: ${this.hetkeseis}<hr>`
    }
    taidaVaat(joogiga){
    	this.jook = joogiga
    	this.hetkeseis = this.ruumala*1000
    }
}

var limonaad = new Jook("Mulinaad", 1.5, 1)
var limpsipudel = new Joogipudel("pudel_01" ,limonaad, 0.5, 0.05, 0.10)
var limpsivaat = new Joogivaat("limpsivaat_01", 1)

app.get('/', (req, res)=>{
  res.send(`
  	uue joogi lisamine: /lisa/jook/nimetus/omahind/erikaal <br>
  	uue joogipudeli lisamine: /lisa/joogipudel/joogi_nimi/maht/mass/taarahind <br>
  	<br>
  	<h3 style="text-decoration: underline">Olemasolevad joogid:</h3>
  	${joogid}
  	<h3 style="text-decoration: underline">Olemasolevad pudelid:</h3>
  	${joogipudelid}
  	<h3 style="text-decoration: underline">Olemasolev joogivaat:</h3>
  	${joogivaadid}
  	`)
})

app.get('/lisa/jook/:nimi/:omahind/:erikaal', (req, res)=>{
	let nimi = req.params.nimi;
	
	let omahind = req.params.omahind;
	let erikaal = req.params.erikaal;
	let uusjook = new Jook(nimi, omahind, erikaal)

	res.send(`
		<a href="http://46.101.173.169:3000/">Avaleht</a>
		<h3 style="text-decoration: underline">Konstrueerisid uue joogi:</h3>
		Nimetusega: ${uusjook.nimetus} <br>
		Hinnaga: ${uusjook.liitri_omahind}€/l <br>
		Erikaaluga: ${uusjook.erikaal}kg/l <br>
		<br>
	  	<h3 style="text-decoration: underline">Olemasolevad joogid:</h3>
	  	${joogid} <br>
	  	<h3 style="text-decoration: underline">Olemasolevad pudelid:</h3>
	  	${joogipudelid}
		`)
})

app.get('/lisa/joogipudel/:kood/:jooginimi/:maht/:mass/:taarahind', (req, res)=>{
	let kood = req.params.kood
	for (let obj of joogipudelid){
		if(obj.kood == kood){
			throw ("sellise koodiga pudel juba eksisteerib")
		}
	}
	let jooginimi = req.params.jooginimi;
	for (let obj of joogid){
		if(obj.nimetus == jooginimi){
			// console.log(obj.nimetus)
			var jook = obj;
		} /*else {
			throw ("sellist jooki pole! pudeli saad täita ainult eksisteeriva joogiga")
		}*/
	}
	// console.log(jook)
	let maht = req.params.maht;
	let mass = req.params.mass;
	let taarahind = req.params.taarahind;
	let uusjoogipudel = new Joogipudel(kood, jook, maht, mass, taarahind)

	res.send(`
		<a href="http://46.101.173.169:3000/">Avaleht</a>
		<h3 style="text-decoration: underline">Konstrueerisid uue joogipudeli:</h3>
		Unikaalne kood: ${uusjoogipudel.kood} <br>
		Mis sisaldab jooki: ${uusjoogipudel.jook.nimetus || "ei sisalda veel jooki"} <br>
		On mahuga: ${uusjoogipudel.maht}l <br>
		On netomassiga: ${uusjoogipudel.pudelimass}kg <br>
		On kogumassiga: ${uusjoogipudel.kogumass}kg <br>
		On koguhinnaga: ${uusjoogipudel.koguhind}€<br>
		<br>
	  	<h3 style="text-decoration: underline">Olemasolevad joogid:</h3>
	  	${joogid} <br>
	  	<h3 style="text-decoration: underline">Olemasolevad pudelid:</h3>
	  	${joogipudelid}
		`)
})

app.get('/taida/pudel/:pudelikood', (req, res)=>{
	if(limpsivaat.hetkeseis <= 0){
		throw ("vaat on tühi, ei saa pudelit täita")
	}
	let pudelikood = req.params.pudelikood
	for (let pudel of joogipudelid){
		if(pudel.kood == pudelikood){
			if(pudel.taidetud){throw("viga: pudel on juba täis")}
				console.log(limpsivaat.jook)
			pudel.taidaPudel(limpsivaat.jook)
			res.send(`<a href="http://46.101.173.169:3000/">Avaleht</a>
		täidetud`)
		}
	}
})

app.get('/taida/vaat/:millega', (req, res)=>{
	let millega = req.params.millega
	for (let obj of joogid){
		if(obj.nimetus == millega){
			var jook = obj;
		}
	}
	limpsivaat.taidaVaat(jook)
	res.send(`<a href="http://46.101.173.169:3000/">Avaleht</a>
		täidetud`)
})

app.get('/tyhjendavaat', (req, res)=>{
	limpsivaat.jook = 0
	limpsivaat.hetkeseis = 0
	res.send(`<a href="http://46.101.173.169:3000/">Avaleht</a>
		tühjendatud`)
})


//req.params.nimi