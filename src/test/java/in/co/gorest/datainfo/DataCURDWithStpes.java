package in.co.gorest.datainfo;

import in.co.gorest.testbase.TestBase;
import in.co.gorest.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class DataCURDWithStpes extends TestBase {
    static String name = "string" + TestUtils.getRandomValue();
    static String gender="string"+TestUtils.getRandomValue();
    static String email="string"+TestUtils.getRandomValue();
    static String status="string"+TestUtils.getRandomValue();

    static int id;
    ValidatableResponse response;

    @Steps
   UserSteps userSteps;

    @Title("This will create a new booking data")
    @Test
    public void test001() {
        userSteps.createUserinfo(name, gender, email, status).log().all();
    }


    @Title("update the user information and verify the update info ")
    @Test
    public void test002 (){
        name=name+"_update03";
        ValidatableResponse response=userSteps.UpdateuserId(id,name);
   //     response.log().all().statusCode(200);
        response=userSteps.UpdateuserId(id,name);
        response.body("name",equalTo(name));

    }
    @Title("Delete the user and verify if the user is deleted!")
    @Test
    public void test003() {
        userSteps.deleteuserId(id).statusCode(200);
        userSteps.verifyuserid(id).statusCode(404);

    }


}

