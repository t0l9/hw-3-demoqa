package tests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AutomationPracticeForm {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;

    }

    @Test
    void fillFormTestXpath(){
        open("/utomation-practice-form");

        $x("//*[@id='firstName']").setValue("Anatoliy");
        $x("//*[@id='lastName']").setValue("Kolyshkin");
        $x("//*[@id='userEmail']").setValue("Kolyshkin");

    }

    @Test
    void fillFormTestCssSelectors(){
        open("/automation-practice-form");

        $("#firstName").scrollIntoView(true).setValue("Anatoliy");
        $("#lastName").setValue("Kolyshkin");
        $("#userEmail").setValue("t0l4ik.kas1@gmail.com");
        $$("label").findBy(text("Male")).click();
        $("#userNumber").setValue("7073689896");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1996");
        $(".react-datepicker__month-select").selectOptionByValue("1");
        $$(".react-datepicker__day").findBy(text("14")).click();



        $("#subjectsInput").setValue("English").pressEnter();
        $$("label").findBy(text("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("files/img.png");
        $("#currentAddress").setValue("Almaty");

        $("#state").scrollIntoView(true).click();
        $("#react-select-3-input").setValue("NCR").pressEnter();

        $("#city").click();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").scrollIntoView(true).click();


//        $("#output").$("#name").shouldHave(text("Anatoliy"));
//        $("#output #email").shouldHave(text("t0l4ik.kas1@gmail.com"));
//        $("#output").$("#currentAddress").shouldHave(text("Almaty"));
//        $("#output").$("#permanentAddress").shouldHave(text("saina"));

    }
}

