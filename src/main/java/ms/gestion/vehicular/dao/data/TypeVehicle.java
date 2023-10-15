package ms.gestion.vehicular.dao.data;

import jakarta.persistence.*;

@Entity
@Table(name = "type_vehicle")
public class TypeVehicle {
    @Id
    @SequenceGenerator(name="s_type_vehicle", sequenceName = "s_type_vehicle",allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_type_vehicle")
    @Column(name = "type_id")
    private long id;

    @Column(name = "type_name")
    private String name;

    public TypeVehicle() {
    }

    public TypeVehicle(long id, String name) {
        this.id = id;
        this.name = name;
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
