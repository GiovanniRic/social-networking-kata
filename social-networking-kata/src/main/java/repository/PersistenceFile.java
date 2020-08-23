package repository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class PersistenceFile implements Persistence {

	@Override
	public void savePost(String username, String post) {

		File file = getFileOf(username);
		
		try(Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(file), "UTF-8"))){
			
					writer.write(post);
			
		} catch (UnsupportedEncodingException e ) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

	@Override
	public List<String> readPostOf(String username) {
		
		List<String> post = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(username))) {
			stream.forEach(post::add);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return post;
		
	}

	private File getFileOf(String username) {

		File file = new File(username);
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
