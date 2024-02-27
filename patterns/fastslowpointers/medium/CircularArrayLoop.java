package patterns.fastslowpointers.medium;

public class CircularArrayLoop {
    public static void main(String[] args) {
        int[] nums = {-2,-3,-9};

        System.out.println(circularArrayLoop(nums));
    }

    public static boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                continue;

            int slow = i;
            int fast = getNextIndex(i, nums);

            while (nums[fast] * nums[i] > 0 && nums[getNextIndex(fast, nums)] * nums[i] > 0) {
                if (slow == fast) {
                    if (slow == getNextIndex(slow, nums))
                        break;
                    return true;
                }
                slow = getNextIndex(slow, nums);
                fast = getNextIndex(getNextIndex(fast, nums), nums);
            }

            slow = i;
            int val = nums[i];
            while (nums[slow] * val > 0) {
                int next = getNextIndex(slow, nums);
                nums[slow] = 0;
                slow = next;
            }
        }

        return false;
    }

    private static int getNextIndex(int current, int[] nums) {
        int n = nums.length;
        int nextIndex = (current + nums[current]) % n;
        if (nextIndex < 0)
            nextIndex += n;
        return nextIndex;
    }
}
