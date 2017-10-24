package ch.hegarc.odi.serie4.services;

import ch.hegarc.odi.serie4.business.Movie;
import ch.hegarc.odi.serie4.business.Person;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.util.*;


@Stateless
public class PersonMovieService {

    private Map<Long, Person> mapPerson;
    private Map<Long, Movie> mapMovie;

    @PostConstruct
    public void init(){

        mapPerson = new HashMap<Long, Person>();

        Person p1 = new Person(Long.valueOf(1001),"Myriam", "Schaffter");
        Person p2 = new Person(Long.valueOf(1002), "Mark", "Johnes");
        Person p3 = new Person(Long.valueOf(1003),"Andrea", "Davis");
        Person p4 = new Person(Long.valueOf(1004), "Zoe", "Smith");

        mapPerson.put(p1.getId(),p1);
        mapPerson.put(p2.getId(),p2);
        mapPerson.put(p3.getId(),p3);
        mapPerson.put(p4.getId(),p4);

        mapMovie = new HashMap<Long, Movie>();

        Movie m1 = new Movie(Long.valueOf(2001),"La Ligne verte", "Frank Darabont");
        Movie m2 = new Movie(Long.valueOf(2002), "La Liste de Schindler", "Steven Spielberg");
        Movie m3 = new Movie(Long.valueOf(2003),"Le Parrain", "Francis Ford Coppola");
        Movie m4 = new Movie(Long.valueOf(2004), "Gran Torino", "Clint Eastwood");
        Movie m5 = new Movie(Long.valueOf(2005), "Pulp Fiction", "Quentin Tarantino");

        mapMovie.put(m1.getId(),m1);
        mapMovie.put(m2.getId(),m2);
        mapMovie.put(m3.getId(),m3);
        mapMovie.put(m4.getId(),m4);
        mapMovie.put(m5.getId(),m5);


        p1.addMovie(m1);
        p1.addMovie(m2);

        p3.addMovie(m1);
        p3.addMovie(m2);
        p3.addMovie(m4);
        p3.addMovie(m5);

        p4.addMovie(m3);

    }

    public Person getPerson(Long id){

        return mapPerson.get(id);
    }

    public List getPeople(){

        List l = new ArrayList<Person>();

        Iterator i = mapPerson.keySet().iterator();
        while (i.hasNext()){
            l.add(mapPerson.get((Long)i.next()));
        }
        return l;
    }

    public boolean addPerson(Long id, String firstName, String lastName){
        if(id!=null){
            this.mapPerson.put(id, new Person(id, firstName, lastName));
            return true;
        } else {
            return false;}
    }

    public boolean updatePerson(Long id, String fistName, String lastName) {
        if (id != null) {
            Person p = this.mapPerson.get(id);
            if (p != null) {
                p.setFirstName(fistName);
                p.setLastName(lastName);
                return true;
            }
        }

        return false;

    }
    public boolean deletePerson(Long id){
        Person p = this.mapPerson.remove(id);
        if(p==null) {
            return false;
        } else{
                return true;
            }
        }


    public Movie getMovie(Long id){
        return mapMovie.get(id);

    }

    public List getMovies(){
        List l = new ArrayList<Movie>();

        Iterator i = mapMovie.keySet().iterator();
        while (i.hasNext()){
            l.add(mapMovie.get((Long)i.next()));
        }
        return l;
    }



    public boolean addMovie(Long id, String name, String producer){
        if(id!=null){
            this.mapMovie.put(id, new Movie(id, name, producer));
            return true;
        } else {
            return false;}
    }

    public boolean updateMovie(Long id, String name, String producer) {
        if (id != null) {
            Movie m = this.mapMovie.get(id);
            if (m != null) {
                m.setName(name);
                m.setName(producer);
                return true;
            }
        }

        return false;

    }
    public boolean deleteMovie(Long id){
        Movie m = this.mapMovie.remove(id);
        if(m==null) {
            return false;
        } else{
            return true;
        }
    }

    public boolean addMoviePerson(Long idP, Long idM){
        Person p = mapPerson.get(idP);
        if(p!=null){
            Movie m = mapMovie.get(idM);
            if(m!=null){
                p.addMovie(m);
                return true;
            }
        }
        return false;
    }



}
