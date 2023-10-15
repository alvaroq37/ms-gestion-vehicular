package ms.gestion.vehicular.dao.data;

import jakarta.persistence.*;

@Entity
@Table(name="city")
public class City {
    @Id
    @SequenceGenerator(name="s_city", sequenceName = "s_city",allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_city")
    @Column(name="cit_id")
    private long id;
    @Column(name="cit_name")
    private String name;
    @Column(name="country_id")
    private int countryId;
    public City(long id, String name, int countryId) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
    }

    public City() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
}
