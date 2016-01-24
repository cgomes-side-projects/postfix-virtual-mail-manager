package com.pvmm.domains;

import com.pvmm.domains.domain.Domain;
import com.pvmm.domains.domain.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateDomainController {

    @Autowired
    DomainRepository repository;

    @RequestMapping(value = "/domains/create", method = RequestMethod.GET)
    public String createDomain(Model model) {

        model.addAttribute("domain", new Domain());
        return "domains/create-domain";
    }


    @RequestMapping(value = "/domains/create", method = RequestMethod.POST)
    public String createDomainPost(
        Model model,
        @RequestParam(name = "name", defaultValue = "")
        String name
    ){
        Domain domain = new Domain();
        domain.setName(name);

        domain = repository.save(domain);

        if( domain.getId() != 0 ) {
            return "redirect:/domains";
        }

        return "domains/create-domain";
    }


}
