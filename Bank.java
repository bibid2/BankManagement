package bank;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observer;
import java.util.Set;

import javax.swing.JOptionPane;

import account.Account;
import account.SavingAccount;
import account.SpendingAccount;
import junit.framework.Assert;
import person.Person;

public class Bank implements BankProc, Serializable {


	private static final long serialVersionUID = 1;
	HashMap<Person, ArrayList<Account>> persons = new HashMap<Person, ArrayList<Account>>();
	private ArrayList<Observer> obs;
	public Bank() {
		persons = new HashMap<Person, ArrayList<Account>>();
		obs = new ArrayList<Observer>();
	} 
	

	public Bank(HashMap<String, ArrayList<Account>> accounts) {
		this.persons = persons;
		obs = new ArrayList<Observer>();
	}
	public void addObs(Observer observer) {
		obs.add(observer);
	}

	
	public void removeObs(Observer observer) {
		obs.remove(observer);
	}

	public void addPerson(String nume, String prenume, String adresa) {
		assertTrue(nume!=null);
		assertTrue(prenume!=null);
		assertTrue(adresa!=null);
		int size=persons.size();
		Person p = new Person(nume, prenume, adresa);
		ArrayList<Account> c = new ArrayList<Account>();
		if (persons.containsKey(p) == false) {
			persons.put(p, c);}
			//JOptionPane.showMessageDialog(null, "Person has been added!");
	//	} else
			//JOptionPane.showMessageDialog(null, "Persoana este deja adaugata!");
		assertTrue(p!=null);
		//assertTrue(size==size+1);
	}

	public ArrayList<Person> afisarePersoane() {
		ArrayList<Person> p = new ArrayList<Person>();
		for (Person p1 : persons.keySet()) {
			System.out.println(p1.getNume().toString() + " " + p1.getPrenume() + " " + p1.getAdresa());
		}
		assertTrue(p!=null);
		return p;
		
	}

	public void stergerePersoana(String nume, String prenume, String adresa) {
		assertTrue(nume!=null);
		assertTrue(prenume!=null);
		assertTrue(adresa!=null);
		int presize= persons.size();
		Person p = new Person(nume, prenume, adresa);
		Person p2=null;
		for (Person p1 : persons.keySet()) {
			if (p1.getNume().equals(p.getNume())) {
				p2 = p1;
			}		
		}
		persons.remove(p2);
		//assertTrue(presize==presize-1);
	}

	public void editarePersoana(String nume, String prenume, String adresa) {
		assertTrue(nume!=null);
		assertTrue(prenume!=null);
		assertTrue(adresa!=null);
		Person p = new Person(nume, prenume, adresa);
		for (Person p1 : persons.keySet()) {
			if (p1.getNume().equals(p.getNume())) {
				if (p1.getAdresa() != "" && p1.getPrenume() != "") {
					p1.setPrenume(prenume);
					p1.setAdresa(adresa);
				}
			}
		}
	}

	public ArrayList<Person> vizualizarePersoane() {
		// JTable tabel1=new JTable();
		
		/*DefaultTableModel model = new DefaultTableModel(new Object[] { "Key", "Value" }, 0);
		for (Map.Entry<Person, ArrayList<Account>> entry : persons.entrySet()) {
			model.addRow(new Object[] { entry.getKey(), entry.getValue() });
		}
		return model;*/
		ArrayList<Person> pers=new ArrayList<Person>();
		for(Person p:persons.keySet())
		{	pers.add(p);
			//System.out.println(p.getNume());
		}
		assertTrue(pers!=null);
		return pers;
	}

	public HashMap<Person, ArrayList<Account>> getPersons() {
		return persons;
	}

	public void setPersons(HashMap<Person, ArrayList<Account>> persons) {
		this.persons = persons;
	}

