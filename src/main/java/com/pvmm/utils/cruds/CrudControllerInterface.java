package com.pvmm.utils.cruds;

public interface CrudControllerInterface<T extends CrudEntityInterface> {

    GenericCrudRepositoryInterface<T, Integer> getRepository();
}
