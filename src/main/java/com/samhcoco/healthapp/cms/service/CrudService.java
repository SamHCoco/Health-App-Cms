package com.samhcoco.healthapp.cms.service;

/** Generic base service for services involving CRUD */

public interface CrudService<T> {

    /**
     * Get {@link T} by ID.
     * @param id {@link T} ID.
     * @return {@link T}
     */
    T getById(Long id);

    /**
     * Create {@link T}.
     * @param object The {@link T} to create.
     * @return The created {@link T}.
     */
    T create(T object);

    /**
     * Update {@link T}.
     * @param object The {@link T} to be updated.
     * @return Updated {@link T}.
     */
    T update(T object);

    /**
     * Delete {@link T} by ID.
     * @param id {@link T} ID.
     */
    void delete(Long id);

}
