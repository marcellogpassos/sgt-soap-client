package br.jus.tjpb.libs.sgtsoapcient.pesquisaritem;

import br.jus.tjpb.libs.sgtsoapcient.client.AbstractSoapService;
import br.jus.tjpb.libs.sgtsoapcient.client.IConverter;
import br.jus.tjpb.libs.sgtsoapcient.client.wcfmethod.DefaultWcfMethod;
import br.jus.tjpb.libs.sgtsoapcient.client.wcfmethod.IWcfMethod;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class PesquisarItemService extends AbstractSoapService<ArrayOfItemTO, Collection<ItemSgt>> {

    public PesquisarItemService(String methodNamespace, boolean enableLogging, int timeout) {
        super(methodNamespace, enableLogging, timeout);
    }

    @Override
    protected String getMethodName() {
        return "pesquisarItemPublicoWS";
    }

    @Override
    protected IWcfMethod getWcfMethod(Object... params) {
        return new DefaultWcfMethod(
                this.methodNamespace,
                this.getMethodName(),
                this.createProperties(params),
                ArrayOfItemTO.class);
    }

    @Override
    protected boolean validParams(Object... params) {
        return Objects.nonNull(params) &&
                params.length == 3 &&
                Objects.nonNull(params[0]) &&
                Objects.nonNull(params[1]) &&
                Objects.nonNull(params[2]) &&
                params[0] instanceof String &&
                params[1] instanceof String &&
                params[2] instanceof String &&
                ((String) params[0]).trim().length() == 1 &&
                ((String) params[1]).trim().length() == 1;
    }

    @Override
    protected List<PropertyInfo> createProperties(Object... params) {
        return Arrays.asList(this.createProperty("tipoTabela", params[0], PropertyInfo.STRING_CLASS),
                this.createProperty("tipoPesquisa", params[1], PropertyInfo.STRING_CLASS),
                this.createProperty("valorPesquisa", params[2], PropertyInfo.STRING_CLASS));
    }

    @Override
    protected IConverter<ArrayOfItemTO, Collection<ItemSgt>> getConverter() {
        return input -> {
            Set<ItemSgt> output = new HashSet<>();
            for (ItemTO element : input) {
                output.add(new ItemSgt(element.cod_item, element.cod_item_pai, element.nome, element.dscGlossario));
            }
            return output;
        };
    }
}
