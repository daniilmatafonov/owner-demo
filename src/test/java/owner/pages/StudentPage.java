package owner.pages;

import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentPage {

    @Step("Заполнить имя")
    public void fillFirstName(String userName) {
        $("#firstName").setValue(userName);
    }

    @Step("Заполнить фамилию")
    public void fillLastName(String lastName) {
        $("#lastName").setValue(lastName);
    }

    @Step("Заполнить email")
    public void fillEmail(String email) {
        $("#userEmail").setValue(email);
    }

    @Step("Задать пол")
    public void chooseGender(String gender) {
        $(byText(gender)).click();
    }

    @Step("Заполнить номер телефона")
    public void fillMobile(String number) {
        $("#userNumber").setValue(number);
    }

    @Step("Заполнить дату рождения")
    public void setDatePicker(String day, String month, String year) {
        String daySelector = ".react-datepicker__day";
        String monthSelector = ".react-datepicker__month-select";
        String yearSelector = ".react-datepicker__year-select";
        $("#dateOfBirthInput").click();
        $(yearSelector).click();
        $(yearSelector).$$("option").findBy(text(year)).click();
        $(monthSelector).click();
        $(monthSelector).$$("option").findBy(text(month)).click();
        $$(daySelector).findBy(text(day)).click();
    }

    @Step("Заполнить предмет")
    public void fillSubject(String subject) {
        $("#subjectsInput").setValue("Computer Science");
        $(".subjects-auto-complete__menu-list").$(byText(subject)).click();
    }

    @Step("Загрузить фото")
    public void upload(String fileName) {
        File file = new File("./src/test/resources/" + fileName);
        $("#uploadPicture").uploadFile(file);
    }

    @Step("Заполнить информацио о хобби")
    public void hobbies(String hobby) {
        $x("//label[contains(text(),'" + hobby + "')]").click();
    }

    @Step("Заполнить адрес")
    public void curAddress(String text) {
        $("#currentAddress").setValue(text);
    }

    @Step("Заполнить место проживания")
    public void location(String state, String city) {
        $("#state").shouldBe(visible).scrollIntoView(true).click();
        $(byText(state)).click();
        $("#city").shouldBe(visible).scrollIntoView(true).click();
        $(byText(city)).click();
    }

    @Step("Отправить форму")
    public void sendForm() {
        $("#submit").shouldBe(visible).scrollIntoView(true).click();
    }

    @Step("Проинвалидировать форму")
    public void validateForm(String name, String gender, String email, String number,
                             String month, String year, String day, String location, String address, String subject,
                             String hobby, String image) {
        $(byClassName("table-responsive")).shouldHave(text(name), text(location), text(email));

        $x("//td[text()='Student Name']").parent().shouldHave(text(name));
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(number));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(day + " " + month + "," + year));
        $x("//td[text()='Subjects']").parent().shouldHave(text(subject));
        $x("//td[text()='Picture']").parent().shouldHave(text(image));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby));
        $x("//td[text()='Address']").parent().shouldHave(text(address));
        $x("//td[text()='State and City']").parent().shouldHave(text(location));
    }
}
