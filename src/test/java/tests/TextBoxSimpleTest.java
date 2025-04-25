package tests;


import org.junit.jupiter.api.Test;
import pages.TextBoxPage;


public class TextBoxSimpleTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest(){

        String fullName = "Anatoliy Kolyshkin";
        String email = "t0l4ik.kas1@gmail.com";
        String userAddress = "Almaty";
        String permanentAddress = "saina";

        textBoxPage.openPage()
                .removeBanners()
                .setFullName(fullName)
                .setEmail(email)
                .setAdress(userAddress)
                .setPermanentAdress(permanentAddress)
                .pressSubmit();

        textBoxPage.checkResult("#name", fullName)
                .checkResult("#email", email)
                .checkResult("#currentAddress", userAddress)
                .checkResult("#permanentAddress", permanentAddress);

    }
}

