package com.ssi.demo.domain;

import com.ssi.demo.domain.enumeration.Commune;
import java.io.Serializable;
import javax.persistence.*;

/**
 * A Departement.
 */
@Entity
@Table(name = "departement")
public class Departement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nomdepartement")
    private String nomdepartement;

    @Enumerated(EnumType.STRING)
    @Column(name = "commune")
    private Commune commune;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Departement id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomdepartement() {
        return this.nomdepartement;
    }

    public Departement nomdepartement(String nomdepartement) {
        this.setNomdepartement(nomdepartement);
        return this;
    }

    public void setNomdepartement(String nomdepartement) {
        this.nomdepartement = nomdepartement;
    }

    public Commune getCommune() {
        return this.commune;
    }

    public Departement commune(Commune commune) {
        this.setCommune(commune);
        return this;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Departement)) {
            return false;
        }
        return id != null && id.equals(((Departement) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Departement{" +
            "id=" + getId() +
            ", nomdepartement='" + getNomdepartement() + "'" +
            ", commune='" + getCommune() + "'" +
            "}";
    }
}
