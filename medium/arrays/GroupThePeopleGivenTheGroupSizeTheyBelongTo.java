package medium.arrays;

import java.util.*;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    public static void main(String[] args) {
        int[] groupSize = {3, 3, 3, 3, 3, 1, 3};

        System.out.println(groupThePeople(groupSize));
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> groupsMap = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            if (!groupsMap.containsKey(size)) {
                groupsMap.put(size, new ArrayList<>());
            }

            groupsMap.get(size).add(i);

            if (groupsMap.get(size).size() == size) {
                result.add(groupsMap.get(size));
                groupsMap.remove(size);
            }
        }

        return result;
    }
}
