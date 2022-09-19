package com.demoqa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.tests.pages.RegistrationFormPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class StudentRegistrationFormTest extends BaseTest {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void fillFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Заполняем форму регистрации", () -> {
            registrationFormPage
                    .openPage()
                    .setFirstName("Sergey")
                    .setLastName("Sviridov")
                    .setEmail("super@test.com")
                    .setGender("Male")
                    .setUserNumber("9171234567")
                    .setBirthDate("08", "October", "1993")
                    .setSubjects("Computer Science")
                    .setHobbies("Sports")
                    .uploadPicture("face.png")
                    .setCurrentAddress("960 AVENUE OF THE AMERICAS NEW YORK")
                    .setState("Haryana")
                    .setCity("Panipat")
                    .pressSubmitButton();
        });

        step("Проверяем результат", () -> {
            registrationFormPage
                    .checkResultsModalIsVisible()
                    .checkResult("Student Name", "Sergey Sviridov")
                    .checkResult("Student Email", "super@test.com")
                    .checkResult("Gender", "Male")
                    .checkResult("Mobile", "9171234567")
                    .checkResult("Date of Birth", "08 October,1993")
                    .checkResult("Subjects", "Computer Science")
                    .checkResult("Hobbies", "Sports")
                    .checkResult("Picture", "face.png")
                    .checkResult("Address", "960 AVENUE OF THE AMERICAS NEW YORK")
                    .checkResult("State and City", "Haryana Panipat");
        });
    }
}
