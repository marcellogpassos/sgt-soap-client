package br.jus.tjpb.libs.sgtsoapcient;

public class SgtSoapClientDefaultProperties {

    public static final String ENDPOINT = "https://www.cnj.jus.br/sgt/sgt_ws.php";
    public static final String WSDL = "https://www.cnj.jus.br/sgt/sgt_ws.php?wsdl";
    public static final boolean ENABLE_LOGGING = false;
    public static final int TIMEOUT = 60000;

    public static final SgtSoapClient CLIENT = new SgtSoapClient(ENDPOINT, ENABLE_LOGGING, TIMEOUT);

    private SgtSoapClientDefaultProperties() {
        throw new UnsupportedOperationException();
    }
}
