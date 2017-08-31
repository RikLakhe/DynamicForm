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
public class FormFieldDTO {
    public int ffid;
    public String ffname;
    public int ffuserid;

    public FormFieldDTO() {
    }

    public FormFieldDTO(int ffid, String ffname, int ffuserid) {
        this.ffid = ffid;
        this.ffname = ffname;
        this.ffuserid = ffuserid;
    }

    public int getFfid() {
        return ffid;
    }

    public void setFfid(int ffid) {
        this.ffid = ffid;
    }

    public String getFfname() {
        return ffname;
    }

    public void setFfname(String ffname) {
        this.ffname = ffname;
    }

    public int getFfuserid() {
        return ffuserid;
    }

    public void setFfuserid(int ffuserid) {
        this.ffuserid = ffuserid;
    }
    
}
