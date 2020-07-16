package br.jus.tjpb.libs.sgtsoapcient.getdataultimaversao;

import br.jus.tjpb.libs.sgtsoapcient.client.AbstractSoapService;
import br.jus.tjpb.libs.sgtsoapcient.client.IConverter;
import br.jus.tjpb.libs.sgtsoapcient.client.wcfmethod.IWcfMethod;
import org.ksoap2.serialization.PropertyInfo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

public class GetDataUltimaVersaoService extends AbstractSoapService<String, LocalDate> {

    private static final String DATE_FORMAT = "dd/MM/yyyy";

    public GetDataUltimaVersaoService(String methodNamespace, boolean enableLogging, int timeout) {
        super(methodNamespace, enableLogging, timeout);
    }

    @Override
    protected String getMethodName() {
        return "getDataUltimaVersao";
    }

    @Override
    protected IWcfMethod getWcfMethod(Object... params) {
        return new GetDataUltimaVersaoMethod(
                this.methodNamespace,
                this.getMethodName(),
                this.createProperties(params),
                String.class);
    }

    @Override
    protected boolean validParams(Object... params) {
        return true;
    }

    @Override
    protected List<PropertyInfo> createProperties(Object... params) {
        return Collections.emptyList();
    }

    @Override
    protected IConverter<String, LocalDate> getConverter() {
        return input -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
            return LocalDate.parse(input, formatter);
        };
    }
}
