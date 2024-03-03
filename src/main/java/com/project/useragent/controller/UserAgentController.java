package com.project.useragent.controller;

import com.project.useragent.service.UserAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAgentController {
    @Autowired
    private UserAgentService service;


}
