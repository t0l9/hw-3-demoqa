package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static tests.TestData.*;

public class test2 extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest(){

        registrationPage.openPage()
                .removebanners();
        $$("label").findBy(text("Sports")).click();
        sleep(10000);



        registrationPage.checkResult("Label", "Values")
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", userSex)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", userDateOfBirthday[0] + " February," + userDateOfBirthday[2])
                .checkResult("Subjects", favoriteSubject)
                .checkResult("Hobbies", favoriteHobby)
                .checkResult("Address", userAddress).checkResult("State and City", userState + " " + userCity);


    }
}

