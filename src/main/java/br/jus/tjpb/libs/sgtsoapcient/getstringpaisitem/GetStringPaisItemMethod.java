package br.jus.tjpb.libs.sgtsoapcient.getstringpaisitem;

import br.jus.tjpb.libs.sgtsoapcient.client.ExtendedSoapSerializationEnvelope;
import br.jus.tjpb.libs.sgtsoapcient.client.wcfmethod.DefaultWcfMethod;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.List;
import java.util.Objects;

public class GetStringPaisItemMethod extends DefaultWcfMethod {

    public GetStringPaisItemMethod(String methodNamespace, String methodName, List<PropertyInfo> properties, Class<?> clazz) {
        super(methodNamespace, methodName, properties, clazz);
    }

    @Override
    protected Object getResult(Class<?> objClass, Object source, String resultName, ExtendedSoapSerializationEnvelope envelope) {
        SoapObject soap = (SoapObject) source;
        Object obj = soap.getProperty("return");
        if (Objects.nonNull(obj) && obj.getClass().equals(SoapPrimitive.class)) {
            SoapPrimitive j = (SoapPrimitive) obj;
            return j.toString();
        } else if (obj instanceof String) {
            return obj;
        }
        return null;
    }
}
