package com.pvmm.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class OiController {

    @RequestMapping("/oi")
    public ModelAndView oi() {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("title", "teste");
        return modelAndView;
    }
}
