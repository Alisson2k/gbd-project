package br.com.ufu.service;

import java.io.FileNotFoundException;
import java.io.InputStream;

public interface FileService {

    String createIfNotExists(String fileName, int count);
    InputStream readFile(String fileName) throws FileNotFoundException;
}
