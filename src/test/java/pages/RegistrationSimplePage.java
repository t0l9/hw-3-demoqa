package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CheckResultComponent;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationSimplePage {

    CheckResultComponent checkResultComponent = new CheckResultComponent();

    private final SelenideElement userName = $("#userName");
    private final SelenideElement permanentAdress = $("#permanentAddress");
    private final SelenideElement currentAdress = $("#currentAddress");
    private final SelenideElement userEmail = $("#userEmail");
    private final SelenideElement submit = $("#submit");


    public RegistrationSimplePage openPage(){

        String pageUrl = "/text-box";
        open(pageUrl);
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        return this;
    }

    public RegistrationSimplePage setFullName(String value){
        userName.setValue(value);
        return this;
    }

    public RegistrationSimplePage setEmail(String value){

        userEmail.setValue(value);
        return this;
    }

    public RegistrationSimplePage setAdress(String value){

        currentAdress.setValue(value);
        return this;
    }

    public RegistrationSimplePage setPermanentAdress(String value){

        permanentAdress.setValue(value);
        return this;
    }


    public RegistrationSimplePage pressSubmit(){

        submit.scrollIntoView(true).click();

        return this;
    }

    public RegistrationSimplePage checkResult(String key, String value){

        checkResultComponent.checkResultSimpleForm(key, value);
        return this;
    }

}
