package day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3_ArrayCommon {

	public static void main(String[] args) {
		int a[] = {1,3,5,9};
		int b[] = {2,3,6,9,10};
		List<Integer> arr= solution(a,b);
		System.out.println(arr);
	}
	
	static List<Integer> solution(int[] a,int[] b){
		Arrays.sort(a);
		Arrays.sort(b);
		List<Integer> arr= new ArrayList<>();
		int p1=0,p2=0;
		while(p1<a.length && p2<b.length) {
			if(a[p1]==b[p2]) {
				arr.add(a[p1]);
				p1++;
				p2++;
			}else if(a[p1]<b[p2]) {
				p1++;
			}else {
				p2++;
			}
		}
		return arr;
	}

}
