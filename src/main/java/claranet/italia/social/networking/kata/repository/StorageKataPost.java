package claranet.italia.social.networking.kata.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import claranet.italia.social.networking.kata.model.Post;
import claranet.italia.social.networking.kata.utils.DateTimeHandler;

class StorageKataPost extends StorageSocialKata implements Storage<Post> {
	
	private final String DIRECTORY = "post/";

	@Override
	public void save(String username, Post post) {

		File file = getFileOf(DIRECTORY, username);
		String dataTime = DateTimeHandler.getDateFormated(post.getTimestampPost());
		String record = post.getMessage() + ", " + dataTime + "\n";
		
		write(file, record);

	}

	@Override
	public List<Post> read(String user) {

		List<Post> post = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(BASE_DIRECTORY+DIRECTORY+user))) {
			stream.map(s -> s.split(","))
			.forEach(record -> 
			 post.add(new Post(record[0], DateTimeHandler.getDateParsed(record[1]))));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return post;

	}



}
