package services.impl;

import commons.Pair;
import entities.Appointment;
import entities.Patient;
import repositories.AppointmentRepo;
import repositories.PatientRepo;
import services.IAppointmentService;
import services.IPatientService;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.stream.Collectors;

public class PatientService implements IPatientService, IAppointmentService {
    @Override
    public int register(Patient p) {
        return PatientRepo.getInstance().addPatient(p);
    }

    @Override
    public List<Appointment> getAppointmentList(int id) {
        return AppointmentRepo.getInstance().getAppointmentById(id,false);
    }

    @Override
    public int addAppointment(Appointment a) throws Exception {

        Pair<LocalDateTime, LocalDateTime> p = a.getBookedSlot();
        Duration duration  = Duration.between(p.getFirst(), p.getSecond());
        if(!duration.equals(Duration.ofMinutes(15))){
            throw new Exception("appointment duration must be of 15 min");
        }

        if(!(p.getFirst().getMinute()%15==0))
            throw  new Exception("appointment start time invalid");

        //doctor slot is free or not
        int doctorId = a.getDocterId();
        List<Appointment> appointments = AppointmentRepo.getInstance().getAppointmentById(doctorId,true);
        long c = appointments.stream().filter(ap->
            p.getFirst().equals(ap.getBookedSlot().getFirst())
        ).count();

        if(c>0)
            throw new Exception("slot for "+p.getFirst() + " is not free for doctor");

        //patient has already booked the slot with other doctor
        List<Appointment> patientAppointments = getAppointmentList(a.getPatientId());
        Appointment existingAppointment = appointments.stream().filter(ap->
                p.getFirst().equals(ap.getBookedSlot().getFirst())
        ).toList().getFirst();

        if(existingAppointment!=null)
            throw new Exception("slot for "+p.getFirst() + " is already booked by you with "+ existingAppointment.getDocterId());

        return AppointmentRepo.getInstance().addApointment(a);
    }

    @Override
    public int cancelAppointment(int appointmentId) {
        return AppointmentRepo.getInstance().deleteAppointment(appointmentId);
    }
}
