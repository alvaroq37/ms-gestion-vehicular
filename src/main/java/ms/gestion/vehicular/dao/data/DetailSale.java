package ms.gestion.vehicular.dao.data;

import jakarta.persistence.*;

@Entity
@Table(name = "detail_sale")
public class DetailSale {
    @Id
    @SequenceGenerator(name="s_detail_sale", sequenceName = "s_detail_sale",allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_detail_sale")
    @Column(name = "sale_id")
    private long id;

    @Column(name = "sale_discount")
    private float discount;

    @Column(name = "client_id")
    private int clientId;

    @Column(name = "vehicle_id")
    private int vehicleId;

    public DetailSale() {
    }

    public DetailSale(long id, float discount, int clientId, int vehicleId) {
        this.id = id;
        this.discount = discount;
        this.clientId = clientId;
        this.vehicleId = vehicleId;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
}
