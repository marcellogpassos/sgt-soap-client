package br.jus.tjpb.libs.sgtsoapcient.getarrayfilhositem;

import br.jus.tjpb.libs.sgtsoapcient.client.ExtendedSoapSerializationEnvelope;
import org.ksoap2.serialization.AttributeContainer;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.Hashtable;

public class ArvoreGenericaTO extends AttributeContainer implements KvmSerializable {

    private transient Object __source;

    public Integer seq_elemento = 0;

    public String dsc_elemento;

    public Integer seq_elemento_pai = 0;

    public String temFilhos;

    public String situacao;

    public ArrayOfArvoreGenericaTO filhos = new ArrayOfArvoreGenericaTO();

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
        if (info.name.equals("seq_elemento")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.seq_elemento = Integer.parseInt(j.toString());
                    }
                } else if (obj instanceof Integer) {
                    this.seq_elemento = (Integer) obj;
                }
            }
            return true;
        }
        if (info.name.equals("dsc_elemento")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.dsc_elemento = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.dsc_elemento = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("seq_elemento_pai")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.seq_elemento_pai = Integer.parseInt(j.toString());
                    }
                } else if (obj instanceof Integer) {
                    this.seq_elemento_pai = (Integer) obj;
                }
            }
            return true;
        }
        if (info.name.equals("temFilhos")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.temFilhos = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.temFilhos = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("situacao")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.situacao = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.situacao = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("filhos")) {
            if (obj != null) {
                Object j = obj;
                this.filhos = (ArrayOfArvoreGenericaTO) __envelope.get(j, ArrayOfArvoreGenericaTO.class, false);
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
            return seq_elemento;
        } else if (propertyIndex == 1) {
            return dsc_elemento;
        } else if (propertyIndex == 2) {
            return seq_elemento_pai;
        } else if (propertyIndex == 3) {
            return temFilhos;
        } else if (propertyIndex == 4) {
            return situacao;
        } else if (propertyIndex == 5) {
            return filhos;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 6;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        if (propertyIndex == 0) {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "seq_elemento";
            info.namespace = "";
        } else if (propertyIndex == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "dsc_elemento";
            info.namespace = "";
        } else if (propertyIndex == 2) {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "seq_elemento_pai";
            info.namespace = "";
        } else if (propertyIndex == 3) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "temFilhos";
            info.namespace = "";
        } else if (propertyIndex == 4) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "situacao";
            info.namespace = "";
        } else if (propertyIndex == 5) {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "filhos";
            info.namespace = "";
        }
    }

    @Override
    public void setProperty(int arg0, Object arg1) {
    }


}
