package com.poly.lab1.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.poly.lab1.bean.*;

public class StreamAPI {
	static List<Student> list = Arrays.asList(new Student("Hồ Thị Vân Anh", true, 7.5),
			new Student("Lâm Diễm Thúy", false, 8.5), new Student("Mai Văn Đạt", true, 8.0),
			new Student("Nguyễn Minh Thức", false, 9.0), new Student("Thái Hoàng An", false, 7.0),
			new Student("Phạm Xuân Vinh", true, 9.5));

	public static void main(String[] args) {
		// demo1();
		// demo2();
		// demo3();
		demo4();
	}

	private static void demo1() {
		Stream<Integer> stream1 = Stream.of(1, 9, 4, 7, 5, 2);
		stream1.forEach(n -> {
			System.out.println(n);

		});

		System.out.println();

		List<Integer> list = Arrays.asList(1, 9, 4, 7, 5, 2);
		list.stream().forEach(n -> {

			System.out.println(n);
		});
	}

	private static void demo2() {
		List<Integer> list = Arrays.asList(1, 9, 4, 7, 5, 2);
		List<Double> result = list.stream().filter(n -> n % 2 == 0).map(n -> Math.sqrt(n))
				.peek(d -> System.out.println(d)).collect(Collectors.toList());
	}

	private static void demo3() {
		List<Student> result = list.stream().filter(sv -> sv.getMarks() >= 9)
				.peek(sv -> sv.setName(sv.getName().toUpperCase())).collect(Collectors.toList());

		result.forEach(sv -> {
			System.out.println(">>Name: " + sv.getName());
			System.out.println(">>Marks: " + sv.getMarks());
			System.out.println();
		});
	}

	private static void demo4() {
		double average = list.stream().mapToDouble(sv -> sv.getMarks()).average().getAsDouble();
		System.out.println("average: " + average);

		double sum = list.stream().mapToDouble(sv -> sv.getMarks()).sum();
		System.out.println("sum: " + sum);

		double min_marks = list.stream().mapToDouble(sv -> sv.getMarks()).min().getAsDouble();
		System.out.println("min_marks: " + min_marks);

		boolean all_passed = list.stream().allMatch(sv -> sv.getMarks() >= 5);
		System.out.println("all_passed: " + all_passed);

		Student min_sv = list.stream().reduce(list.get(0), (min, sv) -> sv.getMarks() < min.getMarks() ? sv : min);
		System.out.println("min_sv: " + min_sv.getName());
	}
}
