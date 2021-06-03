package com.specflare.algohut.algos.dynprog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateMaximumNumberTest {
    public void maxNumberTest() {
        Assertions.assertEquals(0, CreateMaximumNumber.compareNumbers(new int[] {9, 8, 6, 5, 3},
                CreateMaximumNumber.maxNumber(new int[] {3, 4, 6, 5}, new int[] {9, 1, 2, 5, 8, 3}, 5)
        ));

        Assertions.assertEquals(0, CreateMaximumNumber.compareNumbers(new int[] {6, 7, 6, 0, 4},
                CreateMaximumNumber.maxNumber(new int[] {6, 7}, new int[] {6, 0, 4}, 5)
        ));

        Assertions.assertEquals(0, CreateMaximumNumber.compareNumbers(new int[] {9, 8, 9},
                CreateMaximumNumber.maxNumber(new int[] {3, 9}, new int[] {8, 9}, 3)
        ));
    }
}