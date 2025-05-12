package entities;

import java.util.List;

public class Patient extends User {
    private List<String> ailment;

    public Patient(String name, String contactNo,String password){
        super(name, contactNo,password);
    }

    public List<String> getAilment(){
        return ailment;
    }

    public void setAilment(List<String> ailment){
        this.ailment = ailment;
    }
}
