package com.example.rest.controller;

import java.util.List;

import com.example.rest.model.User;
import com.example.rest.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/users")
    public List<User> index() {
        return userService.list();        
    }

    @RequestMapping(value = "/users", method = {RequestMethod.POST}, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public User add(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/users", method = {RequestMethod.PATCH}, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public User update(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/users", method = {RequestMethod.DELETE}, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public void delete(@RequestBody User user) {
        userService.delete(user);
    }
}