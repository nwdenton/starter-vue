package com.example.maestro.Controllers;

import lombok.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class WhoAmIController {
    @GetMapping("/api/whoami")
    public Identity whoAmI() {
        return new Identity("Jim", Arrays.asList("user"));
    }
}

@Value
class Identity {
    private String name;
    private List<String> roles;
}
