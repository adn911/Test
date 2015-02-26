package org.galib.httpwebserver.utilities;

/**
 * Created by bakhtiar.galib on 2/24/15.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public static String readFromFile(String filename) {

        String fileData = "";
        BufferedReader reader = null;
        String currentLine;
        String homeDirectory = System.getProperty("user.home");

        try {

            reader = new BufferedReader(new FileReader(Configuration.WEB_DIRECTORY
                    + "/" + /* homeDirectory + "/" + */
                    filename));

            while ((currentLine = reader.readLine()) != null) {

                fileData += currentLine + System.getProperty("line.separator");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return fileData;
    }

    public static void clearFileContents(String filename) {

        writeToFile(filename, "");
    }

    public static List<String> getAllFiles(String directoryName) {

        List<String> listOfFiles = new ArrayList<String>();

        File directory = new File(Configuration.WEB_DIRECTORY);

        File[] files = directory.listFiles();

        for (File file : files) {
            listOfFiles.add(file.getName());
        }

        return listOfFiles;
    }

    public static void writeToFile(String filename, String data) {

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(filename);
            writer.write(data);

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            if (writer != null)
                writer.close();

        }

    }

    public static void appendToFile(String filename, String data) {

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(
                    filename, true)));
            writer.append(data);

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            if (writer != null)
                writer.close();

        }

    }

}

