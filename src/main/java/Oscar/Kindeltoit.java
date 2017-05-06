package Oscar;

public class Kindeltoit{

    Toituaine nimi1;
    double kogus1;
    Toituaine nimi2;
    double kogus2;
    Toituaine nimi3;
    double kogus3;

    public void Kindeltoit(Toituaine nimi1, double kogus1, Toituaine nimi2, double kogus2, Toituaine nimi3, double kogus3){
        this.nimi1=nimi1;
        this.kogus1=kogus1;
        this.nimi2=nimi2;
        this.kogus2=kogus2;
        this.nimi3=nimi3;
        this.kogus3=kogus3;
    }

    public double saakalorid(){        
        return (nimi1.kalorid*kogus1)+(nimi2.kalorid*kogus2)+(nimi3.kalorid*kogus3);
    }

}