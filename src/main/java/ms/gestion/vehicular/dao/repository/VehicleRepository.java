package ms.gestion.vehicular.dao.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import ms.gestion.vehicular.dao.data.Vehicle;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class VehicleRepository implements PanacheRepository<Vehicle> {

    public List<Vehicle> findAllVehicle(){return listAll();}

    public Vehicle findVehicleById(long id){return find("id", id).firstResult();}

    public void createVehicle(Vehicle vehicle){persist(vehicle);}

    public Optional<Vehicle> updateVehicle(Vehicle vehicle){
        final var id = vehicle.getId();

        var saveOpt = this.findByIdOptional(id);

        if(saveOpt.isEmpty()){
            return Optional.empty();
        }

        var saved = saveOpt.get();
        saved.setCostCif(vehicle.getCostCif());
        saved.setCostInvoiced(vehicle.getCostInvoiced());
        saved.setBrandVehicleId(vehicle.getBrandVehicleId());
        saved.setTypeVehicleId(vehicle.getTypeVehicleId());
        saved.setYearId(vehicle.getYearId());
        saved.setChassis(vehicle.getChassis());
        saved.setColor(vehicle.getColor());
        saved.setModel(vehicle.getModel());

        return Optional.of(saved);
    }
}
