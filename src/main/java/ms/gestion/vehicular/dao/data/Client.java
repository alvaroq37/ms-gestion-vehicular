package ms.gestion.vehicular.dao.data;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @SequenceGenerator(name="s_client", sequenceName = "s_client",allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_client")
    @Column(name="cli_id")
    private long id;
    @Column(name="cli_ci")
    private String ci;
    @Column(name = "cli_names")
    private String names;
    @Column(name="cli_last_name_paternal")
    private String lastNamesPaternal;
    @Column(name="cli_last_name_maternal")
    private String lastNamesMaternal;
    @Column(name="cli_address")
    private String address;
    @Column(name="cli_cell_phone")
    private int cellPhone;
    @Column(name="cli_phone")
    private int phone;
    @Column(name="cli_email")
    private String email;
    @Column(name="cli_date_birth")
    private Date dateBirth;
    @Column(name = "sex_id")
    private long sexId;
    @Column(name="city_id")
    private long cityId;
    @Column(name="occupation_id")
    private long occupationId;

    public Client() {
    }

    public Client(long id, String ci, String names, String lastNamesPaternal, String lastNamesMaternal, String address, int cellPhone, int phone, String email, Date dateBirth, long sexId, long cityId, long occupationId) {
        this.id = id;
        this.ci = ci;
        this.names = names;
        this.lastNamesPaternal = lastNamesPaternal;
        this.lastNamesMaternal = lastNamesMaternal;
        this.address = address;
        this.cellPhone = cellPhone;
        this.phone = phone;
        this.email = email;
        this.dateBirth = dateBirth;
        this.sexId = sexId;
        this.cityId = cityId;
        this.occupationId = occupationId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNamesPaternal() {
        return lastNamesPaternal;
    }

    public void setLastNamesPaternal(String lastNamesPaternal) {
        this.lastNamesPaternal = lastNamesPaternal;
    }

    public String getLastNamesMaternal() {
        return lastNamesMaternal;
    }

    public void setLastNamesMaternal(String lastNamesMaternal) {
        this.lastNamesMaternal = lastNamesMaternal;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(int cellPhone) {
        this.cellPhone = cellPhone;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public long getSexId() {
        return sexId;
    }

    public void setSexId(long sexId) {
        this.sexId = sexId;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public long getOccupationId() {
        return occupationId;
    }

    public void setOccupationId(long occupationId) {
        this.occupationId = occupationId;
    }
}
