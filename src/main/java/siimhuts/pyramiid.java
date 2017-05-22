package siimhuts;

public class pyramiid extends pystkeha{
	double a, k, kK;
	public pyramiid(double alus, double korgus, double kKorgus){
		super(korgus);
		a=alus;
		kK=kKorgus;
	}
	@Override
	public double pohjaPindala(){
		return a*a;
	}
	public double kuljePindala(){
		return ((a*kK)/2)*4;
	}
}
