package com.ssi.demo.service.dto;

import com.ssi.demo.domain.enumeration.Commune;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.ssi.demo.domain.Departement} entity.
 */
public class DepartementDTO implements Serializable {

    private Long id;

    private String nomdepartement;

    private Commune commune;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomdepartement() {
        return nomdepartement;
    }

    public void setNomdepartement(String nomdepartement) {
        this.nomdepartement = nomdepartement;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DepartementDTO)) {
            return false;
        }

        DepartementDTO departementDTO = (DepartementDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, departementDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DepartementDTO{" +
            "id=" + getId() +
            ", nomdepartement='" + getNomdepartement() + "'" +
            ", commune='" + getCommune() + "'" +
            "}";
    }
}
