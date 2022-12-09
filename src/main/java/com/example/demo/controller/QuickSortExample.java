package com.example.demo.controller;

import java.util.Arrays;

public class QuickSortExample {
    public static void main(String[] args) {
        // 要排序的数组
        int[] numbers = {10, 20, 15, 0, 6, 7, 2, 1, -5, 55};

        // 调用快速排序方法
        quickSort (numbers, 0, numbers.length - 1);

        // 打印排序后的数组
        System.out.println (Arrays.toString (numbers));
    }

    // 快速排序方法
    public static void quickSort(int[] arr, int low, int high) {
        // 如果数组长度为0或1，无需排序
        if (arr == null || arr.length <= 1) {
            return;
        }

        // 如果low等于high，说明数组只有一个元素，无需排序
        if (low >= high) {
            return;
        }

        // 获取枢纽元素，并将其放到当前待处理序列末尾
        int pivot = arr[low];
        int i = low, j = high;
        while (i < j) {
            // 从右向左遍历，找到第一个比枢纽元素小的数
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            // 如果没有找到比枢纽元素小的数，就将枢纽元素放到i的位置
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }

            // 从左向右遍历，找到第一个比枢纽元素大的数
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            // 如果没有找到比枢纽元素大的数，就将枢纽元素放到j的位置
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
    }
}
