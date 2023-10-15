package ms.gestion.vehicular.dao.data;

import jakarta.persistence.*;

@Entity
@Table(name="year")
public class Year {
    @Id
    @SequenceGenerator(name="s_year", sequenceName = "s_year",allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_year")
    @Column(name="year_id")
    private long id;
    @Column(name="year_worth")
    private int worth;

    public Year(int id, int worth) {
        this.id = id;
        this.worth = worth;
    }

    public Year() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorth() {
        return worth;
    }

    public void setWorth(int worth) {
        this.worth = worth;
    }
}
