package com.ssi.demo.service;

import com.ssi.demo.service.dto.DepartementDTO;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ssi.demo.domain.Departement}.
 */
public interface DepartementService {
    /**
     * Save a departement.
     *
     * @param departementDTO the entity to save.
     * @return the persisted entity.
     */
    DepartementDTO save(DepartementDTO departementDTO);

    /**
     * Updates a departement.
     *
     * @param departementDTO the entity to update.
     * @return the persisted entity.
     */
    DepartementDTO update(DepartementDTO departementDTO);

    /**
     * Partially updates a departement.
     *
     * @param departementDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<DepartementDTO> partialUpdate(DepartementDTO departementDTO);

    /**
     * Get all the departements.
     *
     * @return the list of entities.
     */
    List<DepartementDTO> findAll();

    /**
     * Get the "id" departement.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DepartementDTO> findOne(Long id);

    /**
     * Delete the "id" departement.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
