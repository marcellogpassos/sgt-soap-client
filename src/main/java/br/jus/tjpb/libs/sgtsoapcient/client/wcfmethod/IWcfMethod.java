package br.jus.tjpb.libs.sgtsoapcient.client.wcfmethod;

import br.jus.tjpb.libs.sgtsoapcient.client.ExtendedSoapSerializationEnvelope;

public interface IWcfMethod {

    ExtendedSoapSerializationEnvelope CreateSoapEnvelope();

    Object ProcessResult(ExtendedSoapSerializationEnvelope envelope, Object result);

    String getMethodName();
}
