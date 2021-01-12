package tests.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PracticePage {

    public String pageUrl = "https://demoqa.com/automation-practice-form";

    public SelenideElement
            formWrapper = $(".practice-form-wrapper"),
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            genterWrapper = $("#genterWrapper"),
            genterNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            datepickerMonth = $(".react-datepicker__month-select"),
            datepickerYear = $(".react-datepicker__year-select"),

    subjectsInput = $("#subjectsInput"),
            subjectsMenuList = $(".subjects-auto-complete__menu-list"),

    hobbiesWrapper = $("#hobbiesWrapper"),
            hobbiesUploadPicture = $("#uploadPicture"),
            hobbiesCurrentAddress = $("#currentAddress"),

    state = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            city = $("#city"),

    submitButton = $("#submit");

    public String datepickerDay = ".react-datepicker__day--0";
}
