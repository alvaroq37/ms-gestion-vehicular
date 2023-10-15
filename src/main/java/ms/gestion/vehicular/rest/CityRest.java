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
import ms.gestion.vehicular.dao.data.City;
import ms.gestion.vehicular.impl.CityImpl;
import java.util.List;
import java.util.Optional;

@Path("/api/city")
@ApplicationScoped
public class CityRest {

    @Inject
    CityImpl cityImpl;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/find-all")
    public String findAllCity() throws JsonProcessingException {

        List<City> cityList = cityImpl.findAllCity();
        Response response = Response.ok(cityList).build();
        if(response.getStatus()==200){
            if(cityList.isEmpty()){
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
    public String findCityById(JsonObject jsonCity) throws JsonProcessingException {
        long id = jsonCity.getLong("id");
        City city = cityImpl.findCityById(id);
        Response response = Response.ok(city).build();
        if(response.getStatus()==200){
            if(response.getEntity() == null){
                response = Response.ok("No se encontraron datos").build();

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
    public JsonObject createCity(JsonObject city) {
        City createCity = Json.decodeValue(city.toString(), City.class);
        cityImpl.createCity(createCity);
        Response response = Response.ok(createCity).build();
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
    public JsonObject updateCity(JsonObject city){
        City updateCity = Json.decodeValue(city.toString(), City.class);
        Optional<City> optionalCity = cityImpl.updateCity(updateCity);
        Response response = Response.ok(optionalCity).build();
        if(response.getStatus() == 200){
            response = Response.ok(updateCity).build();
            return JsonObject.mapFrom(response.getEntity());
        }
        return null;
    }
}
