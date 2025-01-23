package LabOne;

import java.util.HashMap;
import java.util.Map;

public class Purse {
    private final Map<Denomination, Integer> cash = new HashMap<>();

    public void add(Denomination type, int num) {
        cash.put(type, cash.getOrDefault(type, 0) + num);
    }

    public double remove(Denomination type, int num) {
        if (cash.containsKey(type) && cash.get(type) >= num) {
            cash.put(type, cash.get(type) - num);
            return type.amt * num;
        }
        return 0;
    }

    public double getValue() {
        return cash.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().amt * entry.getValue())
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        cash.forEach((denomination, quantity) -> {
            result.append(denomination.name())
                    .append(": ")
                    .append(quantity)
                    .append("\n");
        });
        return result.toString();
    }
}

