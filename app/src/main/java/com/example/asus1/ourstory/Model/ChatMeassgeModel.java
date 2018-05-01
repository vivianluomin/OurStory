package com.example.asus1.ourstory.Model;

/**
 * Created by asus1 on 2018/5/1.
 */

public class ChatMeassgeModel {

    public  static  final int LEFT= 0;
    public  static  final  int RIGHT = 1;

    private int location;
    private String meassge;

    public ChatMeassgeModel(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }
}
