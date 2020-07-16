package br.jus.tjpb.libs.sgtsoapcient.getcomplementomovimento;

import br.jus.tjpb.libs.sgtsoapcient.client.AbstractSoapService;
import br.jus.tjpb.libs.sgtsoapcient.client.IConverter;
import br.jus.tjpb.libs.sgtsoapcient.client.wcfmethod.DefaultWcfMethod;
import br.jus.tjpb.libs.sgtsoapcient.client.wcfmethod.IWcfMethod;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class GetComplementoMovimentoService extends AbstractSoapService<ArrayOfComplementoMovimentoTO, Collection<ComplementoMovimento>> {

    public GetComplementoMovimentoService(String methodNamespace, boolean enableLogging, int timeout) {
        super(methodNamespace, enableLogging, timeout);
    }

    @Override
    protected String getMethodName() {
        return "getComplementoMovimentoWS";
    }

    @Override
    protected IWcfMethod getWcfMethod(Object... params) {
        return new DefaultWcfMethod(
                this.methodNamespace,
                this.getMethodName(),
                this.createProperties(params),
                ArrayOfComplementoMovimentoTO.class);
    }

    @Override
    protected boolean validParams(Object... params) {
        return Objects.nonNull(params) &&
                params.length == 1 &&
                Objects.nonNull(params[0]) &&
                params[0] instanceof Integer;
    }

    @Override
    protected List<PropertyInfo> createProperties(Object... params) {
        return Collections.singletonList(this.createProperty("codMovimento", params[0], PropertyInfo.INTEGER_CLASS));
    }

    @Override
    protected IConverter<ArrayOfComplementoMovimentoTO, Collection<ComplementoMovimento>> getConverter() {
        return input -> {
            Set<ComplementoMovimento> output = new HashSet<>();
            for (ComplementoMovimentoTO element : input) {
                output.add(new ComplementoMovimento(element.seqComplemento, element.seqTipoComplemento,
                        element.seqComplMov, element.dscComplemento, element.dscObservacao,
                        element.arrayValoresTabelados, element.arrayMovimentosVinculados));
            }
            return output;
        };
    }
}
