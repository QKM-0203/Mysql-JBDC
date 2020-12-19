package com.qkm.Text;

/**
 *将一个mysql表封装成一个对象，存倒集合里面去
 */
public class Student {
    private int ID;
    private String Name;

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "com.qkm.Text.Student{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
