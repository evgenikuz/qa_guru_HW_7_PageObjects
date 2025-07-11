import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import pages.components.ModalComponent;


public class PracticeFormTests extends TestBase {
    PracticeFormPage practiceForm = new PracticeFormPage();
    ModalComponent modalComponent = new ModalComponent();

    @Test
    void fillPracticeFormTest() {
        practiceForm.openPage()
                .deleteAds()
                .setFirstName("Alex")
                .setLastName("Potapov")
                .setEmail("alex@ya.ru")
                .setGender("Other")
                .setPhoneNumber("8800345645")
                .setDateOfBirth("08", "September", "1912")
                .setSubject("Maths")
                .setSubject("Hindi")
                .setHobby("Reading")
                .setHobby("Music")
                .setPicture("Ob1aUY2U.jpeg")
                .setAddress("123409, Russia, Moscow")
                .setState("Rajasthan")
                .setCity("Jaipur")
                .submitForm();
        modalComponent.checkModalIsOpen()
                .checkResult("Student Name", "Alex Potapov")
                .checkResult("Student Email", "alex@ya.ru")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "8800345645")
                .checkResult("Date of Birth", "08 September,1912")
                .checkResult("Subjects", "Maths, Hindi")
                .checkResult("Hobbies", "Reading, Music")
                .checkResult("Picture", "Ob1aUY2U.jpeg")
                .checkResult("Address", "123409, Russia, Moscow")
                .checkResult("State and City", "Rajasthan Jaipur")
                .closeModal();
    }

    @Test
    void fillNecessaryOnlyPracticeFormTest() {
        practiceForm.openPage()
                .deleteAds()
                .setFirstName("Eugene")
                .setLastName("White")
                .setGender("Male")
                .setPhoneNumber("8800345645")
                .submitForm();
        modalComponent.checkModalIsOpen()
                .checkResult("Student Name", "Eugene White")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8800345645")
                .closeModal();
    }

    @Test
    void fillNothingPracticeFormTest() {
        practiceForm.openPage()
                .deleteAds()
                .submitForm()
                .checkValidation();
        modalComponent.checkModalIsNotOpen();
    }
}
