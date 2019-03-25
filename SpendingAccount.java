package account;

public class SpendingAccount extends Account {

	private int type; // egal cu 1 pt spending
	public SpendingAccount(int type,String numeTitular, double suma, int idCont) {
		super(numeTitular, suma, idCont);
		this.type=type;
		// TODO Auto-generated constructor stub
	}

	public String depunereNumerar(double suma)
	{
		this.suma+=suma;
		return "Operatiunea s-a finalizat cu succes! ";
	}
	
	
	public String retragereNumerar(double suma)
	{
	//	System.out.println("ret");
		this.suma-=suma;
		return "Operatiunea s-a finalizat cu succes!";
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}