package com.example.minipetworld;

public class AddressesModel {

    private String  fullname;
    private String  address;
    private String  pindcode;
    private Boolean selected;

    public AddressesModel(String fullname, String address, String pindcode,Boolean selected) {
        this.fullname = fullname;
        this.address = address;
        this.pindcode = pindcode;
        this.selected= selected;

    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPindcode() {
        return pindcode;
    }

    public void setPindcode(String pindcode) {
        this.pindcode = pindcode;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
