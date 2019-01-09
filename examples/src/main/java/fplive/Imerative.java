package fplive;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Imerative {
	public static void main(String[] args) {
		// imperativ
		ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
		PrintStream ps1 = new PrintStream(bos1);
		for (Student s : Database.getStudents()) {
			if (s.getClasses().contains("Programmieren 3")) {
				Transcript tr = Database.getToR(s.getMatrikel());
				for (Record r : tr)
					ps1.println(r);
			}
		}

		// funktional
		ByteArrayOutputStream bos2 = new ByteArrayOutputStream();
		PrintStream ps2 = new PrintStream(bos2);
		Database.getStudents().stream()
				.filter(s -> s.getClasses().contains("Programmieren 3"))
				.map(Student::getMatrikel)
				.map(Database::getToR)
				.flatMap(t -> t.records.stream())
				.forEach(ps2::println);

		System.out.println(bos1.toString());
		System.out.println(bos2.toString());

		System.out.println(bos1.toString().equals(bos2.toString()));
	}
}
