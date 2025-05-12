package services.impl;

import entities.Appointment;
import entities.Doctor;
import repositories.AppointmentRepo;
import repositories.DoctorRepo;
import services.IDoctorService;

import java.util.List;

public class DoctorService implements IDoctorService {
    @Override
    public int register(Doctor d) {
        return DoctorRepo.getInstance().addDoctor(d);
    }

    @Override
    public List<Appointment> getAppointmentList(int id) {
        return AppointmentRepo.getInstance().getAppointmentById(id,true);
    }

    @Override
    public Boolean Login(int id, String password) {
        Doctor d = DoctorRepo.getInstance().getDoctorById(id);
        if(d.getPassword()==password)
            return true;
        
        return false;
    }

    public List<Doctor> getAllDoctorsByFirstFreeTime() {
        return DoctorRepo.getInstance().getDoctorsByFirstFreeTime();
    }
}
