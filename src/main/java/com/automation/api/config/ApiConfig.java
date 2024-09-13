package com.automation.api.config;


import org.aeonbits.owner.Config;


@Config.Sources({"classpath:api.properties"})
public interface ApiConfig extends Config {

    @Key("baseUrl")
    String baseUrl();

    @Key("username")
    String username();

    @Key("password")
    String password();
}