	public void adaugareCont(int type, String numeTitular, double suma, int idCont) {

		assertTrue(numeTitular!=null);
		assertTrue(idCont!=0);
		Person p2 = new Person();
		int size=persons.size();
		// ArrayList<Account> cont=new ArrayList<Account>();
		if (type == 0) // saving
		{
			if(suma>1000)
			{	
				double sumaAux=suma+suma*3/100;
				Account c1 = new SavingAccount(type, numeTitular, sumaAux, idCont);
				// cont.add(c1);
				for (Person p1 : persons.keySet()) {
					if (p1.getNume().equals(numeTitular))
						p2 = p1;
					//
					// cont.add(persons.get(p2));
				}
				persons.get(p2).add(c1);
				// cont.add(c1);
				//System.out.println(c1.getClass().getSimpleName());
			}
			else {
				JOptionPane.showMessageDialog(null, "Suma minima pentru un depozit este 1000 RON!");
			} 
			
		} else {
			Account c2 = new SpendingAccount(type, numeTitular, suma, idCont);
			for (Person p1 : persons.keySet())
				p2 = p1;
			//System.out.println(c2.getClass().getSimpleName());
			persons.get(p2).add(c2);
			//assertTrue(size==size+1);
		}

	}

	public void stergereCont(int type, String numeTitular, double suma, int idCont) {
		Person p2 = new Person();
		assertTrue(numeTitular!=null);
		assertTrue(idCont!=0);
		int presize=persons.size();
		// ArrayList<Account> cont=new ArrayList<Account>();

		// savingAccount c1=new savingAccount(type, numeTitular, suma, idCont);
		for (Person p1 : persons.keySet()) {
			if (p1.getNume().equals(numeTitular))
				{p2 = p1;
				}
			//return;
		}
		// persons.get(p2).remove(c1);
		ArrayList<Account> cont = persons.get(p2);
		for (Account c1 : cont) {
			if (c1.getIdCont() == idCont)
				{persons.get(p2).remove(c1);
				//assertTrue(presize==presize-1);
			return;}
		}
	

	}

	public void editareCont(int type, String numeTitular, double suma, int idCont) {
		Person p2 = new Person();
		assertTrue(numeTitular!=null);
		assertTrue(idCont!=0);
		for (Person p1 : persons.keySet()) {
			if (p1.getNume().equals(numeTitular))
				p2 = p1;
		}
		ArrayList<Account> cont = persons.get(p2);
		for (Account c1 : cont) {
			if (c1.getNumeTitular().equals(numeTitular)) {
				c1.setIdCont(idCont);
				c1.setSuma(suma);
				c1.setType(type);
			}
		}
	}
	public ArrayList<Account> afisareConturi() {
		ArrayList<Account> c = new ArrayList<Account>();
		for (Person p1 : persons.keySet()) {
			for (Account c1 : persons.get(p1))
				{System.out.println(c1.getNumeTitular().toString() + " " + c1.getIdCont() + " " + c1.getSuma());
				
				}
		}
		System.out.println("----------");
		return c;
	}
	public ArrayList<Account> afisareConturi1() {
	
		ArrayList<Account> cont1=new ArrayList<Account>();
		for (Person p1 : persons.keySet()) {
			for (Account c1 : persons.get(p1))
			{
				cont1.add(c1);
			}
		}
		return cont1;
	}

	//public ArrayList<Account> vizualizareConturi()
	//{
		/*java.util.Iterator<Entry<Person, ArrayList<Account>>> it= persons.entrySet().iterator();
		ArrayList<String[]>acc=new ArrayList<String[]>();
		while(it.hasNext())
		{
			int index=0;
			Map.Entry aux=(Map.Entry) it.next();
			ArrayList<Account> auxCont= (ArrayList<Account>) aux.getValue();
			while(index<auxCont.size())
			{
				String[] m= new String[3];
				m[0]=""+auxCont.get(index).getNumeTitular();
				m[1]=""+auxCont.get(index).getSuma();
				m[2]=""+auxCont.get(index).getIdCont();
				//m[3]=""+auxCont.get(index).getType();
				acc.add(m);
				index++;
			}
		}
		return acc;*/
	//}
	
	public void retragereNumerar(String numeTitular, double sumaExtrasa, int type) {
		Person p2 = new Person();
		for (Person p1 : persons.keySet()) {
			if (p1.getNume().equals(numeTitular))
				p2 = p1;
		}
		//if(type==1) {
		for (Account c1 : persons.get(p2) ) {
			if (c1.getNumeTitular().equals(numeTitular) && (c1 instanceof SpendingAccount)) {
				((SpendingAccount) c1).retragereNumerar(sumaExtrasa);
			}
		}
		
			for (Account c1 : persons.get(p2) ) {
				if (c1.getNumeTitular().equals(numeTitular) && (c1 instanceof SavingAccount) && type==0) {
					((SavingAccount) c1).retragereNumerar(sumaExtrasa);
				}
			}
	}

