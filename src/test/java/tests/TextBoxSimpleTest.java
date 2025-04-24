package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationSimplePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxSimpleTest extends TestBase {

    RegistrationSimplePage registrationSimplePage = new RegistrationSimplePage();

    @Test
    void fillFormTest(){

        String fullName = "Anatoliy Kolyshkin";
        String email = "t0l4ik.kas1@gmail.com";
        String userAddress = "Almaty";
        String permanentAddress = "saina";

        registrationSimplePage.openPage()
                .setFullName(fullName)
                .setEmail(email)
                .setAdress(userAddress)
                .setPermanentAdress(permanentAddress)
                .pressSubmit();

        registrationSimplePage.checkResult("#name", fullName)
                .checkResult("#email", email)
                .checkResult("#currentAddress", userAddress)
                .checkResult("#permanentAddress", permanentAddress);

    }
}

