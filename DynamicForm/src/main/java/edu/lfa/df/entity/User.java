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
import javax.persistence.Lob;
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
@Table(name = "tbl_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUId", query = "SELECT u FROM User u WHERE u.uId = :uId"),
    @NamedQuery(name = "User.findByUFname", query = "SELECT u FROM User u WHERE u.uFname = :uFname"),
    @NamedQuery(name = "User.findByULname", query = "SELECT u FROM User u WHERE u.uLname = :uLname"),
    @NamedQuery(name = "User.findByUaddedDate", query = "SELECT u FROM User u WHERE u.uaddedDate = :uaddedDate"),
    @NamedQuery(name = "User.findByUmodifiedDate", query = "SELECT u FROM User u WHERE u.umodifiedDate = :umodifiedDate"),
    @NamedQuery(name = "User.findByUType", query = "SELECT u FROM User u WHERE u.uType = :uType"),
    @NamedQuery(name = "User.findByUUsername", query = "SELECT u FROM User u WHERE u.uUsername = :uUsername"),
    @NamedQuery(name = "User.findByUPassword", query = "SELECT u FROM User u WHERE u.uPassword = :uPassword")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "u_id")
    private Integer uId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "u_fname")
    private String uFname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "u_lname")
    private String uLname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "u_addedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uaddedDate;
    @Column(name = "u_modifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date umodifiedDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "u_type")
    private boolean uType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "u_username")
    private String uUsername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "u_password")
    private String uPassword;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "u_token")
    private String uToken;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fUId")
    private List<Form> formList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fuUId")
    private List<FormUsers> formUsersList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ffUserId")
    private List<FormFields> formFieldsList;

    public User() {
    }

    public User(Integer uId) {
        this.uId = uId;
    }

    public User(Integer uId, String uFname, String uLname, Date uaddedDate, boolean uType, String uUsername, String uPassword) {
        this.uId = uId;
        this.uFname = uFname;
        this.uLname = uLname;
        this.uaddedDate = uaddedDate;
        this.uType = uType;
        this.uUsername = uUsername;
        this.uPassword = uPassword;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public String getUFname() {
        return uFname;
    }

    public void setUFname(String uFname) {
        this.uFname = uFname;
    }

    public String getULname() {
        return uLname;
    }

    public void setULname(String uLname) {
        this.uLname = uLname;
    }

    public Date getUaddedDate() {
        return uaddedDate;
    }

    public void setUaddedDate(Date uaddedDate) {
        this.uaddedDate = uaddedDate;
    }

    public Date getUmodifiedDate() {
        return umodifiedDate;
    }

    public void setUmodifiedDate(Date umodifiedDate) {
        this.umodifiedDate = umodifiedDate;
    }

    public boolean getUType() {
        return uType;
    }

    public void setUType(boolean uType) {
        this.uType = uType;
    }

    public String getUUsername() {
        return uUsername;
    }

    public void setUUsername(String uUsername) {
        this.uUsername = uUsername;
    }

    public String getUPassword() {
        return uPassword;
    }

    public void setUPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getUToken() {
        return uToken;
    }

    public void setUToken(String uToken) {
        this.uToken = uToken;
    }

    @XmlTransient
    public List<Form> getFormList() {
        return formList;
    }

    public void setFormList(List<Form> formList) {
        this.formList = formList;
    }

    @XmlTransient
    public List<FormUsers> getFormUsersList() {
        return formUsersList;
    }

    public void setFormUsersList(List<FormUsers> formUsersList) {
        this.formUsersList = formUsersList;
    }

    @XmlTransient
    public List<FormFields> getFormFieldsList() {
        return formFieldsList;
    }

    public void setFormFieldsList(List<FormFields> formFieldsList) {
        this.formFieldsList = formFieldsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uId != null ? uId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.uId == null && other.uId != null) || (this.uId != null && !this.uId.equals(other.uId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.lfa.df.entity.User[ uId=" + uId + " ]";
    }
    
}
