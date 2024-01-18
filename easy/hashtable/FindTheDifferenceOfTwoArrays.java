package easy.hashtable;

import java.util.*;

public class FindTheDifferenceOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,3};
        int[] nums2 = {1,1,2,2};

        System.out.println(findDifference2(nums1, nums2));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new Hashtable<>();

        for (int i : nums1) {
            map.put(i, 1);
        }

        for (int j = 0; j < nums2.length; j++) {
            if (map.containsKey(nums2[j]) ) {
                map.put(nums2[j], -1);
            } else {
                map.put(nums2[j], 0);
            }
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (var obj : map.entrySet()) {
            if (obj.getValue() == 1) {
                list1.add(obj.getKey());
            }

            if (obj.getValue() == 0) {
                list2.add(obj.getKey());
            }
        }


        List<List<Integer>> answer = new ArrayList<>();
        answer.add(list1);
        answer.add(list2);

        return answer;
    }

    // using sets
    public static List<List<Integer>> findDifference2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }

        Set<Integer> diffSet1 = new HashSet<>(set1);
        diffSet1.removeAll(set2);

        Set<Integer> diffSet2 = new HashSet<>(set2);
        diffSet2.removeAll(set1);

        List<Integer> list1 = new ArrayList<>(diffSet1);
        List<Integer> list2 = new ArrayList<>(diffSet2);

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(list1);
        answer.add(list2);

        return answer;
    }
}
