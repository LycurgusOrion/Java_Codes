import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.concurrent.ExecutionException;

public class FileOps
{
	final static int BUFFER_SIZE = 1000;

	public static void main(String[] args) 
	{
		String mode = args[0];

		File f1 = new File("abc.txt");
		File f2 = new File("txt\\abc.txt");
		File f3 = new File("..\\abc.txt");
		File f4 = new File("..\\txt\\abc.txt");

		try 
		{
			File f = new File(args[1]);
			if(mode.compareToIgnoreCase("create") == 0)
			{
				if(f.createNewFile())
					System.out.println("File created!");
				else
					System.out.println("Error creating file!");
			} 
			else if(mode.compareToIgnoreCase("write") == 0) 
			{
				FileWriter w = new FileWriter(f);
				w.write(args[2]);
				w.close();
			} 
			else if(mode.compareToIgnoreCase("read") == 0) 
			{
				if(args[2].compareToIgnoreCase("byte") == 0)
				{
					FileInputStream fin = new FileInputStream(args[1]);
					byte[] b = new byte[BUFFER_SIZE];
					int totalBytes = 0, currBytes = 0;
					while((currBytes = fin.read(b)) != -1)
					{
						System.out.println(new String(b));
						totalBytes += currBytes;
					}
					System.out.println("Finished reading " + totalBytes + " bytes from " + args[1]);
					fin.close();
				}
				if(args[2].compareToIgnoreCase("char") == 0)
				{
					FileReader fr = new FileReader(args[1]);
					BufferedReader bf = new BufferedReader(fr);
					String data;
					while((data = bf.readLine()) != null)
					{
						System.out.println(data);
					}
					bf.close();
				}
			}
			else if(mode.compareToIgnoreCase("rename") == 0)
			{
				String cName = args[1];
				String nName = args[2];
	
				File cFile = new File(cName);
				File nFile = new File(nName);
	
				cFile.renameTo(nFile);
			}
			else if(mode.compareToIgnoreCase("fd") == 0)
			{
				// File f = new File(args[1]);
				String fd = f.getPath();
				// if(fd != null)
					System.out.println(fd);
			}
			else if(mode.compareToIgnoreCase("find") == 0)
			{
				File file = new File(args[1]);
				File currentPath = new File(file.getAbsolutePath());
				String fullPath = currentPath.toString();
				for(int i = fullPath.length() ; i > 0 ; i--)
				{
					
				}
				File folder = new File(folder);
				File[] listOfFiles = folder.listFiles();
				for (int i = 0; i < listOfFiles.length; i++) {
					if(listOfFiles[i].isFile())
						System.out.println(listOfFiles[i].getName());
				}
			}
			else if(mode.compareToIgnoreCase("copy") == 0)
			{
				FileReader fr = new FileReader(args[1]);
				BufferedReader bf = new BufferedReader(fr);
				FileWriter w = new FileWriter(args[2]);
				String data;
				while ((data = bf.readLine()) != null) {
					System.out.println(data);
					w.write(data);
				}
				w.close();
				bf.close();
			}
		} 
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}