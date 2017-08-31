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
public class FormUsersDTO {
    public int fuid;
    public int fufid;
    public int ffuid;
    public boolean fupermission;

    public FormUsersDTO() {
    }

    public FormUsersDTO(int fuid, int fufid, int ffuid, boolean fupermission) {
        this.fuid = fuid;
        this.fufid = fufid;
        this.ffuid = ffuid;
        this.fupermission = fupermission;
    }

    public int getFuid() {
        return fuid;
    }

    public void setFuid(int fuid) {
        this.fuid = fuid;
    }

    public int getFufid() {
        return fufid;
    }

    public void setFufid(int fufid) {
        this.fufid = fufid;
    }

    public int getFfuid() {
        return ffuid;
    }

    public void setFfuid(int ffuid) {
        this.ffuid = ffuid;
    }

    public boolean isFupermission() {
        return fupermission;
    }

    public void setFupermission(boolean fupermission) {
        this.fupermission = fupermission;
    }
    
}
