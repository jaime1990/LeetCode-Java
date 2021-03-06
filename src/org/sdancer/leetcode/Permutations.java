package org.sdancer.leetcode;
import java.util.*;
public class Permutations {
	public static ArrayList<ArrayList<Integer>> permute(int[] num){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		permute(path,0,num,res);
		return res;
	}
	/**
	 * 
	 * @param path contains the indexes 
	 * @param step number of elements in the list
	 * @param num 
	 * @param res
	 */
	private static void permute(ArrayList<Integer> path, int step, int[] num, ArrayList<ArrayList<Integer>> res){
		for(int i=0; i<num.length;i++){
			
			//check whether is already in the list
			boolean in = false;
			for(int j=0; j<path.size();j++){
				//check
				if(i==path.get(j)){
					in = true;
					break;
				}
			}
			if(in) continue;
			else{
				path.add(i);
				if(step == num.length - 1){
					res.add(buildPermutation(path,num));
				}
				else{
					permute(path,step+1,num,res);
				}
				//backtracing
				path.remove(path.get(path.size()-1));
			}
		}
	}
	
	public static ArrayList<Integer> buildPermutation(ArrayList<Integer> path, int[]num){
		ArrayList<Integer> perm = new ArrayList<Integer>();
		for(int i=0; i<path.size();i++){
			perm.add(num[path.get(i)]);
		}
		return perm;
	}
	public static void simpletest(){
		int[] num = new int[3];
		num[0] = 1;
		num[1] = 2;
		num[2] = 3;
		ArrayList<ArrayList<Integer>> res = permute(num);
		for(int i=0; i< res.size();i++){
			System.out.println(res.get(i).toString());
		}
	}
	public static void main(String[] args){
		simpletest();
	}
}
