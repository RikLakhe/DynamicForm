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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LAKHE
 */
@Entity
@Table(name = "tbl_form_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormUsers.findAll", query = "SELECT f FROM FormUsers f"),
    @NamedQuery(name = "FormUsers.findByFuId", query = "SELECT f FROM FormUsers f WHERE f.fuId = :fuId"),
    @NamedQuery(name = "FormUsers.findByFuPermission", query = "SELECT f FROM FormUsers f WHERE f.fuPermission = :fuPermission")})
public class FormUsers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fu_id")
    private Integer fuId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fu_permission")
    private boolean fuPermission;
    @JoinColumn(name = "fu_f_id", referencedColumnName = "f_id")
    @ManyToOne(optional = false)
    private Form fuFId;
    @JoinColumn(name = "fu_u_id", referencedColumnName = "u_id")
    @ManyToOne(optional = false)
    private User fuUId;

    public FormUsers() {
    }

    public FormUsers(Integer fuId) {
        this.fuId = fuId;
    }

    public FormUsers(Integer fuId, boolean fuPermission) {
        this.fuId = fuId;
        this.fuPermission = fuPermission;
    }

    public Integer getFuId() {
        return fuId;
    }

    public void setFuId(Integer fuId) {
        this.fuId = fuId;
    }

    public boolean getFuPermission() {
        return fuPermission;
    }

    public void setFuPermission(boolean fuPermission) {
        this.fuPermission = fuPermission;
    }

    public Form getFuFId() {
        return fuFId;
    }

    public void setFuFId(Form fuFId) {
        this.fuFId = fuFId;
    }

    public User getFuUId() {
        return fuUId;
    }

    public void setFuUId(User fuUId) {
        this.fuUId = fuUId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fuId != null ? fuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormUsers)) {
            return false;
        }
        FormUsers other = (FormUsers) object;
        if ((this.fuId == null && other.fuId != null) || (this.fuId != null && !this.fuId.equals(other.fuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.lfa.df.entity.FormUsers[ fuId=" + fuId + " ]";
    }
    
}
