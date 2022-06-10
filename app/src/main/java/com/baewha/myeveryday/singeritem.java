package com.baewha.myeveryday;

public class singeritem {
    String name;
    String mobile;
    String clinic;


    public singeritem(String name, String mobile, String clinic) {
        this.name = name;
        this.mobile = mobile;
        this.clinic = clinic;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getClinic() { return clinic; }

    public void setClinic(String clinic) { this.clinic = clinic; }

    @Override
    public String toString() {
        return "singeritem{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", clinic='" + mobile + '\'' +
                '}';
    }
}