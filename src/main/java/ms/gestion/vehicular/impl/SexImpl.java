package ms.gestion.vehicular.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import ms.gestion.vehicular.dao.data.Sex;
import ms.gestion.vehicular.dao.repository.SexRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class SexImpl {

    @Inject
    SexRepository sexRepository;

    public List<Sex> findAllSex(){return sexRepository.findAllSex();}

    public Sex findSexById(long id){return sexRepository.findSexById(id);}

    public void createSex(Sex sex){sexRepository.createSex(sex);}

    public Optional<Sex> updateSex(Sex sex){return sexRepository.updateSex(sex);}
}
