package com.pvmm.emails.email;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface EmailRepository extends CrudRepository<Email, Long> {

    List<Email> findByEmail(String email);

}
