package com.pvmm.domains;

import com.pvmm.domains.domain.Domain;
import com.pvmm.domains.domain.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public final class DomainEditController {

    private final String VIEW_PATH = "domains/domain-form";

    @Autowired
    private DomainRepository repository;

    private RedirectAttributes redirectAttributes;


    @RequestMapping( value = "domains/edit/{id}", method = RequestMethod.GET)
    public String domainEdit(
        Model model,
        @PathVariable("id") Domain domain,
        final RedirectAttributes redirectAttributes
    ) {
        this.redirectAttributes = redirectAttributes;

        if( domain == null ) {
            return this.domainNotFound();
        }

        model.addAttribute("domain", domain);
        return VIEW_PATH;
    }


    @RequestMapping(value = "domains/edit/{id}", method = RequestMethod.POST )
    public String domainEditPost(
        final @PathVariable("id") Domain domain,
        final @Valid @ModelAttribute("domain") Domain newDomain,
        final BindingResult errors,
        final RedirectAttributes redirectAttributes
    ){
        this.redirectAttributes = redirectAttributes;

        if( domain == null ) {
            return this.domainNotFound();
        }

        if( errors.getErrorCount() > 0 ) {
            return VIEW_PATH;
        }

        this.saveDomain(newDomain, domain);
        return "redirect:/domains/edit/" + newDomain.getId();
    }



    private String domainNotFound() {
        redirectAttributes.addFlashAttribute("error_message", "Registro não encontrado.");
        return this.domainEditRedir();
    }


    public String domainEditRedir() {
        return "redirect:/domains";
    }


    public void saveDomain(Domain newDomain, Domain domain) {
        newDomain.setId( domain.getId() );
        repository.save(newDomain);
        redirectAttributes.addFlashAttribute("message", "Registro salvo com sucesso.");
    }
}
