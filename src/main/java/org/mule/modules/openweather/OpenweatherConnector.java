/**
 * (c) 2003-2014 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.openweather;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.mule.api.ConnectionException;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Connect;
import org.mule.api.annotations.ConnectionIdentifier;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Disconnect;
import org.mule.api.annotations.Mime;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.ReconnectOn;
import org.mule.api.annotations.Transformer;
import org.mule.api.annotations.ValidateConnection;
import org.mule.api.annotations.display.Password;
import org.mule.api.annotations.param.ConnectionKey;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.rest.HttpMethod;
import org.mule.api.annotations.rest.RestCall;
import org.mule.api.annotations.rest.RestQueryParam;
import org.mule.api.annotations.rest.RestUriParam;

/**
 * Anypoint Connector
 *
 * @author MuleSoft, Inc.
 */
@Connector(name="openweather", schemaVersion="1.0", friendlyName="Openweather")
public abstract class OpenweatherConnector
{
    /**
     * Configurable
     */
	@Configurable
	@Default("http://api.openweathermap.org/data/")
	@RestUriParam("apiBaseURI")
    private String apiBaseURI;
	
	@Configurable
	@RestUriParam("apiVersion")
	@Default("2.5")
	private String apiVersion;


	/**
     * Set apiBaseURI
     *
     * @param apiBaseURI 
     */
    public void setApiBaseURI(String apiBaseURI) {
        this.apiBaseURI = apiBaseURI;
    }
    
    /**
     * Set apiVersion
     *
     * @param apiVersion 
     */
    public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}
    
    /**
     * Get apiBaseURI
     */
    
    public String getApiBaseURI() {
        return this.apiBaseURI;
    }
    
    /**
     * Get apiVersion
     */
    public String getApiVersion() {
		return apiVersion;
	}

	

	/**
     * currentWeatherOfStation
     *
     * {@sample.xml ../../../doc/openweather-connector.xml.sample openweather:current-Weather-of-station}
     *
     * @param content Content to be processed
     * @return Some string
     * @throws IOException Comment for Exception
     */
    @Processor
    @ReconnectOn(exceptions = { Exception.class })
    @Mime("application/json")
    @RestCall(uri="{apiBaseURI}/{apiVersion}/station?id={id}", method=HttpMethod.GET,contentType = "application/json")
    public abstract Object currentWeatherOfStation(@RestQueryParam("id") String id) throws IOException;  


    
    /**
     * currentWeatherOfCity
     *
     * {@sample.xml ../../../doc/openweather-connector.xml.sample openweather:current-Weather-of-city}
     *
     * @param content Content to be processed
     * @return Some string
     * @throws IOException Comment for Exception
     */
    @Processor
    @ReconnectOn(exceptions = { Exception.class })
    @Mime("application/json")
    @RestCall(uri="{apiBaseURI}/{apiVersion}/weather?q={q}", method=HttpMethod.GET,contentType = "application/json")
    public abstract Object currentWeatherOfCity(@RestQueryParam("q") String query) throws IOException;
    
    /**
     * LangitudeAndLatitude
     *
     * {@sample.xml ../../../doc/openweather-connector.xml.sample openweather:current-Weather-of-LangitudeAndLatitude}
     *
     * @param content Content to be processed
     * @return Some string
     * @throws IOException Comment for Exception
     */
    @Processor
    @ReconnectOn(exceptions = { Exception.class })
    @Mime("application/json")
    @RestCall(uri="{apiBaseURI}/{apiVersion}/weather?lat={latitude}&lon={longitude}&cnt={count}", method=HttpMethod.GET,contentType = "application/json")
    public abstract Object currentWeatherforLangitudeAndLatitude(@RestQueryParam("latitude") String latitude, @RestQueryParam("longitude") String longitude, @RestQueryParam("count") String count) throws IOException;
    
    
    /**
     * Connect
     *
     * @param username A username
     * @param password A password
     * @throws ConnectionException
     */
    @Connect
    public void connect(@ConnectionKey String username, @Password String password)
        throws ConnectionException {
        /*
         * CODE FOR ESTABLISHING A CONNECTION GOES IN HERE
         */
    }

    /**
     * Disconnect
     */
    @Disconnect
    public void disconnect() {
        /*
         * CODE FOR CLOSING A CONNECTION GOES IN HERE
         */
    }

    /**
     * Are we connected
     */
    @ValidateConnection
    public boolean isConnected() {
        //TODO: Change it to reflect that we are connected.
        return true;
    }

    /**
     * Are we connected
     */
    @ConnectionIdentifier
    public String connectionId() {
        return "001";
    }
    
}