package com.project.useragent.dao;

import com.project.useragent.model.UserAgent;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_agent")
public class UserAgentEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String browser;
    private LocalDateTime created;

    public UserAgentEntity() {
        browser = "";
        created = LocalDateTime.now();
    }

    public UserAgentEntity(String browser) {
        this.browser = browser;
    }

    public UserAgent convert() {
        UserAgent userAgent = new UserAgent();
        userAgent.setId(id);
        userAgent.setBrowser(browser);

        return userAgent;
    }
}
