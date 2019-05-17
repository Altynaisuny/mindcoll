package com.sunyt.mindcoll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author altynai
 */
@Controller
@RequestMapping("/error")
@EnableConfigurationProperties({ServerProperties.class})
public class BasicErrorController implements ErrorController {

    @Autowired
    private ServerProperties serverProperties;

    private ErrorAttributes errorAttributes;

    public BasicErrorController(ErrorAttributes errorAttributes){
        Assert.notNull(errorAttributes, "ErrorAttributes must not be null");
        this.errorAttributes = errorAttributes;
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}