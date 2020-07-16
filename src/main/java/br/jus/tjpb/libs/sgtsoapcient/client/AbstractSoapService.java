package br.jus.tjpb.libs.sgtsoapcient.client;

import br.jus.tjpb.libs.sgtsoapcient.client.wcfmethod.IWcfMethod;
import br.jus.tjpb.libs.sgtsoapcient.client.wcfmethod.IWcfMethodExecutor;
import br.jus.tjpb.libs.sgtsoapcient.client.wcfmethod.WcfMethodExecutor;
import com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile;
import org.ksoap2.HeaderProperty;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class AbstractSoapService<T, R> {

    protected final String url;
    protected final String methodNamespace;
    protected final boolean enableLogging;
    protected final int timeout;
    protected final List<HeaderProperty> headers;
    protected final WS_Profile profile;

    protected final IWcfMethodExecutor wcfMethodExecutor;

    protected AbstractSoapService(String methodNamespace, boolean enableLogging, int timeout) {
        this(methodNamespace, methodNamespace, enableLogging, timeout, Collections.emptyList(), new WS_Profile());
    }

    private AbstractSoapService(String url, String methodNamespace, boolean enableLogging, int timeout,
                                List<HeaderProperty> headers, WS_Profile profile) {
        this.url = url;
        this.methodNamespace = methodNamespace;
        this.enableLogging = enableLogging;
        this.timeout = timeout;
        this.headers = headers;
        this.profile = profile;
        this.wcfMethodExecutor = new WcfMethodExecutor(url, timeout, enableLogging, headers);
    }

    protected abstract String getMethodName();

    protected abstract IWcfMethod getWcfMethod(Object... params);

    protected abstract boolean validParams(Object... params);

    protected abstract List<PropertyInfo> createProperties(Object... params);

    protected abstract IConverter<T, R> getConverter();

    public R run() {
        return this.run(new Object[]{});
    }

    public R run(Object... params) {
        if (this.validParams(params)) {
            IWcfMethod wcfMethod = this.getWcfMethod(params);
            return this.getConverter().convert((T) this.wcfMethodExecutor
                    .execute(wcfMethod, wcfMethod.getMethodName(), this.profile));
        } else {
            throw new IllegalArgumentException();
        }
    }

    protected PropertyInfo createProperty(String propertyName, Object propertyValue, Class<?> propertyClass) {
        PropertyInfo info = new PropertyInfo();
        info.namespace = "";
        info.name = propertyName;
        info.type = propertyClass;
        info.setValue(Optional.ofNullable(propertyValue).orElse(SoapPrimitive.NullNilElement.toString()));
        return info;
    }

    public String getUrl() {
        return this.url;
    }

    public String getMethodNamespace() {
        return this.methodNamespace;
    }

    public boolean isEnableLogging() {
        return this.enableLogging;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public List<HeaderProperty> getHeaders() {
        return this.headers;
    }

    public WS_Profile getProfile() {
        return this.profile;
    }

    public IWcfMethodExecutor getWcfMethodExecutor() {
        return this.wcfMethodExecutor;
    }
}
