package tests;

import org.junit.jupiter.api.Test;

public class PracticeFormWithPageObjectsTest extends TestBase {

    @Test
    void fillFormTest() {
        String userFirstName = "Irina";
        String userLastName = "Korovina";
        String userEmail = "iparakhina91@gmail.com";
        String userGender = "Female";
        String userMobile = "89999999999";
        String dayOfBirthDate = "16";
        String monthOfBirthDate = "April";
        String yearOfBirthDate = "2004";
        String userSubject1 = "Economics";
        String userSubject2 = "English";
        String userHobbies = "Reading";
        String pictureName = "Cat_image.jpeg";
        String userAddress = "Moscow";
        String userState = "Haryana";
        String userCity = "Panipat";

        registrationPage.openPage()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setNumber(userMobile)
                .setBirthDate(dayOfBirthDate, monthOfBirthDate, yearOfBirthDate)
                .setSubjects(userSubject1, userSubject2)
                .setHobbies(userHobbies)
                .setPicture(pictureName)
                .setAddress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .submitting();

        registrationPage.verifyResultsModalAppears()
                .verifyResults("Student Name", "Irina Korovina")
                .verifyResults("Student Email", "iparakhina91@gmail.com")
                .verifyResults("Gender", "Female")
                .verifyResults("Mobile", "8999999999")
                .verifyResults("Date of Birth", "16 April,2004")
                .verifyResults("Subjects", "Economics, English")
                .verifyResults("Hobbies", "Reading")
                .verifyResults("Picture", "Cat_image.jpeg")
                .verifyResults("Address", "Moscow")
                .verifyResults("State and City", "Haryana Panipat");
    }
}