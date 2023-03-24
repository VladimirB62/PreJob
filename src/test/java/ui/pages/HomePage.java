package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ui.utils.PropertiesLoader;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    public static String baseURL = PropertiesLoader.loadProperty("url");
    private final SelenideElement title = $x("//h1[contains(text(),'PreJob')]");

    public HomePage titleDisplayed() {
        title.shouldBe(Condition.visible);
        return this;
    }
}


