package br.jus.tjpb.libs.sgtsoapcient.pesquisaritem;

public enum TipoItemEnum {

    CLASSE("C", "Classe"),
    ASSUNTO("A", "Assunto"),
    MOVIMENTO("M", "Movimento");

    private final String codigo;
    private final String descricao;

    private TipoItemEnum(String codigo, String descricao) {
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
