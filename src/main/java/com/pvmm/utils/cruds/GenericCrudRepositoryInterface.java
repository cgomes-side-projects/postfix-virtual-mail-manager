package com.pvmm.utils.cruds;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface GenericCrudRepositoryInterface<T, ID extends Serializable> extends JpaRepository<T, ID> {


}
