import java.nio.file.LinkPermission;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> sortedList = new ArrayList<>();
        ArrayList<Integer> unsortedList;
        for(int i = -1000; i <= 1000; i++) {
            sortedList.add(i);
        }
        unsortedList = sortedList;
        Collections.shuffle(unsortedList);
        System.out.println("unsorted input:");
        System.out.println(unsortedList);
//        System.out.println("bubble sorted output:");
//        System.out.println(bubbleSort(unsortedList));
        System.out.println("selection sorted output:");
        System.out.println(selectionSort(unsortedList));
//        System.out.println("insertion sorted output:");
//        System.out.println(insertionSort(unsortedList));
//        System.out.println("super sorted output:");
//        System.out.println(superSort(sortedList));
//        System.out.println("miracle sorted output:");
//        System.out.println(miracleSort(unsortedList));
        System.out.println(isSorted(unsortedList));
    }


    //strategy: wait until cosmic ray interference edits the list to make it correct
    public static ArrayList<Integer> miracleSort(ArrayList<Integer> input) {
        while(!isSorted(input)) {}
        return input;
    }

    //strategy: swap elements incorrectly sorted and follows them to the front of the list
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> input) {
        for(int i = 0; i < input.size() - 1; i++)
        {
            int header = i;
            while(input.get(header) > input.get(header + 1))
            {
                input = swap(input, header, header + 1);
                if(header > 0)
                {
                    header--;
                }
            }
        }
        return input;
    }

    //strategy: swap elements incorrectly sorted and follows them to the back of the list
    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> input) {
        for(int i = 0; i < input.size() - 1; i++)
        {
            for(int header = 0;header < input.size() - 1;header++)
            {
                if(input.get(header) > input.get(header+1))
                {
                    input = swap(input, header, header+1);
                }
            }
        }
        return input;
    }


    //strategy: lie to the end user
    public static ArrayList<Integer> superSort (ArrayList<Integer> input)
    {
        return input;
    }

    //strategy: move the smallest element to the front
    public static ArrayList<Integer> selectionSort(ArrayList<Integer> input) {
        for(int i = 0; i < input.size() - 1; i++) {
            int minVal = input.get(i);
            int minInd = i;
            for(int j = i + 1;j < input.size(); j++) {
                if(input.get(j) < minVal) {
                    minVal = input.get(j);
                    minInd = j;
                }
            }
            if(i != minInd)
            {
                input = swap(input, i, minInd);
            }
        }
        return input;
    }

    public static ArrayList<Integer> swap(ArrayList<Integer> input, int i, int j)
    {
        int tmp = input.get(i);
        input.set(i, input.get(j));
        input.set(j, tmp);
        return input;
    }
    public static boolean isSorted(ArrayList<Integer> input) {
        boolean isSorted = true;
        for (int i = 0; i < input.size() - 1; i++) {
            if (input.get(i) > input.get(i + 1)) {
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }
}

