package ms.gestion.vehicular.dao.data;

import jakarta.persistence.*;

@Entity
@Table(name="occupation")
public class Occupation {
    @Id
    @SequenceGenerator(name="s_occupation", sequenceName = "s_occupation",allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_occupation")
    @Column(name="occ_id")
    private long id;
    @Column(name="occ_description")
    private String description;

    public Occupation(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Occupation() {
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
