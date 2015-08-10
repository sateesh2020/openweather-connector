
package org.mule.modules.openweather.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.openweather.OpenweatherConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>OpenweatherConnectorProcessAdapter</code> is a wrapper around {@link OpenweatherConnector } that enables custom processing strategies.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.1", date = "2015-07-24T03:29:30+05:30", comments = "Build UNNAMED.1967.45d0eb0")
public abstract class OpenweatherConnectorProcessAdapter
    extends OpenweatherConnectorLifecycleAdapter
    implements ProcessAdapter<OpenweatherConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, OpenweatherConnectorCapabilitiesAdapter> getProcessTemplate() {
        final OpenweatherConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,OpenweatherConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, OpenweatherConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, OpenweatherConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
