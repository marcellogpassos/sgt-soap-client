package br.jus.tjpb.libs.sgtsoapcient.getcomplementomovimento;

import br.jus.tjpb.libs.sgtsoapcient.client.ExtendedSoapSerializationEnvelope;
import org.ksoap2.serialization.AttributeContainer;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.Hashtable;

public class ComplementoMovimentoTO extends AttributeContainer implements KvmSerializable {

    private transient Object __source;

    public Integer seqComplemento;

    public Integer seqTipoComplemento;

    public Integer seqComplMov;

    public String dscComplemento;

    public String dscObservacao;

    public String arrayValoresTabelados;

    public String arrayMovimentosVinculados;

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
        if (info.name.equals("seqComplemento")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.seqComplemento = Integer.parseInt(j.toString());
                    }
                } else if (obj instanceof Integer) {
                    this.seqComplemento = (Integer) obj;
                }
            }
            return true;
        }
        if (info.name.equals("seqTipoComplemento")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.seqTipoComplemento = Integer.parseInt(j.toString());
                    }
                } else if (obj instanceof Integer) {
                    this.seqTipoComplemento = (Integer) obj;
                }
            }
            return true;
        }
        if (info.name.equals("seqComplMov")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.seqComplMov = Integer.parseInt(j.toString());
                    }
                } else if (obj instanceof Integer) {
                    this.seqComplMov = (Integer) obj;
                }
            }
            return true;
        }
        if (info.name.equals("dscComplemento")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.dscComplemento = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.dscComplemento = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("dscObservacao")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.dscObservacao = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.dscObservacao = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("arrayValoresTabelados")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.arrayValoresTabelados = j.toString();
                    }
                } else {
                    this.arrayValoresTabelados = obj.toString();
                }
            }
            return true;
        }
        if (info.name.equals("arrayMovimentosVinculados")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.arrayMovimentosVinculados = j.toString();
                    }
                } else {
                    this.arrayMovimentosVinculados = obj.toString();
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
            return this.seqComplemento != null ? this.seqComplemento : SoapPrimitive.NullNilElement;
        } else if (propertyIndex == 1) {
            return this.seqTipoComplemento != null ? this.seqTipoComplemento : SoapPrimitive.NullNilElement;
        } else if (propertyIndex == 2) {
            return this.seqComplMov != null ? this.seqComplMov : SoapPrimitive.NullNilElement;
        } else if (propertyIndex == 3) {
            return this.dscComplemento != null ? this.dscComplemento : SoapPrimitive.NullNilElement;
        } else if (propertyIndex == 4) {
            return this.dscObservacao != null ? this.dscObservacao : SoapPrimitive.NullNilElement;
        } else if (propertyIndex == 5) {
            return this.arrayValoresTabelados != null ? this.arrayValoresTabelados : SoapPrimitive.NullNilElement;
        } else if (propertyIndex == 6) {
            return this.arrayMovimentosVinculados != null ? this.arrayMovimentosVinculados : SoapPrimitive.NullNilElement;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 7;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        if (propertyIndex == 0) {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "seqComplemento";
            info.namespace = "";
        } else if (propertyIndex == 1) {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "seqTipoComplemento";
            info.namespace = "";
        } else if (propertyIndex == 2) {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "seqComplMov";
            info.namespace = "";
        } else if (propertyIndex == 3) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "dscComplemento";
            info.namespace = "";
        } else if (propertyIndex == 4) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "dscObservacao";
            info.namespace = "";
        } else if (propertyIndex == 5) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "arrayValoresTabelados";
            info.namespace = "";
        } else if (propertyIndex == 6) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "arrayMovimentosVinculados";
            info.namespace = "";
        }
    }

    @Override
    public void setProperty(int arg0, Object arg1) {
    }

}
