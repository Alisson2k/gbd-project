package br.com.ufu.util;

import br.com.ufu.data.Student;

import java.util.UUID;

public class UtilRandom {

    public static Student randomStudent(int seq) {
        Student student = new Student();
        student.setSeqAluno(seq);
        student.setCodigoCurso(UtilRandom.randomString(3));
        student.setNomeAluno(UtilRandom.randomString(10));
        return student;
    }

    public static String randomString(int size) {
        final String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid.substring(size);
    }
}
