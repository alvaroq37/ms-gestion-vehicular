package ms.gestion.vehicular.dao.data;

import jakarta.persistence.*;

@Entity
@Table(name = "brand_vehicle")
public class BrandVehicle {
    @Id
    @SequenceGenerator(name="s_brand_vehicle", sequenceName = "s_brand_vehicle",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "s_brand_vehicle")
    @Column(name = "brand_id")
    private long id;

    @Column(name = "brand_name")
    private String brandName;

    public BrandVehicle() {
    }

    public BrandVehicle(long id, String brandName) {
        this.id = id;
        this.brandName = brandName;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
