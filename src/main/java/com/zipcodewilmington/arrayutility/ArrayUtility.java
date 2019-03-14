package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<E> {

    E[] inputArray;
    E[] arrayToMerge;

    public ArrayUtility(E[] inputArray)
    {
    this.inputArray = inputArray;
    }

    public Integer countDuplicatesInMerge(E[] arrayToMerge, E valueToEvaluate) {

        Integer count=0;
        E[] mergeArray = Arrays.copyOf(inputArray, inputArray.length + arrayToMerge.length);
        int len1=inputArray.length;

        int len2 = arrayToMerge.length;
        for(int i = 0; i <len2; i++) {
            mergeArray[len1++] = arrayToMerge[i];
        }
        for(E i: mergeArray)
        {
            if(valueToEvaluate.equals(i))
                count++;
        }

        return count;
    }

    public E[] removeValue(E valueToRemove) {


        List<E> inputList = new ArrayList<E>();
            inputList.addAll(Arrays.asList(inputArray));

        for(int i=0; i<inputList.size();i++)

        {
                if (inputList.get(i).equals(valueToRemove)) {
                    inputList.remove(valueToRemove);
                }
            }

        E[] newArr = (E[]) Array.newInstance(inputArray.getClass().getComponentType(),
                inputList.size());
       inputList.toArray(newArr);

        return inputList.toArray(newArr);
    }


    public E getMostCommonFromMerge(E[] arrayToMerge) {

        Integer count=0;
        E popular=null;
        E[] mergeArray = Arrays.copyOf(inputArray, inputArray.length + arrayToMerge.length);
        int len1=inputArray.length;
        int len2 = arrayToMerge.length;
        for(int i = 0; i <len2; i++) {
            mergeArray[len1++] = arrayToMerge[i];
        }
        E temp = null;
        int tempCount;
        for (int i = 0; i < (mergeArray.length - 1); i++)
        {
            temp = mergeArray[i];
            tempCount = 0;
            for (int j = 1; j < mergeArray.length; j++)
            {
                if (temp == mergeArray[j])
                    tempCount++;
            }
            if (tempCount > count)
            {
                popular = temp;
                count = tempCount;
            }
        }
        return popular;

    }

    public Integer getNumberOfOccurrences(E valueToEvaluate) {
        Integer count=0;
        for(int i=0;i<inputArray.length;i++)
        {
            if(inputArray[i]==valueToEvaluate)
                count++;
        }
        System.out.println(count);
        return count;
    }
}
