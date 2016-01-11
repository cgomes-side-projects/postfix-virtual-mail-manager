package com.pvmm.emails;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BuscarController {


    @RequestMapping("/emails/buscar")
    public ModelAndView buscarEmails(
                                        @RequestParam(value = "email", required = false) String email,
                                        @RequestParam(value = "limit", required = false) String limit
                                    ) {
        this.searchOnDb();
        return this.renderView();
    }


    private void searchOnDb() {

    }


    private ModelAndView renderView() {
        ModelAndView modelAndView = new ModelAndView("emails/buscar");
        modelAndView.addObject("title", "Buscar e-mails");

        return modelAndView;
    }
}
