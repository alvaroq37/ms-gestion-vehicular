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
import ms.gestion.vehicular.dao.data.Sex;
import ms.gestion.vehicular.impl.SexImpl;
import java.util.List;
import java.util.Optional;

@Path("/api/sex")
@ApplicationScoped
public class SexRest {

    @Inject
    SexImpl sexImpl;

    @GET
    @Path("/find-all")
    @Produces(MediaType.APPLICATION_JSON)
    public String findAllSex() throws JsonProcessingException {
        List<Sex> sexList = sexImpl.findAllSex();
        Response response = Response.ok(sexList).build();
        if(response.getStatus() == 200){
            if(sexList.isEmpty()){
                response = Response.ok("No se encontraron datos").build();
            }
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(response.getEntity());
        }
        return null;
    }


    @GET
    @Path("/find-by-id")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String findSexById(JsonObject jsonCountry) throws JsonProcessingException {
        long id = jsonCountry.getLong("id");
        Sex sex = sexImpl.findSexById(id);
        Response response = Response.ok(sex).build();
        if(response.getStatus() == 200){
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
    public JsonObject createSex(JsonObject sex){
        Sex createSex = Json.decodeValue(sex.toString(), Sex.class);
        sexImpl.createSex(createSex);
        Response response = Response.ok(createSex).build();
        if(response.getStatus() == 200){
            return JsonObject.mapFrom(response.getEntity());
        }
        return null;
    }

    @PUT
    @Path("/update")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject updateSex(JsonObject sex){
        Sex updateSex = Json.decodeValue(sex.toString(), Sex.class);
        Optional<Sex> optionalSex = sexImpl.updateSex(updateSex);
        Response response = Response.ok(optionalSex).build();
        if(response.getStatus() == 200){
            response = Response.ok(updateSex).build();
            return JsonObject.mapFrom(response.getEntity());
        }
        return null;
    }
}
