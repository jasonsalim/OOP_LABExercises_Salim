
// **************************************************************
// File Name: EXER1_IMPERATIVE.java
// Author: Jason S. SALIM
// Date: September 04 2025
// Deskripsyon: Nagpasabot sa paggamit sa Imperative Programming
//              sa Java gamit ang loop ug manual nga pamaagi.
// **************************************************************

import java.util.ArrayList; // Gigamit para makahimo og dynamic list
import java.util.List;      // Para sa List nga koleksyon

public class Exer1_Imperative {
    public static void main(String[] args) {
        // Paghimo og lista nga adunay numero gikan 1 hangtod 10
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);  // gi-dugang isa-isa ang mga numero
        }

        // Imperative nga paagi:
        // Sunod-sunod nga proseso sa pagpangita og even numbers
        List<Integer> evenNumbers = new ArrayList<>();
        for (int n : numbers) {
            if (n % 2 == 0) {
                evenNumbers.add(n);  // i-save kung even
            }
        }

        // Pagpakita sa resulta
        System.out.println("Mga even numbers (Imperative): " + evenNumbers);
    }
}

// ----------------------------
// SAMPLE OUTPUT
// ----------------------------
// Mga even numbers (Imperative): [2, 4, 6, 8, 10]
//
// GENERAL COMMENT:
// Ang imperative approach mas detalyado ug manual.
// Kinahanglan gyud gamiton ang loop ug kondisyon para makuha
// ang gusto nga resulta. Ang programmer mismo ang nagsulti 
// step-by-step unsay buhaton sa computer.
// ----------------------------