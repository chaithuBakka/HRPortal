package com.or.hr.utils;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

public class PropMgr {
    private Configuration config;

    public PropMgr() {
        Configurations configs = new Configurations();
        try
        {
            config = configs.properties(new File("/Users/ravi/gitProject/HRPortal/src/test/resources/config/hrportal.properties"));
        }
        catch(ConfigurationException cex)
        {
            System.out.println("Failed to load config file" + cex.getMessage());
        }
    }

    public String getUrl(String url) {
        return config.getString(url);
    }

    public String getDriverPath() {
        return config.getString("driverPath");
    }
}