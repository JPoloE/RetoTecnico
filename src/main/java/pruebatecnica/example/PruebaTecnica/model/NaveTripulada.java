package pruebatecnica.example.PruebaTecnica.model;


public class NaveTripulada extends NaveEspacial{
    //Nave Tripulada
    private int people;
    private String orbite;


    public NaveTripulada(){

    }

    //Contructores
    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public String getOrbite() {
        return orbite;
    }

    public void setOrbite(String orbite) {
        this.orbite = orbite;
    }
}
