/// **************************************************************
// File Name: EXER1_FUNCTIONAL.java
// Author: Jason Salim
// Date: September 04 2025
// Deskripsyon: Nagpakita sa konsepto sa Functional Programming
//              sa Java gamit ang lambda ug Stream API.
// **************************************************************

import java.util.Arrays;              // Gigamit aron makahimo og lista
import java.util.List;                // Para sa List interface
import java.util.stream.Collectors;   // Para sa collect() nga method

public class Exer1_Functional {
    public static void main(String[] args) {
        // Koleksyon sa mga numero nga gihimo manually (user-defined)
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // Functional nga estilo:
        // Ipahayag lang unsa ang buhaton → pagpili sa mga even numbers ug i-square sila
        List<Integer> squaresOfEven = numbers.stream()
                .filter(n -> n % 2 == 0)       // pili-a ang mga numero nga even
                .map(n -> n * n)               // i-transform ngadto sa ilang square
                .collect(Collectors.toList()); // i-store sa usa ka bag-ong lista

        // Pag-print sa resulta
        System.out.println("Mga square sa even numbers (Functional): " + squaresOfEven);
    }
}

// ----------------------------
// SAMPLE OUTPUT
// ----------------------------
// Mga square sa even numbers (Functional): [4, 16, 36, 64, 100]
//
// GENERAL COMMENT:
// Ang functional approach mas dali basahon ug mubo isulat.
// Dili na magkinahanglan og detalye sa looping tungod kay 
// ang stream() na mismo ang nagdumala sa proseso.
// ----------------------------

