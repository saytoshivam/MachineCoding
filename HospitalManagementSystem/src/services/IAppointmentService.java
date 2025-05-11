package services;

import commons.Pair;
import entities.Appointment;

import java.time.LocalDateTime;

public interface IAppointmentService {
    int addAppointment(Appointment a) throws Exception;
    int cancelAppointment(int appointmentId);
}
