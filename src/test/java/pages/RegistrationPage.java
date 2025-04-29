package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
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

    public RegistrationPage openPage(){

        open(pageUrl);
        return this;
    }

    public RegistrationPage removebanners(){

        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value){
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setSex(String value){
        userSexs.findBy(text(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value){
        numberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDate(String day, String month, String year){

        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value){

        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value){

        label.findBy(text(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value){

        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAdress(String value){

        currentAddress.setValue(value);

        return this;
    }


    public RegistrationPage setState(String value){

        stateInput.click();
        reactSelectStateInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setCity(String value){

        cityInput.click();
        reactSelectCityInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage pressSubmit(){

        submitBt.click();

        return this;
    }



    public RegistrationPage checkResult(String key, String value){

        checkResultComponent.checkResultFullForm(key, value);
        return this;
    }





}
