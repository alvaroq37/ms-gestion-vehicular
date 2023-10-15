package ms.gestion.vehicular.dao.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import ms.gestion.vehicular.dao.data.Country;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CountryRepository implements PanacheRepository<Country> {
    public List<Country> findAllCountry(){return listAll();}

    public Country findCountryById(long id){
        return find("id", id).firstResult();
    }

    public void createCountry(Country country){persist(country);}

    public Optional<Country> updateCountry(Country country){
        final var id = country.getId();

        var saveOpt = this.findByIdOptional(id);

        if(saveOpt.isEmpty()){
            return Optional.empty();
        }

        var saved = saveOpt.get();
        saved.setName(country.getName());

        return Optional.of(saved);
    }
}
