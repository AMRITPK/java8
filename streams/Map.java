package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Map {
	public static void main(String args[]) throws IOException {
		
		Stream<String> str = Files.lines(Paths.get("./in.txt"))
							.map(String::toLowerCase);
		str.forEach(System.out::println);
	}
}
