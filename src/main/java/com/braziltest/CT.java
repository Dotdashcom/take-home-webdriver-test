package com.braziltest;



import java.util.Arrays;

public class CT {
    private String modulo;
    private String [] parametros;
    private String ctName;
    private int numeroLinhaCT;
    private int indiceColunaResultado;
    private int indiceColunaDuracao;
    private int indiceColunaMotivoErro;
    private String motivoErro;
    private int duracao;
    private boolean resultado;
    
    public String getMotivoErro() {
        return motivoErro;
    }

    
    @Override
    public String toString() {
        return "CT [modulo=" + modulo + ", ctName=" + ctName + ", parametros=" + Arrays.toString(parametros) + ", numeroLinhaCT="
                + numeroLinhaCT + ", indiceColunaResultado=" + indiceColunaResultado + ", indiceColunaDuracao=" + indiceColunaDuracao
                + ", indiceColunaMotivoErro=" + indiceColunaMotivoErro + ", motivoErro=" + motivoErro + ", duracao=" + duracao
                + ", resultado=" + resultado + "]";
    }


    public void setMotivoErro(String motivoErro) {
        this.motivoErro = motivoErro;
    }

    
    public int getDuracao() {
        return duracao;
    }

    
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public boolean isResultado() {
        return resultado;
    }

    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }

    public String getModulo() {
        return modulo;
    }
    
    public void setModulo(String modulo) {
        this.modulo = modulo;
    }
    
    public String[] getParametros() {
        return parametros;
    }
    
    public void setParametros(String[] parametros) {
        this.parametros = parametros;
    }
    
    public String getCTName() {
        return ctName;
    }
    
    public void setCTName(String ctName) {
        this.ctName = ctName;
    }
    
    
    public int getNumeroLinhaCT() {
        return numeroLinhaCT;
    }

    
    public void setNumeroLinhaCT(int numeroLinhaCT) {
        this.numeroLinhaCT = numeroLinhaCT;
    }

    public int getIndiceColunaResultado() {
        return indiceColunaResultado;
    }
    
    public void setIndiceColunaResultado(int indiceColunaResultado) {
        this.indiceColunaResultado = indiceColunaResultado;
    }
    
    public int getIndiceColunaDuracao() {
        return indiceColunaDuracao;
    }
    
    public void setIndiceColunaDuracao(int indiceColunaDuracao) {
        this.indiceColunaDuracao = indiceColunaDuracao;
    }
    
    public int getIndiceColunaMotivoErro() {
        return indiceColunaMotivoErro;
    }
    
    public void setIndiceColunaMotivoErro(int indiceColunaMotivoErro) {
        this.indiceColunaMotivoErro = indiceColunaMotivoErro;
    }
    
}
