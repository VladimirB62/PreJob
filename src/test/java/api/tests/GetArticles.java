package api.tests;

import api.steps.ArticleSteps;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class GetArticles {

    @Test
    @Description("Get articles")
    public void getArticles(){
        new ArticleSteps().getAllArticlesById("2");
    }
}
