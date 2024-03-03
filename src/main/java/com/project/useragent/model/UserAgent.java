package com.project.useragent.model;

public class UserAgent {
    private Long id;
    private String browser;

    public UserAgent() {
        id = 0L;
        browser = "";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return browser;
    }

    public Long getId() {
        return id;
    }
}
