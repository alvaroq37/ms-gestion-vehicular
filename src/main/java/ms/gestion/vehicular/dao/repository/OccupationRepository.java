package ms.gestion.vehicular.dao.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import ms.gestion.vehicular.dao.data.Occupation;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OccupationRepository implements PanacheRepository<Occupation> {

    public List<Occupation> findAllOccupation(){return listAll();}

    public Occupation findOccupationById(long id){
        return find("id", id).firstResult();
    }

    public void createOccupation(Occupation occupation){
        persist(occupation);
    }

    public Optional<Occupation> updateOccupation(Occupation occupation){
        final var id = occupation.getId();

        var saveOpt = this.findByIdOptional(id);

        if(saveOpt.isEmpty()){
            return Optional.empty();
        }

        var saved = saveOpt.get();

        saved.setDescription(occupation.getDescription());

        return Optional.of(saved);
    }
}
