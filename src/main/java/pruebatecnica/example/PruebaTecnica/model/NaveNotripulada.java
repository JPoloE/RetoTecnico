package pruebatecnica.example.PruebaTecnica.model;


public class NaveNotripulada extends NaveEspacial{

    private String explorer;
    private String orbiteBody;

    public NaveNotripulada(){

    }


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
