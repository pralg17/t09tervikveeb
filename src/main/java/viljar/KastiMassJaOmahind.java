package viljar;

public class KastiMassJaOmahind{
  public String KastiMass(String tuup, String anum, String mark){
    try{
    if(mark.equals("")){
      return String.valueOf(Math.round(((Kast.valueOf(tuup).getKastiKaal())+
      ((Joogipudel.valueOf(anum).getPudeliMass())*(Kast.valueOf(tuup).getSuurus())))*100)/100);

    }else{
      return String.valueOf(Math.round(((Kast.valueOf(tuup).getKastiKaal())+
      ((Joogipudel.valueOf(anum).getPudeliMass())+
      (Jook.valueOf(mark).getErikaal())/
      (Joogipudel.valueOf(anum).getPudeliMaht()))*
      (Kast.valueOf(tuup).getSuurus()))*100)/100);//kastikaal+(pudelimass+erikaal/pudelimaht)*kastisuurus
    }
    }catch(Exception e){return "Error";}
  }
  public String KastiHind (String tuup, String anum, String mark){
    try{
  if(mark.equals("")){
    return String.valueOf(Math.round(((Kast.valueOf(tuup).getKastiHind())+
    ((Joogipudel.valueOf(anum).getTaaraMaksumus())*(Kast.valueOf(tuup).getSuurus())))*100)/100);

  }else{
    return String.valueOf(Math.round(((Kast.valueOf(tuup).getKastiHind())+
    (((Joogipudel.valueOf(anum).getTaaraMaksumus())+
    (Jook.valueOf(mark).getLiitri_Hind())/
    (Joogipudel.valueOf(anum).getPudeliMaht()))*
    (Kast.valueOf(tuup).getSuurus())))*100)/100); //kastihind+(taarahind+liitrihind/pudelimaht)*kastisuurus
  }
  }catch(Exception e){return "Error";}
}
public String KastiMassJaOmahind(String tuup, String anum, String mark){
    if((("Error").equals(KastiHind(tuup,anum,mark)))||
    (("Error").equals(KastiMass(tuup,anum,mark)))){
      return "Sellist jooki, anumat või kasti pole";
    }else{
  return "Kasti joogi maksumus on: " +KastiHind(tuup,anum,mark)+
  " Kast kaalub "+ KastiMass(tuup,anum,mark);
}
}
}
