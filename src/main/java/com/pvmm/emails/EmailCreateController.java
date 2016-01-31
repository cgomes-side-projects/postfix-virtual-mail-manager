package com.pvmm.emails;

import com.pvmm.domains.domain.Domain;
import com.pvmm.domains.domain.DomainRepository;
import com.pvmm.emails.email.Email;
import com.pvmm.emails.email.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmailCreateController {

    @Autowired
    EmailRepository repository;

    @Autowired
    DomainRepository domainRepository;

    @RequestMapping(value = "/emails/create", method = RequestMethod.GET)
    public String emailCreate(Model model) {

        model.addAttribute("email", new Email() );
        return "emails/email-create";
    }


    @RequestMapping( value = "/emails/create", method = RequestMethod.POST)
    public String emailCreatePost(@ModelAttribute("newEmail") Email email, Model model) {
        Domain domain = domainRepository.findOne(email.getDomain().getId());
        email.setDomain(domain);

        email = repository.save(email);

        if( email.getId() != 0 ) {
            return "redirect:/emails";
        }

        model.addAttribute("email", new Email() );
        return "emails/email-create";
    }


}
