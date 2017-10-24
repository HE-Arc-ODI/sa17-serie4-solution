package ch.hegarc.odi.serie4.servicesREST;

import ch.hegarc.odi.serie4.business.Movie;
import ch.hegarc.odi.serie4.services.PersonMovieService;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/movies")
public class MovieServicesREST {


    @Inject
    private PersonMovieService pms;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_XML)
    public List<Movie> getMovies(){
        return pms.getMovies();
    }

    @GET
    @Path("/{movieid}")
    @Produces(MediaType.APPLICATION_XML)
    public Movie getMovie(@PathParam("movieid") Long movieid){
        return pms.getMovie(movieid);
    }


    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String createMovie(@FormParam("id") Long movieid, @FormParam("name") String name, @FormParam("producer") String producer){
        boolean b = pms.addMovie(movieid, name, producer);
        if(b==true){
            return "SUCCESS";
        }else{
            return "FAIL";
        }
    }

    @DELETE
    @Path("/{movieid}")
    public String deleteMovie(@PathParam("movieid") Long movieid){
        boolean b = pms.deleteMovie(movieid);
        if(b==true){
            return "SUCCESS";
        }else{
            return "FAIL";
        }
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String updatePeople(@FormParam("id") Long movieid, @FormParam("name") String name, @FormParam("producer") String producer){
        boolean b = pms.updateMovie(movieid, name, producer);
        if(b==true){
            return "SUCCESS";
        }else{
            return "FAIL";
        }
    }


}
