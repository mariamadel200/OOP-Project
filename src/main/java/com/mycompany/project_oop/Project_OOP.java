/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.project_oop;

import java.util.*;

public class Project_OOP {

    static int[] parking_area = new int[101];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Vehicle> vehicle = new ArrayList();
        while (true) {
            int inputnum = menu();
            //to add a Vechile
            //***************************************
            if (inputnum == 1) {
                System.out.println("enter your ID");
                int id = input.nextInt();
                System.out.println("enter your Type");
                String type = input.next();
                if ("Car".equals(type)) {
                    if (parking_add(5, id) != -1) {//check avaliable space
                        vehicle.add(new Car(id));
                    } else {
                        System.out.println("No available Space");
                    }
                }
                if ("Truck".equals(type)) {
                    if (parking_add(7, id) != -1) {
                        vehicle.add(new Truck(id));
                    } else {
                        System.out.println("No available Space");
                    }
                }
                if ("Bus".equals(type)) {
                    if (parking_add(10, id) != -1) {
                        vehicle.add(new Bus(id));
                    } else {
                        System.out.println("No available Space");
                    }
                }
                if ("Motorcycle".equals(type)) {
                    if (parking_add(2, id) != -1) {
                        vehicle.add(new Motorcycle(id));
                    } else {
                        System.out.println("No available Space");
                    }
                }
                //to remove a Vechile
                //***************************************
            } else if (inputnum == 2) {
                System.out.println("enter your ID");
                int id = input.nextInt();
                System.out.println("enter your time in hours ");
                double hours = input.nextDouble(), money = 0;
                for (int i = 0; i < vehicle.size(); i++) {
                    if (vehicle.get(i).getId() == id) {//seach in the array to get the type to calculate money
                        money = vehicle.get(i).calcMoney(hours);
                        vehicle.remove(i);//remove the vechile from the array
                        break;
                    }
                }
                System.out.println("the amount of money to pay is " + money);
                parking_remove(id);

            } else if (inputnum == 3) {
                show_parking_status();

            } else if (inputnum == 4) {
                break;
            }
        }
    }

    public static int menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("to add a vehicle enter 1");
        System.out.println("to remove a vehicle enter 2");
        System.out.println("to show parking status enter 3");
        System.out.println("to exit  enter 4");
        int x = input.nextInt();
        return x;
    }

    public static int parking_add(int length, int id) {
        boolean p;
        for (int i = 1; i <= 101 - length; i++) {
            p = true;
            for (int j = i; j < i + length; j++) {
                if (parking_area[j] != 0) {
                    p = false;
                }
            }
            if (p) {
                //if(p!=false)that means there is avalible space from position i with the specified length
                for (int j = i; j < i + length; j++) {
                    parking_area[j] = id;

                }
                return i;//return index to show there is avalible space
            }
        }

        return -1 ;//no avalible space
    }

    public static void parking_remove(int id) {
        for (int i = 1; i < 101; i++) {
            if (parking_area[i] == id) {
                //to remove :when you find the index replace it by 0 to indicate that it s now empty
                parking_area[i] = 0;
            }
        }
    }
    public static void show_parking_status(){
        int j,totalFreeSpace=0;
         for (int i = 1; i < 101; i++) {
           if(parking_area[i]==0){
               int c=0;
               //statrt from here and count zeros from now till the next non zero value
               for( j=i;j<101;j++){
                   if(parking_area[j]==0)c++;
                   else {
                       //when you find non zero print the availble space before it
                       totalFreeSpace+=c;
                       System.out.println(c);
                       i=j;
                       break;
                   }
               }
               if(j==101){
                  System.out.println(c);
                    totalFreeSpace+=c;
                   break;
               }
           }
            }
         System.out.println("total available space is "+ totalFreeSpace);
         int totalocuppiedspace=100-totalFreeSpace;
         System.out.println("total ocuppied space is "+totalocuppiedspace);
    }

}
