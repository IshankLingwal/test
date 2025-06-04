import java.util.ArrayList;
import java.util.List;

public class AlternateListMerger {

    public static List<Integer> alternate(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();

        int size1 = list1.size();
        int size2 = list2.size();
        int minSize = Math.min(size1, size2);

        // Add alternating elements from both lists
        for (int i = 0; i < minSize; i++) {
            result.add(list1.get(i));
            result.add(list2.get(i));
        }

        // Add remaining elements from the longer list
        if (size1 > size2) {
            result.addAll(list1.subList(minSize, size1));
        } else if (size2 > size1) {
            result.addAll(list2.subList(minSize, size2));
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> list2 = List.of(6, 7, 8, 9, 10, 11, 12);

        List<Integer> result = alternate(list1, list2);

        System.out.println("Alternate merged list: " + result);
    }
}
