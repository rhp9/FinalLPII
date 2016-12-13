import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.CharBuffer;
import java.util.Scanner;

public class Server extends Thread{
	
	ServerSocket serverSocket;
	private boolean die;
	private boolean pause;

	public void init() {
		
		File f = new File("Asientos.txt"); 
		if(f.exists() && f.isFile()) {
			
			System.out.println("Leyendo datos de archivo preexistente");
		}
		else{
			BufferedWriter bw;
			File f1;
			FileWriter fw;
			System.out.println("Por crear archivo");
			try {
				f1=new File("Asientos.txt");
				
				if(!f1.exists()){
					System.out.println("Creando archivo");
					f1.createNewFile();
				}
				fw=new FileWriter(f1);
				//bw = new BufferedWriter();
				
				fw.write("False;False;False;False;False;False;False;False;False;False;False;False;False;False;False;False;\nEOF\n");
				
				fw.flush();
				fw.close();
				System.out.println("Finalizo creacion de archivo");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.start();
	}
	

	@Override
	public void run(){
		int k=0;
		while(!die){
			while(!pause){
				if(serverSocket==null){
					try {
						serverSocket=new ServerSocket(60000);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				try {
					Socket socket=serverSocket.accept();
				

					ServerSocketThread sst=new ServerSocketThread(k,socket);
					k++;
					sst.start();
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
			
		}
		
	}

}