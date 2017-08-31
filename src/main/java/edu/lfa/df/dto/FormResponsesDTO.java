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
public class FormResponsesDTO {
    public int frid;
    public int frfid;
    public String fripaddress;

    public FormResponsesDTO() {
    }

    public FormResponsesDTO(int frid, int frfid, String fripaddress) {
        this.frid = frid;
        this.frfid = frfid;
        this.fripaddress = fripaddress;
    }

    public int getFrid() {
        return frid;
    }

    public void setFrid(int frid) {
        this.frid = frid;
    }

    public int getFrfid() {
        return frfid;
    }

    public void setFrfid(int frfid) {
        this.frfid = frfid;
    }

    public String getFripaddress() {
        return fripaddress;
    }

    public void setFripaddress(String fripaddress) {
        this.fripaddress = fripaddress;
    }
    
    
}
