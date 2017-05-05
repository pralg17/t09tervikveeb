package viljar;
import java.util.EnumSet;
public class Hinnaleidja{
  double roo;
  double maht;
  double l_h;
  double taara;
  double mass;
  public String Hinnaleidja(String anum, String mark){
    for(Jook joo:Jook.values()){
      if((joo.getNimi()).equals(mark)){
        roo=joo.getErikaal();
        l_h=joo.getLiitri_Hind();
      }
    }
    for(Joogipudel pudel:Joogipudel.values()){
      if((pudel.getPudeliTyyp()).equals(anum)){
        maht=pudel.getPudeliMaht();
        taara=pudel.getTaaraMaksumus();
        mass=pudel.getPudeliMass();
      }
    }
    String tagasta = Double.toString(mass+(roo* maht));
    return "Joogi nimetusega: "+mark+ " Kaalub koos "+anum+
    " topsiga "+ tagasta+". Jook maksab: "+ (taara+l_h*maht);
  }
  }
