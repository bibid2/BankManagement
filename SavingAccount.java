package account;

import javax.swing.JOptionPane;

public class SavingAccount extends Account {

	private double dobanda;
	private int ok1 = 0, ok2 = 0, perioada, type; // type=0 pt saving

	public SavingAccount(int type, String numeTitular, double suma, int idCont) {
		super(numeTitular, suma, idCont);
		// this.dobanda=dobanda;
		// this.perioada=perioada;
		this.type = type;
		// TODO Auto-generated constructor stub
	}

	public int getPerioada() {
		return perioada;
	}

	public void setPerioada(int perioada) {
		this.perioada = perioada;
	}

	public double getDobanda() {
		return dobanda;
	}

	public void setDobanda(double dobanda) {
		this.dobanda = dobanda;
	}

	public void depunereNumerar(double suma1) {
		if (ok1==0) {
			this.suma += suma1;
			ok1=1;
			//return "Operatiunea s-a finalizat cu succes!\n S-a creat un depozit cu suma de: " + Double.toString(suma);
		} else return;
			//JOptionPane.showMessageDialog(null, "Suma este prea mica pentru a crea un depozit");

	}
	
	public static void main(String[] args) {
		Account x=new SavingAccount(0, "adad", 1000, 1);
		((SavingAccount)x).depunereNumerar(40000);
		System.out.println(x.getSuma());
	}

	public void retragereNumerar(double suma) {
		//System.out.println("Aici");
		/*double castig = (0.25 * 12) / 100;
		double total = this.suma + castig;
		this.suma+=castig;
		if (suma == total) {
			this.suma -= suma;
			return "Operatiunea s-a finalizat cu succes!";
		} else
			//return "Pentru desfiinatarea contului trebuie sa extrageti toata suma: " + Double.toString(total);
			//JOptionPane.showMessageDialog(null, "trebuie sa extrageti!");*/
		if(suma==this.suma)
		{
			this.suma -= suma;
		}
		else JOptionPane.showMessageDialog(null, "trebuie sa extrageti!"+this.suma);
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
