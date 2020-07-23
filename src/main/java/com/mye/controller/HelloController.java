package com.mye.controller;

import com.mye.model.Record;
import com.mye.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String Say(){
        return helloService.Say();
    }

    @RequestMapping(value = "/job", method = RequestMethod.GET)
    public String job(){
        return "index";
    }

    @RequestMapping(value = "/job/result", method = RequestMethod.GET)
    @ResponseBody
    public List<Record> result(){
        return helloService.result();
    }

}
