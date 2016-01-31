package com.pvmm.emails;

import com.pvmm.emails.email.Email;
import com.pvmm.emails.email.EmailRepository;
import com.pvmm.utils.Paginator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class EmailsSearchController {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private HttpServletRequest request;

    private Model model;


    @RequestMapping("/emails")
    public String buscarEmails( Model model, Pageable pageable, @RequestParam(name = "email", defaultValue = "") String email ) {
        this.model = model;

        Page<Email> emails = this.searchOnDb(email, pageable);
        this.preparePaginator(emails);

        return "emails/emails-search";
    }


    private Page<Email> searchOnDb(String email, Pageable pageable) {
        Page<Email> emails = emailRepository.findByEmailContaining( email, pageable );
        model.addAttribute("emails", emails);

        return emails;
    }


    private void preparePaginator( Page<Email> emails ) {
        Paginator<Email> paginator = new Paginator<>(emails, request);

        model.addAttribute("paginator", paginator);
    }
}
