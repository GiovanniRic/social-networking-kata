package repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class StorageSocialKata {
	
	protected static String BASE_DIRECTORY = "repository/";
	
	public File getFileOf(String dir, String user) {

		File file = new File(BASE_DIRECTORY+ dir+ user);
		if (file.exists()) {
			return file;
		} else {
			createFile(dir, file);
			return file;
		}

	}
	
	public void write(File file, String record) {
		
	try (FileWriter writer = new FileWriter(file, true)) {

			writer.write(record);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void createFile(String dir, File file) {

		try {
			String pathName = BASE_DIRECTORY + dir + file.getName();
	        Path path = Paths.get(pathName);
	        Files.createDirectories(path.getParent());
	  
	            Files.createFile(path);
		}  catch (FileAlreadyExistsException e) {
	            System.err.println("already exists: " + e.getMessage());
	        }
			
			
			
		 catch (IOException e) {
			e.printStackTrace();
		}
	}
}
