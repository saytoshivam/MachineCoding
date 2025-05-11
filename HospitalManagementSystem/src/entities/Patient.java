package entities;

import java.util.List;

public class Patient extends User {
    private List<String> ailment;

    public Patient(String name, String contactNo) {
        super(name, contactNo);
    }

    public List<String> getAilment(){
        return ailment;
    }

    public void setAilment(List<String> ailment){
        this.ailment = ailment;
    }
}
