package org.example.data;

import java.io.*;

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

}
