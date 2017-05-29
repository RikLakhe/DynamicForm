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
public class FormDTO {
    public int fid;
    public String title,fdescription;
    public boolean fstatus;
    public int fuid;

    public FormDTO() {
    }

    public FormDTO(int fid, String title, String fdescription, boolean fstatus, int fuid) {
        this.fid = fid;
        this.title = title;
        this.fdescription = fdescription;
        this.fstatus = fstatus;
        this.fuid = fuid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFdescription() {
        return fdescription;
    }

    public void setFdescription(String fdescription) {
        this.fdescription = fdescription;
    }

    public boolean isFstatus() {
        return fstatus;
    }

    public void setFstatus(boolean fstatus) {
        this.fstatus = fstatus;
    }

    public int getFuid() {
        return fuid;
    }

    public void setFuid(int fuid) {
        this.fuid = fuid;
    }
    
    
}
