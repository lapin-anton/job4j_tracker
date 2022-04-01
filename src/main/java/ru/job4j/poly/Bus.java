package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("The bus is moving...");
    }

    @Override
    public void passengers(int amount) {
        System.out.printf("%s passengers got on the bus.%n", amount);
    }

    @Override
    public double refuel(int fuel) {
        double pricePerLiter = 50.00;
        return pricePerLiter * fuel;
    }
}
