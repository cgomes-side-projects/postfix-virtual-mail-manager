package com.pvmm.emails.email;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface EmailRepository extends CrudRepository<Email, Integer> {

    Page<Email> findByEmailContaining(String email, Pageable pageable);

    Page<Email> findByDomainIdAndEmailContainingOrderByEmail(int domainId, String email, Pageable pageable);

    Email findByIdAndDomainId(int id, int domainId);
}
