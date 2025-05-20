package pages.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {


    public void setDate(String day, String month, String year){

        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__month-select").selectOptionByValue(month);
        $$(".react-datepicker__day")
                .filter(not(cssClass("react-datepicker__day--outside-month")))
                .findBy(text(day)).click();
    }
}
