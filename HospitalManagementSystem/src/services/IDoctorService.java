package services;

import entities.Appointment;
import entities.Doctor;

import java.util.List;

public interface IDoctorService extends IUserService  {
    int register(Doctor d);
}
