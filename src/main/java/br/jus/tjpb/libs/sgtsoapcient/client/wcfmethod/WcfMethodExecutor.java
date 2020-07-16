package br.jus.tjpb.libs.sgtsoapcient.client.wcfmethod;

import br.jus.tjpb.libs.sgtsoapcient.client.ExtendedSoapSerializationEnvelope;
import com.easywsdl.exksoap2.transport.AdvancedHttpTransportSE;
import com.easywsdl.exksoap2.transport.AdvancedHttpsTransportSE;
import com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile;
import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapFault;
import org.ksoap2.transport.Transport;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

public class WcfMethodExecutor implements IWcfMethodExecutor {

    private static final Logger LOGGER = Logger.getLogger(WcfMethodExecutor.class.getSimpleName());

    private final String url;
    private final int timeout;
    private final boolean enableLogging;
    private final List<HeaderProperty> httpHeaders;

    public WcfMethodExecutor(String url, int timeout, boolean enableLogging, List<HeaderProperty> httpHeaders) {
        this.url = url;
        this.timeout = timeout;
        this.enableLogging = enableLogging;
        this.httpHeaders = httpHeaders;
    }

    @Override
    public Object execute(IWcfMethod wcfMethod, String methodName, WS_Profile profile) {
        Transport httpTransport = this.createTransport();
        httpTransport.debug = enableLogging;
        ExtendedSoapSerializationEnvelope envelope = wcfMethod.CreateSoapEnvelope();

        this.sendRequest(methodName, profile, httpTransport, envelope);

        if (envelope.bodyIn instanceof SoapFault) {
            throw new WcfMethodExecutionException((SoapFault) envelope.bodyIn);
        } else {
            return wcfMethod.ProcessResult(envelope, envelope.bodyIn);
        }
    }

    protected void sendRequest(String methodName, WS_Profile profile, Transport transport, ExtendedSoapSerializationEnvelope envelope) {
        try {
            if (transport instanceof AdvancedHttpTransportSE) {
                ((AdvancedHttpTransportSE) transport).call(methodName, envelope, this.httpHeaders, null, profile);
            } else {
                ((AdvancedHttpsTransportSE) transport).call(methodName, envelope, httpHeaders, null, profile);
            }
        } catch (XmlPullParserException | IOException e) {
            throw new WcfMethodExecutionException((SoapFault) envelope.bodyIn);
        } finally {
            if (transport.debug && transport.requestDump != null) {
                LOGGER.info(String.format("requestDump: %s", transport.requestDump));
            }
        }
    }

    protected Transport createTransport() {
        try {
            URI uri = new java.net.URI(this.url);
            if (uri.getScheme().equalsIgnoreCase("https")) {
                int port = uri.getPort() > 0 ? uri.getPort() : 443;
                return new AdvancedHttpsTransportSE(uri.getHost(), port, uri.getPath(), this.timeout);
            } else {
                return new AdvancedHttpTransportSE(this.url, this.timeout);
            }
        } catch (java.net.URISyntaxException e) {
            throw new WcfMethodExecutionException(e);
        }
    }
}
