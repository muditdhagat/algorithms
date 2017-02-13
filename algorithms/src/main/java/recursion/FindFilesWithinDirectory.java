package recursion;

import java.io.File;

public class FindFilesWithinDirectory {
	
	int countFileInDir(String directoryPath) {
		
		int count = 0; 
		
		File directory = new File(directoryPath);
		
		if(!directory.exists()) return 0;
		
		if(!directory.isDirectory()) return 0;
		
		File files[] = directory.listFiles();
		for(File file : files) {
			if(file.isFile()) {
				count++;
			}
			if(file.isDirectory()) {
				count = count + countFileInDir(file.getAbsolutePath());
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		
		String directoryPath = "E:\\Work";
		
		FindFilesWithinDirectory f = new FindFilesWithinDirectory();
		int count = f.countFileInDir(directoryPath);
		System.out.printf("Number of files inside directory: %s is %d", directoryPath, count );

	}

}
