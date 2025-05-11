package entities;

public class User {
    private int counter;
    private final int id;
    private String name;
    private String contactNo;

    User(String name, String contactNo){
        this.id = getNextId();
        this.name = name;
        this.contactNo = contactNo;
    }

    private int getNextId(){
        counter++;
        return counter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}
