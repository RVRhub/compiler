package entity;

public class Direction {
    //Поле ID направления
    private int dir_id;

    //Поле ID типа направления
    private int typedir_id;

    //Поле Имя направления
    private String dirname;

    //Поле Имя типа направления
    private String typedirname;

    public int getDir_id() {
        return dir_id;
    }
    public void setDir_id(int dir_id) {
        this.dir_id = dir_id;
    }

    public int getTypedir_id() {
        return typedir_id;
    }
    public void setTypedir_id(int typedir_id) {
        this.typedir_id = typedir_id;
    }

    public String getDirname() {
        return dirname;
    }
    public void setDirname(String dirname) {
        this.dirname = dirname;
    }

    public String getTypedirname() {
        return typedirname;
    }
    public void setTypedirname(String typedirname) {
        this.typedirname = typedirname;
    }

    public String toString(){
        return dir_id + "\t" + typedir_id + "\t"
                + dirname + "\t" + typedirname;
    }
}
