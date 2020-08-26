package claranet.italia.social.networking.kata.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StorageKataFollow extends StorageSocialKata implements Storage<String> {

	private final String DIRECTORY = "follow/";

	@Override
	public void save(String user, String anotherUser) {

		File file = getFileOf(DIRECTORY, user);
		String record = anotherUser + "\n";

		write(file, record);

	}

	@Override
	public List<String> read(String user) {

		List<String> users = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(BASE_DIRECTORY + DIRECTORY + user))) {
			stream.forEach(users::add);

		} catch (IOException e) {}

		return users;
	}

}
