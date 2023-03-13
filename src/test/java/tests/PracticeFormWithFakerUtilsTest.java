package tests;

import org.junit.jupiter.api.Test;

import static tests.TestData.*;

public class PracticeFormWithFakerUtilsTest extends TestBase {

    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setNumber(userMobile)
                .setBirthDate(dayOfBirthDate, monthOfBirthDate, yearOfBirthDate)
                .setSubjects(userSubject)
                .setHobbies(userHobbies)
                .setPicture(pictureName)
                .setAddress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .clickSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResults("Student Name", userFirstName + " " + userLastName)
                .verifyResults("Student Email", userEmail)
                .verifyResults("Gender", userGender)
                .verifyResults("Mobile", userMobile)
                .verifyResults("Date of Birth", dayOfBirthDate + " " + monthOfBirthDate + "," + yearOfBirthDate)
                .verifyResults("Subjects", userSubject)
                .verifyResults("Hobbies", userHobbies)
                .verifyResults("Picture", pictureName)
                .verifyResults("Address", userAddress)
                .verifyResults("State and City", userState + " " + userCity);
    }
}