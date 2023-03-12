package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Irina");
        $("#lastName").setValue("Korovina");
        $("#userEmail").setValue("iparakhina91@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("89999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("2004");
        $(".react-datepicker__day--016:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Economics").pressEnter().setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("Cat_image.jpeg");
        $("#currentAddress").setValue("Moscow");
        $("#state").click();
        $("#state").$(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Panipat")).click();
        $("#submit").click();
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Irina Korovina"),
                text("iparakhina91@gmail.com"), text("Female"), text("8999999999"),
                text("16 April,2004"), text("Economics, English"), text("Reading"),
                text("Cat_image.jpeg"), text("Moscow"), text("Haryana Panipat"));
    }
}
