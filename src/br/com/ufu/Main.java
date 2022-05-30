package br.com.ufu;

import br.com.ufu.service.MainService;
import br.com.ufu.service.impl.MainServiceImpl;

public class Main {

    public static void main(String[] args) {
        MainService service = new MainServiceImpl();
        service.run();
    }
}
