package com.brunoyam.consolemaster.dao;

import java.io.File;
import java.io.IOException;

public class FileManipulator {

    public void createFile(File file) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteFile(File file) {
        if(file.exists()) {
            file.delete();
        }
    }

}
