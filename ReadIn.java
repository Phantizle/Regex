package Class;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class ReadIn {

	public static void main(String[] args) {
		URL url = ReadIn.class.getClassLoader().getResource("temp.txt");
		System.out.println(url.getPath());
		String fileName = url.getPath();

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	String oldClass = "<this the old one>";
            	line = line.replaceAll("(<[^>]+>)", oldClass);
            	
                System.out.println(line);
            }    

            // Always close files.
            bufferedReader.close();            
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                   
            // Or we could just do this: 
            // ex.printStackTrace();
        }
	}

}
