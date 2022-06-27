package pruebatecnica.example.PruebaTecnica.model;


public class NaveNotripulada extends NaveEspacial{
    //Nave no tripulada
    private String explorer;
    private String orbiteBody;

    public NaveNotripulada(){

    }

    //Contructores
    public String getExplorer() {
        return explorer;
    }

    public void setExplorer(String explorer) {
        this.explorer = explorer;
    }

    public String getOrbiteBody() {
        return orbiteBody;
    }

    public void setOrbiteBody(String orbiteBody) {
        this.orbiteBody = orbiteBody;
    }
}
