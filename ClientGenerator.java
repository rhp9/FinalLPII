public class ClientGenerator extends Thread{

	private boolean die;
	private boolean pause;

	public void init() {
		// TODO Auto-generated method stub
		this.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Client1 client=new Client1(1, "localhost", 60000);
		client.init();
		
	}
	
	
	
	public static void main(String[] args)
	{
		ClientGenerator clientGenerator=new ClientGenerator();
		
		clientGenerator.init();
	
	}
}
