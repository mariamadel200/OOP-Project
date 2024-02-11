/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_oop;

/**
 *
 * @author Mariam Adel
 */
import java.util.*;

public class Vehicle {

    private int id;
    private int length;

    public Vehicle(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double calcMoney(double hours) {
        return 0;
    }

    public void setLength(int length) {
        this.length = length;
    }
   

}

class Car extends Vehicle {

    public Car(int id) {
        super(id);
      super.setLength(5);
    }

    @Override
    public double calcMoney(double hours) {

        double money = 10 * hours;
        return money;
    }
}

class Truck extends Vehicle {

    public Truck(int id) {
        super(id);
      setLength(7);
    }

    @Override
    public double calcMoney(double hours) {

        double money = 15 * hours;
        return money;
    }
}

class Bus extends Vehicle {

    public Bus(int id) {
        super(id);
      super.setLength(10);
    }

    @Override
    public double calcMoney(double hours) {

        double money = 15 * hours;
        return money;
    }
}

class Motorcycle extends Vehicle {

    public Motorcycle(int id) {
        super(id);
      super.setLength(2);
    }

    @Override
    public double calcMoney(double hours) {

        double money = 5 * hours;
        return money;
    }
}
