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
import ms.gestion.vehicular.dao.data.Country;
import ms.gestion.vehicular.impl.CountryImpl;

import java.util.List;
import java.util.Optional;

@Path("/api/country")
@ApplicationScoped
public class CountryRest {

    @Inject
    CountryImpl countryImpl;

    @GET
    @Path("/find-all")
    @Produces(MediaType.APPLICATION_JSON)
    public String findAllCountry() throws JsonProcessingException {
        List<Country> countryList = countryImpl.findAllCountry();
        Response response = Response.ok(countryList).build();
        if(response.getStatus() == 200){
            if(countryList.isEmpty()){
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
    public String findCountryById(JsonObject jsonCountry) throws JsonProcessingException {
        long id = jsonCountry.getLong("id");
        Country country = countryImpl.findCountryById(id);
        Response response = Response.ok(country).build();
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
    public JsonObject createCountry(JsonObject country){
        Country createCountry = Json.decodeValue(country.toString(), Country.class);
        countryImpl.createCountry(createCountry);
        Response response = Response.ok(createCountry).build();
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
    public JsonObject updateCountry(JsonObject country){
        Country updateCountry = Json.decodeValue(country.toString(), Country.class);
        Optional<Country> optionalCountry = countryImpl.updateCountry(updateCountry);
        Response response = Response.ok(optionalCountry).build();
        if(response.getStatus() == 200){
            response = Response.ok(updateCountry).build();
            return JsonObject.mapFrom(response.getEntity());
        }
        return null;
    }
}
