package com.pvmm.emails.email;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface EmailRepository extends CrudRepository<Email, Long> {

    Page<Email> findAll(Pageable pageable);

    Page<Email> findByEmailContaining(String email, Pageable pageable);


}
