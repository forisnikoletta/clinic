package edu.wk.clinic.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sicknesses")
@NamedQueries({
        @NamedQuery(name = Sickness.QUERY_FIND_BY_NAME, query = "from Sickness f where f.name = :name")
})
public class Sickness extends BaseEntity {
    public static final String QUERY_FIND_BY_NAME=  "User.findByName";

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int time;

    @ManyToMany(mappedBy = "sicknesses")
    private List<Disease> diseases;

    public Sickness() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Disease> disease) {
        this.diseases = diseases;
    }

    @Override
    public String toString() {
        return "Sickness{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
