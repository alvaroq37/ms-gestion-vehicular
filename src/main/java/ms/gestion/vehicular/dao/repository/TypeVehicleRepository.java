package ms.gestion.vehicular.dao.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import ms.gestion.vehicular.dao.data.TypeVehicle;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class TypeVehicleRepository implements PanacheRepository<TypeVehicle> {

    public List<TypeVehicle> findAllTypeVehicle(){return listAll();}

    public TypeVehicle findTypeVehicleById(long id){return find("id", id).firstResult();}

    public void createTypeVehicle(TypeVehicle typeVehicle){persist(typeVehicle);}

    public Optional<TypeVehicle> updateTypeVehicle(TypeVehicle typeVehicle){
        final var id = typeVehicle.getId();

        var saveOpt = this.findByIdOptional(id);

        if(saveOpt.isEmpty()){
            return Optional.empty();
        }

        var saved = saveOpt.get();

        saved.setName(typeVehicle.getName());

        return Optional.of(saved);
    }
}
