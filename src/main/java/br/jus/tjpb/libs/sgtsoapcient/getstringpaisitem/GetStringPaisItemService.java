package br.jus.tjpb.libs.sgtsoapcient.getstringpaisitem;

import br.jus.tjpb.libs.sgtsoapcient.client.AbstractSoapService;
import br.jus.tjpb.libs.sgtsoapcient.client.IConverter;
import br.jus.tjpb.libs.sgtsoapcient.client.wcfmethod.IWcfMethod;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class GetStringPaisItemService extends AbstractSoapService<String, Collection<String>> {

    public GetStringPaisItemService(String methodNamespace, boolean enableLogging, int timeout) {
        super(methodNamespace, enableLogging, timeout);
    }

    @Override
    protected String getMethodName() {
        return "getStringPaisItemPublicoWS";
    }

    @Override
    protected IWcfMethod getWcfMethod(Object... params) {
        return new GetStringPaisItemMethod(
                this.methodNamespace,
                this.getMethodName(),
                this.createProperties(params),
                String.class);
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
    protected IConverter<String, Collection<String>> getConverter() {
        return input -> Optional.ofNullable(input)
                .map(pais -> Arrays.asList(input.split(",")))
                .orElse(Collections.emptyList());
    }
}
