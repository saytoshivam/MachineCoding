package repositories;

import entities.Patient;

import java.util.HashMap;

public class PatientRepo {
    private HashMap<Integer, Patient> patientHashMap = new HashMap<>();

    private PatientRepo(){};

    private static PatientRepo instance;

    public static PatientRepo getInstance(){
        if(instance==null)
            instance =  new PatientRepo();
        return instance;
    }

    public int addPatient(Patient p){
        patientHashMap.put(p.getId(),p);
        return p.getId();
    }


}
