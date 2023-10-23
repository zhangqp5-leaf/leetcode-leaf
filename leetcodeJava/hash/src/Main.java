import java.util.*;

public class Main {
    public static void main(String[] args) {
        firstSubject();
        subject49();
        subject128();
    }

    public static void subject128() {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> numSet = new HashSet<>();

        int re = 1;
        for (int num : nums) {
            numSet.add(num);
        }
        for (int num : numSet) {
            if (!numSet.contains(num + 1)) {
                int currentRe = 1;
                int currentNum = num - 1;
                while(numSet.contains(currentNum)) {
                    currentRe += 1;
                    currentNum -= 1;
                }

                re = Math.max(re, currentRe);
            }
        }

        return re;
    }

    public static void subject49() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> _map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String sortedStr = getSortRe(strs[i]);
            List<String> _list = _map.getOrDefault(sortedStr, new ArrayList<>());
            _list.add(strs[i]);
            _map.put(sortedStr, _list);
        }
        return new ArrayList<List<String>>(_map.values());
    }

    private static String getSortRe(String str) {
        char[] array = str.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

    public static void firstSubject() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] re = twoSum(nums, target);
        for (int i = 0; i < re.length; i++) {
            System.out.println(re[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> _hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (_hashMap.get(nums[i]) == null) {
                _hashMap.put(target - nums[i], i);
            } else {
                System.out.println("sa" + i);
                return new int[]{i, _hashMap.get(nums[i])};
            }
        }
        return new int[]{0, 0};
    }
}