package henri;
 public class pindala extends ristkulik{
   double esimenekulg;
   double teinekulg;
   public pindala(double esimenekulg, double teinekulg){
     this.esimenekulg = esimenekulg;
     this.teinekulg = teinekulg;
   }
 
   @Override
   public double ristkulikuPindala(){
     return esimenekulg*teinekulg;
   }
 }