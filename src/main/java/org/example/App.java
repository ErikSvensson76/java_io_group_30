package org.example;

import org.example.data.FileCopyService;
import org.example.data.TextFileService;

import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        File source = new File("source/java_logo.png");
        File destination = new File("destination/java_logo_copy.png");
        //FileCopyService.copyWithBuffers(source, destination);
        File text = new File("text/output.txt");
        String string = "Hello I/O";
        //TextFileService.writeString(textDestination,string);

        try{
            String result = TextFileService.readFromTextFile(text);
            System.out.println(result);
        } catch (IOException e) {
            System.out.println(e);
        }


    }
}
