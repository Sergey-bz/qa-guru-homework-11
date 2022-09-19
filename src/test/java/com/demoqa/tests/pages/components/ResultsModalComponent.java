package com.demoqa.tests.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsModalComponent {

    private final static String TITLE_TEXT = "Thanks for submitting the form";

    private SelenideElement
            resultsModal = $(".modal-dialog"),
            resultsTitle = $("#example-modal-sizes-title-lg"),
            resultsTable = $(".table-responsive table");

    public ResultsModalComponent shouldBeVisible() {
        resultsModal.should(appear);
        resultsTitle.shouldHave(text(TITLE_TEXT));
        return this;
    }

    public ResultsModalComponent checkResult(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}
