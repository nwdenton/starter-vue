package com.example.maestro;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class AuthIntegrationTests {

    @Autowired
    WebDriver driver;

    @LocalServerPort
    int port;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(wireMockConfig().port(8077)
            .extensions(new CaptureStateTransformer()));

    @Before
    public void setup(){

        stubFor(get(urlEqualTo("/favicon.ico")));

        stubFor(get(urlPathMatching("/oauth/authorize?.*"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/html")
                        .withBodyFile("login.html")
                        .withTransformers("CaptureStateTransformer")));

        stubFor(post(urlEqualTo("/loginSubmit"))
                .willReturn(aResponse()
                        .withStatus(302)
                        .withHeader("Location", "http://localhost:"+port+"/login?code=oauth_code&state=${state-key}")
                        .withTransformers("CaptureStateTransformer")));

        stubFor(post(urlEqualTo("/oauth/token"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"access_token\":\"fake-token\"}")));

        stubFor(get(urlPathEqualTo("/userinfo"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"user_id\":\"my-id\",\"user_name\":\"tyler\",\"email\":\"hiImTyler@test.com\"}")));
    }

    @Test
    public void testOAuth(){
        final String username = "tyler";
        final String password = "tylertylertyler";

        driver.get("http://localhost:" + port + "/api/token");
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);
        WebElement button = driver.findElement(By.tagName("button"));

        button.click();
        assertThat(driver.getPageSource()).contains("username\":\"tyler\"");
        assertThat(driver.getPageSource()).contains("fake-token");
    }

}
