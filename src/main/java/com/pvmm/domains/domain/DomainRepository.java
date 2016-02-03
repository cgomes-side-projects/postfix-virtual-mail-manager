package com.pvmm.domains.domain;

import com.pvmm.utils.cruds.GenericCrudRepositoryInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainRepository extends GenericCrudRepositoryInterface<Domain, Integer> {

    Page<Domain> findAll(Pageable pageable);

    Page<Domain> findByNameContaining(String name, Pageable pageable);

}
