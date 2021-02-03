package tests.demoqa;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.demoqa.pages.PracticePage;
import tests.demoqa.pages.PracticeResultsPage;

import java.io.File;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class StudentRegistrationFormTests extends TestBase {

    @Test
    @Tag("smoke")
    @DisplayName("Successful fill registration form")
    void successfulFillFormTest() {
        Faker faker = new Faker();
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = fakeValuesService.bothify("????##@gmail.com");
        String userNumber = fakeValuesService.regexify("[0-9]{10}");
        String currentAddress = faker.address().fullAddress();

        String  gender = "Other",
                dayOfBirth = "10",
                monthOfBirth = "May",
                yearOfBirth = "1988",
                subject1Prefix = "m",
                subject1 = "Chemistry",
                subject2Prefix = "e",
                subject2 = "Commerce",
                hobby1 = "Sports",
                hobby2 = "Reading",
                hobby3 = "Music",
                picture = "1.png",
                state = "Uttar Pradesh",
                city = "Merrut";

        PracticePage practicePage = new PracticePage();
        PracticeResultsPage practiceResultsPage = new PracticeResultsPage();

        step("Open students registration form", () -> {
            open(practicePage.pageUrl);
            practicePage.formWrapper.shouldHave(text("Student Registration Form"));
        });

        step("Fill students registration form", () -> {
            practicePage.firstName.val(firstName);
            practicePage.lastName.val(lastName);
            practicePage.userEmail.val(userEmail);
            practicePage.genterWrapper.$(byText(gender)).click();
            practicePage.genterNumber.val(userNumber);
            // set date
            practicePage.dateOfBirthInput.click();
            practicePage.datepickerMonth.selectOption(monthOfBirth);
            practicePage.datepickerYear.selectOption(yearOfBirth);
            $(practicePage.datepickerDay + dayOfBirth).click();
            // set subject
            practicePage.subjectsInput.val(subject1Prefix);
            practicePage.subjectsMenuList.$(byText(subject1)).click();
            practicePage.subjectsInput.val(subject2Prefix);
            practicePage.subjectsMenuList.$(byText(subject2)).click();
            // set hobbies
            practicePage.hobbiesWrapper.$(byText(hobby1)).click();
            practicePage.hobbiesWrapper.$(byText(hobby2)).click();
            practicePage.hobbiesWrapper.$(byText(hobby3)).click();
            practicePage.hobbiesUploadPicture.uploadFile(new File("src/test/resources/" + picture));
            practicePage.hobbiesCurrentAddress.val(currentAddress);
            // set state and city
            practicePage.state.click();
            practicePage.stateCityWrapper.$(byText(state)).click();
            practicePage.city.click();
            practicePage.stateCityWrapper.$(byText(city)).click();

            practicePage.submitButton.click();
        });

        step("Verify successful form submit", () -> {
            practiceResultsPage.modalTitle.shouldHave(text("Thanks for submitting the form"));
            practiceResultsPage.studentName.parent().shouldHave(text(firstName + " " + lastName));
            practiceResultsPage.studentEmail.parent().shouldHave(text(userEmail));
            practiceResultsPage.gender.parent().shouldHave(text(gender));
            practiceResultsPage.mobile.parent().shouldHave(text(userNumber));
            practiceResultsPage.birthDate.parent().shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
            practiceResultsPage.subjects.parent().shouldHave(text(subject1 + ", " + subject2));
            practiceResultsPage.hobbies.parent().shouldHave(text(hobby1 + ", " + hobby2 + ", " + hobby3));
            practiceResultsPage.picture.parent().shouldHave(text(picture));
            practiceResultsPage.address.parent().shouldHave(text(currentAddress));
            practiceResultsPage.stateAndCity.parent().shouldHave(text(state + " " + city));
        });
    }

}
