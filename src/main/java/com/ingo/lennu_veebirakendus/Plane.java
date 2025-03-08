package com.ingo.lennu_veebirakendus;

public class Plane {
    private String size;
    private int passanger_count;


    public Plane(String size, int passanger_count) {
        this.size = size;
        this.passanger_count = passanger_count;
    }


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPassanger_count() {
        return passanger_count;
    }

    public void setPassanger_count(int passanger_count) {
        this.passanger_count = passanger_count;
    }

    //toString for displaying info
    @Override
    public String toString(){
        return "Lennuki suurus on : " + size + " ja see mahutab : " + passanger_count + " reisijat ";
    }
}
