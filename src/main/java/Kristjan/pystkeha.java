package Kristjan;
public abstract class pystkeha{
	double k;
	public pystkeha(double korgus){
		k=korgus;
	}
	public abstract double pohjaPindala();
	public double ruumala(){
		return k*pohjaPindala()/2;
	}
	
	
	
}