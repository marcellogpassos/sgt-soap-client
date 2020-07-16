package br.jus.tjpb.libs.sgtsoapcient;

import br.jus.tjpb.libs.sgtsoapcient.getarraydetalhesitem.GetArrayDetalhesItemService;
import br.jus.tjpb.libs.sgtsoapcient.getarrayfilhositem.ArvoreGenerica;
import br.jus.tjpb.libs.sgtsoapcient.getarrayfilhositem.GetArrayFilhosItemService;
import br.jus.tjpb.libs.sgtsoapcient.getcomplementomovimento.ComplementoMovimento;
import br.jus.tjpb.libs.sgtsoapcient.getcomplementomovimento.GetComplementoMovimentoService;
import br.jus.tjpb.libs.sgtsoapcient.getdataultimaversao.GetDataUltimaVersaoService;
import br.jus.tjpb.libs.sgtsoapcient.getstringpaisitem.GetStringPaisItemService;
import br.jus.tjpb.libs.sgtsoapcient.pesquisaritem.ItemSgt;
import br.jus.tjpb.libs.sgtsoapcient.pesquisaritem.PesquisarItemService;
import br.jus.tjpb.libs.sgtsoapcient.pesquisaritem.TipoItemEnum;
import br.jus.tjpb.libs.sgtsoapcient.pesquisaritem.TipoPesquisaEnum;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

/**
 * @author Marcello Passos marcellogpassos@gmail.com
 */
public class SgtSoapClient {

    private final GetArrayDetalhesItemService getArrayDetalhesItemService;
    private final GetArrayFilhosItemService getArrayFilhosItemService;
    private final GetComplementoMovimentoService getComplementoMovimentoService;
    private final GetDataUltimaVersaoService getDataUltimaVersaoService;
    private final GetStringPaisItemService getStringPaisItemService;
    private final PesquisarItemService pesquisarItemService;

    public SgtSoapClient(String url, boolean enableLogging, int timeout) {
        this(new GetArrayDetalhesItemService(url, enableLogging, timeout),
                new GetArrayFilhosItemService(url, enableLogging, timeout),
                new GetComplementoMovimentoService(url, enableLogging, timeout),
                new GetDataUltimaVersaoService(url, enableLogging, timeout),
                new GetStringPaisItemService(url, enableLogging, timeout),
                new PesquisarItemService(url, enableLogging, timeout));
    }

    public SgtSoapClient(GetArrayDetalhesItemService getArrayDetalhesItemService,
                         GetArrayFilhosItemService getArrayFilhosItemService,
                         GetComplementoMovimentoService getComplementoMovimentoService,
                         GetDataUltimaVersaoService getDataUltimaVersaoService,
                         GetStringPaisItemService getStringPaisItemService,
                         PesquisarItemService pesquisarItemService) {
        this.getArrayDetalhesItemService = getArrayDetalhesItemService;
        this.getArrayFilhosItemService = getArrayFilhosItemService;
        this.getComplementoMovimentoService = getComplementoMovimentoService;
        this.getDataUltimaVersaoService = getDataUltimaVersaoService;
        this.getStringPaisItemService = getStringPaisItemService;
        this.pesquisarItemService = pesquisarItemService;
    }

    /**
     * Retorna um mapa contendo os detalhes de um item
     *
     * @param seqItem
     * @param tipoItem
     * @return
     */
    public Map<String, String> getArrayDetalhesItem(Long seqItem, TipoItemEnum tipoItem) {
        return this.getArrayDetalhesItemService.run(String.valueOf(seqItem.intValue()), tipoItem.getCodigo());
    }

    /**
     * Retorna um coleção contendo uma lista de filhos de um item
     *
     * @param seqItem
     * @param tipoItem
     * @return
     */
    public Collection<ArvoreGenerica> getArrayFilhosItem(Long seqItem, TipoItemEnum tipoItem) {
        return this.getArrayFilhosItemService.run(seqItem.intValue(), tipoItem.getCodigo());
    }

    /**
     * Retorna uma coleção contendo os complementos tabelados
     *
     * @param codMovimento
     * @return
     */
    public Collection<ComplementoMovimento> getComplementoMovimento(Long codMovimento) {
        return this.getComplementoMovimentoService.run(codMovimento.intValue());
    }

    /**
     * Retorna a data da última versão
     *
     * @return
     */
    public LocalDate getDataUltimaVersao() {
        return this.getDataUltimaVersaoService.run();
    }

    /**
     * Retorna uma coleção de Strings contendo o encadeamento de pais de um item
     *
     * @param seqItem
     * @param tipoItem
     * @return
     */
    public Collection<String> getStringPaisItem(Long seqItem, TipoItemEnum tipoItem) {
        return this.getStringPaisItemService.run(seqItem.intValue(), tipoItem.getCodigo());
    }

    /**
     * Pesquisa as tabelas públicas de acordo com os parametros passados
     *
     * @param tipoItem
     * @param tipoPesquisa
     * @param valorPesquisa
     * @return
     */
    public Collection<ItemSgt> pesquisarItem(TipoItemEnum tipoItem, TipoPesquisaEnum tipoPesquisa, String valorPesquisa) {
        return this.pesquisarItemService.run(tipoItem.getCodigo(), tipoPesquisa.getCodigo(), valorPesquisa);
    }

}
