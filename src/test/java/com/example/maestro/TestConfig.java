package com.example.maestro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;

import java.util.Arrays;

@Configuration
public class TestConfig {

    @Bean
    public WebDriver driver(){
        return new ChromeDriver();
    }

    @Bean
    public OAuth2ProtectedResourceDetails fakeOauth() {
        AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
        details.setId("my-id");
        details.setClientId("oauth-client-id");
        details.setClientSecret("oauth-client-secret");
        details.setAccessTokenUri("http://localhost:8077/oauth/token");
        details.setUserAuthorizationUri("http://localhost:8077/oauth/authorize");
        details.setTokenName("fake-token");
        details.setScope(Arrays.asList("identity"));
        details.setPreEstablishedRedirectUri("http://localhost/login");
        details.setUseCurrentUri(false);
        return details;
    }

    @Bean
    public OAuth2RestTemplate oAuth2RestTemplate(OAuth2ProtectedResourceDetails details){
        return new OAuth2RestTemplate(details);
    }
}
