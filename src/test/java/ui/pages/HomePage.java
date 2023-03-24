package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ui.utils.PropertiesLoader;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    public static String baseURL = PropertiesLoader.loadProperty("url");
    private final SelenideElement title = $x("//h1[contains(text(),'PreJob')]");

    private final SelenideElement qrCode = $x("//body/div[@id='root']/div[1]/div[2]/div[1]/img[1]");
    private final SelenideElement telegaButton = $x("//button[contains(text(),'Leave your feedback')]");

    private final SelenideElement searchInput = $x("//body/div[@id='root']/div[1]/main[1]/div[1]/div[1]/form[1]/input[1]");

    private final SelenideElement searchValue = $x("//li[contains(text(),'Quantitative Analyst')]");
    private final SelenideElement searchButton = $x("//button[@class='SearchBar_search_container__p+2Ru']");


    public HomePage titleDisplayed() {
        title.shouldBe(Condition.visible);
        return this;
    }

    public HomePage telegramQrDisplayed() {
        qrCode.shouldBe(Condition.visible);
        return this;
    }

    public HomePage telegramLinkDisplayed() {
        telegaButton.shouldBe(visible);
        return this;
    }

    public MainPage chooseProfession() {
        searchInput.click();
        searchValue.click();
        searchButton.click();
        return new MainPage();
    }
}


