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
@Table(name = "tbl_form_option")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormOption.findAll", query = "SELECT f FROM FormOption f"),
    @NamedQuery(name = "FormOption.findByFoId", query = "SELECT f FROM FormOption f WHERE f.foId = :foId"),
    @NamedQuery(name = "FormOption.findByFodisplayOrder", query = "SELECT f FROM FormOption f WHERE f.fodisplayOrder = :fodisplayOrder"),
    @NamedQuery(name = "FormOption.findByFoType", query = "SELECT f FROM FormOption f WHERE f.foType = :foType"),
    @NamedQuery(name = "FormOption.findByFotypeOption", query = "SELECT f FROM FormOption f WHERE f.fotypeOption = :fotypeOption")})
public class FormOption implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fo_id")
    private Integer foId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fo_displayOrder")
    private int fodisplayOrder;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "fo_type")
    private String foType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "fo_typeOption")
    private String fotypeOption;
    @JoinColumn(name = "fo_f_id", referencedColumnName = "f_id")
    @ManyToOne(optional = false)
    private Form foFId;
    @JoinColumn(name = "fo_ff_id", referencedColumnName = "ff_id")
    @ManyToOne(optional = false)
    private FormFields foFfId;

    public FormOption() {
    }

    public FormOption(Integer foId) {
        this.foId = foId;
    }

    public FormOption(Integer foId, int fodisplayOrder, String foType, String fotypeOption) {
        this.foId = foId;
        this.fodisplayOrder = fodisplayOrder;
        this.foType = foType;
        this.fotypeOption = fotypeOption;
    }

    public Integer getFoId() {
        return foId;
    }

    public void setFoId(Integer foId) {
        this.foId = foId;
    }

    public int getFodisplayOrder() {
        return fodisplayOrder;
    }

    public void setFodisplayOrder(int fodisplayOrder) {
        this.fodisplayOrder = fodisplayOrder;
    }

    public String getFoType() {
        return foType;
    }

    public void setFoType(String foType) {
        this.foType = foType;
    }

    public String getFotypeOption() {
        return fotypeOption;
    }

    public void setFotypeOption(String fotypeOption) {
        this.fotypeOption = fotypeOption;
    }

    public Form getFoFId() {
        return foFId;
    }

    public void setFoFId(Form foFId) {
        this.foFId = foFId;
    }

    public FormFields getFoFfId() {
        return foFfId;
    }

    public void setFoFfId(FormFields foFfId) {
        this.foFfId = foFfId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foId != null ? foId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormOption)) {
            return false;
        }
        FormOption other = (FormOption) object;
        if ((this.foId == null && other.foId != null) || (this.foId != null && !this.foId.equals(other.foId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.lfa.df.entity.FormOption[ foId=" + foId + " ]";
    }
    
}
