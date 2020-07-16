package br.jus.tjpb.libs.sgtsoapcient.getcomplementomovimento;

import java.util.Objects;

public class ComplementoMovimento {

    private Integer seqComplemento;

    private Integer seqTipoComplemento;

    private Integer seqComplMov;

    private String dscComplemento;

    private String dscObservacao;

    private String arrayValoresTabelados;

    private String arrayMovimentosVinculados;

    public ComplementoMovimento() {
    }

    public ComplementoMovimento(Integer seqComplemento, Integer seqTipoComplemento, Integer seqComplMov,
                                String dscComplemento, String dscObservacao, String arrayValoresTabelados,
                                String arrayMovimentosVinculados) {
        this.seqComplemento = seqComplemento;
        this.seqTipoComplemento = seqTipoComplemento;
        this.seqComplMov = seqComplMov;
        this.dscComplemento = dscComplemento;
        this.dscObservacao = dscObservacao;
        this.arrayValoresTabelados = arrayValoresTabelados;
        this.arrayMovimentosVinculados = arrayMovimentosVinculados;
    }

    public Integer getSeqComplemento() {
        return seqComplemento;
    }

    public void setSeqComplemento(Integer seqComplemento) {
        this.seqComplemento = seqComplemento;
    }

    public Integer getSeqTipoComplemento() {
        return seqTipoComplemento;
    }

    public void setSeqTipoComplemento(Integer seqTipoComplemento) {
        this.seqTipoComplemento = seqTipoComplemento;
    }

    public Integer getSeqComplMov() {
        return seqComplMov;
    }

    public void setSeqComplMov(Integer seqComplMov) {
        this.seqComplMov = seqComplMov;
    }

    public String getDscComplemento() {
        return dscComplemento;
    }

    public void setDscComplemento(String dscComplemento) {
        this.dscComplemento = dscComplemento;
    }

    public String getDscObservacao() {
        return dscObservacao;
    }

    public void setDscObservacao(String dscObservacao) {
        this.dscObservacao = dscObservacao;
    }

    public String getArrayValoresTabelados() {
        return arrayValoresTabelados;
    }

    public void setArrayValoresTabelados(String arrayValoresTabelados) {
        this.arrayValoresTabelados = arrayValoresTabelados;
    }

    public String getArrayMovimentosVinculados() {
        return arrayMovimentosVinculados;
    }

    public void setArrayMovimentosVinculados(String arrayMovimentosVinculados) {
        this.arrayMovimentosVinculados = arrayMovimentosVinculados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplementoMovimento that = (ComplementoMovimento) o;
        return Objects.equals(seqComplemento, that.seqComplemento) &&
                Objects.equals(seqTipoComplemento, that.seqTipoComplemento) &&
                Objects.equals(seqComplMov, that.seqComplMov) &&
                Objects.equals(dscComplemento, that.dscComplemento) &&
                Objects.equals(dscObservacao, that.dscObservacao) &&
                Objects.equals(arrayValoresTabelados, that.arrayValoresTabelados) &&
                Objects.equals(arrayMovimentosVinculados, that.arrayMovimentosVinculados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqComplemento, seqTipoComplemento, seqComplMov, dscComplemento, dscObservacao,
                arrayValoresTabelados, arrayMovimentosVinculados);
    }
}
