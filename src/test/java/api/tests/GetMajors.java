package api.tests;

import api.steps.MajorSteps;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class GetMajors {

    @Test
    @Description("Get majors")
    public void getMajors(){
        new MajorSteps().getMajors();
    }
}
