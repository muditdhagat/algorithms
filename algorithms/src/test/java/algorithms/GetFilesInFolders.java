package algorithms;

import java.io.File;

public class GetFilesInFolders {

	public static void main(String[] args) {
		
		String path = "E:\\temp\\com.digitate.store-assembly-1.3.2.28-distribution\\DBSetup\\database\\appstore";
		File filepath = new File(path);
		
		String[] files = filepath.list();
		for( String file : files) {
			System.out.println("psql -U postgres -d appstoreDB -f " + path + File.separator + file);
		}
		

	}

}
