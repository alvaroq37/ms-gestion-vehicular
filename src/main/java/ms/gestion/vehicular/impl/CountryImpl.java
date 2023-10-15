package ms.gestion.vehicular.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import ms.gestion.vehicular.dao.data.Country;
import ms.gestion.vehicular.dao.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CountryImpl {
    @Inject
    CountryRepository countryRepository;

    public List<Country> findAllCountry(){return countryRepository.findAllCountry();}

    public Country findCountryById(long id){return countryRepository.findCountryById(id);}

    public void createCountry(Country country){countryRepository.createCountry(country);}

    public Optional<Country> updateCountry(Country country){return countryRepository.updateCountry(country);}
}
