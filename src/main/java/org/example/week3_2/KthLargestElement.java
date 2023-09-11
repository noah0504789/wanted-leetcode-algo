package org.example.week3_2;

// 문제링크 : https://develop123.tistory.com/106
public class KthLargestElement {
    private int[] arr;
    private int n;

    public int findKthLargest(int[] nums, int k) {
        arr = new int[nums.length];
        n = 0;

        for (int i = 0; i < nums.length; i++) {
            push(nums[i]);
        }

        int top = 0;
        while (k > 0) {
            top = pop();
            k -= 1;
        }

        return top;
    }

    public void push(int i) {
        arr[n++] = i;

        bubbleUp(n-1);
    }

    public int pop() {
        int top = arr[0];
        arr[0] = arr[n-1];
        n--;
        bubbleDown(0);

        System.out.println(top);

        return top;
    }

    private void bubbleUp(int i) {
        if (i <= 0) {
            return;
        }

        int parentIdx = (i-1)/2;
        if (arr[i] > arr[parentIdx]) {
            int tmp = arr[i];
            arr[i] = arr[parentIdx];
            arr[parentIdx] = tmp;
            bubbleUp(parentIdx);
        }
    }

    private void bubbleDown(int i) {
        int child = i*2+1;
        int rightChild = i*2+2;

        if (child <= n-1) {
            if (rightChild <= n-1 && arr[rightChild] > arr[child]) {
                child = rightChild;
            }

            if (arr[child] > arr[i]) {
                int tmp = arr[i];
                arr[i] = arr[child];
                arr[child] = tmp;
                bubbleDown(child);
            }
    }
}
}
