package account;

import bank.Bank;

public abstract class Account {
	
	private String numeTitular;
	private int idCont;
	protected double suma;
	public int type;
	public int getType() {
		return type;
	}
	Bank bank;
	
	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCont;
		result = prime * result + ((numeTitular == null) ? 0 : numeTitular.hashCode());
		long temp;
		temp = Double.doubleToLongBits(suma);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + type;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (idCont != other.idCont)
			return false;
		if (numeTitular == null) {
			if (other.numeTitular != null)
				return false;
		} else if (!numeTitular.equals(other.numeTitular))
			return false;
		if (Double.doubleToLongBits(suma) != Double.doubleToLongBits(other.suma))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	public void setType(int type) {
		this.type = type;
	}
	public Account()
	{
		this.numeTitular="";
		this.idCont=0;
		this.suma=0;
		
	}
	public Account(String numeTitular, double suma, int idCont) {
		super();
		this.numeTitular = numeTitular;
		this.idCont=idCont;
		this.suma = suma;
	}
	public int getIdCont() {
		return idCont;
	}
	public void setIdCont(int idCont) {
		this.idCont = idCont;
	}
	public String getNumeTitular() {
		return numeTitular;
	}
	public void setNumeTitular(String numeTitular) {
		this.numeTitular = numeTitular;
	}
	public double getSuma() {
		return suma;
	}
	public void setSuma(double suma) {
		this.suma = suma;
	}
//
//	public abstract String depunereNumerar(double suma);
//	public abstract String retragereNumerar(double suma);
	
}
