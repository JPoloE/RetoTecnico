package pruebatecnica.example.PruebaTecnica.model;


import javax.persistence.*;

@Entity
@Table(name = "nave_espacial")
@NamedEntityGraph(name = "nave.graph")
public class NaveEspacial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int weigth;
    private String yearOpen;
    private String yearClose;
    private String mision;
    private String force;
    private String tipe;
    private String combustible;
    private String country;

    public NaveEspacial() {
    }


    public String getTipe() {
        return tipe;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public int getId() {
        return Math.toIntExact(id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeigth() {
        return weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    public String getYearOpen() {
        return yearOpen;
    }

    public void setYearOpen(String yearOpen) {
        this.yearOpen = yearOpen;
    }

    public String getYearClose() {
        return yearClose;
    }

    public void setYearClose(String yearClose) {
        this.yearClose = yearClose;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getForce() {
        return force;
    }

    public void setForce(String force) {
        this.force = force;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
