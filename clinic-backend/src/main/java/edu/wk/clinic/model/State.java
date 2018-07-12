package edu.wk.clinic.model;

import edu.wk.clinic.enums.STATES;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "states")
public class State extends BaseEntity {

    @Column(nullable = false)
    private int state;

    @Column(nullable = false)
    private Date date;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="ConsultationId", nullable=false)
    private Consultation Consultation;

    public State() {
    }

    public Consultation getConsultation() {
        return Consultation;
    }

    public void setConsultation(Consultation Consultation) {
        this.Consultation = Consultation;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setState(STATES state) {
        this.state = state.getState();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "State{" +
                ", state=" + state +
                ", date=" + date +
                ", consultation=" + Consultation +
                ", id=" + id +
                '}';
    }
}
