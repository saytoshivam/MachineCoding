package entities;

import commons.Pair;

import java.time.LocalDateTime;

public class Appointment {
    private int counter;
    private final int id;
    private final int patientId;
    private final int docterId;

    Pair<LocalDateTime,LocalDateTime> bookedSlot;

    public Appointment(int patientId, int docterId, Pair<LocalDateTime,LocalDateTime> bookedSlot) {
        this.patientId = patientId;
        this.docterId = docterId;
        this.bookedSlot = bookedSlot;
        id = getNextId();
    }
    private int getNextId(){
        counter++;
        return counter;
    }

    public int getId(){
        return id;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDocterId() {
        return docterId;
    }

    public Pair<LocalDateTime, LocalDateTime> getBookedSlot() {
        return bookedSlot;
    }

}
