package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckResultComponent {

    private final ElementsCollection tableResult = $$("table tr");
    private final SelenideElement modalWindow = $(".modal-content");
    private final SelenideElement outputSimpleResult = $("#output");


    public void checkResultFullForm(String key, String value){

        String successFormText = "Thanks for submitting the form";

        modalWindow.shouldHave(text(successFormText));
        tableResult.findBy(text(key)).shouldHave(text(value));
    }

    public void checkResultSimpleForm(String key, String value){
        outputSimpleResult.$(key).shouldHave(text(value));

    }
}
