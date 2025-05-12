//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

import entities.Appointment;
import entities.Doctor;
import entities.Patient;
import services.IAppointmentService;
import services.IDoctorService;
import services.IPatientService;
import services.IUserService;
import services.impl.DoctorService;
import services.impl.PatientService;

public class Main {
    public static void main(String[] args) {
        // Add some doctors
        Doctor doctor1 = new Doctor("Dr. Smith", "Cardiology","1234567890","1234");
        Doctor doctor2 = new Doctor("Dr. Johnson", "Neurology","0987654321","1234");
        Doctor doctor3 = new Doctor("Dr. Brown", "Pediatrics","1122334455","1234");
        // Add some patients
        Patient patient1 = new Patient("Alice", "30","1234");
        Patient patient2 = new Patient("Bob", "40","1234");
        IDoctorService doctorService = new DoctorService();
        doctorService.register(doctor1);
        doctorService.register(doctor2);
        doctorService.register(doctor3);

        IPatientService patientService = new PatientService();
        patientService.register(patient1);
        patientService.register(patient2);

        Scanner scanner = new Scanner(System.in);

        boolean wannaExit = false;
        System.out.println("Enter your id and password");
        int id = scanner.nextInt();
        String password = scanner.nextLine();

       boolean isDoc= doctorService.Login(id, password);
       boolean isPat= patientService.Login(id, password);

        if(!isDoc && !isPat) {            
            System.out.println("Invalid credentials");
            return;
        }

        while(!wannaExit) {
            System.out.println("Welcome to the Hospital Management System");
            System.out.println("1. List Appointments");
            if(isPat){
                System.out.println("2. Book Appointment");
                System.out.println("3. Cancel Appointment");
            }
            System.out.println("enter 0 to Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    wannaExit = true;
                    break;
                case 1:
                    System.out.println("Your Appointments:");
                    if(isDoc){
                        System.out.println(doctorService.getAppointmentList(id));
                    }else{
                        System.out.println(patientService.getAppointmentList(id));
                    }
                    break;
                case 2:
                    if(isPat){
                        System.out.println("Enter appointment details:");
                        IAppointmentService appointmentService = new PatientService();
                       List<Doctor> doctors = doctorService.getAllDoctorsByFirstFreeTime();
                        System.out.println("Available doctors:");
                        for (int i = 0; i < doctors.size(); i++) {
                            System.out.println((i + 1) + ". " + doctors.get(i).getName());
                        }
                        
                        Appointment appointment = new Appointment(id,);

                        appointmentService.addAppointment(appointment);
                    } else {
                        System.out.println("You are not authorized to book appointments.");
                    }
                   
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Exiting the Hospital Management System. Goodbye!");
    }
}