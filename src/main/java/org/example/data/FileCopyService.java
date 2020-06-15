package org.example.data;

import java.io.*;

public class FileCopyService {

    public static void copy(File source, File destination){

        try(InputStream in = new FileInputStream(source);
        OutputStream out = new FileOutputStream(destination)){

            int _byte;
            while((_byte = in.read()) != -1){
                out.write(_byte);
            }

        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static void copyWithBuffers(File source, File destination){
        try(
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(source));
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destination))
                ){

            byte[] buffer = new byte[1024];
            int bytesRead;
            while((bytesRead = in.read(buffer)) > 0){
                out.write(buffer, 0, bytesRead);
                out.flush();
            }

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

}
