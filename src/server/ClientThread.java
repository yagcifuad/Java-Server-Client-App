
package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author fuadyagci
 */
public class ClientThread extends Thread {

    Socket clientSocket;
    ArrayList<ClientThread> listOfClients;
   

    PrintWriter out;

    public ClientThread(Socket s, ArrayList<ClientThread> l) {
        clientSocket = s;
        listOfClients = l;
        this.setName("");
        
        //name = n;

    }

    @Override
    public void run() {
        super.run();
        try {
            System.out.println("New user connected and got port no " + clientSocket.getPort());
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            
            String inputLine;
            String outputLine;

            while ((inputLine = in.readLine()) != null) {
                outputLine = processTheRequest(inputLine);
                //out.println(outputLine);
                sendMessageToAllClients(outputLine);
                
                if (this.getName().equals("")) {
                this.setName(inputLine + this.clientSocket.getPort());   
                }
                
                if (inputLine.equals("Bye.")) {

                    listOfClients.remove(this);
                    out.println("exit");
                    System.out.println("User"+this.clientSocket.getPort()+" was disconnected, There are " + listOfClients.size() + " user.");
                    break;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendMessageToAllClients(String txt) {
        for (int i = 0; i < listOfClients.size(); i++) {
            ClientThread cl = listOfClients.get(i);
            cl.out.println(txt);
        }
    }

    private String processTheRequest(String command) {
        String response = "";
        switch (command) {
            case "list":
                 response = listOfUsers();
                break;
            case "messageToAll":
                 response = "Message.";
                break;
            case "messageToUser":
                 response = "Message.";
                break;
            case "memory":
                long totalMemory = Runtime.getRuntime().totalMemory();
                response = Long.toString(totalMemory);
                break;
            case "time":
                response = "Current time: "+ LocalTime.now();
                break;
            case "name":
                response = this.getName();
                break;
            default:
                response = this.getName() +": " +command;
                break;
        }
        return response;
    }
    
    private String listOfUsers(){
        String output = "List of users: ";
        
        for(int i =0; i<listOfClients.size();i++){
           int port_no = listOfClients.get(i).clientSocket.getPort();
        output = output + "/"+port_no;
        }
        return output;
    }

}
