package ms.gestion.vehicular.dao.data;

import jakarta.persistence.*;

@Entity
@Table(name="sex")
public class Sex {
    @Id
    @SequenceGenerator(name="s_sex", sequenceName = "s_sex",allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_sex")
    @Column(name="sex_id")
    private long id;
    @Column(name="sex_description")
    private String description;

    public Sex(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Sex() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
