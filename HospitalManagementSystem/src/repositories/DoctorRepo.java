package repositories;

import entities.Doctor;

import java.util.HashMap;

public class DoctorRepo {
    private HashMap<Integer, Doctor> doctorHashMap = new HashMap<>();
    private DoctorRepo(){};

    private static DoctorRepo instance;

    public static DoctorRepo getInstance(){
        if(instance==null)
            instance =  new DoctorRepo();
        return instance;
    }

    public int addDoctor(Doctor p){
        doctorHashMap.put(p.getId(),p);
        return p.getId();
    }
}
