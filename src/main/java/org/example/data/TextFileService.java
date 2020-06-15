package org.example.data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TextFileService {

    public static void writeString(File destination, String source){
        try(FileWriter writer = new FileWriter(destination)){
            if(!destination.exists()){
                destination.createNewFile();
            }
            writer.write(source);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromTextFile(File src) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        FileReader reader = new FileReader(src);
        int i;
        while((i = reader.read()) != -1){
            char letter = (char) i;
            stringBuilder.append(letter);
        }
        reader.close();
        return stringBuilder.toString();
    }

    public static List<String> writeToFile(File file, List<String> source){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            for(String toWrite : source){
                writer.write(toWrite.trim());
                writer.newLine();
            }
            writer.flush();

        }catch (IOException ex){
            ex.printStackTrace();
        }

        return source;
    }

    public static List<String> readFromFile(File file){
        List<String> strings = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while((line = reader.readLine()) != null){
                strings.add(line);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return strings;
    }

    public static List<String> readFromFileLambdaStyle(String location){
        List<String> strings = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(location))){
            strings = reader.lines()
                    .collect(Collectors.toList());
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return strings;
    }

}
