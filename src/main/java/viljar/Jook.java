package viljar;
public enum Jook  {
  olu("olu", 2, 1.1), //Mark, L*hind, kg/L 
  vein("vein", 4, 1.2),
  vesi("vesi", 1,5, 1);
String nimi;
double liitri_hind;
double erikaal;

Jook( String uus_nimi, double uus_liitri_hind, double uus_erikaal){
  nimi=uus_nimi;
  liitri_hind = uus_liitri_hind;
  erikaal = uus_erikaal;
}
public String getNimi(){
  return nimi;
}

public double getErikaal(){
  return erikaal;
}
public double getLiitri_Hind(){
  return liitri_hind;
}
}
