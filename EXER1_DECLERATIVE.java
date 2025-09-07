// **************************************************************
// File Name: EXER1_DECLARATIVE.java
// Author: Jason S. Salim
// Date: September 04 2025
// Deskripsyon: Nagpakita sa Declarative Programming sa Java
//              gamit ang stream() ug kondisyon.
// **************************************************************

import java.util.Arrays;  // Para makahimo og fixed list
import java.util.List;    // Para sa List nga koleksyon

public class Exer1_Declarative {
    public static void main(String[] args) {
        // Koleksyon sa mga pangalan
        List<String> names = Arrays.asList("Cyril", "Jason", "Antonio", "Rever", "Oliver");

        // Declarative nga pamaagi:
        // "Unsay gusto nato makuha?" → tan-awon kung naa bay pangalan nga ≤ 3 ka karakter
        boolean hasShortName = names.stream().anyMatch(name -> name.length() <= 3);

        // Pagpakita sa resulta
        System.out.println("Naa bay pangalan nga mubo (<=3 chars)? " + hasShortName);
    }
}

// ----------------------------
// SAMPLE OUTPUT
// ----------------------------
// Naa bay pangalan nga mubo (<=3 chars)? false
//
// GENERAL COMMENT:
// Ang declarative nga pamaagi nag-focus sa *unsa ang tumong*
// ug dili sa paagi sa pag-loop. 
// Ang stream().anyMatch() awtomatik nga mo-traverse sa tanang elemento.
// ----------------------------
