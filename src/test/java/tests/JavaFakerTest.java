package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.TestData.*;

@Tag("all_tests")
public class JavaFakerTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Feature("Проверка формы регистрации")
    @Story("Форма регистрации")
    @Owner("Kolyshkin A.S.")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://test.url")
    @DisplayName("Прохождение формы регистрации с проверкой введенных данных")
    @Tag("form")
    void fillFormTest(){

        registrationPage.openPage()
                .removebanners()
                .setFirstName(firstName)
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
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", userSex)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", userDateOfBirthday[0] + " " + months[randomMonth] + "," + userDateOfBirthday[2])
                .checkResult("Subjects", favoriteSubject)
                .checkResult("Hobbies", favoriteHobby)
                .checkResult("Address", userAddress).checkResult("State and City", userState + " " + userCity);
    }
}

