package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static utils.RandomUtils.*;

public class PracticeFormWithFakerUtilsTest extends TestBase {

    @Test
    void fillFormTest() {
        Faker faker = new Faker();

        String[] genders = {"Male", "Female", "Other"};

        String userFirstName = faker.name().firstName();
        String userLastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String userGender = getRandomItemFromArray(genders);
        String userMobile = "8" + faker.phoneNumber().subscriberNumber(9);
        String dayOfBirthDate = "16";
        String monthOfBirthDate = "April";
        String yearOfBirthDate = "2004";
        String userSubject1 = "Economics";
        String userSubject2 = "English";
        String userHobbies = "Reading";
        String pictureName = "Cat_image.jpeg";
        String userAddress = faker.address().fullAddress();
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
                .clickSubmit();

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