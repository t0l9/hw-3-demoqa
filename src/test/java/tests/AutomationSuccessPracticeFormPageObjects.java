package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class AutomationSuccessPracticeFormPageObjects extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest(){

        String name = "Anatoliy";
        String lastName = "Kolyshkin";
        String email = "t0l4ik.kas1@gmail.com";
        String userSex = "Male";
        String userNumber = "7073689896";
        String favoriteSubject = "English";
        String favoriteHobby = "Sports";
        String imgPath = "files/img.png";
        String userAddress = "Almaty";
        String userState = "NCR";
        String userCity = "Delhi";
        String[] userDateOfBirthday = {"14", "1", "1996"};

        registrationPage.openPage()
                .removebanners()
                .setFirstName(name)
                .setLastName(lastName)
                .setEmail(email)
                .setSex(userSex)
                .setUserNumber(userNumber)
                .setDate(userDateOfBirthday[0], userDateOfBirthday[1], userDateOfBirthday[2])
                .setSubject(favoriteSubject)
                .setHobbies(favoriteHobby)
                .uploadPicture(imgPath)
                .setAdress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .pressSubmit();

        registrationPage.checkResult("Label", "Values")
                .checkResult("Student Name", name + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", userSex)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", userDateOfBirthday[0] + " February," + userDateOfBirthday[2])
                .checkResult("Subjects", favoriteSubject)
                .checkResult("Hobbies", favoriteHobby)
                .checkResult("Address", userAddress).checkResult("State and City", userState + " " + userCity);


    }
}

