package uku;

import java.io.*;
import java.lang.*;

public class Parabool implements yJoon{
	double kordaja;
	double aste;
	
	public Parabool(double kordaja, double aste){
		
		this.kordaja=kordaja;
		this.aste=aste;

	}	
	
	@Override
    public double f(double x) {
		
        return Math.pow(kordaja, aste);
    }
	
	
}