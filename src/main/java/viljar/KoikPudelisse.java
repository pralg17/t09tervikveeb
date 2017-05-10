package viljar;
public class KoikPudelisse{
  String s;
    public String KoikPudelisse(String anum, String mark){
      try{
          if ((new lugeja().getJoogiKogus(mark)) > (Joogipudel.valueOf(anum).getPudeliMaht())){
            double x=((new lugeja().getJoogiKogus(mark))-
            (new lugeja().getJoogiKogus(mark))%(Joogipudel.valueOf(anum).getPudeliMaht()))
            /(Joogipudel.valueOf(anum).getPudeliMaht());//(jookivaadis-jääk)/pudelimakht.
            s="Jooki mahtus "+x+" anumasse. Järele jäi "+
             (new lugeja().getJoogiKogus(mark))%(Joogipudel.valueOf(anum).getPudeliMaht());
             new muutja().muutja(mark, (new lugeja().getJoogiKogus(mark))%
             (Joogipudel.valueOf(anum).getPudeliMaht()));//uus väärtus vaadis.
          }else{
            s="Jooki pole piisavalt";
          }
        }catch(Exception e){return "Sellist jooki või pudelit pole olemas";}
      return s;
    }
}
