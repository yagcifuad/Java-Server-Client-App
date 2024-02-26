/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.net.ServerSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
/**
 *
 * @author fuadyagci
 */
public class StartTheServer {
    public static void main (String a[]){
        
        try{
            ServerSocket serverSocket = new ServerSocket(1234);
            ArrayList<ClientThread> clientList = new ArrayList();
            
            
            
            
      
             
            while (true) {
            Socket clientSocket = serverSocket.accept();
            ClientThread client = new ClientThread(clientSocket, clientList);
            clientList.add(client);
            System.out.println("There are"+ clientList.size()+" client connected to server.");
             client.start();
             }
       
        } catch(Exception e){
        System.out.println("Klaida");
        }
    
    }
}
