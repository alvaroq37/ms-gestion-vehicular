package ms.gestion.vehicular.dao.data;

import jakarta.persistence.*;

@Entity
@Table(name="country")
public class Country {
    @Id
    @SequenceGenerator(name="s_country", sequenceName = "s_country",allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_country")
    @Column(name="cou_id")
    private long id;
    @Column(name="cou_name")
    private String name;

    public Country(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Country() {
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
}
