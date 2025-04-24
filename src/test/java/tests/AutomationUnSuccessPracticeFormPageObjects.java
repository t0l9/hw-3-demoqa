package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class AutomationUnSuccessPracticeFormPageObjects extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest(){

        String name = "Anatoliy";
        String lastName = "Kolyshkin";
        String userSex = "Male";
        String userNumber = "7073689896";

        registrationPage.openPage()
                .setFirstName(name)
                .setLastName(lastName)
                .setSex(userSex)
                .setUserNumber(userNumber)
                .pressSubmit();

        registrationPage.checkResult("Label", "Values")
                .checkResult("Student Name", "Abracadabra")
                .checkResult("Gender", userSex)
                .checkResult("Mobile", userNumber);


    }
}

