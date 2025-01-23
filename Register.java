package LabOne;

import java.util.Arrays;
import java.util.List;

public class Register {
    private static final List<Denomination> denominations = Arrays.asList(
            new Denomination("Hundred Bill", 100.0, "bill", "hundred.jpg"),
            new Denomination("Fifty Bill", 50.0, "bill", "fifty.jpg"),
            new Denomination("Twenty Bill", 20.0, "bill", "twenty.jpg"),
            new Denomination("Ten Bill", 10.0, "bill", "ten.jpg"),
            new Denomination("Five Bill", 5.0, "bill", "five.jpg"),
            new Denomination("One Bill", 1.0, "bill", "one.jpg"),
            new Denomination("Quarter", 0.25, "coin", "quarter.jpg"),
            new Denomination("Dime", 0.10, "coin", "dime.jpg"),
            new Denomination("Nickel", 0.05, "coin", "nickel.jpg"),
            new Denomination("Penny", 0.01, "coin", "penny.jpg")
    );

    public Purse makeChange(double amt) {
        Purse purse = new Purse();
        for (Denomination denomination : denominations) {
            int count = (int) (amt / denomination.amt);
            if (count > 0) {
                purse.add(denomination, count);
                amt -= count * denomination.amt;
            }
        }
        return purse;
    }

    public static void main(String[] args) {
        Register register = new Register();
        Purse purse = register.makeChange(187.41);  // Example: 187.41 should return the appropriate change
        System.out.println(purse);
    }
}
