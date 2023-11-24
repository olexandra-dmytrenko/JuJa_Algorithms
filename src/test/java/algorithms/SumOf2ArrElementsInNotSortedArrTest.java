package algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SumOf2ArrElementsInNotSortedArrTest {

    @Test
    void shouldReturnTrue_when2ndSolutions() {
        SumOf2ArrElements cut = new SumOf2ArrElements();
        int[] arr =new int[] {-1, 1, 2, 4, 4, 6, 8};
        int sum = 8;
        assertTrue(cut.ifNotSortedArrayContainsSumOf2NumbersEqualTo(arr, sum));
    }
    @Test
    void shouldReturnTrue_when2FirstWithNegative() {
        SumOf2ArrElements cut = new SumOf2ArrElements();
        int[] arr =new int[] {-1, 1, 20, 4, 4, 6, 9};
        int sum = 0;
        assertTrue(cut.ifNotSortedArrayContainsSumOf2NumbersEqualTo(arr, sum));
    }
    @Test
    void shouldReturnTrue_when2AtTheEnd() {
        SumOf2ArrElements cut = new SumOf2ArrElements();
        int[] arr =new int[] {12, 8, 2, 3, 5};
        int sum = 8;
        assertTrue(cut.ifNotSortedArrayContainsSumOf2NumbersEqualTo(arr, sum));
    }
    @Test
    void shouldReturnTrue_when2SameNegative() {
        SumOf2ArrElements cut = new SumOf2ArrElements();
        int[] arr =new int[] {-20, -20, 8, 10, 12};
        int sum = -40;
        assertTrue(cut.ifNotSortedArrayContainsSumOf2NumbersEqualTo(arr, sum));
    }
@Test
    void shouldReturnFalse_whenNoSolutions() {
        SumOf2ArrElements cut = new SumOf2ArrElements();
        int[] arr =new int[] {-2, 4, 2, 3, -4};
        int sum = 8;
        assertFalse(cut.ifNotSortedArrayContainsSumOf2NumbersEqualTo(arr, sum));
    }
}