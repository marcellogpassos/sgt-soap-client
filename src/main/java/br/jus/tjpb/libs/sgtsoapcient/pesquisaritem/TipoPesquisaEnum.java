package br.jus.tjpb.libs.sgtsoapcient.pesquisaritem;

public enum TipoPesquisaEnum {

    CODIGO("C", "Código"),
    GLOSSARIO("G", "Glossário"),
    NOME("N", "Nome");

    private final String codigo;
    private final String descricao;

    private TipoPesquisaEnum(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
