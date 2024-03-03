package com.project.useragent.dao;

import com.project.useragent.model.UserAgent;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_agent")
public class UserAgentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_agent_generator")
    @SequenceGenerator(name = "user_agent_generator", sequenceName = "user_agent_seq", allocationSize = 1)
    private Long id;
    private String browser;
    private LocalDateTime created;

    public UserAgentEntity() {
        browser = "";
        created = LocalDateTime.now();
    }

    public UserAgentEntity(String browser) {
        this.browser = browser;
        this.created = LocalDateTime.now();
    }

    public UserAgent convert() {
        UserAgent userAgent = new UserAgent();
        userAgent.setId(id);
        userAgent.setBrowser(browser);

        return userAgent;
    }
}
