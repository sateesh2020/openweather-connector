
package org.mule.modules.openweather.adapters;

import javax.annotation.Generated;
import org.mule.modules.openweather.OpenweatherConnector;
import org.mule.modules.openweather.connection.Connection;


/**
 * A <code>OpenweatherConnectorConnectionIdentifierAdapter</code> is a wrapper around {@link OpenweatherConnector } that implements {@link org.mule.devkit.dynamic.api.helper.Connection} interface.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.1", date = "2015-07-24T03:29:30+05:30", comments = "Build UNNAMED.1967.45d0eb0")
public abstract class OpenweatherConnectorConnectionIdentifierAdapter
    extends OpenweatherConnectorProcessAdapter
    implements Connection
{


    public String getConnectionIdentifier() {
        return super.connectionId();
    }

}
