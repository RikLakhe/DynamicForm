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
@Table(name = "tbl_form_fields")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormFields.findAll", query = "SELECT f FROM FormFields f"),
    @NamedQuery(name = "FormFields.findByFfId", query = "SELECT f FROM FormFields f WHERE f.ffId = :ffId"),
    @NamedQuery(name = "FormFields.findByFfName", query = "SELECT f FROM FormFields f WHERE f.ffName = :ffName"),
    @NamedQuery(name = "FormFields.findByFfenteryDate", query = "SELECT f FROM FormFields f WHERE f.ffenteryDate = :ffenteryDate"),
    @NamedQuery(name = "FormFields.findByFfmodifiedDate", query = "SELECT f FROM FormFields f WHERE f.ffmodifiedDate = :ffmodifiedDate")})
public class FormFields implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ff_id")
    private Integer ffId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ff_name")
    private String ffName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ff_enteryDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ffenteryDate;
    @Column(name = "ff_modifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ffmodifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foFfId")
    private List<FormOption> formOptionList;
    @JoinColumn(name = "ff_user_id", referencedColumnName = "u_id")
    @ManyToOne(optional = false)
    private User ffUserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "froFfId")
    private List<FormResponseOptions> formResponseOptionsList;

    public FormFields() {
    }

    public FormFields(Integer ffId) {
        this.ffId = ffId;
    }

    public FormFields(Integer ffId, String ffName, Date ffenteryDate) {
        this.ffId = ffId;
        this.ffName = ffName;
        this.ffenteryDate = ffenteryDate;
    }

    public Integer getFfId() {
        return ffId;
    }

    public void setFfId(Integer ffId) {
        this.ffId = ffId;
    }

    public String getFfName() {
        return ffName;
    }

    public void setFfName(String ffName) {
        this.ffName = ffName;
    }

    public Date getFfenteryDate() {
        return ffenteryDate;
    }

    public void setFfenteryDate(Date ffenteryDate) {
        this.ffenteryDate = ffenteryDate;
    }

    public Date getFfmodifiedDate() {
        return ffmodifiedDate;
    }

    public void setFfmodifiedDate(Date ffmodifiedDate) {
        this.ffmodifiedDate = ffmodifiedDate;
    }

    @XmlTransient
    public List<FormOption> getFormOptionList() {
        return formOptionList;
    }

    public void setFormOptionList(List<FormOption> formOptionList) {
        this.formOptionList = formOptionList;
    }

    public User getFfUserId() {
        return ffUserId;
    }

    public void setFfUserId(User ffUserId) {
        this.ffUserId = ffUserId;
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
        hash += (ffId != null ? ffId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormFields)) {
            return false;
        }
        FormFields other = (FormFields) object;
        if ((this.ffId == null && other.ffId != null) || (this.ffId != null && !this.ffId.equals(other.ffId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.lfa.df.entity.FormFields[ ffId=" + ffId + " ]";
    }
    
}
