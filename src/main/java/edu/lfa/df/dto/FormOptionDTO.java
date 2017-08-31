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
public class FormOptionDTO {
    public int foid;
    public int fofid;
    public int foffid;
    public int fodisplayorder;
    public String fotype;
    public String fotypeoption;

    public FormOptionDTO() {
    }

    public FormOptionDTO(int foid, int fofid, int foffid, int fodisplayorder, String fotype, String fotypeoption) {
        this.foid = foid;
        this.fofid = fofid;
        this.foffid = foffid;
        this.fodisplayorder = fodisplayorder;
        this.fotype = fotype;
        this.fotypeoption = fotypeoption;
    }

    public int getFoid() {
        return foid;
    }

    public void setFoid(int foid) {
        this.foid = foid;
    }

    public int getFofid() {
        return fofid;
    }

    public void setFofid(int fofid) {
        this.fofid = fofid;
    }

    public int getFoffid() {
        return foffid;
    }

    public void setFoffid(int foffid) {
        this.foffid = foffid;
    }

    public int getFodisplayorder() {
        return fodisplayorder;
    }

    public void setFodisplayorder(int fodisplayorder) {
        this.fodisplayorder = fodisplayorder;
    }

    public String getFotype() {
        return fotype;
    }

    public void setFotype(String fotype) {
        this.fotype = fotype;
    }

    public String getFotypeoption() {
        return fotypeoption;
    }

    public void setFotypeoption(String fotypeoption) {
        this.fotypeoption = fotypeoption;
    }
    
    
    
}
