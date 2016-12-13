import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Client1  
{
	private boolean die;
	private boolean pause;
	private String ip;
	private int port;
	private int id;
	Socket socket;
	 int x=0;
	 String [] asientos = new String [17];
	 String datos="";
	
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
	
	JFrame applicationFrame;

    Thread someThread;
    
    public void init() {
		// TODO Auto-generated method stub
		someThread.start();
	}
    
    public Client1(int id,String ip, int port) 
    {
    	this.id=id;
		this.ip=ip;
		this.port=port;
    	
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
            	try {
					Thread.sleep(1000);
				
            	
                applicationFrame = new JFrame();
                
                GridLayout mainLayout = new GridLayout(1,2);
        		
        		applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		
        		applicationFrame.getContentPane().setLayout(mainLayout);
        		
        		GridLayout seats = new GridLayout(4,4);
        		
        		GridLayout menu = new GridLayout();
        		
        		 Box box = Box.createVerticalBox(); 
        		 
        		 Label label = new Label();
        		 label.setText("Selecciona tus asientos");
        		 
        		 
        		 box.add(label);
        		   
        		 box.add(Box.createVerticalStrut(25));
        		 
        		 Button comprar = new Button("Comprar");
        		 
       		  		comprar.addActionListener(new ActionListener()
       		  		{
						
						public void actionPerformed(ActionEvent e)
						{		
								
								JOptionPane.showMessageDialog(null,"Tu compra ha sido ralizada satisfactoriamente!!");
							
						}
					});
        		 
        		 box.add(comprar);
        		 
        		    
        		applicationFrame.add(box, BorderLayout.CENTER);
        		
        		Container seatscontent = new Container();
        		
        		seatscontent.setLayout(seats);
        		
        		applicationFrame.add(seatscontent);
        		
        		applicationFrame.setPreferredSize(new Dimension(700,500));
        		
        		boolean contains = Arrays.asList(asientos[0]).contains("True");
        		//System.out.println(contains + " " + asientos[0]);
        		  b1 = new JButton("1");
        		  if(contains) {b1.setBackground(Color.RED);} else {b1.setBackground(Color.GREEN);}
        		  b1.addActionListener(new ActionListener()
     			 {
						
						public void actionPerformed(ActionEvent e)
						{		
								if(contains)
								{
								JOptionPane.showMessageDialog(null,"El asiento esta ocupado");
								}
								else
								{
									asientos[0]="True";
									b1.setBackground(Color.CYAN);
									writetoserver();
								//System.out.println("boton picado");
								}
						}
					});
        		  boolean contains2 = Arrays.asList(asientos[1]).contains("True");
          		//System.out.println(contains + " " + asientos[0]);
          		  b2 = new JButton("2");
          		  if(contains2) {b2.setBackground(Color.RED);} else {b2.setBackground(Color.GREEN);}
          		  b2.addActionListener(new ActionListener()
       			 {
  						
  						public void actionPerformed(ActionEvent e)
  						{		
  								if(contains2)
  								{
  									JOptionPane.showMessageDialog(null,"El asiento esta ocupado");
  								}
  								else
  								{
  									asientos[1]="True";
  									b2.setBackground(Color.CYAN);
  									writetoserver();
  								//System.out.println("boton picado");
  								}
  						}
  					});   
          		boolean contains3 = Arrays.asList(asientos[2]).contains("True");
          		//System.out.println(contains + " " + asientos[0]);
          		  b3 = new JButton("3");
          		  if(contains3) {b3.setBackground(Color.RED);} else {b3.setBackground(Color.GREEN);}
          		  b3.addActionListener(new ActionListener()
       			 {
  						
  						public void actionPerformed(ActionEvent e)
  						{		
  								if(contains3)
  								{
  								JOptionPane.showMessageDialog(null,"El asiento esta ocupado");
  								}
  								else
  								{
  								asientos[2]="True";
  								b3.setBackground(Color.CYAN);
  								writetoserver();
  								//System.out.println("boton picado");
  								}
  						}
  					}); 
          		boolean contains4 = Arrays.asList(asientos[3]).contains("True");
          		//System.out.println(contains + " " + asientos[0]);
          		  b4 = new JButton("4");
          		  if(contains4) {b4.setBackground(Color.RED);} else {b4.setBackground(Color.GREEN);}
          		  b4.addActionListener(new ActionListener()
       			 {
  						
  						public void actionPerformed(ActionEvent e)
  						{		
  								if(contains4)
  								{
  								JOptionPane.showMessageDialog(null,"El asiento esta ocupado");
  								}
  								else
  								{
  								asientos[3]="True";
  								b4.setBackground(Color.CYAN);
  								writetoserver();
  								//System.out.println("boton picado");
  								}
  						}
  					}); 
          		  
          		boolean contains5 = Arrays.asList(asientos[4]).contains("True");
          		//System.out.println(contains + " " + asientos[0]);
          		  b5 = new JButton("5");
          		  if(contains5) {b5.setBackground(Color.RED);} else {b5.setBackground(Color.GREEN);}
          		  b5.addActionListener(new ActionListener()
       			 {
  						
  						public void actionPerformed(ActionEvent e)
  						{		
  								if(contains5)
  								{
  								JOptionPane.showMessageDialog(null,"El asiento esta ocupado");
  								}
  								else
  								{
  								asientos[4]="True";
  								b5.setBackground(Color.CYAN);
  								writetoserver();
  								//System.out.println("boton picado");
  								}
  						}
  					}); 
        		 
          		
 
       		boolean contains6 = Arrays.asList(asientos[5]).contains("True");
      		//System.out.println(contains + " " + asientos[0]);
      		  b6 = new JButton("6");
      		  if(contains6) {b6.setBackground(Color.RED);} else {b6.setBackground(Color.GREEN);}
      		  b6.addActionListener(new ActionListener()
   			 {
						
						public void actionPerformed(ActionEvent e)
						{		
								if(contains6)
								{
								JOptionPane.showMessageDialog(null,"El asiento esta ocupado");
								}
								else
								{
								asientos[5]="True";
								b6.setBackground(Color.CYAN);
								writetoserver();
								//System.out.println("boton picado");
								}
						}
					}); 
       		boolean contains7 = Arrays.asList(asientos[6]).contains("True");
      		//System.out.println(contains + " " + asientos[0]);
      		  b7 = new JButton("7");
      		  if(contains7) {b7.setBackground(Color.RED);} else {b7.setBackground(Color.GREEN);}
      		  b7.addActionListener(new ActionListener()
   			 {
						
						public void actionPerformed(ActionEvent e)
						{		
								if(contains7)
								{
								JOptionPane.showMessageDialog(null,"El asiento esta ocupado");
								}
								else
								{
								asientos[6]="True";
								b7.setBackground(Color.CYAN);
								writetoserver();
								//System.out.println("boton picado");
								}
						}
					}); 
       		  b8 = new JButton("8");
       		  
       		boolean contains8 = Arrays.asList(asientos[7]).contains("True");
      		//System.out.println(contains + " " + asientos[0]);
     
      		  if(contains8) {b8.setBackground(Color.RED);} else {b8.setBackground(Color.GREEN);}
      		  b4.addActionListener(new ActionListener()
   			 {
						
						public void actionPerformed(ActionEvent e)
						{		
								if(contains8)
								{
								JOptionPane.showMessageDialog(null,"El asiento esta ocupado");
								}
								else
								{
								asientos[7]="True";
								b8.setBackground(Color.CYAN);
								writetoserver();
								//System.out.println("boton picado");
								}
						}
					}); 
       		  b9 = new JButton("9");
       		  
       		boolean contains9 = Arrays.asList(asientos[8]).contains("True");
      		//System.out.println(contains + " " + asientos[0]);
      		  
      		  if(contains9) {b9.setBackground(Color.RED);} else {b9.setBackground(Color.GREEN);}
      		  b9.addActionListener(new ActionListener()
   			 {
						
						public void actionPerformed(ActionEvent e)
						{		
								if(contains9)
								{
								JOptionPane.showMessageDialog(null,"El asiento esta ocupado");
								}
								else
								{
								asientos[8]="True";
								b9.setBackground(Color.CYAN);
								writetoserver();
								//System.out.println("boton picado");
								}
						}
					}); 
       		  b10 = new JButton("10");
       		  
       		boolean contains10 = Arrays.asList(asientos[9]).contains("True");
      		//System.out.println(contains + " " + asientos[0]);
      		 
      		  if(contains10) {b10.setBackground(Color.RED);} else {b10.setBackground(Color.GREEN);}
      		  b10.addActionListener(new ActionListener()
   			 {
						
						public void actionPerformed(ActionEvent e)
						{		
								if(contains10)
								{
								JOptionPane.showMessageDialog(null,"El asiento esta ocupado");
								}
								else
								{
								asientos[9]="True";
								b10.setBackground(Color.CYAN);
								writetoserver();
								//System.out.println("boton picado");
								}
						}
					}); 
       		  b11 = new JButton("11");
       		  
       		boolean contains11 = Arrays.asList(asientos[10]).contains("True");
      		//System.out.println(contains + " " + asientos[0]);
      		
      		  if(contains11) {b11.setBackground(Color.RED);} else {b11.setBackground(Color.GREEN);}
      		  b11.addActionListener(new ActionListener()
   			 {
						
						public void actionPerformed(ActionEvent e)
						{		
								if(contains11)
								{
								JOptionPane.showMessageDialog(null,"El asiento esta ocupado");
								}
								else
								{
								asientos[10]="True";
								b11.setBackground(Color.CYAN);
								writetoserver();
						
								}
						}
					}); 
       		  b12 = new JButton("12");
       		  
       		boolean contains12 = Arrays.asList(asientos[11]).contains("True");
      		//System.out.println(contains + " " + asientos[0]);
      		
      		  if(contains12) {b12.setBackground(Color.RED);} else {b12.setBackground(Color.GREEN);}
      		  b12.addActionListener(new ActionListener()
   			 {
						
						public void actionPerformed(ActionEvent e)
						{		
								if(contains12)
								{
								JOptionPane.showMessageDialog(null,"El asiento esta ocupado");
								}
								else
								{
								asientos[11]="True";
								b12.setBackground(Color.CYAN);
								writetoserver();
								//System.out.println("boton picado");
								}
						}
					}); 
       		  b13 = new JButton("13"); 
       		  
       		boolean contains13 = Arrays.asList(asientos[12]).contains("True");

      		  if(contains13) {b13.setBackground(Color.RED);} else {b13.setBackground(Color.GREEN);}
      		  b13.addActionListener(new ActionListener()
   			 {
						
						public void actionPerformed(ActionEvent e)
						{		
								if(contains13)
								{
								JOptionPane.showMessageDialog(null,"El asiento esta ocupado");
								}
								else
								{
								asientos[12]="True";
								b13.setBackground(Color.CYAN);
								writetoserver();
								//System.out.println("boton picado");
								}
						}
					}); 
       		  b14 = new JButton("14");
       		boolean contains14 = Arrays.asList(asientos[13]).contains("True");
      		//System.out.println(contains + " " + asientos[0]);
      	
      		  if(contains14) {b14.setBackground(Color.RED);} else {b14.setBackground(Color.GREEN);}
      		  b14.addActionListener(new ActionListener()
   			 {
						
						public void actionPerformed(ActionEvent e)
						{		
								if(contains14)
								{
								JOptionPane.showMessageDialog(null,"El asiento esta ocupado");
								}
								else
								{
								asientos[13]="True";
								b14.setBackground(Color.CYAN);
								writetoserver();
								//System.out.println("boton picado");
								}
						}
					}); 
       		 b15 = new JButton("15");
       		 
       		boolean contains15 = Arrays.asList(asientos[14]).contains("True");
      		//System.out.println(contains + " " + asientos[0]);
      
      		  if(contains15) {b15.setBackground(Color.RED);} else {b15.setBackground(Color.GREEN);}
      		  b15.addActionListener(new ActionListener()
   			 {
						
						public void actionPerformed(ActionEvent e)
						{		
								if(contains15)
								{
								JOptionPane.showMessageDialog(null,"El asiento esta ocupado");
								}
								else
								{
								asientos[14]="True";
								b15.setBackground(Color.CYAN);
								writetoserver();
								//System.out.println("boton picado");
								}
						}
					}); 
       		  b16 = new JButton("16");
       		  
       		boolean contains16 = Arrays.asList(asientos[15]).contains("True");
      		//System.out.println(contains + " " + asientos[0]);
      		
      		  if(contains16) {b16.setBackground(Color.RED);} else {b16.setBackground(Color.GREEN);}
      		  b16.addActionListener(new ActionListener()
   			 {
						
						public void actionPerformed(ActionEvent e)
						{		
								if(contains16)
								{
								JOptionPane.showMessageDialog(null,"El asiento esta ocupado");
								}
								else
								{
								asientos[15]="True";
								b16.setBackground(Color.CYAN);
								writetoserver();
								//System.out.println("boton picado");
								}
						}
					}); 
        		  
        		  seatscontent.add(b1);
        		    seatscontent.add(b2);
        		    seatscontent.add(b3);
        		    seatscontent.add(b4);
        		    seatscontent.add(b5);
        		    seatscontent.add(b6);
        		    seatscontent.add(b7);
        		    seatscontent.add(b8);
        		    seatscontent.add(b9);
        		    seatscontent.add(b10);
        		    seatscontent.add(b11);
        		    seatscontent.add(b12);
        		    seatscontent.add(b13);
        		    seatscontent.add(b14);
        		    seatscontent.add(b15);
        		    seatscontent.add(b16);
        		    
        			applicationFrame.pack();
        		
                applicationFrame.setVisible(true);
            }
            	
             catch (InterruptedException e1)
            	{
				// TODO Auto-generated catch block
				e1.printStackTrace();
            	}
            }
        });

        someThread = new Thread(new Runnable()
        {
			public void run() 
			{
				try {
					
					//if(socket==null){
						socket=new Socket(ip,port);
						System.out.println("ip: "+ip +" port " + port);
						//DataInputStream dis = new DataInputStream(socket.getInputStream());
						BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
						Thread.sleep(1000);
						
						String line;
						
						while ((line = input.readLine())!=null)
						{
							//System.out.println(line);
								boolean contains = line.contains("EOL");
				            
				            if(contains)
				            {
				            	break;
				            }
				             asientos= line.split(";");
				             for(int k=0;k<asientos.length;k++)
				             {
				            	 //System.out.println("\nArreglo asientos["+k+"] = "+asientos[k]);
				             }
				            System.out.println("Client: "+asientos[0]);
				            
				             x++;
				         }   
						//input.close();
						System.out.println("\n Recibido");
						
					
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}catch (IOException e) {
					e.printStackTrace();
				} 
            }
        });

    }

    
    public void writetoserver()
    {
    	String resultados="";
    	
    	for(int i=0; i<16;i++)
    	{
    			resultados = resultados + asientos[i]+";" ;
    	}
    	
    	//System.out.println("asientos :\n" +resultados);
    	
    	try
    	{
    		DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
    		dos.writeBytes(resultados+"\nEOL\n");
    		//System.out.println("resultados :"+resultados);
    		//dos.close();
    	}
    	catch(IOException ie)
    	{
    		ie.printStackTrace();
    	}
    }
    
  
	
	
}
