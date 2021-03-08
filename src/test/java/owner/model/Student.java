package owner.model;

public class Student {

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String mobileNumber;
    private String date;
    private String subject;
    private String hobby;
    private String fileName;
    private String curAddress;
    private String state;
    private String city;

    public Student(String firstName, String lastName, String email, String gender, String mobileNumber, String date, String subject, String hobby, String fileName, String curAddress, String state, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.date = date;
        this.subject = subject;
        this.hobby = hobby;
        this.fileName = fileName;
        this.curAddress = curAddress;
        this.state = state;
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getDate() {
        return date;
    }

    public String getSubject() {
        return subject;
    }

    public String getHobby() {
        return hobby;
    }

    public String getFileName() {
        return fileName;
    }

    public String getCurAddress() {
        return curAddress;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

}
