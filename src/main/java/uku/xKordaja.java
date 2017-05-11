package uku;

import java.io.*;

public class xKordaja implements yJoon{
	double kordaja;
	public xKordaja(double kordaja){
		
		this.kordaja=kordaja;

	}
	
	
	@Override
    public double f(double x) {
        return x * kordaja;
    }
	
	
}