package ms.gestion.vehicular.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import ms.gestion.vehicular.dao.data.City;
import ms.gestion.vehicular.dao.repository.CityRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CityImpl {

    @Inject
    CityRepository cityRepository;

    public List<City> findAllCity(){ return cityRepository.findAllCity();}

    public City findCityById(long id){return cityRepository.findCityById(id);}

    public void createCity(City city){cityRepository.createCity(city);}

    public Optional<City> updateCity(City city){return cityRepository.updateCity(city);}
}
