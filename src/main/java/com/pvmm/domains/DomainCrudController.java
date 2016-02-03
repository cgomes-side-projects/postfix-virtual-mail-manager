package com.pvmm.domains;

import com.pvmm.domains.domain.Domain;
import com.pvmm.domains.domain.DomainRepository;
import com.pvmm.utils.cruds.CrudController;
import com.pvmm.utils.cruds.CrudControllerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/domain")
public class DomainCrudController extends CrudController<Domain> implements CrudControllerInterface<Domain> {

    @Autowired
    DomainRepository repository;

    public DomainCrudController() {
        super("domains", Domain.class);
    }



    @Override
    public DomainRepository getRepository() {
        return repository;
    }
}
