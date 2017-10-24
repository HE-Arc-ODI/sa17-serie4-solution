package ch.hegarc.odi.serie4.business;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Movie")
public class Movie implements Serializable {

    private Long id;
    private String name;
    private String producer;

    public Movie(){
    }

    public Movie(Long id, String n, String p){
        this.id = id;
        this.setName(n);
        this.producer = p;

    }

    public Long getId() {
        return id;
    }

    @XmlElement
    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    @XmlElement
    public void setProducer(String producer) {
        this.producer = producer;
    }
}
