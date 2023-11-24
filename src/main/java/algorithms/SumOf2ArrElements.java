package algorithms;

import java.util.HashSet;
import java.util.Set;

public class SumOf2ArrElements {
    public boolean ifNotSortedArrayContainsSumOf2NumbersEqualTo(int[] arr, int sum) {
        //[1, 4,2, 5,1, 8, 4, 2, 3]
        int length = arr.length;
        int cur = 0;
        Set<Integer> complementarySet = new HashSet<>();
        while (cur < length){
            int complementary = sum - arr[cur];
            if (complementarySet.contains(arr[cur])){
                return true;
            }
            else {
                complementarySet.add(complementary);
                cur ++;
            }
        }
        return false;
    }

    public boolean ifSortedArrayContainsSumOf2NumbersEqualTo(int[] arr, int sum) {
        boolean result = false;
        int length = arr.length;

        int upInd = length - 1;
        int downInd = 0;
        while (upInd > downInd) {
            int curSum = arr[upInd] + arr[downInd];
            if (curSum == sum) {
                return true;
            }
            if (curSum > sum) {
                upInd--;
            }
            if (curSum < sum) {
                downInd++;
            }
        }
        return result;
    }
}
