package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@RestController
@RequestMapping("/url")
public class UrlController {

    @GetMapping("/testUrl1")
    public RedirectView getUrl(){
        RedirectView redirectView = new RedirectView ();
        String authToken = "diuqanwdioqw12312";
        String url = "https://www.baidu.com/?Authorization="+authToken;
        redirectView.setUrl (url);
        return redirectView;
    }
}
