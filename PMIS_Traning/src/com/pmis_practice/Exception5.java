package exceptionhandling.com;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Exception5 {
    static void readfile() throws IOException
    {
	    FileReader file = new FileReader("data.txt");
	    System.out.println("File Opened");
    }
	public static void main(String[] args) {
		
		try
		{
			readfile();
		}
		catch(IOException e)
		{
			System.out.println("Could not find the file");
		}	

	}

}
