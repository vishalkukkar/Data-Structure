package BankAccounts;

public class Run {

	int num = 100;

	public void calc(int num) {
		this.num = num * 10;
	}
	
	public int getNum(){
		return this.num;
	}

	public void printNum() {
		System.out.println(num);
	}

	public static void main(String[] args) {
		Run obj = new Run();
		obj.calc(2);
		obj.printNum();
		
		obj.getNum();
	}
	
	
}

/***
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * 
 * Input: [ [1,3,1], [1,5,1], [4,2,1] ] Output: 7 Explanation: Because the path
 * 1→3→1→1→1 minimizes the sum.
 */
/*
 * public class Run {
 * 
 * public static void main(String[] args) {
 * 
 * int[] nums = { 0, 2, 1, -3 }; List<String> list = Arrays.asList("leet",
 * "code"); int[] array = { 5, 4, 3, 2, 1 };
 * 
 * int[][] matrix = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
 * System.out.println(new Run().minPathSum(matrix));
 * 
 * }
 * 
 * int max = 0;
 * 
 * public int minPathSum(int[][] grid) {
 * 
 * if (grid == null || grid.length == 0) return 0; int[][] memo = new
 * int[grid.length][grid[0].length];
 * 
 * for (int i = 0; i < memo.length; i++) { Arrays.fill(memo[i],
 * Integer.MAX_VALUE); }
 * 
 * return findMinPathSum(grid, 0, 0, memo);
 * 
 * }
 * 
 * private int findMinPathSum(int[][] grid, int i, int j, int[][] memo) {
 * 
 * if (i >= grid.length || j >= grid[0].length) return Integer.MAX_VALUE; else
 * if (memo[i][j] != Integer.MAX_VALUE) return memo[i][j]; else if (i ==
 * grid.length - 1 && j == grid[0].length - 1) return grid[i][j]; else
 * memo[i][j] = grid[i][j] + Math.min(findMinPathSum(grid, i + 1, j, memo),
 * findMinPathSum(grid, i, j + 1, memo));
 * 
 * return memo[i][j];
 * 
 * }
 * 
 * public int findMaxProduct(int[] array) {
 * 
 * if (array == null || array.length == 0) return 0;
 * 
 * int max = array[0]; int secMax = 0;
 * 
 * for (int i = 1; i < array.length; i++) {
 * 
 * if (array[i] >= max) {
 * 
 * secMax = max; max = array[i]; } else if (array[i] > secMax) { secMax =
 * array[i]; } } return max * secMax; }
 * 
 * public int divide(int d1, int d2) {
 * 
 * Long dividend = new Long(d1); Long divisor = new Long(d2);
 * 
 * if (dividend == 0) return 0; if (divisor == 0) return 0;
 * 
 * long count = 0; int sum = 0; int temp = 0;
 * 
 * boolean isNeg = false;
 * 
 * if (dividend < 0 || divisor < 0) isNeg = true;
 * 
 * if (dividend < 0 && divisor < 0) isNeg = false;
 * 
 * dividend = Math.abs(dividend); divisor = Math.abs(divisor);
 * 
 * if (dividend == divisor) return isNeg ? -1 : 1;
 * 
 * while (temp < dividend) {
 * 
 * System.out.println(temp); temp += divisor; count++;
 * 
 * }
 * 
 * if (count > Integer.MAX_VALUE) return Integer.MAX_VALUE;
 * 
 * return Math.toIntExact(isNeg ? -1 * (count - 1) : count - 1); }
 * 
 * public boolean wordBreak(String s, List<String> wordDict) {
 * 
 * if (s == null || s.length() == 0) return false;
 * 
 * for (String str : wordDict) {
 * 
 * if (str == null) continue;
 * 
 * if (s.indexOf(str) != -1) {
 * 
 * s = s.replaceAll(str, "");
 * 
 * if (s.length() == 0) return true; } }
 * 
 * return false; }
 * 
 * public static int threeSumClosest(int[] nums, int target) {
 * 
 * if (nums == null || nums.length == 0) return 0;
 * 
 * Arrays.sort(nums); int minSum = Integer.MAX_VALUE; int minCount =
 * Integer.MAX_VALUE; int i = 0, j = 0, k = 0; int sum = 0;
 * 
 * for (i = 0; i < nums.length; i++) {
 * 
 * j = i + 1; k = nums.length - 1;
 * 
 * while (j < k) {
 * 
 * sum = nums[i] + nums[j] + nums[k];
 * 
 * System.out.println(sum); if (sum == target) return target; else if (sum < 0
 * && target < 0) { int temp = Math.abs(Math.abs(sum) - target); if (temp <
 * minCount) { minSum = sum; minCount = temp; } } else if (sum < 0 || target <
 * 0) { int temp = 0; if (target < 0) { temp = Math.abs(target) + sum; } else {
 * temp = Math.abs(sum) + target; }
 * 
 * if (temp < minCount) { minSum = sum; minCount = temp; } } else { int temp =
 * Math.abs(sum - target); if (temp < minCount) { minSum = sum; minCount = temp;
 * } }
 * 
 * j++; k--; } }
 * 
 * return minSum; }
 * 
 * public static HashMap<Integer, Integer> sortByValue(Map<Integer, Integer> hm)
 * { List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer,
 * Integer>>(hm.entrySet());
 * 
 * Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() { public
 * int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
 * return (o1.getValue()).compareTo(o2.getValue()); } });
 * 
 * HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>(); for
 * (Map.Entry<Integer, Integer> aa : list) { temp.put(aa.getKey(),
 * aa.getValue()); } return temp; }
 * 
 * }
 * 
 *//***
	 * ListNode l1 = new ListNode(1); l1.next = new ListNode(2); l1.next.next =
	 * new ListNode(3); l1.next.next.next = new ListNode(4);
	 * 
	 * ListNode l2 = new ListNode(1); l2.next = new ListNode(3); l2.next.next =
	 * new ListNode(4);
	 * 
	 * ListNode[] array = new ListNode[2]; array[0] = l1; array[1] = l2;
	 * 
	 * ListNode r = null; System.out.println(r); while (r != null) {
	 * System.out.println(r.val); r = r.next; }
	 * 
	 * 
	 *//*
	*/