package melissa;

public class Proov1{
    public static void main(String[] arg){
        Jook j1=new Jook("Õlu", 0.90);
        Joogipudel p1=new Joogipudel();
        p1.maht=0.5;
        p1.tyyp=pudelityyp.KLAAS;
        p1.pudelimass=0.25;
        p1.taarahind=0.1;
        p1.j=j1;

        Jook j2=new Jook("Siirup", 0.75,1.6);
        Joogipudel p2=new Joogipudel();
        p2.maht=0.25;
        p2.tyyp=pudelityyp.PLASTIK;
        p2.pudelimass=0.05;
        p2.taarahind=0.1;
        p2.j=j2;

        System.out.println(j1.nimetus+" mass: "+p1.koguMass()+" ja hind: "+((j1.omahind*p1.maht)+p1.taarahind));
        System.out.println(j2.nimetus+" mass: "+p2.koguMass()+" ja hind: "+((j2.omahind*p2.maht)+p2.taarahind));
    }
}