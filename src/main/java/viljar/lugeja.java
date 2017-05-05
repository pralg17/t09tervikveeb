package viljar;
import java.util.Scanner;
import java.io.*;
public class lugeja{
String[] tagasta ;
  public String[] lugeja(String u)throws IOException{
    String[] split;
    Scanner file=new Scanner(new File("sisu.txt"));
    int numTimes =file.nextInt();
    file.nextLine();
      for (int i=0; i<numTimes; i++){
        split=file.nextLine().split(" ");
        if ((split[0].trim()).equals(u.trim())){
        tagasta=split;
        }
      }
    return tagasta;
  }
  public double getRuumala(String u)throws IOException{
    return Double.parseDouble(lugeja(u)[1]);
  }
  public String getJookVaadis(String u)throws IOException{
    return lugeja(u)[0];
  }
  public double getJoogiKogus(String u)throws IOException{
    return  Double.parseDouble(lugeja(u)[2]);
  }
}
