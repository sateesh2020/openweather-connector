
package org.mule.modules.openweather.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * Registers bean definitions parsers for handling elements in <code>http://www.mulesoft.org/schema/mule/openweather</code>.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.1", date = "2015-07-24T03:29:30+05:30", comments = "Build UNNAMED.1967.45d0eb0")
public class OpenweatherNamespaceHandler
    extends NamespaceHandlerSupport
{

    private static Logger logger = LoggerFactory.getLogger(OpenweatherNamespaceHandler.class);

    private void handleException(String beanName, String beanScope, NoClassDefFoundError noClassDefFoundError) {
        String muleVersion = "";
        try {
            muleVersion = MuleManifest.getProductVersion();
        } catch (Exception _x) {
            logger.error("Problem while reading mule version");
        }
        logger.error(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [openweather] is not supported in mule ")+ muleVersion));
        throw new FatalBeanException(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [openweather] is not supported in mule ")+ muleVersion), noClassDefFoundError);
    }

    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after construction but before any custom elements are parsed. 
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     * 
     */
    public void init() {
        try {
            this.registerBeanDefinitionParser("config", new OpenweatherConnectorConfigDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("config", "@Config", ex);
        }
        try {
            this.registerBeanDefinitionParser("current-weather-of-station", new CurrentWeatherOfStationDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("current-weather-of-station", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("current-weather-of-city", new CurrentWeatherOfCityDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("current-weather-of-city", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("current-weatherfor-langitude-and-latitude", new CurrentWeatherforLangitudeAndLatitudeDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("current-weatherfor-langitude-and-latitude", "@Processor", ex);
        }
    }

}
