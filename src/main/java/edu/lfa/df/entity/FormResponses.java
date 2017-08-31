/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.df.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LAKHE
 */
@Entity
@Table(name = "tbl_form_responses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormResponses.findAll", query = "SELECT f FROM FormResponses f"),
    @NamedQuery(name = "FormResponses.findByFrId", query = "SELECT f FROM FormResponses f WHERE f.frId = :frId"),
    @NamedQuery(name = "FormResponses.findByFrentryDate", query = "SELECT f FROM FormResponses f WHERE f.frentryDate = :frentryDate"),
    @NamedQuery(name = "FormResponses.findByFripAddress", query = "SELECT f FROM FormResponses f WHERE f.fripAddress = :fripAddress")})
public class FormResponses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fr_id")
    private Integer frId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fr_entryDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date frentryDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "fr_ipAddress")
    private String fripAddress;
    @JoinColumn(name = "fr_f_id", referencedColumnName = "f_id")
    @ManyToOne(optional = false)
    private Form frFId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "froFrId")
    private List<FormResponseOptions> formResponseOptionsList;

    public FormResponses() {
    }

    public FormResponses(Integer frId) {
        this.frId = frId;
    }

    public FormResponses(Integer frId, Date frentryDate, String fripAddress) {
        this.frId = frId;
        this.frentryDate = frentryDate;
        this.fripAddress = fripAddress;
    }

    public Integer getFrId() {
        return frId;
    }

    public void setFrId(Integer frId) {
        this.frId = frId;
    }

    public Date getFrentryDate() {
        return frentryDate;
    }

    public void setFrentryDate(Date frentryDate) {
        this.frentryDate = frentryDate;
    }

    public String getFripAddress() {
        return fripAddress;
    }

    public void setFripAddress(String fripAddress) {
        this.fripAddress = fripAddress;
    }

    public Form getFrFId() {
        return frFId;
    }

    public void setFrFId(Form frFId) {
        this.frFId = frFId;
    }

    @XmlTransient
    public List<FormResponseOptions> getFormResponseOptionsList() {
        return formResponseOptionsList;
    }

    public void setFormResponseOptionsList(List<FormResponseOptions> formResponseOptionsList) {
        this.formResponseOptionsList = formResponseOptionsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (frId != null ? frId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormResponses)) {
            return false;
        }
        FormResponses other = (FormResponses) object;
        if ((this.frId == null && other.frId != null) || (this.frId != null && !this.frId.equals(other.frId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.lfa.df.entity.FormResponses[ frId=" + frId + " ]";
    }
    
}
