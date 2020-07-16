package br.jus.tjpb.libs.sgtsoapcient.getarrayfilhositem;

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

public class GetArrayFilhosItemService extends AbstractSoapService<ArrayOfArvoreGenericaTO, Collection<ArvoreGenerica>> {

    public GetArrayFilhosItemService(String methodNamespace, boolean enableLogging, int timeout) {
        super(methodNamespace, enableLogging, timeout);
    }

    @Override
    protected String getMethodName() {
        return "getArrayFilhosItemPublicoWS";
    }

    @Override
    protected IWcfMethod getWcfMethod(Object... params) {
        return new DefaultWcfMethod(
                this.methodNamespace,
                this.getMethodName(),
                this.createProperties(params),
                ArrayOfArvoreGenericaTO.class);
    }

    @Override
    protected boolean validParams(Object... params) {
        return Objects.nonNull(params) &&
                params.length == 2 &&
                Objects.nonNull(params[0]) &&
                Objects.nonNull(params[1]) &&
                params[0] instanceof Integer &&
                params[1] instanceof String &&
                ((String) params[1]).trim().length() == 1;
    }

    @Override
    protected List<PropertyInfo> createProperties(Object... params) {
        return Arrays.asList(this.createProperty("seqItem", params[0], PropertyInfo.INTEGER_CLASS),
                this.createProperty("tipoItem", params[1], PropertyInfo.STRING_CLASS));
    }

    @Override
    protected IConverter<ArrayOfArvoreGenericaTO, Collection<ArvoreGenerica>> getConverter() {
        return input -> {
            Set<ArvoreGenerica> output = new HashSet<>();
            for (ArvoreGenericaTO element : input) {
                output.add(new ArvoreGenerica(element.seq_elemento, element.dsc_elemento,
                        element.seq_elemento_pai, element.temFilhos, element.situacao));
            }
            return output;
        };
    }
}
