package com.poly.lab1.app;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import com.poly.lab1.bean.*;

public class Lambda {
	static List<Student> list = Arrays.asList(new Student("Lâm Diễm Thúy", false, 10.0),
			new Student("Hồ Thị Vân Anh", true, 7.5), new Student("Mai Quốc Bảo", true, 8.0),
			new Student("Nguyễn Minh Thức", false, 9.0), new Student("Thái Hoàng An", false, 7.0),
			new Student("Công Tôn Sách", true, 9.5));

	public static void main(String[] args) {
		// demo1();
		// demo2();
		// demo3();
		demo4();
	}

	private static void demo1() {
		List<Integer> list = Arrays.asList(1, 9, 4, 5, 2);
		list.forEach(n -> System.out.println(n));
	}

	private static void demo2() {
		List<Student> list = Arrays.asList(new Student("Lâm Diễm Thúy", false, 10.0),
				new Student("Hồ Thị Vân Anh", true, 7.5), new Student("Mai Quốc Bảo", true, 8.0),
				new Student("Nguyễn Minh Thức", false, 9.0), new Student("Thái Hoàng An", false, 7.0),
				new Student("Công Tôn Sách", true, 9.5));
		list.forEach(sv -> {
			System.out.println(">> Name: " + sv.getName());
			System.out.println(">> Marks: " + sv.getMarks());
			System.out.println("-----------------------------------------");

		});
	}

	private static void demo3() {
		Collections.sort(list, (sv1, sv2) -> -sv1.getMarks().compareTo(sv2.getMarks()));
		list.forEach(sv -> {
			System.out.println(">> Name: " + sv.getName());
			System.out.println(">> Marks: " + sv.getMarks());
			System.out.println();
		});
	}

	private static void demo4() {
		Demo4Inter o = (x) -> {

			System.out.println(x);

		};
		o.m1(2021);
	}

	@FunctionalInterface
	interface Demo4Inter {
		void m1(int x);

		default void m2() {
		}

		public static void m3() {
		}
	}

}
