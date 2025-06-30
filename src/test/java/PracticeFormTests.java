import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests extends TestBase {
    PracticeFormPage practiceForm = new PracticeFormPage();

    @Test
    void fillPracticeFormTest() {
        practiceForm.openPage()
                    .setFirstName("Alex")
                    .setLastName("Potapov")
                    .setEmail("alex@ya.ru")
                    .setGender("Other")
                    .setPhoneNumber("8800345645")
                    .setDateOfBirth("7", "September", "1912")
                    .setSubject("Maths")
                    .setSubject("Hindi")
                    .setHobby("Reading")
                    .setHobby("Music")
                    .setPicture("Ob1aUY2U.jpeg")
                    .setAddress("123409, Russia, Moscow")
                    .setState("Rajasthan")
                    .setCity("Jaipur")
                    .submitForm()
                    .checkResult("Student Name", "Alex Potapov")
                    .checkResult("Student Email", "alex@ya.ru")
                    .checkResult("Gender", "Other")
                    .checkResult("Mobile", "8800345645")
                    .checkResult("Date of Birth", "07 September,1912")
                    .checkResult("Subjects", "Maths, Hindi")
                    .checkResult("Hobbies", "Reading, Music")
                    .checkResult("Picture", "Ob1aUY2U.jpeg")
                    .checkResult("Address", "123409, Russia, Moscow")
                    .checkResult("State and City", "Rajasthan Jaipur")
                    .closeForm();
    }
}
