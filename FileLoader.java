import java.io.File;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class FileLoader {
    /**
     * List out all subdirectories of the specified directory.
     * Use a lambda rather than a FileFilter
     */
    public static void listSubdirectoriesLambda(String dirName) {
        System.out.println("List subdirectories, using a lambda (instead of FileFilter)");
        File myDir = new File(dirName);

        if (myDir.exists() && myDir.isDirectory()) {
            File[] subdirs = myDir.listFiles(file -> file.isDirectory()); // Lambda
            if (subdirs != null) {
                for (File subdir : subdirs) {
                    System.out.println(subdir.getName());
                }
            }
        }
    }

    /**
     * List out all subdirectories of the specified directory.
     * For this version, use a method reference.
     */
    public static void listSubdirectoriesMethodRef(String dirName) {
        System.out.println("List subdirectories using a method reference");
        File myDir = new File(dirName);

        if (myDir.exists() && myDir.isDirectory()) {
            File[] subdirs = myDir.listFiles(File::isDirectory); // Method reference
            if (subdirs != null) {
                for (File subdir : subdirs) {
                    System.out.println(subdir.getName());
                }
            }
        }
    }

    /**
     * List out all files in the specified directory that have the specified extension.
     * Use a lambda rather than a FilenameFilter.
     */
    public static void listFiles(String dirName, String extension) {
        System.out.println("Listing all ." + extension + " files");
        File dir = new File(dirName);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles((file, name) -> name.endsWith("." + extension)); // Lambda
            if (files != null) {
                for (File file : files) {
                    System.out.println(file.getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        listSubdirectoriesLambda(".");
        listSubdirectoriesMethodRef(".");
        listFiles("src", "java");
    }
}
