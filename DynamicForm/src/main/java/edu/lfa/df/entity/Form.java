/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.df.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LAKHE
 */
@Entity
@Table(name = "tbl_form")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Form.findAll", query = "SELECT f FROM Form f"),
    @NamedQuery(name = "Form.findByFId", query = "SELECT f FROM Form f WHERE f.fId = :fId"),
    @NamedQuery(name = "Form.findByFTitle", query = "SELECT f FROM Form f WHERE f.fTitle = :fTitle"),
    @NamedQuery(name = "Form.findByFStatus", query = "SELECT f FROM Form f WHERE f.fStatus = :fStatus")})
public class Form implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_id")
    private Integer fId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "f_title")
    private String fTitle;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "f_description")
    private String fDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "f_status")
    private boolean fStatus;
    @JoinColumn(name = "f_u_id", referencedColumnName = "u_id")
    @ManyToOne(optional = false)
    private User fUId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "frFId")
    private List<FormResponses> formResponsesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fuFId")
    private List<FormUsers> formUsersList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foFId")
    private List<FormOption> formOptionList;

    public Form() {
    }

    public Form(Integer fId) {
        this.fId = fId;
    }

    public Form(Integer fId, String fTitle, String fDescription, boolean fStatus) {
        this.fId = fId;
        this.fTitle = fTitle;
        this.fDescription = fDescription;
        this.fStatus = fStatus;
    }

    public Integer getFId() {
        return fId;
    }

    public void setFId(Integer fId) {
        this.fId = fId;
    }

    public String getFTitle() {
        return fTitle;
    }

    public void setFTitle(String fTitle) {
        this.fTitle = fTitle;
    }

    public String getFDescription() {
        return fDescription;
    }

    public void setFDescription(String fDescription) {
        this.fDescription = fDescription;
    }

    public boolean getFStatus() {
        return fStatus;
    }

    public void setFStatus(boolean fStatus) {
        this.fStatus = fStatus;
    }

    public User getFUId() {
        return fUId;
    }

    public void setFUId(User fUId) {
        this.fUId = fUId;
    }

    @XmlTransient
    public List<FormResponses> getFormResponsesList() {
        return formResponsesList;
    }

    public void setFormResponsesList(List<FormResponses> formResponsesList) {
        this.formResponsesList = formResponsesList;
    }

    @XmlTransient
    public List<FormUsers> getFormUsersList() {
        return formUsersList;
    }

    public void setFormUsersList(List<FormUsers> formUsersList) {
        this.formUsersList = formUsersList;
    }

    @XmlTransient
    public List<FormOption> getFormOptionList() {
        return formOptionList;
    }

    public void setFormOptionList(List<FormOption> formOptionList) {
        this.formOptionList = formOptionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fId != null ? fId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Form)) {
            return false;
        }
        Form other = (Form) object;
        if ((this.fId == null && other.fId != null) || (this.fId != null && !this.fId.equals(other.fId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.lfa.df.entity.Form[ fId=" + fId + " ]";
    }
    
}
