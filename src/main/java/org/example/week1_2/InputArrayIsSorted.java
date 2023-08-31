package org.example.week1_2;

public class InputArrayIsSorted {
    public static void main(String[] args) {
        int[] numbers = new int[]{2,7,11,15};
        int target = 9;

        myTwoSum(numbers, target);
    }

    public static int[] myTwoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                break;

            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{left+1, right+1};
    }
}
