package com.ssi.demo.service.mapper;

import com.ssi.demo.domain.Departement;
import com.ssi.demo.service.dto.DepartementDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Departement} and its DTO {@link DepartementDTO}.
 */
@Mapper(componentModel = "spring")
public interface DepartementMapper extends EntityMapper<DepartementDTO, Departement> {}
