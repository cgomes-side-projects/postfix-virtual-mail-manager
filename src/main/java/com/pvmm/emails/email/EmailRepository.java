package com.pvmm.emails.email;

import com.pvmm.utils.cruds.GenericCrudRepositoryInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface EmailRepository extends GenericCrudRepositoryInterface<Email, Integer> {

    Page<Email> findByEmailContaining(String email, Pageable pageable);

}
