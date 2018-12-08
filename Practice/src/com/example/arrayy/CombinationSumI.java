package com.example.arrayy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.util.Util;

public class CombinationSumI {

	public static void main(String[] args) {
		int[] candidates = { 2, 3, 6, 7 };
		System.out.println(Util.print(new CombinationSumI().combinationSum(candidates, 7)));
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> res = new ArrayList<>();
		if (candidates == null || candidates.length == 0)
			return res;
		ArrayList<Integer> curr = new ArrayList<>();
		Arrays.sort(candidates);

		combinationSum(res, curr, candidates, target, 0);
		return res;

	}

	private void combinationSum(List<List<Integer>> res, ArrayList<Integer> curr, int[] candidates, int target, int i) {

		if (target == 0) {
			ArrayList<Integer> temp = new ArrayList<Integer>(curr);
			res.add(temp);
			return;
		} else {

			for (int j = i; j < candidates.length; j++) {
				if (candidates[j] > target)
					return;
				curr.add(candidates[j]);
				combinationSum(res, curr, candidates, target - candidates[j], j);
				curr.remove(curr.size() - 1);
			}
		}
	}

}
