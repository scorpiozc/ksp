package cn.com.bjjdsy.ksp;

import java.util.Arrays;

public class MyTest {

	public static void main(String[] args) {
		int[][] counts = new int[10][10];
		for (int[] a : counts) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println(counts[1][2]++);
		System.out.println(counts[1][2]);
	}

}
