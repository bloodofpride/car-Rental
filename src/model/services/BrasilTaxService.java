package model.services;

public class BrasilTaxService {

    public double tax(double amount){
        return amount <= 100 ? amount * 0.2 : amount * 0.15;
    }
}
