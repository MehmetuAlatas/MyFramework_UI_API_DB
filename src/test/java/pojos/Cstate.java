package pojos;

public class Cstate {
    /*
     "cstate": {
            "id": 1262,
            "name": "Hawaii",
            "country": {
                "id": 1201,
                "name": "Türkye"
            }
     */
    private Integer id;
    private String name;
    private Country country;

    public Cstate(Integer id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Cstate() {
    }

    @Override
    public String toString() {
        return "Cstate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
