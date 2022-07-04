package org.example10.models;

public class OrgStaff {
private int staff_id;
private String nameSurname;
private int experiance;
private int id_posts;
private int id_work_shops;

    public OrgStaff() {

    }

    public OrgStaff(int staff_id, String nameSurname, int experiance, int id_posts, int id_work_shop) {
        this.staff_id = staff_id;
        this.nameSurname = nameSurname;
        this.experiance = experiance;
        this.id_posts = id_posts;
        this.id_work_shops = id_work_shop;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public int getExperiance() {
        return experiance;
    }

    public void setExperiance(int experiance) {
        this.experiance = experiance;
    }

    public int getId_posts() {
        return id_posts;
    }

    public void setId_posts(int id_posts) {
        this.id_posts = id_posts;
    }

    public int getId_work_shops() {
        return id_work_shops;
    }

    public void setId_work_shops(int id_work_shop) {
        this.id_work_shops = id_work_shop;
    }
}
