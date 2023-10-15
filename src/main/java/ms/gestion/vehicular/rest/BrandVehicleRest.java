package ms.gestion.vehicular.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ms.gestion.vehicular.dao.data.BrandVehicle;
import ms.gestion.vehicular.impl.BrandVehicleImpl;
import java.util.List;
import java.util.Optional;

@Path("api/brand-vehicle")
@ApplicationScoped
public class BrandVehicleRest {

    @Inject
    BrandVehicleImpl brandVehicleImpl;
    @GET
    @Path("/find-all")
    @Produces(MediaType.APPLICATION_JSON)
    public String findAllBrandVehicle() throws JsonProcessingException {
        List<BrandVehicle> brandVehicle = brandVehicleImpl.findAllBrandVehicle();
        Response response = Response.ok(brandVehicle).build();
        if(response.getStatus() == 200){
            if(brandVehicle.isEmpty()){
                response = Response.ok("La lista de datos está vacía").build();
            }
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(response.getEntity());

        }
        return null;
    }
    @GET
    @Path("/find-by-id")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String findBrandVehicleById(JsonObject jsonBrandVehicle) throws JsonProcessingException {
        long id = jsonBrandVehicle.getLong("id");
        BrandVehicle brandVehicle = brandVehicleImpl.findBrandVehicleById(id);
        Response response = Response.ok(brandVehicle).build();
        if(response.getStatus()==200){
            if(response.getEntity() == null){
                response = Response.ok("No se encontraron datos con la información especificada").build();
            }
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(response.getEntity());
        }
        return null;
    }

    @POST
    @Path("/create")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject createBrandVehicle(JsonObject brandVehicle) {
        BrandVehicle createBrandVehicle = Json.decodeValue(brandVehicle.toString(), BrandVehicle.class);
        brandVehicleImpl.createBrandVehicle(createBrandVehicle);
        Response response = Response.ok(createBrandVehicle).build();
        if(response.getStatus()==200){
            return JsonObject.mapFrom(response.getEntity());
        }
        return null;
    }

    @PUT
    @Path("/update")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject updateBrandVehicle(JsonObject brandVehicle) {
        BrandVehicle updateBrandVehicle = Json.decodeValue(brandVehicle.toString(), BrandVehicle.class);
        Optional<BrandVehicle> optionalBrandVehicle = brandVehicleImpl.updateBrandVehicle(updateBrandVehicle);
        Response response = Response.ok(optionalBrandVehicle).build();
        if(response.getStatus()==200){
            //ObjectMapper mapper = new ObjectMapper();
            response = Response.ok(updateBrandVehicle).build();
            return JsonObject.mapFrom(response.getEntity());
        }
        return null;
    }
}
