import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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

        $("#firstName").setValue("Irina");
        $("#lastName").setValue("Korovina");
        $("#userEmail").setValue("iparakhina91@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("89999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $("option[value='3']").click();
        $(".react-datepicker__year-select").click();
        $("option[value='2004']").click();
        $("div[aria-label='Choose Friday, April 16th, 2004']").click();
        $("#subjectsInput").setValue("Economics").pressEnter().setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("Cat_image.jpeg");
        $("#currentAddress").setValue("Moscow");
        $("#state").click();
        $("#state").$(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Panipat")).click();
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#submit").click();

        $(".modal-body").shouldHave(text("Irina Korovina"),
                text("iparakhina91@gmail.com"), text("Female"), text("8999999999"),
                text("16 April,2004"), text("Economics, English"), text("Reading"),
                text("Cat_image.jpeg"), text("Moscow"), text("Haryana Panipat"));
    }
}
