/*
 * 
Given a list of N integers find the longest increasing subsequence in this list.

Example
If the list is [16, 3, 5, 19, 10, 14, 12, 0, 15] one possible answer is the subsequence [3, 5, 10, 12, 15], 
another is [3, 5, 10, 14, 15].

If the list has only one integer, for example: [14], the correct answer is [14].

One more example: [10, 8, 6, 4, 2, 0], a possible correct answer is [8].
 */

package hiredInTech;

import java.util.*;

public class LongestIncreasingSubsequence {

//    public static List<Integer> longest_increasing_subsequence_old(List<Integer> sequence) {
//        if (sequence.size() == 1) {
//            return sequence;
//        }
//
//        Map<Integer, List<Integer>> aux = new HashMap<>();
//
//        for (int seq = 0; seq < sequence.size(); seq++) {
//            List<Integer> l = new ArrayList<>();
//            l.add(sequence.get(seq));
//            aux.put(seq, l);
//        }
//
//        int max = 0;
//        int index = 0;
//        for (int i = 1; i < sequence.size(); i++) {
//            List<Integer> list = aux.get(i);
//            for (int j = 0; j < i; j++) {
//                if ((sequence.get(j) < sequence.get(i)) && (aux.get(j).size() + 1 > list.size())) {
//                    List<Integer> auxList = aux.get(j);
//                    int num = list.get(list.size() - 1);
//                    list.clear();
//                    list.addAll(auxList);
//                    list.add(num);
//                    aux.put(i, list);
//                }
//            }
//            if (list.size() > max) {
//                max = list.size();
//                index = i;
//            }
//        }
//        return aux.get(index);
//    }

    public static List<Integer> longest_increasing_subsequence(List<Integer> sequence) {
        if (sequence.size() == 1) {
            return sequence;
        }
        Map<Integer, List<Integer>> aux = new HashMap<>();
        List<Integer> first = new ArrayList<>();
        first.add(sequence.get(0));
        aux.put(0, first);
        int max = 0;
        int index = 0;
        List<Integer> list = null;
        List<Integer> auxList = null;
        for (int i = 1; i < sequence.size(); i++) {
            list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                auxList = aux.get(j);
                if ((sequence.get(j) < sequence.get(i)) && (aux.get(j).size()  > list.size())) {
                   list.clear();
                   list.addAll(auxList);
                }
            }
            list.add(sequence.get(i));
            aux.put(i, list);
            if (list.size() > max) {
                max = list.size();
                index = i;
            }
        }
        return aux.get(index);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{16, 3, 5, 19, 10, 14, 12, 0, 15};
        System.out.println(longest_increasing_subsequence(Arrays.asList(arr)));
    }

}
