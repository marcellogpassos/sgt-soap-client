package br.jus.tjpb.libs.sgtsoapcient.getarrayfilhositem;

import java.util.Objects;

public class ArvoreGenerica {

    private Integer seqElemento;

    private String dscElemento;

    private Integer seqElementoPai;

    private String temFilhos;

    private String situacao;

    public ArvoreGenerica() {
    }

    public ArvoreGenerica(Integer seqElemento, String dscElemento, Integer seqElementoPai, String temFilhos,
                          String situacao) {
        this.seqElemento = seqElemento;
        this.dscElemento = dscElemento;
        this.seqElementoPai = seqElementoPai;
        this.temFilhos = temFilhos;
        this.situacao = situacao;
    }

    public Integer getSeqElemento() {
        return seqElemento;
    }

    public void setSeqElemento(Integer seqElemento) {
        this.seqElemento = seqElemento;
    }

    public String getDscElemento() {
        return dscElemento;
    }

    public void setDscElemento(String dscElemento) {
        this.dscElemento = dscElemento;
    }

    public Integer getSeqElementoPai() {
        return seqElementoPai;
    }

    public void setSeqElementoPai(Integer seqElementoPai) {
        this.seqElementoPai = seqElementoPai;
    }

    public String getTemFilhos() {
        return temFilhos;
    }

    public void setTemFilhos(String temFilhos) {
        this.temFilhos = temFilhos;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArvoreGenerica that = (ArvoreGenerica) o;
        return Objects.equals(seqElemento, that.seqElemento) &&
                Objects.equals(dscElemento, that.dscElemento) &&
                Objects.equals(seqElementoPai, that.seqElementoPai) &&
                Objects.equals(temFilhos, that.temFilhos) &&
                Objects.equals(situacao, that.situacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqElemento, dscElemento, seqElementoPai, temFilhos, situacao);
    }
}
