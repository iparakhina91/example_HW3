package tests;

import org.junit.jupiter.api.Test;

public class PracticeFormWithPageObjectsTest extends TestBase {

    @Test
    void fillFormTest() {
        String userFirstName = "Irina";
        String userLastName = "Korovina";
        String userEmail = "iparakhina91@gmail.com";
        String userGender = "Female";
        String userMobile = "9999999999";
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
                .removeBanners()
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
                .verifyResults("Student Name", userFirstName + " " + userLastName)
                .verifyResults("Student Email", userEmail)
                .verifyResults("Gender", userGender)
                .verifyResults("Mobile", userMobile)
                .verifyResults("Date of Birth", dayOfBirthDate + " " + monthOfBirthDate + "," + yearOfBirthDate)
                .verifyResults("Subjects", userSubject1 + ", " + userSubject2)
                .verifyResults("Hobbies", userHobbies)
                .verifyResults("Picture", pictureName)
                .verifyResults("Address", userAddress)
                .verifyResults("State and City", userState + " " + userCity);
    }
}