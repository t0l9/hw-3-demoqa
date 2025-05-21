package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.CheckResultComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final String pageUrl = "/automation-practice-form";
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final ElementsCollection userSexs = $$("label");
    private final SelenideElement numberInput = $("#userNumber");
    private final SelenideElement calendarInput = $("#dateOfBirthInput");
    private final SelenideElement stateInput = $("#state");
    private final SelenideElement reactSelectStateInput = $("#react-select-3-input");
    private final SelenideElement cityInput = $("#city");
    private final SelenideElement reactSelectCityInput = $("#react-select-4-input");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final ElementsCollection label = $$("label");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement submitBt = $("#submit");


    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResultComponent checkResultComponent = new CheckResultComponent();

    @Step("Открываем страницу в браузере")
    public RegistrationPage openPage(){

        open(pageUrl);
        return this;
    }

    @Step("Удаляем рекламные баннеры")
    public RegistrationPage removebanners(){

        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        return this;
    }

    @Step("Вводим имя {name}")
    public RegistrationPage setFirstName(String name){
        firstNameInput.setValue(name);
        return this;
    }

    @Step("Вводим фамилию {value}")
    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Вводим email {value}")
    public RegistrationPage setEmail(String value){
        emailInput.setValue(value);
        return this;
    }

    @Step("Выбираем пол {value}")
    public RegistrationPage setSex(String value){
        userSexs.findBy(text(value)).click();
        return this;
    }

    @Step("Вводим номер телефона {value}")
    public RegistrationPage setUserNumber(String value){
        numberInput.setValue(value);
        return this;
    }

    @Step("Вводим дату рождения {day}.{month}.{year}")
    public RegistrationPage setDate(String day, String month, String year){

        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Вводим subject {value}")
    public RegistrationPage setSubject(String value){

        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Выбираем хобби {value}")
    public RegistrationPage setHobbies(String value){

        label.findBy(text(value)).click();

        return this;
    }

    @Step("Загружаем картинку из {value}")
    public RegistrationPage uploadPicture(String value){

        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    @Step("Вводим адрес {value}")
    public RegistrationPage setAdress(String value){

        currentAddress.setValue(value);

        return this;
    }

    @Step("Выбираем state {value}")
    public RegistrationPage setState(String value){

        stateInput.scrollIntoView(true).click();
        reactSelectStateInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Выбираем city {value}")
    public RegistrationPage setCity(String value){

        cityInput.click();
        reactSelectCityInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Нажимаем на кнопку подтвердить")
    public RegistrationPage pressSubmit(){

        submitBt.click();

        return this;
    }



    @Step("Проверяем результат что {key} = {value}")
    public RegistrationPage checkResult(String key, String value){

        checkResultComponent.checkResultFullForm(key, value);
        return this;
    }

}
