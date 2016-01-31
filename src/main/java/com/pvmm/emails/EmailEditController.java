package com.pvmm.emails;

import com.pvmm.emails.email.Email;
import com.pvmm.emails.email.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmailEditController {

    @Autowired
    private EmailRepository emailRepository;


    @RequestMapping(value = "emails/edit/{id}", method = RequestMethod.GET)
    public String editEmail( @PathVariable("id") Email email, Model model) {
        //Email email = emailRepository.findByIdAndDomainId(id, 6);

        if( email == null ) {
            return this.redirect();
        }

        model.addAttribute("email", email);

        return "emails/edit";
    }


    @RequestMapping(value = "emails/edit", method = RequestMethod.GET)
    public String redirect() {
        return "redirect:/emails";
    }
}
