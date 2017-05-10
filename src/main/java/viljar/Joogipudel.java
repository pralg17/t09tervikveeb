package viljar;
public enum Joogipudel  {
  plast(1, "plast", 0.03, 0.1), //L,tyyp,tyhikaal(kr),maksumus(kr)
  klaas(0.5,"klaas", 0.35, 0.15);
  double maht;
  String pudelityyp;
  double mass;
  double taara_maksumus;

  Joogipudel(double maht, String pudelityyp,double uus_mass, double taara_maksumus){
      this.maht= maht;
      this.pudelityyp = pudelityyp;
      this.mass= mass;
      this.taara_maksumus= taara_maksumus;
      }

  public double getPudeliMaht(){
    return maht;
    }
  public String getPudeliTyyp(){
    return pudelityyp;
    }
  public double getPudeliMass(){
    return mass;
      }
  public double getTaaraMaksumus(){
    return taara_maksumus;
      }

}
