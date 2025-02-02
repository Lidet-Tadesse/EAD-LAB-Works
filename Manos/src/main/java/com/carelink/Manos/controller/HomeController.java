package com.carelink.Manos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/about")
    public String aboutUs() {
        return "about-us"; // Name of the HTML file for About Us page
    }
}
