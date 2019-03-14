package hiredInTech;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BorderCover {

    public static int cover_the_border(int l, List<List<Integer>> radars) {
        // Example arguments:
        // l = 100
        // radars = [ [5, 10], [3, 25], [46, 99], [39, 40], [45, 50] ]
        // The `radars` list will çonsist of lists with two elements
        radars.sort((List<Integer> o1, List<Integer> o2) -> o1.get(0).compareTo(o2.get(0)));
        int covered = 0;
        int start = radars.get(0).get(0);
        int end = radars.get(0).get(1);
        covered = end - start;
        for (int i = 1; i < radars.size(); i++) {
            int s1 = radars.get(i).get(0);
            int e1 = radars.get(i).get(1);
            if (end < s1) {
                start = s1;
                end = e1;
                covered += (e1 - s1);
            } else if (end < e1) {
                covered += e1 - end;
                end = e1;
            }
            System.out.println("start = " + start + " end = " + end);
        }
        return covered;
    }

    public static void main(String args[]) {
        List<List<Integer>> radars = new ArrayList<>();
        List<Integer> radar = new ArrayList<>();
        radar.add(5);
        radar.add(10);
        radars.add(radar);

        radar = new ArrayList<>();
        radar.add(3);
        radar.add(25);
        radars.add(radar);

        radar = new ArrayList<>();
        radar.add(46);
        radar.add(99);
        radars.add(radar);

        radar = new ArrayList<>();
        radar.add(39);
        radar.add(40);
        radars.add(radar);

        radar = new ArrayList<>();
        radar.add(45);
        radar.add(50);
        radars.add(radar);

//        radars.sort(new Comparator<List<Integer>>() {
//            @Override
//            public int compare(List<Integer> o1, List<Integer> o2) {
//                return o1.get(0).compareTo(o2.get(0));
//            }
//        });




//        System.out.println("Sorted Radars : " + radars);

        System.out.println(cover_the_border(100, radars));

    }

}
