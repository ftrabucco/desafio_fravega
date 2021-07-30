import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;

public class FirstTest extends BaseTest{

    SoftAssert soft = new SoftAssert();

    @Test
    public void project() {

        String response =
                given().
                when().
                    contentType(ContentType.JSON).queryParam("query","lagunitas").
                    get("/autocomplete").
                then()
                    .extract()
                    .body()
                    .asString();

        List<Map> lagunitas_filtered = from(response).get("findAll {name -> name.name == 'Lagunitas Brewing Co'}");

        String correctResponse = given().
                contentType(ContentType.JSON).pathParam("id","12040").
                when().
                    get("{id}").
                then().
                    extract().body().asString();

        int id = from(correctResponse).get("id");
        String name = from(correctResponse).get("name");
        String street = from(correctResponse).get("street");
        String phone = from(correctResponse).get("phone");

        soft.assertEquals(street, "1280 N McDowell Blvd");
        soft.assertEquals(phone, "7077694495");
        soft.assertEquals(name, "Lagunitas Brewing Co");
        soft.assertEquals(id, 761);
        soft.assertAll();
    }
}
