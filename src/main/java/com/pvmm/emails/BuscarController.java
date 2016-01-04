package com.pvmm.emails;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BuscarController {


    @RequestMapping("/emails/buscar")
    public ModelAndView buscarEmails() {
        ModelAndView modelAndView = new ModelAndView("emails/buscar");
        modelAndView.addObject("title", "Buscar e-mails");

        return modelAndView;
    }
}
