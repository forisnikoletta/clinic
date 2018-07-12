package edu.wk.clinic.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "diseases")
public class Disease extends BaseEntity{
    @Column(nullable = false)
    private String name;



    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "diseasesickness",
            joinColumns = @JoinColumn(name = "diseaseid"),
            inverseJoinColumns = @JoinColumn(name = "sicknessid")
    )
    private Set<Sickness> sicknesses;

    public Disease() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Sickness> getSicknesses() {
        return sicknesses;
    }

    public void setSicknesses(Set<Sickness> sicknesses) {
        this.sicknesses = sicknesses;
    }

    @Override
    public String toString() {
        return "Disease{" +
                ", sicknesses=" + sicknesses +
                '}';
    }
}
