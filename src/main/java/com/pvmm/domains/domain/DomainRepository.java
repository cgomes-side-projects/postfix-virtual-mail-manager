package com.pvmm.domains.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface DomainRepository extends CrudRepository<Domain, Integer> {

    Page<Domain> findAll(Pageable pageable);

    Page<Domain> findByNameContaining(String name, Pageable pageable);

}
