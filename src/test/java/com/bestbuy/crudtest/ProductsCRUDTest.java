package com.bestbuy.crudtest;

import com.bestbuy.steps.ProductsSteps;
import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)

public class ProductsCRUDTest extends TestBase {


    String name = "iPhone 22 Ultra Pro Max" + TestUtils.getRandomValue();
    String type = "Phone";
    Double price = 515.99;
    Double shipping = 0.99;
    String description = "New Futuristic iPhone with AI" + TestUtils.getRandomValue();
    String model = "iPhone 22" + TestUtils.getRandomValue();
    String manufacturer = "Apple.inc";
    String upc = "Text";
    String url = "https://www.apple.com/iphone-14-pro/";
    String image = "https://www.google.com/imgres?imgurl=https%3A%2F%2Fcdn.mos.cms.futurecdn.net%2F9Qo2ZoxP5UoBkBTbDZ7Wrg.jpg&tbnid=12TkJjMwWpFb4M&vet=12ahUKEwiCh-7UpsyAAxVqtycCHaaqC8gQMygCegUIARDTAQ..i&imgrefurl=https%3A%2F%2Fwww.tomsguide.com%2Fnews%2Fiphone-flip-everything-we-know-about-apples-foldable-phone-plans&docid=9ud4ngOimQEV2M&w=4934&h=2606&q=iphone%20flip%20concept&ved=2ahUKEwiCh-7UpsyAAxVqtycCHaaqC8gQMygCegUIARDTAQ";
    static int id;

    @Steps
    ProductsSteps productSteps;

    @Title("Creating a new product.")
    @Test
    public void test001() {
        ValidatableResponse response = productSteps.createProduct(name, type, price, shipping, upc, description, manufacturer, model, url, image);
        response.log().all().statusCode(201);
        id = response.extract().path("id");
    }

    @Title("Getting single product.")
    @Test
    public void test002() {
        ValidatableResponse response = productSteps.getProduct(id);
        response.log().all().statusCode(200);
    }

    @Title("Updating the product.")
    @Test
    public void test003() {
        name = "iPhone 22 Ultra Pro Max";
        ValidatableResponse response = productSteps.updateProduct(id, name, type, price, shipping, upc, description, manufacturer, model, url, image);
        response.log().all().statusCode(200);
    }

    @Title("Deleting the product and verifying the deletion.")
    @Test
    public void test004() {
        productSteps.deleteProduct(id).statusCode(200);
        productSteps.getProduct(id).statusCode(404);
    }

}
