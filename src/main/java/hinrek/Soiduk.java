public class Soiduk {
    public String mudel;
    public String voimsus;

    public Soiduk (String mudel) {
        this.mudel = mudel;
        
    }

    public Soiduk (String mudel, String voimsus){
        this.mudel = mudel;
        this.voimsus = voimsus;

    }

    @Override    
    public String toString(){
        String ajutinemudel = mudel;
        if (voimsus != null){
            ajutinemudel = ajutinemudel + " | " + voimsus;
        }

        return ajutinemudel;
    }

}