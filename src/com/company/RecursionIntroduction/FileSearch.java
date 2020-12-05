package com.company.RecursionIntroduction;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class FileSearch {
    public static void main(String[] args) {
        search(new File("/Users/ryan/Desktop/eclipse"), "workspace.xml");
    }

    public static boolean search(File file, String fileName){

        System.out.println("checking: " + file);
        if(file.getName().equals(fileName)){
            System.out.println("** found: " + fileName + " in directory :" + file);
            return true;
        }

        if(file.isFile()) return false;
        for(File f: Objects.requireNonNull(file.listFiles())){
            System.out.println(" - " + (f.isDirectory() ? "directory: " : "file: ")+ f.getName());
            boolean found = search(f, fileName);
            if(found) return true;// if(found) break;
        }
        return false;
    }
}
