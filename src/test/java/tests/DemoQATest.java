package tests;

import com.github.javafaker.Faker;
import model.Student;
import org.junit.jupiter.api.Test;
import pages.StudentPage;

import static com.codeborne.selenide.Selenide.open;

public class DemoQATest extends BaseTest{

    private StudentPage studentPage = new StudentPage();
    private Faker faker = new Faker();
    private static final String CITY = "Karnal";
    private static final String STATE = "Haryana";
    private static final String IMAGE_NAME = "mrburns.png";
    private static final String HOBBY = "Sports";
    private static final String SUBJECT = "Computer Science";
    private static final String DATE = "1/September/1993";
    private static final String DAY = "31";
    private static final String MONTH = "August";
    private static final String YEAR = "1993";

    @Test
    public void registerStudent() {
        String location = STATE + " " + CITY;
        String firstName = faker.address().firstName();
        String lastName = faker.address().lastName();
        String name = firstName + " " + lastName;
        String emailAddress = faker.internet().emailAddress();
        String address = faker.address().fullAddress();
        String cellPhone = "79" + faker.number().digits(8);
        String gender = faker.demographic().sex();
        final Student student = new Student(firstName, lastName, emailAddress, gender, cellPhone,
                DATE, SUBJECT, HOBBY, IMAGE_NAME, address, STATE, CITY);
        open("/");
        studentPage.fillFirstName(student.getFirstName());
        studentPage.fillLastName(student.getLastName());
        studentPage.fillEmail(student.getEmail());
        studentPage.chooseGender(student.getGender());
        studentPage.fillMobile(student.getMobileNumber());
        studentPage.setDatePicker(DAY, MONTH, YEAR);
        studentPage.fillSubject(student.getSubject());
        studentPage.upload(student.getFileName());
        studentPage.hobbies(student.getHobby());
        studentPage.curAddress(student.getCurAddress());
        studentPage.location(student.getState(), student.getCity());
        studentPage.sendForm();
        studentPage.validateForm(name, student.getGender(), student.getEmail(), student.getMobileNumber(), MONTH, YEAR, DAY, location, student.getCurAddress(), student.getSubject(), student.getHobby(), student.getFileName());
    }
}
