package entities;

import commons.Pair;
import java.time.*;
import java.util.List;

public class Doctor extends User {
    private String specialization;
    private List<Pair<LocalDateTime,LocalDateTime>> availability;

    Doctor(String name, String specialization, String contactNo){
        super(name,contactNo);
        this.specialization=specialization;
    }

    public List<Pair<LocalDateTime, LocalDateTime>> getAvailability() {
        return availability;
    }

    public void setAvailability(List<Pair<LocalDateTime, LocalDateTime>> availability) {
        this.availability = availability;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }



}
