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
}
