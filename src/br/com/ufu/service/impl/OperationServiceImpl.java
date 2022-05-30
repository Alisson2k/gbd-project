package br.com.ufu.service.impl;

import br.com.ufu.data.enumeration.Command;
import br.com.ufu.service.FileService;
import br.com.ufu.service.OperationService;

public class OperationServiceImpl implements OperationService {

    private final FileService fileService;

    public OperationServiceImpl() {
        this.fileService = new FileServiceImpl();
    }

    @Override
    public Object exec(Command command, Object ...args) {
        switch (command) {
            case CREATE_HEAP_FILE:
                return createHeapFile(args);
            case READ_RANDOM:
                return readRandom();
            case ISRT_AT_END:
                return isrtAtEnd();
            case UPDATE_RANDOM:
                return updateRandom();
            case DELETE_RANDOM:
                return deleteRandom();
            default:
                break;
        }

        return null;
    }

    private Object createHeapFile(Object ...args) {
        this.fileService.createIfNotExists("arquivo.txt", (int) args[0]);
        return null;
    }

    private Object readRandom() {
        // TODO implements
        return null;
    }

    private Object isrtAtEnd() {
        // TODO implements
        return null;
    }

    private Object updateRandom() {
        // TODO implements
        return null;
    }

    private Object deleteRandom() {
        // TODO implements
        return null;
    }
}
