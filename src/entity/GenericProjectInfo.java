package entity;

public class GenericProjectInfo {

    private int project_id;
    private String projname;
    private String proglang;
    private String langplatform;
    private String projtype;
    private String projcategory;

    public int getProject_id() {
        return project_id;
    }
    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProjname() {
        return projname;
    }
    public void setProjname(String projname) {
        this.projname = projname;
    }

    public String getProglang() {
        return proglang;
    }
    public void setProglang(String proglang) {
        this.proglang = proglang;
    }

    public String getLangplatform() {
        return langplatform;
    }
    public void setLangplatform(String langplatform) {
        this.langplatform = langplatform;
    }

    public String getProjtype() {
        return projtype;
    }
    public void setProjtype(String projtype) {
        this.projtype = projtype;
    }

    public String getProjcategory() {
        return projcategory;
    }
    public void setProjcategory(String projcategory) {
        this.projcategory = projcategory;
    }

    public String toString() {
        return project_id + "\t" + projname + "\t"
                + proglang + "\t" + langplatform + "\t" + projtype + "\t" + projcategory;
    }

}
