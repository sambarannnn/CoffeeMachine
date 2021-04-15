package machine;

import java.util.*;
//import java.lang.Math;
public class CoffeeMachine {
    static Scanner s = new Scanner(System.in);
    static int revenue = 550;
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int dispcups = 9;
    static void calculate(int curr_water, int curr_milk, int curr_beans, int curr_price){
        if(water < curr_water) {
            System.out.println("Sorry, not enough water!");
        }
        else if(milk < curr_milk) {
            System.out.println("Sorry, not enough milk!");
        }
        else if(beans < curr_beans) {
            System.out.println("Sorry, not enough coffee!");
        }
        else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= curr_water;
            milk -= curr_milk;
            beans -= curr_beans;
            dispcups--;
            revenue += curr_price;
        }
    }
    static void buy() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String q = s.nextLine();
        if(q.equals("back")) {
            return;
        }
        else
        {
            int query = Integer.parseInt(q);
            if(query==1) {
                //esspresso
                int curr_water = 250;
                int curr_milk = 0;
                int curr_beans = 16;
                int curr_price = 4;
                calculate(curr_water, curr_milk, curr_beans, curr_price);

            }
            else if(query==2) {
                //latte
                int curr_water = 350;
                int curr_milk = 75;
                int curr_beans = 20;
                int curr_price = 7;
                calculate(curr_water, curr_milk, curr_beans, curr_price);
            }
            else if(query==3) {
                //cappuccino
                int curr_water = 200;
                int curr_milk = 100;
                int curr_beans = 12;
                int curr_price = 6;
                calculate(curr_water, curr_milk, curr_beans, curr_price);
            }
            else {
                System.out.println("Wrong input!");
            }
        }
        //System.out.println();
    }
    static void fill() {
        System.out.println("\nWrite how many ml of water do you want to add:");
        water += s.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += s.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += s.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        dispcups += s.nextInt();
        s.nextLine();
    }
    static void take() {
        System.out.println("\nI gave you $" + revenue);
        revenue = 0;
    }
    static void remaining(){
        System.out.printf("\nThe coffee machine has:\n" +
                "%d of water\n" +
                "%d of milk\n" +
                "%d of coffee beans\n" +
                "%d of disposable cups\n" +
                "$%d of money\n", water, milk, beans, dispcups, revenue);
    }
    public static void main(String[] args) {
        String query;
        int flag = 1;
        do {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            //s.nextLine();
            query = s.nextLine();
            //System.out.println("**"+query+"**");
            switch(query) {
                case "buy" :
                    buy();
                    break;
                case "fill" :
                    fill();
                    break;
                case "take" :
                    take();
                    break;
                case "remaining" :
                    remaining();
                    break;
                case "exit" :
                    flag = 0;
                    break;
                case "" :
                    System.out.println("SKIP");
                    break;
            }
        } while(flag==1);
    }
}