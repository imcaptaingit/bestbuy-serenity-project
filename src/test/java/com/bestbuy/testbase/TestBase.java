package com.bestbuy.testbase;

import com.bestbuy.utils.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

/**
 * Created by Jay Vaghani
 */
public class TestBase {

    public static PropertyReader propertyReader;

    @BeforeClass

    public static void inIt() {

   /*     propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        RestAssured.port = Integer.parseInt(propertyReader.getProperty("port"));
        RestAssured.basePath = Path.PRODUCT;
    }*/

            RestAssured.baseURI = "http://localhost";
            RestAssured.port = 3030;

        }
}