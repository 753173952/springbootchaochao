package com.appication.controller;

import com.appication.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("rest")
public class RestClientController {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    private String base = "http://127.0.0.1:80/";

    @ResponseBody
    @RequestMapping("/test/user")
    public User getUser() {
        RestTemplate client = restTemplateBuilder.build();
        String url = base + "rest/test/{userId}";
        Map map = new HashMap();
        map.put("userId", "3");
        map.put("name", "chaochao");
        User user = client.getForObject(url, User.class, map);
        client.
        return user;

    }

    @ResponseBody
    @RequestMapping("/test/{userId}/{name}")
    public User restCheck(@PathVariable Integer userId, @PathVariable String name) {
        User user = new User();
        user.setId(userId);
        user.setName(name);
        return user;
    }

}

