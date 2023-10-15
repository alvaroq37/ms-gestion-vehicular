package ms.gestion.vehicular.dao.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import ms.gestion.vehicular.dao.data.Client;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ClientRepository implements PanacheRepository<Client> {

    public List<Client> findAllClient(){return listAll();}

    public Client findClientByCi(String ci){
        return find("ci", ci).firstResult();
    }

    public void createClient(Client client){
        persist(client);
    }

    public Optional<Client> updateClient(Client client){
        final var id = client.getId();
        var saveOpt = this.findByIdOptional(id);

        if(saveOpt.isEmpty()){
            return Optional.empty();
        }
        var saved = saveOpt.get();

        saved.setCellPhone(client.getCellPhone());
        saved.setPhone(client.getCellPhone());
        saved.setDateBirth(client.getDateBirth());
        saved.setCityId(client.getSexId());
        saved.setOccupationId(client.getOccupationId());
        saved.setSexId(client.getSexId());
        saved.setAddress(client.getAddress());
        saved.setCi(client.getCi());
        saved.setEmail(client.getEmail());
        saved.setLastNamesMaternal(client.getLastNamesMaternal());
        saved.setLastNamesPaternal(client.getLastNamesPaternal());
        saved.setNames(client.getNames());

        return Optional.of(saved);
    }
}
