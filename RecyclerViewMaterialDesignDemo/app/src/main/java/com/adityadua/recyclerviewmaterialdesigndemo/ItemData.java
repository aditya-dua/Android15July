package com.adityadua.recyclerviewmaterialdesigndemo;

/**
 * Created by AdityaDua on 17/09/17.
 */

public class ItemData {

    String name;
    int url;

    public ItemData(String name, int url) {
        this.name = name;
        this.url = url;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getUrl() {
        return url;
    }
    public void setUrl(int url) {
        this.url = url;
    }
}
