package ms.gestion.vehicular.dao.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import ms.gestion.vehicular.dao.data.DetailSale;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class DetailSaleRepository implements PanacheRepository<DetailSale> {

    public List<DetailSale> findAllDetailSale(){return listAll();}

    public DetailSale findDetailSaleById(long id){
        return find("id", id).firstResult();
    }

    public void createDetailSale(DetailSale detailSale){
        persist(detailSale);
    }

    public Optional<DetailSale> updateDetailSale(DetailSale detailSale){
        final var id = detailSale.getId();

        var saveOpt = this.findByIdOptional(id);

        if(saveOpt.isEmpty()){
            return Optional.empty();
        }
        var saved = saveOpt.get();
        saved.setDiscount(detailSale.getDiscount());
        saved.setClientId(detailSale.getClientId());
        saved.setVehicleId(detailSale.getVehicleId());

        return Optional.of(saved);
    }
}
