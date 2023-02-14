package com.example.controller;

import com.example.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@SessionAttributes(value = "user")
@RestController
@RequestMapping("test/")
public class TestController {

    @RequestMapping(value = {"requestMapping1","requestMapping2"}
            ,method = {RequestMethod.GET,RequestMethod.POST}
            ,consumes = "application/x-www-form-urlencoded"
            ,produces = "application/json"
            ,headers = {"Content-Type=application/json"} )
    @ResponseBody
    public String requestMapping() {
        return "success1";
    }

    @PostMapping("param")
    public String param(String username,String pwd) {
        return username + pwd;
    }

    @RequestMapping(value = "info/{uid}",method = RequestMethod.GET)
    public String getUserInfoById(@PathVariable(value = "uid") String uid) {
        return uid;
    }

    @RequestMapping(value = "login")
    public String login(@ModelAttribute("user") User user) {
        return "success:" + user.toString();
    }

    @ModelAttribute
    public void addModelAttribute(String name, Model model) {
        model.addAttribute("name",name);
    }

//    @ModelAttribute // 如果使用该注解的话，相当于在模型视图中有 "string":name 这样的属性
    @ModelAttribute("name") // 使用该注解会将返回值添加到模型视图中，即 "name" : name
    public String addModelAttribute(@RequestParam String name) {
        return name;
    }

    @RequestMapping("/model")
    @ModelAttribute("name")
    public String name(String name) {
        return name;
    }

    @GetMapping("verify")
    public String verifyUser(@CookieValue("_TOKEN") String token) {
        // check token
        return "";
    }

    @RequestMapping("/testSessionAttribute")
    public String testUserAttribute(Model model) {
        model.addAttribute("user","zhangsan");
        return "success";
    }



}
