package ms.gestion.vehicular.dao.data;

import jakarta.persistence.*;

@Entity
@Table(name="vehicle")
public class Vehicle {
    @Id
    @SequenceGenerator(name="s_vehicle", sequenceName = "s_vehicle",allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_vehicle")
    @Column(name = "veh_id")
    private long id;
    @Column(name = "veh_model")
    private String model;
    @Column(name="veh_chassis")
    private String chassis;
    @Column(name = "veh_color")
    private String color;
    @Column(name = "veh_cost_cif")
    private float costCif;
    @Column(name = "veh_cost_invoiced")
    private float costInvoiced;
    @Column(name = "brand_vehicle_id")
    private long brandVehicleId;
    @Column(name = "type_vehicle_id")
    private long typeVehicleId;
    @Column(name = "year_id")
    private long yearId;

    public Vehicle() {
    }

    public Vehicle(long id, String model, String chassis, String color, float costCif, float costInvoiced, long brandVehicleId, long typeVehicleId, long yearId) {
        this.id = id;
        this.model = model;
        this.chassis = chassis;
        this.color = color;
        this.costCif = costCif;
        this.costInvoiced = costInvoiced;
        this.brandVehicleId = brandVehicleId;
        this.typeVehicleId = typeVehicleId;
        this.yearId = yearId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getCostCif() {
        return costCif;
    }

    public void setCostCif(float costCif) {
        this.costCif = costCif;
    }

    public float getCostInvoiced() {
        return costInvoiced;
    }

    public void setCostInvoiced(float costInvoiced) {
        this.costInvoiced = costInvoiced;
    }

    public long getBrandVehicleId() {
        return brandVehicleId;
    }

    public void setBrandVehicleId(long brandVehicleId) {
        this.brandVehicleId = brandVehicleId;
    }

    public long getTypeVehicleId() {
        return typeVehicleId;
    }

    public void setTypeVehicleId(long typeVehicleId) {
        this.typeVehicleId = typeVehicleId;
    }

    public long getYearId() {
        return yearId;
    }

    public void setYearId(long yearId) {
        this.yearId = yearId;
    }
}
