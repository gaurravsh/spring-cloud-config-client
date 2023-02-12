package com.shaga.springcloudconfigclient.controller;

import com.shaga.springcloudconfigclient.config.DbSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GreetingsController {
    @Value("${my.greeting}")
    private String greetingMessage;

    @Autowired
    private DbSettings dbSettings;

    @GetMapping("/greeting")
    public String greeting(){
        return "my.greeting: " + greetingMessage + " db.connection: " + dbSettings.getConnection();
    }
}
