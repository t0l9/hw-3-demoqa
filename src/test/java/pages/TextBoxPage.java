package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CheckResultComponent;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    CheckResultComponent checkResultComponent = new CheckResultComponent();

    private final SelenideElement userName = $("#userName");
    private final SelenideElement permanentAdress = $("#permanentAddress");
    private final SelenideElement currentAdress = $("#currentAddress");
    private final SelenideElement userEmail = $("#userEmail");
    private final SelenideElement submit = $("#submit");


    public TextBoxPage openPage(){

        open("/text-box");
        return this;
    }

    public TextBoxPage removeBanners(){

        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        return this;
    }


    public TextBoxPage setFullName(String value){
        userName.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value){

        userEmail.setValue(value);
        return this;
    }

    public TextBoxPage setAdress(String value){

        currentAdress.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAdress(String value){

        permanentAdress.setValue(value);
        return this;
    }


    public TextBoxPage pressSubmit(){

        submit.scrollIntoView(true).click();

        return this;
    }

    public TextBoxPage checkResult(String key, String value){

        checkResultComponent.checkResultSimpleForm(key, value);
        return this;
    }

}
