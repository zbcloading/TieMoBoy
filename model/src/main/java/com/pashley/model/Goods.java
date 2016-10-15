package com.pashley.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Pashley on 2016/10/15.
 */

public class Goods implements Serializable {
    private int id;
    private String name;
    private String price;
    private String thumb;
    private List<String> attrFeatures;
    private int salesNum;
    private String shortIntro;

    public String getShortIntro() {
        return shortIntro;
    }

    public void setShortIntro(String shortIntro) {
        this.shortIntro = shortIntro;
    }

    public int getSalesNum() {
        return salesNum;
    }

    public void setSalesNum(int salesNum) {
        this.salesNum = salesNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public List<String> getAttrFeatures() {
        return attrFeatures;
    }

    public void setAttrFeatures(List<String> attrFeatures) {
        this.attrFeatures = attrFeatures;
    }
}
