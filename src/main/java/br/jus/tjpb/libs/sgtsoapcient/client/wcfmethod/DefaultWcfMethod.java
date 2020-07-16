package br.jus.tjpb.libs.sgtsoapcient.client.wcfmethod;

import br.jus.tjpb.libs.sgtsoapcient.client.ExtendedSoapSerializationEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.ksoap2.SoapEnvelope.VER11;

public class DefaultWcfMethod implements IWcfMethod {

    protected final String methodNamespace;
    protected final String methodName;
    protected final List<PropertyInfo> properties;
    protected final Class<?> clazz;

    public DefaultWcfMethod(String methodNamespace, String methodName, List<PropertyInfo> properties, Class<?> clazz) {
        this.methodNamespace = methodNamespace;
        this.methodName = methodName;
        this.properties = properties;
        this.clazz = clazz;
    }

    @Override
    public ExtendedSoapSerializationEnvelope CreateSoapEnvelope() {
        ExtendedSoapSerializationEnvelope essEnvelope = this.createEnvelope();
        SoapObject soapReq = new SoapObject(this.methodNamespace, this.methodName);
        essEnvelope.setOutputSoapObject(soapReq);
        this.properties.forEach(soapReq::addProperty);
        return essEnvelope;
    }

    @Override
    public Object ProcessResult(ExtendedSoapSerializationEnvelope envelope, Object result) {
        return this.getResult(this.clazz, result, "return", envelope);
    }

    @Override
    public String getMethodName() {
        return String.format("%s#%s", this.methodNamespace, this.methodName);
    }

    protected ExtendedSoapSerializationEnvelope createEnvelope() {
        return new ExtendedSoapSerializationEnvelope(VER11);
    }

    protected Object getResult(Class<?> objClass, Object source, String resultName, ExtendedSoapSerializationEnvelope envelope) {
        if (Objects.nonNull(source)) {
            if (source instanceof SoapPrimitive) {
                SoapPrimitive soap = (SoapPrimitive) source;
                if (soap.getName().equals(resultName)) {
                    return envelope.get(source, objClass, false);
                }
            } else {
                SoapObject soap = (SoapObject) source;
                if (soap.hasProperty(resultName)) {
                    return Optional.ofNullable(soap.getProperty(resultName))
                            .map(j -> envelope.get(j, objClass, false))
                            .orElse(null);
                } else if (soap.getName().equals(resultName)) {
                    return envelope.get(source, objClass, false);
                }
            }
        }
        return null;
    }
}
