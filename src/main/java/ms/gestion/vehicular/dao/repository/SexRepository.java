package ms.gestion.vehicular.dao.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import ms.gestion.vehicular.dao.data.Sex;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class SexRepository implements PanacheRepository<Sex> {

    public List<Sex> findAllSex(){return listAll();}

    public Sex findSexById(long id){
        return find("id", id).firstResult();
    }

    public void createSex(Sex sex){persist(sex);}

    public Optional<Sex> updateSex(Sex sex){
        final var id = sex.getId();

        var saveOpt = this.findByIdOptional(id);

        if(saveOpt.isEmpty()){
            return Optional.empty();
        }

        var saved = saveOpt.get();
        saved.setDescription(sex.getDescription());

        return Optional.of(saved);
    }
}
