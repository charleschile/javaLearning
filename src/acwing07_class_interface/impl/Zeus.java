package acwing07_class_interface.impl;

import acwing07_class_interface.Hero;

class Zeus implements Hero {
    private final String name = "Zeus";
    public void attack() {
        System.out.println(name + ": Attack!");
    }

    public void greet() {
        System.out.println(name + ": Hi!");
    }

    public void move() {
        System.out.println(name + ": Move!");
    }

    public int getSpeed() {
        return 10;
    }

}