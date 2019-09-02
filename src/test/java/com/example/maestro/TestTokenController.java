package com.example.maestro;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TestTokenController {
    @Autowired
    OAuth2RestTemplate oauthRestTemplate;

    @RequestMapping(path="/api/token", method= RequestMethod.GET)
    public AuthenticationInfo getAuthenticationInfo() {
        OAuth2Authentication authentication = (OAuth2Authentication) SecurityContextHolder
                .getContext()
                .getAuthentication();

        HashMap<String, String> userDetails = (HashMap<String, String>)authentication
                .getUserAuthentication()
                .getDetails();

        return new AuthenticationInfo(oauthRestTemplate.getAccessToken(), userDetails);
    }

    @Data
    @NoArgsConstructor
    class AuthenticationInfo {
        private OAuth2AccessToken token;
        private HashMap<String,String> userDetails;

        public AuthenticationInfo(OAuth2AccessToken token, HashMap<String,String> userDetails) {
            this.token = token;
            this.userDetails = userDetails;
        }

        public String getToken() { return this.token.getValue(); }

        public String getUsername() {
            return this.userDetails.get("user_name");
        }
    }
}
