/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.df.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LAKHE
 */
@Entity
@Table(name = "tbl_form_response_options")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormResponseOptions.findAll", query = "SELECT f FROM FormResponseOptions f"),
    @NamedQuery(name = "FormResponseOptions.findByFroId", query = "SELECT f FROM FormResponseOptions f WHERE f.froId = :froId"),
    @NamedQuery(name = "FormResponseOptions.findByFroValue", query = "SELECT f FROM FormResponseOptions f WHERE f.froValue = :froValue")})
public class FormResponseOptions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fro_id")
    private Integer froId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "fro_value")
    private String froValue;
    @JoinColumn(name = "fro_fr_id", referencedColumnName = "fr_id")
    @ManyToOne(optional = false)
    private FormResponses froFrId;
    @JoinColumn(name = "fro_ff_id", referencedColumnName = "ff_id")
    @ManyToOne(optional = false)
    private FormFields froFfId;

    public FormResponseOptions() {
    }

    public FormResponseOptions(Integer froId) {
        this.froId = froId;
    }

    public FormResponseOptions(Integer froId, String froValue) {
        this.froId = froId;
        this.froValue = froValue;
    }

    public Integer getFroId() {
        return froId;
    }

    public void setFroId(Integer froId) {
        this.froId = froId;
    }

    public String getFroValue() {
        return froValue;
    }

    public void setFroValue(String froValue) {
        this.froValue = froValue;
    }

    public FormResponses getFroFrId() {
        return froFrId;
    }

    public void setFroFrId(FormResponses froFrId) {
        this.froFrId = froFrId;
    }

    public FormFields getFroFfId() {
        return froFfId;
    }

    public void setFroFfId(FormFields froFfId) {
        this.froFfId = froFfId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (froId != null ? froId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormResponseOptions)) {
            return false;
        }
        FormResponseOptions other = (FormResponseOptions) object;
        if ((this.froId == null && other.froId != null) || (this.froId != null && !this.froId.equals(other.froId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.lfa.df.entity.FormResponseOptions[ froId=" + froId + " ]";
    }
    
}
