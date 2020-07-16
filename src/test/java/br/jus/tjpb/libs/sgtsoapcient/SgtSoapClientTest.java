package br.jus.tjpb.libs.sgtsoapcient;

import br.jus.tjpb.libs.sgtsoapcient.getarrayfilhositem.ArvoreGenerica;
import br.jus.tjpb.libs.sgtsoapcient.getcomplementomovimento.ComplementoMovimento;
import br.jus.tjpb.libs.sgtsoapcient.pesquisaritem.ItemSgt;
import br.jus.tjpb.libs.sgtsoapcient.pesquisaritem.TipoItemEnum;
import br.jus.tjpb.libs.sgtsoapcient.pesquisaritem.TipoPesquisaEnum;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

import static br.jus.tjpb.libs.sgtsoapcient.SgtSoapClientDefaultProperties.CLIENT;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SgtSoapClientTest {

    @Test
    void getArrayDetalhesItem() {
        final Map<String, String> result = CLIENT.getArrayDetalhesItem(51L, TipoItemEnum.MOVIMENTO);
        assertNotNull(result);
    }

    @Test
    void getArrayFilhosItem() {
        final Collection<ArvoreGenerica> result = CLIENT.getArrayFilhosItem(2L, TipoItemEnum.CLASSE);
        assertNotNull(result);
    }

    @Test
    void getComplementoMovimento() {
        final Collection<ComplementoMovimento> result = CLIENT.getComplementoMovimento(51L);
        assertNotNull(result);
    }

    @Test
    void getDataUltimaVersao() {
        final LocalDate result = CLIENT.getDataUltimaVersao();
        assertNotNull(result);
    }

    @Test
    void getStringPaisItem() {
        final Collection<String> result = CLIENT.getStringPaisItem(51L, TipoItemEnum.MOVIMENTO);
        assertNotNull(result);
    }

    @Test
    void pesquisarItem() {
        final Collection<ItemSgt> result = CLIENT.pesquisarItem(TipoItemEnum.CLASSE, TipoPesquisaEnum.NOME, "Procedimento");
        assertNotNull(result);
    }
}
