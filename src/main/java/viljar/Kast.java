package viljar;
public enum Kast{
  k24("k24", 2,1, 1.3, 24), //tyyp, hind(EUR), kastikaal(kg), maht
  k20("k20", 1.5, 1.1, 20);
  String kastityyp;
  double kastihind;
  double kastikaal;
  double suurus;

  Kast(String kastityyp, double kastihind, double kastikaal, int suurus){
    this.kastityyp=kastityyp;
    this.kastihind=kastihind;
    this.kastikaal=kastikaal;
    this.suurus=suurus;
  }
  public String getKastiTyyp(){
    return kastityyp;
  }
  public double getKastiHind(){
    return kastihind;
  }
  public double getKastiKaal(){
    return kastikaal;
  }
  public double getSuurus(){
    return suurus;
  }
}
