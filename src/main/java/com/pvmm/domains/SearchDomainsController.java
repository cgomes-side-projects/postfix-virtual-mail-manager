package com.pvmm.domains;

import com.pvmm.domains.domain.Domain;
import com.pvmm.domains.domain.DomainRepository;
import com.pvmm.utils.Paginator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SearchDomainsController {

    @Autowired
    DomainRepository repository;

    @Autowired
    private HttpServletRequest request;


    @RequestMapping(value = "/domains", method = RequestMethod.GET)
    public String searchDomain(Model model, Pageable pageable, @RequestParam(name = "email", defaultValue = "") String name) {
        Page<Domain> domains = repository.findByNameContaining(name, pageable);

        model.addAttribute("domains",  domains);
        preparePaginator(domains, model);

        return "domains/search-domains";
    }


    private void preparePaginator( Page<Domain> domains, Model model ) {
        Paginator<Domain> paginator = new Paginator<>(domains, request);

        model.addAttribute("paginator", paginator);
    }
}
