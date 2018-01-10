package livecoding;

import javakara.JavaKaraProgram;

import java.io.IOException;

public class CommandExample extends JavaKaraProgram {
	public static void main(String[] args) throws IOException, InterruptedException {
		designpattern.command.CommandExample program = new designpattern.command.CommandExample();
		program.run("src/main/resources/world1.world");

		int c;
		while ((c = System.in.read()) != -1) {
			// do something interactive with kara
		}
	}
}
