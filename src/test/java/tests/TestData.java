package tests;

import static utils.RandomUtils.*;
import static utils.RandomUtils.getRandomCity;

public class TestData {
    public static String userFirstName = getRandomFirstName(),
            userLastName = getRandomLastName(),
            userEmail = getRandomEmail(),
            userGender = getRandomGender(),
            userMobile = "8" + getRandomPhoneNumber(),
            dayOfBirthDate = String.valueOf(getRandomDayOfBirthDate()),
            monthOfBirthDate = getRandomMonthOfBirthDate(),
            yearOfBirthDate = String.valueOf(getRandomYearOfBirthDate()),
            userSubject = getRandomSubject(),
            userHobbies = getRandomHobby(),
            pictureName = "Cat_image.jpeg",
            userAddress = getRandomAddress(),
            userState = getRandomState(),
            userCity = getRandomCity();
}