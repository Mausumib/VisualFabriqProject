package apiTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class nextBirthdayAPITest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://lx8ssktxx9.execute-api.eu-west-1.amazonaws.com/Prod";
    }

    @Test
    public void testNextBirthdayInHours() {
        String expectedMessage = "2616 hours left";
        Response response = given()
                .queryParam("dateofbirth", "1990-10-30")
                .queryParam("unit", "hour")
                .get("/next-birthday");

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedMessage, response.jsonPath().getString("message"));
    }

    @Test
    public void testNextBirthdayInDays() {
        String expectedMessage = "109 days left";
        Response response = given()
                .queryParam("dateofbirth", "1990-10-30")
                .queryParam("unit", "day")
                .get("/next-birthday");

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedMessage, response.jsonPath().getString("message"));
    }

    @Test
    public void testNextBirthdayInWeeks() {
        String expectedMessage = "15 weeks left";
        Response response = given()
                .queryParam("dateofbirth", "1990-10-30")
                .queryParam("unit", "week")
                .get("/next-birthday");

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedMessage, response.jsonPath().getString("message"));
    }

    @Test
    public void testNextBirthdayInMonths() {
        String expectedMessage = "3 months left";
        Response response = given()
                .queryParam("dateofbirth", "1990-10-30")
                .queryParam("unit", "month")
                .get("/next-birthday");

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedMessage, response.jsonPath().getString("message"));
    }
}
