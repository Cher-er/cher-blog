package com.cher.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping({"", "/", "/login"})
    public String login() {
        return "admin/login";
    }

    @RequestMapping("/blog")
    public String blog() {
        return "admin/blog";
    }

    @RequestMapping("/blogInput")
    public String blogInput() {
        return "admin/blog-input";
    }

    @RequestMapping("/type")
    public String type() {
        return "admin/type";
    }

    @RequestMapping("typeInput")
    public String typeInput() {
        return "admin/type-input";
    }

}
