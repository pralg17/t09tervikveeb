package melissa;

public class Joogipudel {
    Jook j;
    double maht;
    pudelityyp tyyp;
    double pudelimass;
    double taarahind;
    double koguMass(){
        if(j==null){return pudelimass;}
        return pudelimass+maht*j.erikaal;
    }

}