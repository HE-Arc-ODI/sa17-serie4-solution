package ch.hegarc.odi.serie4.servicesREST;

import ch.hegarc.odi.serie4.business.Person;
import ch.hegarc.odi.serie4.services.PersonMovieService;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/people")
public class PersonServicesREST {

    @Inject
    private PersonMovieService pms;

    @GET
    @Path("/")
    @Produces(value = MediaType.APPLICATION_XML)
    public List<Person> getPeople(){
        return pms.getPeople();
    }

    @GET
    @Path("/{personid}")
    @Produces(MediaType.APPLICATION_XML)
    public Person getPerson(@PathParam("personid") Long personid){
        return pms.getPerson(personid);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String createPeople(@FormParam("id") Long personid, @FormParam("firstName") String firstName, @FormParam("lastName") String lastName){
        boolean b = pms.addPerson(personid, firstName, lastName);
        if(b==true){
            return "SUCCESS";
        }else{
            return "FAIL";
        }
    }

    @DELETE
    @Path("/{personid}")
    public String deletePeople(@PathParam("personid") Long personid){
        boolean b = pms.deletePerson(personid);
        if(b==true){
            return "SUCCESS";
        }else{
            return "FAIL";
        }
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String updatePeople(@FormParam("id") Long personid, @FormParam("firstName") String firstName, @FormParam("lastName") String lastName){
        boolean b = pms.updatePerson(personid, firstName, lastName);
        if(b==true){
            return "SUCCESS";
        }else{
            return "FAIL";
        }
    }

    @PUT
    @Path("/{personid}/movie")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String updatePeople(@PathParam("personid") Long personid, @FormParam("movieid") Long movieid){
        boolean b = pms.addMoviePerson(personid, movieid);
        if(b==true){
            return "SUCCESS";
        }else{
            return "FAIL";
        }
    }

}
