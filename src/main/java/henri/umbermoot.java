package henri;
 public class umbermoot extends ristkulik{
   double esimenekulg;
   double teinekulg;
   
 
   public umbermoot(double esimenekulg, double teinekulg){
     this.esimenekulg = esimenekulg;
     this.teinekulg = teinekulg;
   }
 
   @Override
   public double ristkulikuUmbermoot(){
     return 2*(esimenekulg*teinekulg);
   }
 }