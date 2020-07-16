package br.jus.tjpb.libs.sgtsoapcient.getarrayfilhositem;

import br.jus.tjpb.libs.sgtsoapcient.SgtSoapClientDefaultProperties;
import br.jus.tjpb.libs.sgtsoapcient.client.ExtendedSoapSerializationEnvelope;
import org.ksoap2.serialization.AttributeContainer;
import org.ksoap2.serialization.AttributeInfo;
import org.ksoap2.serialization.HasAttributes;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.Hashtable;
import java.util.Vector;

public class ArrayOfArvoreGenericaTO extends Vector<ArvoreGenericaTO> implements KvmSerializable, HasAttributes {

    private transient Object __source;

    public void loadFromSoap(Object inObj, ExtendedSoapSerializationEnvelope __envelope) {
        if (inObj == null)
            return;
        __source = inObj;

        if (inObj instanceof Vector) {
            Vector list = (Vector) inObj;
            for (int i0 = 0; i0 < list.size(); i0++) {
                Object j = list.get(i0);
                if (j != null) {
                    ArvoreGenericaTO j1 = (ArvoreGenericaTO) __envelope.get(j, ArvoreGenericaTO.class, false);
                    add(j1);
                }
            }
        } else {
            SoapObject soapObject = (SoapObject) inObj;
            int size = soapObject.getPropertyCount();
            for (int i0 = 0; i0 < size; i0++) {
                Object obj = soapObject.getProperty(i0);
                if (obj != null && obj instanceof AttributeContainer) {
                    AttributeContainer j = (AttributeContainer) soapObject.getProperty(i0);
                    ArvoreGenericaTO j1 = (ArvoreGenericaTO) __envelope.get(j, ArvoreGenericaTO.class, false);
                    add(j1);
                }
            }
        }
    }

    public Object getSourceObject() {
        return __source;
    }

    @Override
    public Object getProperty(int arg0) {
        return this.get(arg0) != null ? this.get(arg0) : SoapPrimitive.NullNilElement;
    }

    @Override
    public int getPropertyCount() {
        return this.size();
    }

    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        info.name = "ArvoreGenerica";
        info.type = ArvoreGenericaTO.class;
        info.namespace = SgtSoapClientDefaultProperties.ENDPOINT;
    }

    @Override
    public void setProperty(int arg0, Object arg1) {
    }

    @Override
    public int getAttributeCount() {
        return 4;
    }

    @Override
    public void getAttributeInfo(int index, AttributeInfo info) {
        if (index == 0) {
            info.name = "type";
            info.namespace = "http://www.w3.org/2001/XMLSchema-instance";
            info.setValue("xx2:ArrayOfArvoreGenerica");
        }
        if (index == 1) {
            info.name = "arrayType";
            info.namespace = "http://schemas.xmlsoap.org/soap/encoding/";
            info.setValue("xx1:ArvoreGenerica[]");
        }
        if (index == 2) {
            info.name = "xmlns:xx1";
            info.namespace = "";
            info.setValue(SgtSoapClientDefaultProperties.ENDPOINT);
        }
        if (index == 3) {
            info.name = "xmlns:xx2";
            info.namespace = "";
            info.setValue(SgtSoapClientDefaultProperties.ENDPOINT);
        }
    }

    @Override
    public void getAttribute(int i, AttributeInfo attributeInfo) {

    }

    @Override
    public void setAttribute(AttributeInfo attributeInfo) {

    }
}
