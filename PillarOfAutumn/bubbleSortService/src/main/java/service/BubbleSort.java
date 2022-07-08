package service;


import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

// Annotation
@Component
@NoArgsConstructor
public class BubbleSort {

    // Method
    public List<Integer> sort(List<Integer> listOfNums)
    {

        for (int i = 0; i < listOfNums.size() - 1; i++)
            for (int j = 0; j < listOfNums.size() - i - 1; j++)
                if (listOfNums.get(j) > listOfNums.get(j + 1)) {
                    // swap arr[j+1] and arr[j]
                    int temp = listOfNums.get(j);
                    listOfNums.set(j, listOfNums.get(j + 1));
                    listOfNums.set(j + 1, temp);
                }

        return listOfNums;





    }
}
