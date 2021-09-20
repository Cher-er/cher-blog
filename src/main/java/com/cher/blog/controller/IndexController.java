package com.cher.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/blog")
    public String blog() {
        return "blog";
    }

    @RequestMapping("/type")
    public String type() {
        return "type";
    }

    @RequestMapping("/archive")
    public String archive() {
        return "archive";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

}
