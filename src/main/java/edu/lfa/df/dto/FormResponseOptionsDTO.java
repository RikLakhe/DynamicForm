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
public class FormResponseOptionsDTO {
    public int froId;
    public int frofrid;
    public int froffid;
    public String frovalue;

    public FormResponseOptionsDTO() {
    }

    public FormResponseOptionsDTO(int froId, int frofrid, int froffid, String frovalue) {
        this.froId = froId;
        this.frofrid = frofrid;
        this.froffid = froffid;
        this.frovalue = frovalue;
    }

    public int getFroId() {
        return froId;
    }

    public void setFroId(int froId) {
        this.froId = froId;
    }

    public int getFrofrid() {
        return frofrid;
    }

    public void setFrofrid(int frofrid) {
        this.frofrid = frofrid;
    }

    public int getFroffid() {
        return froffid;
    }

    public void setFroffid(int froffid) {
        this.froffid = froffid;
    }

    public String getFrovalue() {
        return frovalue;
    }

    public void setFrovalue(String frovalue) {
        this.frovalue = frovalue;
    }
    
    
}
