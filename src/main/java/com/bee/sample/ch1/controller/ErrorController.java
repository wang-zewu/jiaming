package com.bee.sample.ch1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;

public class ErrorController extends AbstractErrorController {

    Log log = LogFactory.getLog(ErrorController.class);
    @Autowired
    ObjectMapper objectMapper;

    public ErrorController(){
        super(new DefaultErrorAttributes());
    }

    @Override
    public String getErrorPath() {
        return null;
    }

    @RequestMapping("error")
    public ModelAndView getErrorPath(HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> model = Collections.unmodifiableMap(getErrorAttributes(request, false));
//        Throwable cause = getCause(request);
        return null;
    }
}
