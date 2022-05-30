package br.com.ufu.service.impl;

import br.com.ufu.config.Constants;
import br.com.ufu.service.FileService;
import br.com.ufu.util.UtilRandom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStream;

public class FileServiceImpl implements FileService {

    @Override
    public String createIfNotExists(String fileName, int count) {
        // TODO: fazer ele criar na heap (através de stream)
        String entirePath = System.getProperty("user.dir") + "/" + fileName;
        if (!Constants.FORCED && exists(entirePath)) {
            return entirePath;
        }

        System.out.println("Creating file in path: " + entirePath);
        populateFile(entirePath, count);
        return entirePath;
    }

    private Boolean exists(String fileName) {
        try {
            return new File(fileName).exists();
        } catch (Exception e) {
            System.out.println("File cannot be available, trying to creating another then");
        }
        return false;
    }

    private void populateFile(String filePath, int count) {
        try {
            FileWriter output = new FileWriter(filePath);

            for (int i = 1; i < count; i++) {
                output.write(UtilRandom.randomStudent(i).toString());
                output.write(";");
            }
            output.close();
        } catch(Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    public InputStream readFile(String fileName) throws FileNotFoundException {
        return new FileInputStream(fileName);
    }
}
