package ksenbelo;
public class pindala extends kolmnurk{
  double a;
  double b;
  double c;
  public pindala(double a, double b, double c){
    this.a = a;
    this.b = b;
    this.c = c;
  }

  @Override
  public double kolmnurkpindala(){
    return a + b + c;
  }
}