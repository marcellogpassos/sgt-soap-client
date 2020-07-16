package br.jus.tjpb.libs.sgtsoapcient.getarraydetalhesitem;

import br.jus.tjpb.libs.sgtsoapcient.client.AbstractSoapService;
import br.jus.tjpb.libs.sgtsoapcient.client.IConverter;
import br.jus.tjpb.libs.sgtsoapcient.client.wcfmethod.DefaultWcfMethod;
import br.jus.tjpb.libs.sgtsoapcient.client.wcfmethod.IWcfMethod;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GetArrayDetalhesItemService extends AbstractSoapService<ArrayOfDetalheItemTO, Map<String, String>> {

    public GetArrayDetalhesItemService(String methodNamespace, boolean enableLogging, int timeout) {
        super(methodNamespace, enableLogging, timeout);
    }

    @Override
    protected String getMethodName() {
        return "getArrayDetalhesItemPublicoWS";
    }

    @Override
    protected IWcfMethod getWcfMethod(Object... params) {
        return new DefaultWcfMethod(
                this.methodNamespace,
                this.getMethodName(),
                this.createProperties(params),
                ArrayOfDetalheItemTO.class);
    }

    @Override
    protected boolean validParams(Object... params) {
        return Objects.nonNull(params) &&
                params.length == 2 &&
                Objects.nonNull(params[0]) &&
                Objects.nonNull(params[1]) &&
                params[0] instanceof String &&
                params[1] instanceof String &&
                ((String) params[1]).trim().length() == 1;
    }

    @Override
    protected List<PropertyInfo> createProperties(Object... params) {
        return Arrays.asList(this.createProperty("seqItem", params[0], PropertyInfo.STRING_CLASS),
                this.createProperty("tipoItem", params[1], PropertyInfo.STRING_CLASS));
    }

    @Override
    protected IConverter<ArrayOfDetalheItemTO, Map<String, String>> getConverter() {
        return input -> {
            Map<String, String> map = new HashMap<>();
            for (DetalheItemTO entry : input) {
                map.put(entry.getKey(), entry.getValue());
            }
            return map;
        };
    }
}
