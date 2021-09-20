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

    @RequestMapping("/blogManage")
    public String blog() {
        return "admin/blog-manage";
    }

    @RequestMapping("/blogInput")
    public String blogInput() {
        return "admin/blog-input";
    }

    @RequestMapping("/typeManage")
    public String type() {
        return "admin/type-manage";
    }

    @RequestMapping("typeInput")
    public String typeInput() {
        return "admin/type-input";
    }

}
