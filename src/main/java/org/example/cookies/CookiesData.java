package org.example.cookies;

public class CookiesData {
    public String name;
    public Integer session;


    public CookiesData(String string, Integer session) {
        name = string;
        this.session = session;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSession() {
        return session;
    }

    public void setSession(Integer session) {
        this.session = session;
    }
}
