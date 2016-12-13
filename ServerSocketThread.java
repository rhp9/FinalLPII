import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerSocketThread extends Thread{
	
	private Socket socket;
	private int id;
	private boolean die;
	private boolean pause;
	 int x=0;
	 String [] asientos = new String [100];
	 private PrintWriter archivoSalida;

	public ServerSocketThread(int id,Socket socket) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.socket=socket;
	}

	public void run(){
		System.out.println("ServerSocket: Arrancando");
		while(!die){
			while(!pause){
				
				try {
					PrintWriter out=new PrintWriter(socket.getOutputStream(), true);
					BufferedReader br = new BufferedReader(new FileReader("Asientos.txt"));
					DataOutputStream dos= new DataOutputStream(socket.getOutputStream());
					String line ="";
					
		            while(line != null){
		                line=br.readLine();
		                
		                if(line!=null){
		                	System.out.println("Server: enviando la linea : " + line);
		                	dos.writeBytes(line+"\nEOL\n");
		                }
		            }
		            System.out.println("enviado");
					br.close();
					
					
					BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
					BufferedWriter bw;
					String line1="";
					//File file= new File("Asientos.txt");
					//FileWriter fw=new FileWriter(file,true);
					
					//bw = new BufferedWriter(new FileWriter("Asientos.txt"));
					while((line1 = input.readLine())!=null)
					{
						boolean contains = line1.contains("EOL");
			            
			            if(contains)
			            {
			            	break;
			            }
			             asientos= line1.split(";");
			             for(int k=0;k<asientos.length;k++)
			             {
			            	 System.out.println("\nArreglo asientos["+k+"] = "+asientos[k]);
			             }
			            System.out.println("Server: "+asientos[0]);
				         
					}
					input.close();
					
					archivoSalida = new PrintWriter(new FileWriter("Asientos.txt",false));
					
					for(int i=0; i<16;i++)
					{
						 System.out.println("Server2file : "+asientos[i]);
						archivoSalida.print(asientos[i]+";");
					}
					
					//bw.close();
					archivoSalida.close();
		
				} catch (IOException e) {
					e.printStackTrace();
				} 
				
				pause=true;
				die=true;
			   }
				
			}
		}
	}
