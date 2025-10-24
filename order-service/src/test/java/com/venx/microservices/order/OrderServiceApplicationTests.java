package com.venx.microservices.order;

import com.venx.microservices.order.client.InventoryClient;
import com.venx.microservices.order.stubs.InventoryClientStub;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.testcontainers.containers.MySQLContainer;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
class OrderServiceApplicationTests {

    @ServiceConnection
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");
    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        mySQLContainer.start();
    }


	@Test
	void shouldSubmitOrder() {
        String submitOrderJson = """
                {
                   "skuCode": "iphone_15",
                   "price": 1000,
                   "quantity": 1
                }
                """;

        InventoryClientStub.stubInventoryCall("iphone_15", 1);

        var responseBodyString = RestAssured.given()
                .contentType("application/json")
                .body(submitOrderJson)
                .when()
                .post("/api/order")
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .body().asString();

        assertThat(responseBodyString, Matchers.is("Order Placed Successfully"));
	}

    @Test
    void shouldNotSubmitOrderWhenNotInStock() {
        String submitOrderJson = """
                {
                   "skuCode": "iphone_15",
                   "price": 1000,
                   "quantity": 1000
                }
                """;

        InventoryClientStub.stubInventoryCallNotInStock("iphone_15", 1000);

        var negativeResponse = RestAssured.given()
                .contentType("application/json")
                .body(submitOrderJson)
                .when()
                .post("/api/order")
                .then()
                .log().all()
                .statusCode(500)
                .extract()
                .body().asString();
        assertFalse(Boolean.parseBoolean(negativeResponse));
    }


}
