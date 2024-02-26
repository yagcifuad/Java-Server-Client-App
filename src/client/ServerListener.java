package client;

import java.io.BufferedReader;
import static java.lang.System.in;

/**
 *
 * @author fuadyagci
 */
public class ServerListener extends Thread {

    BufferedReader in;

    public ServerListener(BufferedReader i) {
        in = i;
    }

    @Override
    public void run() {
        super.run();
        try {
            String response;
            while(true){
                response = in.readLine();
                if(response.equals("exit")){
                break;}
                
            System.out.println("echo: " + response);
            }
        } catch (Exception e) {
            System.out.println("Error is: " + e);
        }

    }

}
