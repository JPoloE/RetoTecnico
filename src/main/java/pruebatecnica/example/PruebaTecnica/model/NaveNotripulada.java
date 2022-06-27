package pruebatecnica.example.PruebaTecnica.model;


public class NaveNotripulada extends NaveEspacial{
    //Nave no tripulada
    private String orbiteBody;

    public NaveNotripulada(){

    }

    //Contructores

    public String getOrbiteBody() {
        return orbiteBody;
    }

    public void setOrbiteBody(String orbiteBody) {
        this.orbiteBody = orbiteBody;
    }
}
