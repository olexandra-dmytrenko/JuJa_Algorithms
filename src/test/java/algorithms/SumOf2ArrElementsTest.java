package algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOf2ArrElementsTest {

    @Test
    void shouldReturnTrue_when2ndSolutions() {
        SumOf2ArrElements cut = new SumOf2ArrElements();
        int[] arr =new int[] {-1, 1, 2, 4, 4, 6, 8};
        int sum = 8;
        assertTrue(cut.ifSortedArrayContainsSumOf2NumbersEqualTo(arr, sum));
    }
    @Test
    void shouldReturnTrue_when2FirstWithNegative() {
        SumOf2ArrElements cut = new SumOf2ArrElements();
        int[] arr =new int[] {-1, 1, 2, 4, 4, 6, 9};
        int sum = 8;
        assertTrue(cut.ifSortedArrayContainsSumOf2NumbersEqualTo(arr, sum));
    }
    @Test
    void shouldReturnTrue_when2AtTheEnd() {
        SumOf2ArrElements cut = new SumOf2ArrElements();
        int[] arr =new int[] {1, 1, 2, 4, 4};
        int sum = 8;
        assertTrue(cut.ifSortedArrayContainsSumOf2NumbersEqualTo(arr, sum));
    }
    @Test
    void shouldReturnTrue_when2InTheBeginning() {
        SumOf2ArrElements cut = new SumOf2ArrElements();
        int[] arr =new int[] {2, 6, 8, 10, 12};
        int sum = 8;
        assertTrue(cut.ifSortedArrayContainsSumOf2NumbersEqualTo(arr, sum));
    }
@Test
    void shouldReturnFalse_whenNoSolutions() {
        SumOf2ArrElements cut = new SumOf2ArrElements();
        int[] arr =new int[] {-2, 2, 3, 4};
        int sum = 8;
        assertFalse(cut.ifSortedArrayContainsSumOf2NumbersEqualTo(arr, sum));
    }
}