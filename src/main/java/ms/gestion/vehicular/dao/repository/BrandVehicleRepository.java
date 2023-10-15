package ms.gestion.vehicular.dao.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import ms.gestion.vehicular.dao.data.BrandVehicle;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BrandVehicleRepository implements PanacheRepository<BrandVehicle> {
    public List<BrandVehicle> findAllBrandVehicle(){
        return listAll();
    }

    public BrandVehicle findBrandVehicleById(Long id){
        return find("id", id).firstResult();
    }

    public void createBrandVehicle(BrandVehicle brandVehicle){
        persist(brandVehicle);
    }

    public Optional<BrandVehicle> updateBrandVehicle(BrandVehicle brandVehicle){
        final var id = brandVehicle.getId();
        var saveOpt = this.findByIdOptional(id);

        if(saveOpt.isEmpty()){
            return Optional.empty();
        }
        var saved = saveOpt.get();
        saved.setBrandName(brandVehicle.getBrandName());

        return Optional.of(saved);
    }
}
