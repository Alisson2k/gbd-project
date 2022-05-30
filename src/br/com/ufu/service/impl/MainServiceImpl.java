package br.com.ufu.service.impl;

import br.com.ufu.data.enumeration.Command;
import br.com.ufu.service.FileService;
import br.com.ufu.service.MainService;
import br.com.ufu.service.OperationService;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class MainServiceImpl implements MainService {

    private final OperationService operationService;

    public MainServiceImpl() {
        this.operationService = new OperationServiceImpl();
    }

    @Override
    public void run() {
        operationService.exec(Command.CREATE_HEAP_FILE, 100);

//        so um exemplo de como transformar o arquivo stream (heap) numa string
//        try {
//            InputStream stream = fileService.readFile(path);
//            String result = new BufferedReader(new InputStreamReader(stream)).lines().collect(Collectors.joining("\n"));
//            System.out.println(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
