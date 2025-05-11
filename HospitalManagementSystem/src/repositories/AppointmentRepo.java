package repositories;

import entities.Appointment;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentRepo {
    HashMap<Integer, Appointment> appointmentHashMap = new HashMap<>();

    private AppointmentRepo(){};

    private static AppointmentRepo instance;

    public static AppointmentRepo getInstance(){
        if(instance==null)
            instance =  new AppointmentRepo();
        return instance;
    }
    public int addApointment(Appointment a){
        appointmentHashMap.put(a.getId(),a);
        return a.getId();
    }

    public int deleteAppointment(int id){
        appointmentHashMap.remove(id);
        return id;
    }

    public List<Appointment> getAppointmentById(int id,boolean byDoctorId){
        return appointmentHashMap.values().stream()
                .filter(app -> byDoctorId ? app.getDocterId() == id : app.getPatientId() == id)
                .collect(Collectors.toList());
    }
}
