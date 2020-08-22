package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class PersistenceFile implements Persistence<File> {

	@Override
	public File getDataOf(String username) {
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

	@Override
	public void savePost(String username, String post) {
		File file = getDataOf(username);
		FileWriter fw;
		try {
			fw = new FileWriter(file);

			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(post);
			bw.flush();
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<String> readPostOf(String username) {
		File file = getDataOf(username);
		
		List<String> post = new ArrayList<>();
		FileReader fr;
		try {
			fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		
		
//		while(br.readLine() !=null ) {
//			post.add(br.readLine());
//		}
		
		try (Stream<String> stream = Files.lines(Paths.get(username))) {
	        stream.forEach(post::add);
	}
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return post;
	}

}
