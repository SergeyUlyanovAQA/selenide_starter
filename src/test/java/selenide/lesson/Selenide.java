package selenide.lesson;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Selenide {

    @BeforeAll
    static void setup(){
        Configuration.startMaximized = true;
    }

    @Test
    void selenideTest() {

        open("https://github.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("#js-pjax-container").$(byText("Wikis")).click();
        $(byText("SoftAssertions")).click();
        $("#js-repo-pjax-container").shouldHave(text ("Using JUnit5 extend test class:"));

    }
}
