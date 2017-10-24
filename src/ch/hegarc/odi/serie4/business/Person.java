package ch.hegarc.odi.serie4.business;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Person")
public class Person implements Serializable {

     private Long id;
     private String firstName;
     private String lastName;
     private List<Movie> movies;

    public Person(){
        movies = new ArrayList<Movie>();
    }

    public Person(Long id, String f, String l){
        this.id = id;
        this.firstName = f;
        this.lastName = l;
        movies = new ArrayList<Movie>();
    }

    public Long getId() {
        return id;
    }

    @XmlElement
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @XmlElement
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    @XmlElement
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie){
        this.movies.add(movie);
    }

}