	public void depunereNumerar(String numeTitular, double suma, int type) {
		Person p2 = new Person();
		for (Person p1 : persons.keySet()) {
			if (p1.getNume().equals(numeTitular))
				p2 = p1;
		}
		for (Account c1 : persons.get(p2) ) {
			if (c1.getNumeTitular().equals(numeTitular) && (c1 instanceof SpendingAccount)) {
				((SpendingAccount) c1).depunereNumerar(suma);
			}
			/*else if(c1.getNumeTitular().equals(numeTitular) && (c1 instanceof SavingAccount) && type==0) {
				((SavingAccount) c1).depunereNumerar(suma);
			}*/
		}
		
		/*ArrayList<Account> cont = persons.get(p2);
		for (Account c1 : cont) {
			System.out.println(c1.getNumeTitular());
			if (c1 instanceof SpendingAccount) {
				if (c1.getNumeTitular().equals(numeTitular)) {
				//	System.out.println("Am gasit contul");
					c1.depunereNumerar(suma);
				}
			}
		}*/
	}
		public static void main(String[] args) {
			 Bank b =new Bank();

//			b.addPerson("Popescu", "Ion", "Turda");
//			b.addPerson("Pop", "Iona", "Turda");
//				
		        // The "ObjectOutputStream" class has the default 
		        // definition to serialize an object.
//		        ObjectOutputStream oss=null;
			 	ObjectInputStream oss=null;
				try {
//					oss = new ObjectOutputStream( 
//					                       // By using "FileOutputStream" we will 
//					                       // Write it to a File in the file system
//					                       // It could have been a Socket to another 
//					                       // machine, a database, an in memory array, etc.
//					                       new FileOutputStream(new File("output.txt")));
					oss = new ObjectInputStream( 
		                       // By using "FileOutputStream" we will 
		                       // Write it to a File in the file system
		                       // It could have been a Socket to another 
		                       // machine, a database, an in memory array, etc.
		                       new FileInputStream(new File("output.txt")));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

//		        // do the magic  
		        try {
//					oss.writeObject(b);
		        	b=(Bank) oss.readObject();
		        	
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//			 
//			 
//			 	
//		        
		        Set<Person> p=b.persons.keySet();
		        
		        for(Person pe:p) {
		        	System.out.println(pe);
		        }
		        // close the writing.
//		        try {
//					oos.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
		/*	FileOutputStream fileOut=null;
			try {
		        fileOut =  new FileOutputStream("employee.ser");
		         ObjectOutputStream out = new ObjectOutputStream(fileOut);
		         out.writeObject(b);
		         out.close();
		         fileOut.close();
		         System.out.printf("Serialized data is saved in employee.ser");
		      } catch (IOException i) {
		         i.printStackTrace();
		      }*/
			
			
		//Bank b = new Bank();
		//b.addPerson("Popescu", "Ion", "Turda");
		//b.addPerson("Pop", "Iona", "Turda");
		//b.stergerePersoana("Pop", "Iona", "Turda");
		//b.editarePersoana("Popescu", "Ana", "Cluj");
		
		//b.adaugareCont(0, "Popescu", 6000, 12);
		//b.adaugareCont(1, "Popescu", 550, 11);
		//b.adaugareCont(1, "Pop", 980, 5);
	
		//b.stergereCont(1, "Pop", 980, 5);
		//b.stergereCont(0, "Popescu", 6000, 12);
		
		//b.editareCont(0, "Popescu", 8000, 13);
		//b.editareCont(1, "Pop", 550, 7);
		
		//b.retragereNumerar("Pop", 60, 5);
		//b.depunereNumerar("Pop", 430,1);
		//b.depunereNumerar("Popescu", 8000, 0);
		//b.retragereNumerar("Popescu", 6000, 1);
		//b.afisareConturi();
		
	/*	for (Person p : b.persons.keySet()) {
			System.out.println(p.getNume());
			for (Account a : b.persons.get(p)) {
				System.out.println(a.getIdCont());
				System.out.println(a.getSuma());
			}
		}*/
		// b.afisarePersoane();
	}
}