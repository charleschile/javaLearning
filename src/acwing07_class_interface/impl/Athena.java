package acwing07_class_interface.impl;

import acwing07_class_interface.Hero;

class Athena implements Hero {
    private final String name = "Athena";
    public void attack() {
        System.out.println(name + ": Attack!!!");
    }

    public void greet() {
        System.out.println(name + ": Hi!!!");
    }

    public void move() {
        System.out.println(name + ": Move!!!");
    }

    public int getSpeed() {
        return 10;
    }

}

class Main {
    public static void main(String[] args) {
        Hero[] heros = {new Zeus(), new Athena()};
        for (Hero hero : heros) {
            hero.greet();
        }
    }
}

