/*
Your task is given N to return the sorted lexicographically list of file names. N is in the range [1, 1,000,000].
In 40% of the test cases N will be no higher than 1,000. If N if higher than 1,000 return just the first 1,000
file names.
 */

package hiredInTech;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SortFiles {

    public static void sort_the_files(int n, List<String> result) {

        PriorityQueue<String> pq = new PriorityQueue<>();
        String name = "";
        for (int i = 1; i <= n; i++) {
            pq.add("IMG"+i+".jpg");
        }

        int len = pq.size() > 1000 ? 1000 : pq.size();
        for (int i = 0; i < len; i++) {
            result.add(pq.remove());
        }
    }

    public static void main(String[] args) {
        int len = 16;
        List<String> list = new ArrayList<>();
        sort_the_files(len, list);
        System.out.println(list);
    }

}
