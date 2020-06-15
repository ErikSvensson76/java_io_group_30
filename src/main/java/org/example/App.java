package org.example;

import org.example.data.FileCopyService;
import org.example.data.TextFileService;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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

        /*
        try{
            String result = TextFileService.readFromTextFile(text);
            System.out.println(result);
        } catch (IOException e) {
            System.out.println(e);
        }
        */

        List<String> names = Arrays.asList(
                "Michelle", "Tobias", "Martin", "Mattias", "Patrik", "Huiyi", "Negar", "Elmira", "Amer"
        );
        File fileNames = new File("text/names.txt");
        //TextFileService.writeToFile(fileNames, names);

        /*TextFileService.readFromFile(fileNames)
                .forEach(System.out::println);
        */

        String location = "text/names.txt";
        TextFileService.readFromFileLambdaStyle(location).forEach(System.out::println);

    }
}
