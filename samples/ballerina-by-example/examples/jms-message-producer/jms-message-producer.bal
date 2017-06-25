import ballerina.net.jms;
import ballerina.lang.messages;

function main (string[] args) {
    jmsSender();
}

function jmsSender() (boolean) {
    // We define the connection properties as a map. 'providerUrl' and the 'factoryInitial' vary according to the JMS provider you use.
    // In this example we connect to the WSO2 MB server
    map properties = {
     "factoryInitial":"org.wso2.andes.jndi.PropertiesFileInitialContextFactory",
     "providerUrl":"../jndi.properties",
     "connectionFactoryJNDIName": "QueueConnectionFactory",
     "connectionFactoryType" : "queue"
    };
    // Create the JMS client Connector using the connection properties we defined earlier.
    jms:ClientConnector jmsEP = create jms:ClientConnector(properties);
    // Create an empty Ballerina message
    message queueMessage = {};
    // Set a string payload to the message
    messages:setStringPayload(queueMessage, "Hello from Ballerina!");
    // Send the Ballerina message to the JMS provider.
    jms:ClientConnector.send(jmsEP, "MyQueue", queueMessage);
    return true;
}
