package com.ingo.lennu_veebirakendus;

public class Flight {
    private String city;
    private String date;
    private String time;


    // Constructor


    public Flight(String city, String date, String time) {
        this.city = city;
        this.date = date;
        this.time = time;
    }

    //Getters


    public String getCity() {
        return city;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    //toString for displaying info
    @Override
    public String toString(){
        return "Sihtkoht: " + city + ", Kuupäev: " + date + ", Lennu kestvus " + time;
    }
}
