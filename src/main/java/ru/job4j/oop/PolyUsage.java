package ru.job4j.oop;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle an2 = new Plane();
        Vehicle il76 = new Plane();
        Vehicle sukhojSuperJet = new Plane();
        Vehicle siemensES64U4 = new Train();
        Vehicle emdSD40 = new Train();
        Vehicle tornado = new Train();
        Vehicle icarus = new Bus();
        Vehicle liaz = new Bus();
        Vehicle paz = new Bus();
        Vehicle[] vehicles = new Vehicle[] {
                an2, il76, sukhojSuperJet, siemensES64U4, emdSD40, tornado, icarus, liaz, paz};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}
