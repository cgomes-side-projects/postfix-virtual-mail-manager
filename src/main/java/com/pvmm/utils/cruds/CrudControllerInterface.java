package com.pvmm.utils.cruds;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudControllerInterface<T extends CrudEntityInterface> {

    GenericCrudRepositoryInterface<T, Integer> getRepository();

    Page<T> searchOnRepository( String query, Pageable pageable );
}
