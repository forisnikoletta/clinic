package edu.wk.clinic.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "consultations")
@NamedQueries({
        @NamedQuery(name = Consultation.QUERY_FIND_BY_DISEASE, query = "Select c from Consultation c where mo.Consultation.id = :diseaseId"),
        @NamedQuery(name = Consultation.QUERY_FIND_BY_USER, query = "Select c from C c where mo.user.id = :userId")
})
public class Consultation extends BaseEntity {
    public static final String QUERY_FIND_BY_USER =  "Consultation.findByUserId";
    public static final String QUERY_FIND_BY_DISEASE =  "Consultation.findByDiseaseId";

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "diseaseId")
    private Disease disease;

    @Column(nullable = false)
    private Date date;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Consultation")
    private List<State> states;

    public Consultation() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "user=" + user +
                ", disease=" + disease +
                ", date=" + date +
                ", states=" + states +
                '}';
    }

    public int getLastState() {
        if(states == null || states.isEmpty()) {
            return  -1;
        } else {
            return states.get(states.size() - 1).getState();
        }
    }
}
