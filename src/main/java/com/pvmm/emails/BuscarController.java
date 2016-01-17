package com.pvmm.emails;

import com.pvmm.emails.email.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BuscarController {

    @Autowired
    EmailRepository emailRepository;

    ModelAndView modelAndView;


    @RequestMapping("/emails/buscar")
    public ModelAndView buscarEmails(
                                        @RequestParam(value = "email", required = false) String email,
                                        @RequestParam(value = "limit", required = false) String limit
                                    ) {

        modelAndView = new ModelAndView("emails/buscar");

        this.searchOnDb(email, limit);
        return this.renderView();
    }


    private void searchOnDb(String email, String limit) {
        modelAndView.addObject("emails", emailRepository.findAll() );
    }


    private ModelAndView renderView() {
        modelAndView.addObject("title", "Buscar e-mails");

        return modelAndView;
    }
}
