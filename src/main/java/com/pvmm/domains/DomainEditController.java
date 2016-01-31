package com.pvmm.domains;

import com.pvmm.domains.domain.Domain;
import com.pvmm.domains.domain.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@SessionAttributes("message")
public class DomainEditController {

    @Autowired
    DomainRepository repository;

    @RequestMapping( value = "domains/edit/{id}", method = RequestMethod.GET)
    public String domainEdit(
        Model model,
        @PathVariable("id") Domain domain,
        @ModelAttribute("message") final String message
    ) {
        if( domain == null ) {
            return this.domainEditRedir();
        }

        model.addAttribute("message", message);
        model.addAttribute("domain", domain);
        return "domains/domain-form";
    }


    @RequestMapping(value = "domains/edit/{id}", method = RequestMethod.POST )
    public String domainEditPost(
        Model model,
        @PathVariable("id") int id,
        @Valid @ModelAttribute("Domain") Domain newDomain,
        BindingResult errors,
        final RedirectAttributes redirectAttributes
    ){
        if( ! repository.exists(id) ) {
            return this.domainEditRedir();
        }

        if( errors.getErrorCount() > 0 ) {
            model.addAttribute("domain", newDomain);
            return "domains/domain-form";
        }

        newDomain.setId(id);
        repository.save(newDomain);
        redirectAttributes.addFlashAttribute("message", "Domínio salvo com sucesso.");
        return "redirect:/domains/edit/" + id;
    }


    public String domainEditRedir() {
        return "redirect:/domains";
    }
}
