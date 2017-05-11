package com.example;

public class Joogipudel{
	Jook j;
	double maht;
	Pudelityyp tyyp;
	double pudelimass;
	double taaramaksumus;
	double koguMass(){
		if(j==null){return pudelimass;}
		return pudelimass+maht*j.erikaal;
	}
	double korgiKorgus;
	double korgiDiameeter;
}