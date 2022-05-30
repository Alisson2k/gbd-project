package br.com.ufu.data;

public class Student {

    private int seqAluno;
    private String codigoCurso;
    private String nomeAluno;

    public int getSeqAluno() {
        return seqAluno;
    }

    public void setSeqAluno(int seqAluno) {
        this.seqAluno = seqAluno;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    @Override
    public String toString() {
        return "seqAluno=" + seqAluno +
                ",codigoCurso=" + codigoCurso +
                ",nomeAluno=" + nomeAluno;
    }
}
