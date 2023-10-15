package ms.gestion.vehicular.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import ms.gestion.vehicular.dao.data.BrandVehicle;
import ms.gestion.vehicular.dao.repository.BrandVehicleRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BrandVehicleImpl {

    @Inject
    BrandVehicleRepository brandVehicleRepository;

    public List<BrandVehicle> findAllBrandVehicle(){
        return brandVehicleRepository.findAllBrandVehicle();
    }

    public BrandVehicle findBrandVehicleById(long id){
        return brandVehicleRepository.findBrandVehicleById(id);
    }

    public void createBrandVehicle(BrandVehicle brandVehicle){
        brandVehicleRepository.createBrandVehicle(brandVehicle);
    }

    public Optional<BrandVehicle> updateBrandVehicle(BrandVehicle brandVehicle){
        return brandVehicleRepository.updateBrandVehicle(brandVehicle);
    }
}
