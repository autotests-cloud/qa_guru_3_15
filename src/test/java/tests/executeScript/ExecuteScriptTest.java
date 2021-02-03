package tests.executeScript;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;

public class ExecuteScriptTest {

    @BeforeAll
    static void setup() {

        open("https://google.com/");

    }

    @Test
    @DisplayName("Инверсия строки поиска")
    public void mainPageTest() {

        $("input[name='q']").val("Hello World!");
        sleep(1000);

        executeJavaScript("let input = document.querySelector(\"input[name='q']\");" +
                "input.value = input.value.split('').reverse().join('')");
        sleep(1000);

        $("input[name='q']").shouldBe(value("dlroW olleH"));
        sleep(1000);

    }

}
