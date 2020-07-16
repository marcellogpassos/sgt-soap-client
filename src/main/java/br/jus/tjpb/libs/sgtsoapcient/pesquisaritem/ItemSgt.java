package br.jus.tjpb.libs.sgtsoapcient.pesquisaritem;

import java.util.Objects;

public class ItemSgt {

    private Integer codItem;

    private Integer codItemPai;

    private String nome;

    private String dscGlossario;

    public ItemSgt() {
    }

    public ItemSgt(Integer codItem, Integer codItemPai, String nome, String dscGlossario) {
        this.codItem = codItem;
        this.codItemPai = codItemPai;
        this.nome = nome;
        this.dscGlossario = dscGlossario;
    }

    public Integer getCodItem() {
        return codItem;
    }

    public void setCodItem(Integer codItem) {
        this.codItem = codItem;
    }

    public Integer getCodItemPai() {
        return codItemPai;
    }

    public void setCodItemPai(Integer codItemPai) {
        this.codItemPai = codItemPai;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDscGlossario() {
        return dscGlossario;
    }

    public void setDscGlossario(String dscGlossario) {
        this.dscGlossario = dscGlossario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemSgt item = (ItemSgt) o;
        return Objects.equals(codItem, item.codItem) &&
                Objects.equals(codItemPai, item.codItemPai) &&
                Objects.equals(nome, item.nome) &&
                Objects.equals(dscGlossario, item.dscGlossario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codItem, codItemPai, nome, dscGlossario);
    }
}
