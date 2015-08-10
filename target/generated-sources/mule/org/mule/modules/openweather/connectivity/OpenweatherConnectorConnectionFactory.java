
package org.mule.modules.openweather.connectivity;

import javax.annotation.Generated;
import org.apache.commons.pool.KeyedPoolableObjectFactory;
import org.mule.api.context.MuleContextAware;
import org.mule.api.lifecycle.Disposable;
import org.mule.api.lifecycle.Initialisable;
import org.mule.api.lifecycle.Startable;
import org.mule.api.lifecycle.Stoppable;
import org.mule.modules.openweather.adapters.OpenweatherConnectorRestClientAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Generated(value = "Mule DevKit Version 3.5.1", date = "2015-07-24T03:29:30+05:30", comments = "Build UNNAMED.1967.45d0eb0")
public class OpenweatherConnectorConnectionFactory implements KeyedPoolableObjectFactory
{

    private static Logger logger = LoggerFactory.getLogger(OpenweatherConnectorConnectionFactory.class);
    private OpenweatherConnectorConnectionManager connectionManager;

    public OpenweatherConnectorConnectionFactory(OpenweatherConnectorConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public Object makeObject(Object key)
        throws Exception
    {
        if (!(key instanceof OpenweatherConnectorConnectionKey)) {
            if (key == null) {
                logger.warn("Connection key is null");
            } else {
                logger.warn("Cannot cast key of type ".concat(key.getClass().getName().concat(" to ").concat("org.mule.modules.openweather.connectivity.OpenweatherConnectorConnectionKey")));
            }
            throw new RuntimeException("Invalid key type ".concat(key.getClass().getName()));
        }
        OpenweatherConnectorRestClientAdapter connector = new OpenweatherConnectorRestClientAdapter();
        connector.setApiBaseURI(connectionManager.getApiBaseURI());
        connector.setApiVersion(connectionManager.getApiVersion());
        if (connector instanceof MuleContextAware) {
            ((MuleContextAware) connector).setMuleContext(connectionManager.getMuleContext());
        }
        if (connector instanceof Initialisable) {
            ((Initialisable) connector).initialise();
        }
        if (connector instanceof Startable) {
            ((Startable) connector).start();
        }
        if (connector instanceof MuleContextAware) {
            connector.setMuleContext((connectionManager.muleContext));
        }
        if (!connector.isConnected()) {
            connector.connect(((OpenweatherConnectorConnectionKey) key).getUsername(), ((OpenweatherConnectorConnectionKey) key).getPassword());
        }
        return connector;
    }

    public void destroyObject(Object key, Object obj)
        throws Exception
    {
        if (!(key instanceof OpenweatherConnectorConnectionKey)) {
            if (key == null) {
                logger.warn("Connection key is null");
            } else {
                logger.warn("Cannot cast key of type ".concat(key.getClass().getName().concat(" to ").concat("org.mule.modules.openweather.connectivity.OpenweatherConnectorConnectionKey")));
            }
            throw new RuntimeException("Invalid key type ".concat(key.getClass().getName()));
        }
        if (!(obj instanceof OpenweatherConnectorRestClientAdapter)) {
            if (obj == null) {
                logger.warn("Connector is null");
            } else {
                logger.warn("Cannot cast connector of type ".concat(obj.getClass().getName().concat(" to ").concat("org.mule.modules.openweather.adapters.OpenweatherConnectorRestClientAdapter")));
            }
            throw new RuntimeException("Invalid connector type ".concat(obj.getClass().getName()));
        }
        try {
            ((OpenweatherConnectorRestClientAdapter) obj).disconnect();
        } catch (Exception e) {
            throw e;
        } finally {
            if (((OpenweatherConnectorRestClientAdapter) obj) instanceof Stoppable) {
                ((Stoppable) obj).stop();
            }
            if (((OpenweatherConnectorRestClientAdapter) obj) instanceof Disposable) {
                ((Disposable) obj).dispose();
            }
        }
    }

    public boolean validateObject(Object key, Object obj) {
        if (!(obj instanceof OpenweatherConnectorRestClientAdapter)) {
            if (obj == null) {
                logger.warn("Connector is null");
            } else {
                logger.warn("Cannot cast connector of type ".concat(obj.getClass().getName().concat(" to ").concat("org.mule.modules.openweather.adapters.OpenweatherConnectorRestClientAdapter")));
            }
            throw new RuntimeException("Invalid connector type ".concat(obj.getClass().getName()));
        }
        try {
            return ((OpenweatherConnectorRestClientAdapter) obj).isConnected();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    public void activateObject(Object key, Object obj)
        throws Exception
    {
        if (!(key instanceof OpenweatherConnectorConnectionKey)) {
            throw new RuntimeException("Invalid key type");
        }
        if (!(obj instanceof OpenweatherConnectorRestClientAdapter)) {
            throw new RuntimeException("Invalid connector type");
        }
        try {
            if (!((OpenweatherConnectorRestClientAdapter) obj).isConnected()) {
                ((OpenweatherConnectorRestClientAdapter) obj).connect(((OpenweatherConnectorConnectionKey) key).getUsername(), ((OpenweatherConnectorConnectionKey) key).getPassword());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void passivateObject(Object key, Object obj)
        throws Exception
    {
    }

}
