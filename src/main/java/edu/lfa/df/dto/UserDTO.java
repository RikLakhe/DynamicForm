/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.df.dto;

/**
 *
 * @author LAKHE
 */
public class UserDTO {
    public int uid;
    public String ufname,ulname,uusername,upassword;
    public boolean utype;

    public UserDTO() {
    }

    public UserDTO(int uid, String ufname, String ulname, String uusername, String upassword, boolean utype) {
        this.uid = uid;
        this.ufname = ufname;
        this.ulname = ulname;
        this.uusername = uusername;
        this.upassword = upassword;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUfname() {
        return ufname;
    }

    public void setUfname(String ufname) {
        this.ufname = ufname;
    }

    public String getUlname() {
        return ulname;
    }

    public void setUlname(String ulname) {
        this.ulname = ulname;
    }

    public String getUusername() {
        return uusername;
    }

    public void setUusername(String uusername) {
        this.uusername = uusername;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public boolean isUtype() {
        return utype;
    }

    public void setUtype(boolean utype) {
        this.utype = utype;
    }
    
    
}
