package in.co.gorest.datainfo;

import in.co.gorest.constants.EndPoints;
import in.co.gorest.model.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UserSteps {
    @Step("Update all user data :name {0},gender {1},email {2},status{3}")

    public ValidatableResponse createUserinfo(String name, String gender, String email, String status) {
        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setGender(gender);
        userPojo.setEmail(email);
        userPojo.setStatus(status);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(userPojo)
                .when()
                .post(EndPoints.GET_ALL_USERS)
                .then();
    }
    @Step("Update all user data :{0}")
    public ValidatableResponse UpdateuserId(int id,String name){
        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);

        return  SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("usersID",id)
                .body(userPojo)
                .when()
                .patch(EndPoints.UPDATE_USERS_BY_ID)
                .then();


    }
    @Step("Delete id:{0}")
    public ValidatableResponse deleteuserId(int id){
        return  SerenityRest.given().log().all()
                .pathParam("usersID",id)
                .when()
                .delete(EndPoints.DELETE_USERS_BY_ID)
                .then();
    }
    @Step("verify that user id is delete:{0}")
    public ValidatableResponse verifyuserid(int id){
        return SerenityRest.given().log().all()
                .pathParam("usersID",id)
                .when()
                .get(EndPoints.GET_SINGLE_USERS_ID)
                .then();

    }




}
