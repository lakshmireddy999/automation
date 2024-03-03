//Implement the findMaxSum method that efficiently with respect to time used, returns the largest sum of any two elements in the given list of positive numbers
//      For example, the largest sum of the list { 5, 9, 7, 11 } is the sum of the elements 9 and 11, which is 20.
//

package com.example;

import java.util.List;

import java.util.Arrays;

public class MaxSum {

    public static int findMaxSum(List<Integer> list) {
        int largest = 0;
        int secondLargest = 0;
        if(list.size()<2)
        {
            return list.get(0);
        }
            
        for (int i = 0; i < list.size(); i++) {
            if (largest < list.get(i)) {
                secondLargest = largest;
                largest = list.get(i);
            }
            else if (secondLargest < list.get(i)) {
                secondLargest = list.get(i);
            }

        }
        return (largest + secondLargest);
    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5);
        int ans;
        try
        {
            ans=findMaxSum(list);
        }
        catch (ArrayIndexOutOfBoundsException exception)
        {
            System.out.println("Index out of found");
        }


    }

}