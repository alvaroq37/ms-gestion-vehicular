package ms.gestion.vehicular.dao.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import ms.gestion.vehicular.dao.data.City;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CityRepository implements PanacheRepository<City> {

    public List<City> findAllCity(){return listAll();}

    public City findCityById(long id){
        return find("id", id).firstResult();
    }

    public void createCity(City city){persist(city);}

    public Optional<City> updateCity(City city){
        final var id = city.getId();

        var saveOpt = this.findByIdOptional(id);

        if(saveOpt.isEmpty()){
            return Optional.empty();
        }
        var saved = saveOpt.get();
        saved.setName(city.getName());
        saved.setCountryId(city.getCountryId());

        return Optional.of(saved);
    }

}
