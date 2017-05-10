package viljar;
import java.io.IOException;
import java.util.EnumSet;
public class JookPudelisse{
  String s="Tere";
  public String JookPudelisse (String anum, String mark, String kogus)throws IOException{
    int kogus1 = Integer.parseInt(kogus);

  //  for(Joogipudel jook:Joogipudel.values()){
try{
    if ((new lugeja().getJoogiKogus(mark)) > ((Joogipudel.valueOf(anum).getPudeliMaht())*kogus1)){
      new muutja().muutja(mark, (new lugeja().getJoogiKogus(mark))-
      ((Joogipudel.valueOf(anum).getPudeliMaht())*kogus1)); //(muuda väärtus(algnekogus-pudelimaht)*mitupudelit)

      s="Täideti "+kogus+" pudelit "+ mark+" järele jäi "+(new lugeja().getJoogiKogus(mark)) +" ";

    }else{
      s="Jooki pole piisavalt";
    }
  }catch(Exception e){return "Sellist jooki või pudelit pole olemas";}
    //Joogipudel.valueOf(anum).getPudeliTyyp().trim()
    //Joogipudel.valueOf(anum).getPudeliMaht()
  //}
  return s;
  }
}
