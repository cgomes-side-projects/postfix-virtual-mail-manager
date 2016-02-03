package com.pvmm.emails;

import com.pvmm.emails.email.Email;
import com.pvmm.emails.email.EmailRepository;
import com.pvmm.utils.cruds.CrudController;
import com.pvmm.utils.cruds.CrudControllerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/email")
//TODO implementar o create e o edit com views diferentes
public class EmailCrudCrontroller extends CrudController<Email> implements CrudControllerInterface<Email> {

    @Autowired
    EmailRepository repository;

    public EmailCrudCrontroller() {
        super("emails", Email.class);
    }

    @Override
    public EmailRepository getRepository() {
        return repository;
    }

    @Override
    public Page<Email> searchOnRepository(String query, Pageable pageable) {
        return repository.findByEmailContaining(query, pageable);
    }
}
