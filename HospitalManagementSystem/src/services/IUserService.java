package services;

import entities.Appointment;
import entities.Doctor;

import java.util.List;

public interface IUserService {
    List<Appointment> getAppointmentList(int id);
    Boolean Login(int id, String password);
}
