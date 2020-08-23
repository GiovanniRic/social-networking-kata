package repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import model.Post;
import utils.DateHandler;

class PersistencePostFile implements Persistence<Post> {

	@Override
	public void save(String username, Post post) {

		File file = getFileOf(username);
		String dataTime = DateHandler.getDateFormated(post.getTimestampPost());

		try (FileWriter writer = new FileWriter(file, true)) {

			String record = post.getMessage() + ", " + dataTime + "\n";
			writer.write(record);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Post> read(String user) {

		List<Post> post = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(user))) {
			stream.map(s -> s.split(","))
					.forEach(record -> post.add(new Post(record[0], DateHandler.getDateParsed(record[1]))));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return post;

	}

	private File getFileOf(String user) {

		File file = new File(user);
		if (file.exists()) {
			return file;
		} else {
			createFile(file);
			return file;
		}

	}

	private static void createFile(File file) {

		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
