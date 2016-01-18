package com.pvmm.emails;

import com.pvmm.emails.email.Email;
import com.pvmm.emails.email.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
                                        @RequestParam(name = "email", defaultValue = "")
                                        String email,
                                        @RequestParam(name = "limit", defaultValue = "25")
                                        String limit,
                                        @RequestParam(name = "page", defaultValue = "1")
                                        String page
                                    ) {

        modelAndView = new ModelAndView("emails/buscar");

        this.searchOnDb(email, limit, page);
        return this.renderView();
    }


    private void searchOnDb(String email, String limitParam, String pageParam) {

        int limit = Integer.parseInt(limitParam);
        int pageNum = Integer.parseInt(pageParam);

        Page<Email> emails = emailRepository.findByEmailContaining(
            email,
            new PageRequest(pageNum - 1, limit, Sort.Direction.ASC, "id")
        );

        modelAndView.addObject("emails",  emails);
    }


    private ModelAndView renderView() {
        modelAndView.addObject("title", "Buscar e-mails");

        return modelAndView;
    }
}
