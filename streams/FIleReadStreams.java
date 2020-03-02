package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FIleReadStreams {
	public static void main(String args[]) throws IOException {
		List<String> a = Files.lines(Paths.get("./in.txt")).parallel().filter(item->item.length()==1).collect(Collectors.toList());
		System.out.println(a);
	}
}
