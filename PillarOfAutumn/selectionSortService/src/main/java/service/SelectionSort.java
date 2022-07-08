package service;


import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

// Annotation
@Component
@NoArgsConstructor
public class SelectionSort {

    // Method
    public List<Integer> sort(List<Integer> listOfNums)
    {


        for (int i = 0; i < listOfNums.size()-1; i++)
        {
            // Find the minimum element in unsorted array
            int min = i;
            for (int j = i+1; j < listOfNums.size(); j++)
                if (listOfNums.get(j) < listOfNums.get(min))
                    min = j;

            // Swap the found minimum element with the first
            // element
            int temp = listOfNums.get(min);
            listOfNums.set(min, listOfNums.get(i));
            listOfNums.set(i, listOfNums.get(temp));
        }
        return listOfNums;





    }
}
