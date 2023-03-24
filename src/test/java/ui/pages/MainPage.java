package ui.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement title = $x("//h1[contains(text(),'PreJob')]");
    private final ElementsCollection videoContainer = $$x("//div[@class='VideoItem_video_container__l7vVp']");
    private final ElementsCollection filters = $$x("//select[@class='Filtration_search__RFXNe']");
    private final SelenideElement telegaButton = $x("//button[contains(text(),'Leave your feedback')]");

    private final ElementsCollection videoTitles = $$x("//p");

    private final SelenideElement groupTel = $x("//span[contains(text(),'PreJob')]");


    public MainPage titleDisplayed() {
        title.shouldBe(Condition.visible);
        return this;
    }

    public boolean videosDisplayed() {
        return !videoContainer.isEmpty();
    }

    public boolean titlesDisplayed() {
        return !videoTitles.isEmpty();
    }

    public ElementsCollection filtersDisplayed() {
        return filters.shouldHaveSize(3);
    }

    public MainPage chooseParameters() {
        filters.get(0).click();
        filters.get(0).selectOptionByValue("Finance");
        filters.get(1).click();
        filters.get(1).selectOptionByValue("BFSI");
        filters.get(2).click();
        filters.get(2).selectOptionByValue("Large Co");
        return new MainPage();
    }

    public MainPage matchingResultsDisplayed() {
        for (int i = 0; i < videoTitles.size(); i++) {
            videoTitles.get(i).getText().contains("Small");
            videoTitles.get(i).getText().contains("BFSI");
            videoTitles.get(i).getText().contains("Finance");
        }
        return this;
    }

    public MainPage clickJoinUsButton() {
        telegaButton.click();
        return this;
    }

    public void preJobTelIssDisplayed() {
        groupTel.shouldBe(Condition.visible);
    }
    
}
