package com.project.useragent.controller;

import com.project.useragent.model.UserAgent;
import com.project.useragent.service.UserAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/agent")
public class UserAgentController {
    @Autowired
    private UserAgentService service;

    @GetMapping
    public String getAll(Model model) {
        List<UserAgent> result = service.getAll();
        model.addAttribute("useragents", result);

        return "useragent-list";
    }

    @PostMapping("/create")
    public String create(String browser) {
        service.create(browser);

        return "redirect:/api/agent";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.ok().build();
    }
}
