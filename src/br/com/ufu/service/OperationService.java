package br.com.ufu.service;

import br.com.ufu.data.enumeration.Command;

public interface OperationService {

    Object exec(Command command, Object ...args);
}
