package viljar;
public class VaadistKasti{
  String x;
  double y;
  double z;
  public String VaadistKasti(String anum, String mark, String tuup ){
    if(MituKasti(anum,mark,tuup).equals("Error")){
      return"Pole piisavalt jooki";
    }else{
    return "Jooki: " +mark+" Jagus kasti: "+MituKasti(anum,mark,tuup)+
    " Jääk: "+new lugeja().getJoogiKogus(mark) ;
  }
}

  public double MituLiitritKastis(String anum, String tuup ){
    try{
    y=(Joogipudel.valueOf(anum).getPudeliMaht())*
    (Kast.valueOf(tuup).getSuurus()); //Pudeli mahti * kasti suurus
  }catch(Exception e){}
    return y;
  }
  public String MituKasti(String anum, String mark, String tuup ){

    try{
      if((new lugeja().getJoogiKogus(mark))>
      (MituLiitritKastis(anum, tuup))){
        x=String.valueOf(((new lugeja().getJoogiKogus(mark))-
        Jaagileidja(anum,mark,tuup))/
        (MituLiitritKastis(anum, tuup)));
        //(joogikogus-(joogikogus%Kasti maht))/kastimaht
        new muutja().muutja(mark, Jaagileidja(anum,mark,tuup));
      }else{x="Error";}
    }catch(Exception e){}
      return x;
    }
  public double Jaagileidja(String anum, String mark, String tuup){

    try{
    z=((new lugeja().getJoogiKogus(mark))%(MituLiitritKastis(anum, tuup)));
  }catch(Exception e){}
    return z;
  }
}
