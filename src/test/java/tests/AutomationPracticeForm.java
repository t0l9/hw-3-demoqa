package tests;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
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
    void fillFormTestCssSelectorsTest(){
        open("/automation-practice-form");

        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        $("#firstName").setValue("Anatoliy");
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

        $("#state").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();

        $("#city").click();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").click();


        $(".modal-content").shouldHave(text("Thanks for submitting the form"));

        $$("table tr").findBy(text("Label")).shouldHave(text("Values"));
        $$("table tr").findBy(text("Student Name")).shouldHave(text("Anatoliy Kolyshkin"));
        $$("table tr").findBy(text("Student Email")).shouldHave(text("t0l4ik.kas1@gmail.com"));
        $$("table tr").findBy(text("Gender")).shouldHave(text("Male"));
        $$("table tr").findBy(text("Mobile")).shouldHave(text("7073689896"));
        $$("table tr").findBy(text("Date of Birth")).shouldHave(text("14 February,1996"));
        $$("table tr").findBy(text("Subjects")).shouldHave(text("English"));
        $$("table tr").findBy(text("Hobbies")).shouldHave(text("Sports"));
        $$("table tr").findBy(text("Address")).shouldHave(text("Almaty"));
        $$("table tr").findBy(text("State and City")).shouldHave(text("NCR Delhi"));


    }
}

