package tests.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PracticeResultsPage {

    public SelenideElement
            modalTitle = $("#example-modal-sizes-title-lg"),
            studentName = $("//td[text()='Student Name']"),
            studentEmail = $("//td[text()='Student Email']"),
            gender = $("//td[text()='Gender']"),
            mobile = $("//td[text()='Mobile']"),
            birthDate = $("//td[text()='Date of Birth']"),
            subjects = $("//td[text()='Subjects']"),
            hobbies = $("//td[text()='Hobbies']"),
            picture = $("//td[text()='Picture']"),
            address = $("//td[text()='Address']"),
            stateAndCity = $("//td[text()='State and City']");
}
