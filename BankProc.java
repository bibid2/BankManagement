package bank;

import java.util.ArrayList;

import account.Account;
import person.Person;

public interface BankProc {
	
	
	/**
	 * @pre nume!=null
	 * @pre prenume!=null
	 * @pre adresa!=null
	 * @post p!=null
	 */
	public void addPerson(String nume, String prenume, String adresa);
	public ArrayList<Person> afisarePersoane();
	/**
	 * @pre nume!=null
	 * @pre prenume!=null
	 * @pre adresa!=null
	 * 
	 */
	public void stergerePersoana(String nume, String prenume, String adresa);
	/**
	 * @pre nume!=null
	 * @pre prenume!=null
	 * @pre adresa!=null
	 * @post p!=null
	 */
	public void editarePersoana(String nume, String prenume, String adresa);
	/**
	 * @post p!=null
	 */
	public ArrayList<Person> vizualizarePersoane();
	/**
	 * @pre type!=null
	 * @pre numeTitular!=null
	 * @pre idCont!=null
	 */
	public void adaugareCont(int type, String numeTitular, double suma, int idCont);
	/**
	 * @pre numeTitular!=null
	 * @pre idCont!=0
	 */
	public void stergereCont(int type, String numeTitular, double suma, int idCont);
	/**
	 * @pre type!=null
	 * @pre numeTitular!=null
	 * @pre idCont!=null
	 * @post presize==presize-1;
	 */
	public void editareCont(int type, String numeTitular, double suma, int idCont);
	/**
	 * @post p2!=null
	 * @post c2!=null
	 */
	public ArrayList<Account> afisareConturi();
	public void retragereNumerar(String numeTitular, double sumaExtrasa, int type);
	public void depunereNumerar(String numeTitular, double suma, int type);
}