
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.in;
import java.net.Socket;

/**
 *
 * @author fuadyagci
 */
public class StartTheClient {
    public static void main (String args []) throws IOException {
    String hostName = "127.0.0.1";
    int portNumber = 1234;
    

try {
    Socket echoSocket = new Socket(hostName, portNumber);        
    PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

    ServerListener readThread = new ServerListener(in);
        readThread.start();
    
    ///Name
    
    System.out.println("Please enter your name:");

// Read the user's input from standard input
    String name = stdIn.readLine();

// Send the user's name to the server
out.println(name);

    String userInput;
    while ((userInput = stdIn.readLine()) != null) {
        out.println(userInput);
        if(userInput.equals("Bye.")){
        readThread.interrupt();
        break;
        }
        
    // none - System.out.println("echo: " + in.readLine());
}
    
    
    
} catch(Exception e){System.out.println("Something");
        
        }
    } 
}
    

    

