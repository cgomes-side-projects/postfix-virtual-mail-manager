package com.pvmm.domains;

import com.pvmm.domains.domain.Domain;
import com.pvmm.domains.domain.DomainRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CreateDomainController {

    private final String VIEW_PATH = "domains/domain-form";

    @Autowired
    DomainRepository repository;

    @RequestMapping(value = "/domains/create", method = RequestMethod.GET)
    public String createDomain(Model model) {

        model.addAttribute("domain", new Domain());
        return VIEW_PATH;
    }


    @RequestMapping(value = "/domains/create", method = RequestMethod.POST)
    public String createDomainPost(
        final @Valid @ModelAttribute("domain") Domain newDomain,
        final BindingResult errors,
        final RedirectAttributes redirectAttributes
    ){

        if( errors.getErrorCount() > 0 ) {
            return VIEW_PATH;
        }

        Domain domain = repository.save(newDomain);
        redirectAttributes.addFlashAttribute("message", "Registro criado corretamente.");
        return "redirect:/domains/edit/" + domain.getId();
    }


}
