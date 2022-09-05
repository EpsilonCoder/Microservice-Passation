package com.ssi.demo.service.impl;

import com.ssi.demo.domain.Departement;
import com.ssi.demo.repository.DepartementRepository;
import com.ssi.demo.service.DepartementService;
import com.ssi.demo.service.dto.DepartementDTO;
import com.ssi.demo.service.mapper.DepartementMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Departement}.
 */
@Service
@Transactional
public class DepartementServiceImpl implements DepartementService {

    private final Logger log = LoggerFactory.getLogger(DepartementServiceImpl.class);

    private final DepartementRepository departementRepository;

    private final DepartementMapper departementMapper;

    public DepartementServiceImpl(DepartementRepository departementRepository, DepartementMapper departementMapper) {
        this.departementRepository = departementRepository;
        this.departementMapper = departementMapper;
    }

    @Override
    public DepartementDTO save(DepartementDTO departementDTO) {
        log.debug("Request to save Departement : {}", departementDTO);
        Departement departement = departementMapper.toEntity(departementDTO);
        departement = departementRepository.save(departement);
        return departementMapper.toDto(departement);
    }

    @Override
    public DepartementDTO update(DepartementDTO departementDTO) {
        log.debug("Request to save Departement : {}", departementDTO);
        Departement departement = departementMapper.toEntity(departementDTO);
        departement = departementRepository.save(departement);
        return departementMapper.toDto(departement);
    }

    @Override
    public Optional<DepartementDTO> partialUpdate(DepartementDTO departementDTO) {
        log.debug("Request to partially update Departement : {}", departementDTO);

        return departementRepository
            .findById(departementDTO.getId())
            .map(existingDepartement -> {
                departementMapper.partialUpdate(existingDepartement, departementDTO);

                return existingDepartement;
            })
            .map(departementRepository::save)
            .map(departementMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DepartementDTO> findAll() {
        log.debug("Request to get all Departements");
        return departementRepository.findAll().stream().map(departementMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DepartementDTO> findOne(Long id) {
        log.debug("Request to get Departement : {}", id);
        return departementRepository.findById(id).map(departementMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Departement : {}", id);
        departementRepository.deleteById(id);
    }
}
