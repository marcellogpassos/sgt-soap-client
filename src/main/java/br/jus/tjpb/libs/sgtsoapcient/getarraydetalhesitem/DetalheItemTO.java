package br.jus.tjpb.libs.sgtsoapcient.getarraydetalhesitem;

import br.jus.tjpb.libs.sgtsoapcient.client.ExtendedSoapSerializationEnvelope;
import org.ksoap2.serialization.AttributeContainer;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.Hashtable;

public class DetalheItemTO implements KvmSerializable {

    public String key;
    public String value;
    private transient java.lang.Object __source;

    public DetalheItemTO() {
    }

    public void loadFromSoap(Object paramObj, ExtendedSoapSerializationEnvelope __envelope) {
        if (paramObj == null)
            return;
        AttributeContainer inObj = (AttributeContainer) paramObj;
        __source = inObj;

        if (inObj instanceof SoapObject) {
            SoapObject soapObject = (SoapObject) inObj;
            int size = soapObject.getPropertyCount();
            for (int i0 = 0; i0 < size; i0++) {
                PropertyInfo info = soapObject.getPropertyInfo(i0);
                if (!loadProperty(info, soapObject, __envelope)) {
                }
            }
        }
    }

    protected boolean loadProperty(PropertyInfo info, SoapObject soapObject, ExtendedSoapSerializationEnvelope __envelope) {
        Object obj = info.getValue();
        if (info.name.equals("key")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.key = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.key = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("value")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.value = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.value = (String) obj;
                }
            }
            return true;
        }
        return false;
    }

    public Object getOriginalXmlSource() {
        return __source;
    }

    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if (propertyIndex == 0) {
            return key;
        } else if (propertyIndex == 1) {
            return value;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 2;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        if (propertyIndex == 0) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "key";
            info.namespace = "";
        } else if (propertyIndex == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "value";
            info.namespace = "";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1) {
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public Object get__source() {
        return this.__source;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void set__source(Object __source) {
        this.__source = __source;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof DetalheItemTO)) return false;
        final DetalheItemTO other = (DetalheItemTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$key = this.getKey();
        final Object other$key = other.getKey();
        if (this$key == null ? other$key != null : !this$key.equals(other$key)) return false;
        final Object this$value = this.getValue();
        final Object other$value = other.getValue();
        if (this$value == null ? other$value != null : !this$value.equals(other$value)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof DetalheItemTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $key = this.getKey();
        result = result * PRIME + ($key == null ? 43 : $key.hashCode());
        final Object $value = this.getValue();
        result = result * PRIME + ($value == null ? 43 : $value.hashCode());
        return result;
    }

    public String toString() {
        return "DetalheItem(key=" + this.getKey() + ", value=" + this.getValue() + ", __source=" + this.get__source() + ")";
    }
}
