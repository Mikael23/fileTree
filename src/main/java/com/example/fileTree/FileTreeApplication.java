package com.example.fileTree;

import org.apache.commons.io.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Scanner;

import static com.example.fileTree.service.FileTreeService.printFiles;

@SpringBootApplication
public class FileTreeApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var path = scanner.next();
        SpringApplication.run(FileTreeApplication.class, args);
        File root = new File(path);
        if (root.exists() && root.isDirectory()) {
            System.out.println("This directory " + root.getName());
            System.out.println(FileUtils.byteCountToDisplaySize(printFiles(root, 1)));
        }

    }

}
