package tanel;

public class vagaAktiivne extends Baas{

    public vagaAktiivne(int kaal, int pikkus, int vanus){
        super(kaal, pikkus, vanus);
    }

    @Override
    public double aktiivususArv(){
        return 1.9;
    }

}
