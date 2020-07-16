package br.jus.tjpb.libs.sgtsoapcient.pesquisaritem;

import br.jus.tjpb.libs.sgtsoapcient.client.ExtendedSoapSerializationEnvelope;
import org.ksoap2.serialization.AttributeContainer;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.Hashtable;

public class ItemTO extends AttributeContainer implements KvmSerializable {

    private transient Object __source;

    public Integer cod_item = 0;

    public Integer cod_item_pai = 0;

    public String nome;

    public String dscGlossario;

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
        if (info.name.equals("cod_item")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.cod_item = Integer.parseInt(j.toString());
                    }
                } else if (obj instanceof Integer) {
                    this.cod_item = (Integer) obj;
                }
            }
            return true;
        }
        if (info.name.equals("cod_item_pai")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.cod_item_pai = Integer.parseInt(j.toString());
                    }
                } else if (obj instanceof Integer) {
                    this.cod_item_pai = (Integer) obj;
                }
            }
            return true;
        }
        if (info.name.equals("nome")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.nome = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.nome = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("dscGlossario")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.dscGlossario = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.dscGlossario = (String) obj;
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
    public Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if (propertyIndex == 0) {
            return cod_item;
        } else if (propertyIndex == 1) {
            return cod_item_pai;
        } else if (propertyIndex == 2) {
            return nome;
        } else if (propertyIndex == 3) {
            return dscGlossario;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 4;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        if (propertyIndex == 0) {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "cod_item";
            info.namespace = "";
        } else if (propertyIndex == 1) {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "cod_item_pai";
            info.namespace = "";
        } else if (propertyIndex == 2) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "nome";
            info.namespace = "";
        } else if (propertyIndex == 3) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "dscGlossario";
            info.namespace = "";
        }
    }

    @Override
    public void setProperty(int arg0, Object arg1) {
    }


}
