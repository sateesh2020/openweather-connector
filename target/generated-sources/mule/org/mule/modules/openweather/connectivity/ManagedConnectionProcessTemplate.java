
package org.mule.modules.openweather.connectivity;

import javax.annotation.Generated;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessInterceptor;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.openweather.adapters.OpenweatherConnectorConnectionIdentifierAdapter;
import org.mule.modules.openweather.connection.ConnectionManager;
import org.mule.modules.openweather.process.ManagedConnectionProcessInterceptor;
import org.mule.security.oauth.callback.ProcessCallback;
import org.mule.security.oauth.process.ProcessCallbackProcessInterceptor;
import org.mule.security.oauth.process.RetryProcessInterceptor;

@Generated(value = "Mule DevKit Version 3.5.1", date = "2015-07-24T03:29:30+05:30", comments = "Build UNNAMED.1967.45d0eb0")
public class ManagedConnectionProcessTemplate<P >implements ProcessTemplate<P, OpenweatherConnectorConnectionIdentifierAdapter>
{

    private final ProcessInterceptor<P, OpenweatherConnectorConnectionIdentifierAdapter> processInterceptor;

    public ManagedConnectionProcessTemplate(ConnectionManager<OpenweatherConnectorConnectionKey, OpenweatherConnectorConnectionIdentifierAdapter> connectionManager, MuleContext muleContext) {
        ProcessInterceptor<P, OpenweatherConnectorConnectionIdentifierAdapter> processCallbackProcessInterceptor = new ProcessCallbackProcessInterceptor<P, OpenweatherConnectorConnectionIdentifierAdapter>();
        ProcessInterceptor<P, OpenweatherConnectorConnectionIdentifierAdapter> managedConnectionProcessInterceptor = new ManagedConnectionProcessInterceptor<P>(processCallbackProcessInterceptor, connectionManager, muleContext);
        ProcessInterceptor<P, OpenweatherConnectorConnectionIdentifierAdapter> retryProcessInterceptor = new RetryProcessInterceptor<P, OpenweatherConnectorConnectionIdentifierAdapter>(managedConnectionProcessInterceptor, muleContext, connectionManager.getRetryPolicyTemplate());
        processInterceptor = retryProcessInterceptor;
    }

    public P execute(ProcessCallback<P, OpenweatherConnectorConnectionIdentifierAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
        return processInterceptor.execute(processCallback, null, messageProcessor, event);
    }

    public P execute(ProcessCallback<P, OpenweatherConnectorConnectionIdentifierAdapter> processCallback, Filter filter, MuleMessage message)
        throws Exception
    {
        return processInterceptor.execute(processCallback, null, filter, message);
    }

}
