package ms.gestion.vehicular.dao.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import ms.gestion.vehicular.dao.data.Year;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class YearRepository implements PanacheRepository<Year> {
    public List<Year> findAllYear(){ return listAll();}

    public Year findYearById(long id){
        return  find("id", id).firstResult();
    }

    public void createYear(Year year){
        persist(year);
    }

    public Optional<Year> updateYear(Year year){
        final var id = year.getId();
        var saveOpt = this.findByIdOptional(id);

        if(saveOpt.isEmpty()){
            return Optional.empty();
        }
        var saved = saveOpt.get();
        saved.setWorth(year.getWorth());

        return Optional.of(saved);
    }
}
