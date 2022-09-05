package com.ssi.demo.web.rest;

import com.ssi.demo.repository.DepartementRepository;
import com.ssi.demo.service.DepartementService;
import com.ssi.demo.service.dto.DepartementDTO;
import com.ssi.demo.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.ssi.demo.domain.Departement}.
 */
@RestController
@RequestMapping("/api")
public class DepartementResource {

    private final Logger log = LoggerFactory.getLogger(DepartementResource.class);

    private static final String ENTITY_NAME = "passationDepartement";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DepartementService departementService;

    private final DepartementRepository departementRepository;

    public DepartementResource(DepartementService departementService, DepartementRepository departementRepository) {
        this.departementService = departementService;
        this.departementRepository = departementRepository;
    }

    /**
     * {@code POST  /departements} : Create a new departement.
     *
     * @param departementDTO the departementDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new departementDTO, or with status {@code 400 (Bad Request)} if the departement has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/departements")
    public ResponseEntity<DepartementDTO> createDepartement(@RequestBody DepartementDTO departementDTO) throws URISyntaxException {
        log.debug("REST request to save Departement : {}", departementDTO);
        if (departementDTO.getId() != null) {
            throw new BadRequestAlertException("A new departement cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DepartementDTO result = departementService.save(departementDTO);
        return ResponseEntity
            .created(new URI("/api/departements/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /departements/:id} : Updates an existing departement.
     *
     * @param id the id of the departementDTO to save.
     * @param departementDTO the departementDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated departementDTO,
     * or with status {@code 400 (Bad Request)} if the departementDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the departementDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/departements/{id}")
    public ResponseEntity<DepartementDTO> updateDepartement(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody DepartementDTO departementDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Departement : {}, {}", id, departementDTO);
        if (departementDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, departementDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!departementRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        DepartementDTO result = departementService.update(departementDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, departementDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /departements/:id} : Partial updates given fields of an existing departement, field will ignore if it is null
     *
     * @param id the id of the departementDTO to save.
     * @param departementDTO the departementDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated departementDTO,
     * or with status {@code 400 (Bad Request)} if the departementDTO is not valid,
     * or with status {@code 404 (Not Found)} if the departementDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the departementDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/departements/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<DepartementDTO> partialUpdateDepartement(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody DepartementDTO departementDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Departement partially : {}, {}", id, departementDTO);
        if (departementDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, departementDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!departementRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<DepartementDTO> result = departementService.partialUpdate(departementDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, departementDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /departements} : get all the departements.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of departements in body.
     */
    @GetMapping("/departements")
    public List<DepartementDTO> getAllDepartements() {
        log.debug("REST request to get all Departements");
        return departementService.findAll();
    }

    /**
     * {@code GET  /departements/:id} : get the "id" departement.
     *
     * @param id the id of the departementDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the departementDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/departements/{id}")
    public ResponseEntity<DepartementDTO> getDepartement(@PathVariable Long id) {
        log.debug("REST request to get Departement : {}", id);
        Optional<DepartementDTO> departementDTO = departementService.findOne(id);
        return ResponseUtil.wrapOrNotFound(departementDTO);
    }

    /**
     * {@code DELETE  /departements/:id} : delete the "id" departement.
     *
     * @param id the id of the departementDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/departements/{id}")
    public ResponseEntity<Void> deleteDepartement(@PathVariable Long id) {
        log.debug("REST request to delete Departement : {}", id);
        departementService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
