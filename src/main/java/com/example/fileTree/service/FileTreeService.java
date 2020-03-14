package com.example.fileTree.service;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Objects;

public class FileTreeService {

    public static long printFiles(File file, int level) {
        long size = 0;
            for (File fileFromDirectory : Objects.requireNonNull(file.listFiles())) {
                for (int i = 0; i < level; i++) {
                    System.out.print("\t");
                }
                if (fileFromDirectory.isFile()) {
                    size += fileFromDirectory.length();
                    System.out.println("This is size of file " + fileFromDirectory.getName() + " " +  FileUtils.byteCountToDisplaySize(fileFromDirectory.length()));
                } else if (fileFromDirectory.isDirectory()) {
                    System.out.println("directory " + fileFromDirectory.getName());
                    long desize = printFiles(fileFromDirectory, level + 1);
                    for (int i = 0; i < level; i++) {
                        System.out.print("\t");
                    }
                    System.out.println(FileUtils.byteCountToDisplaySize(desize));
                    size += desize;
                }
            }
        return size;
    }


}
