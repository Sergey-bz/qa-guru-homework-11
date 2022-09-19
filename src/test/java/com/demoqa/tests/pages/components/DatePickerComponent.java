package com.demoqa.tests.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class DatePickerComponent {

    public DatePickerComponent setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__day--0" + day).click();
        return this;
    }
}
