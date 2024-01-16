package easy.hashtable;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public int start2(String s) {
        if (s == null || s.isEmpty() || s.length() > 15) {
            throw new IllegalArgumentException("Invalid input: Roman numeral length must be between 1 and 15 characters.");
        }

        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char currentSymbol = s.charAt(i);
            int currentValue = romanMap.get(currentSymbol);

            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            prevValue = currentValue;
        }

        System.out.println("Result for roman numeral `" + s + "` is: " + result);
        return result;
    }

    public int start(String romanNumerals) {
        if (romanNumerals.length() < 1
                || romanNumerals.length() > 15) {
            return 0;
        }

        String[] parts = romanNumerals.split("");
        int sum = 0;
        for (int i = 0; i < parts.length; i++) {
            for (int j = i + 1; j < parts.length; j++) {
                if (parts[j].equals("V") && parts[i].equals("I")) {
                    sum += 4;
                    i += 2; // jump over j position
                    continue;
                }

                if (parts[j].equals("X") && parts[i].equals("I")) {
                    sum += 9;
                    i += 2; // jump over j position
                    continue;
                }

                if (parts[j].equals("L") && parts[i].equals("X")) {
                    sum += 40;
                    i += 2; // jump over j position
                    continue;
                }

                if (parts[j].equals("C") && parts[i].equals("X")) {
                    sum += 90;
                    i += 2; // jump over j position
                    continue;
                }

                if (parts[j].equals("D") && parts[i].equals("C")) {
                    sum += 400;
                    i += 2; // jump over j position
                    continue;
                }

                if (parts[j].equals("M") && parts[i].equals("C")) {
                    sum += 900;
                    i += 2; // jump over j position
                }
            }

            if (i < parts.length) {
                switch (parts[i]) {
                    case "I" -> sum += 1;
                    case "V" -> sum += 5;
                    case "X" -> sum += 10;
                    case "L" -> sum += 50;
                    case "C" -> sum += 100;
                    case "D" -> sum += 500;
                    case "M" -> sum += 1000;
                }
            }
        }

        return sum;
    }
}