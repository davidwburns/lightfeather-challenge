Shift Cipher Server 

author: David Wilson-Burns
 
I chose java for its portability and Spring Boot because it can be dropped anywhere and run as a server.

The project consists of 
--ShiftCipherController - a controller to expose the /api/encode endpoint
--ShifterService - a service interface to decouple and expose writeCipher() and shift() functions for injection
--ShifterServerImpl - an implementation of the service for the code in writeCipher() and shift()
--Message - a DTO (Data Transfer Object) to handle JSON mapping
--LightFeatherShifterServiceApplication - the main class to launch the server
--POM.xml - Builds the server executable
--application.properties - configures the port as 23456

Flow 

--The server starts up using the startShiftServer.bat or .sh 
--A POST with json to http://localhost:23456/api/encode will be picked up by the encode() method and mapped to the Message class using the FasterXML api. 
--The method first validates that the required elements "Shift" and "Message" are present. 
--If not, it returns a 500 error with an empty JSON using Google's JSON api with a key of "EncodedMessage"; 
--otherwise, it calls the shift method to perform the shift cipher operation which returns the encoded message. 
--Then it writes the message to a file called ciphered-message.txt which will be located in the same the server was started. 
--If there are errors, it returns a 500 and the empty JSON element as before.
--If all goes well, add the shifted (encoded) message to the JSON with the key "EncodedMessage" and return as a 200 status;

To run:

--Install Java, Maven,and GIT
--Add the bins to the system path
--use terminal to execute "git clone https://github.com/davidwburns/lightfeather-challenge.git"
--use a terminal to go to the project directory lightfeather-shifter-service
--execute "mvn install"
--execute the runShiftServer script to start the server
--service is ready!
