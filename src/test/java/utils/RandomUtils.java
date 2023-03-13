package utils;

import com.github.javafaker.Faker;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static tests.TestData.userState;

public class RandomUtils {
    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomItemFromArray(String[] values) {
        int index = getRandomInt(0, values.length - 1);
        return values[index];
    }

    public static String getRandomFirstName() {
        return new Faker().name().firstName();
    }

    public static String getRandomLastName() {
        return new Faker().name().lastName();
    }

    public static String getRandomEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String getRandomGender() {
        return new Faker().options().option("Male", "Female", "Other");
    }

    public static String getRandomPhoneNumber() {
        return new Faker().phoneNumber().subscriberNumber(9);
    }

    public static int getRandomDayOfBirthDate() {
        return new Faker().number().numberBetween(1, 28);
    }

    public static String getRandomMonthOfBirthDate() {
        return new Faker().options().option("January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October", "November", "December");
    }

    public static int getRandomYearOfBirthDate() {
        return new Faker().number().numberBetween(1900, 2100);
    }

    public static String getRandomSubject() {
        return new Faker().options().option("Accounting", "Arts", "Biology", "Civics", "Chemistry",
                "Commerce", "Computer Science", "Economics", "English", "Hindi", "History", "Maths", "Physics",
                "Social Studies");
    }

    public static String getRandomHobby() {
        return new Faker().options().option("Sports", "Reading", "Music");
    }

    public static String getRandomAddress() {
        return new Faker().address().fullAddress();
    }

    static Map<String, String[]> getRandomStateAndCity = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    );

    public static String getRandomState() {
        return new Faker().options().option(getRandomStateAndCity.keySet().toArray()).toString();
    }

    public static String getRandomCity() {
        return new Faker().options().option(getRandomStateAndCity.get(userState));
    }
}