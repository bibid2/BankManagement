package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import account.Account;
import bank.Bank;
import person.Person;

class Testare {

	@Test
	void testAdaugare() {
		Bank b=new Bank();
		Person p1= new Person("Popescu", "Ion", "Turda");
		b.addPerson("Popescu", "Ion", "Turda");
		ArrayList<Person> p = b.vizualizarePersoane();
		String s=p.get(0).getNume()+" "+p.get(0).getPrenume()+" "+p.get(0).getAdresa();
		assertEquals("Popescu Ion Turda",s);
	}
	
	@Test
	void testEditarePersoana()
	{
		Bank b=new Bank();
		Person p1= new Person("Popescu", "Ion", "Turda");
		b.addPerson("Popescu", "Ion", "Turda");
		b.editarePersoana("Popescu", "Ana", "Cluj");
		ArrayList<Person> p = b.vizualizarePersoane();
		String s=p.get(0).getNume()+" "+p.get(0).getPrenume()+" "+p.get(0).getAdresa();
		assertEquals("Popescu Ana Cluj",s);
	}
	
	@Test
	void testAdaugareCont()
	{
		Bank b=new Bank();
		b.addPerson("Pop", "Ion", "Turda");
		b.adaugareCont(1, "Pop", 980, 5);
		ArrayList<Account> c=b.afisareConturi1();
		String s=c.get(0).getType()+" "+c.get(0).getNumeTitular()+" "+c.get(0).getSuma()+" "+ c.get(0).getIdCont();
	//	System.out.println(s);
			assertEquals("1 Pop 980.0 5",s);
	
	}
	
	
	@Test
	void testEditareCont()
	{
		Bank b=new Bank();
		b.addPerson("Pop", "Ion", "Turda");
		b.adaugareCont(1, "Pop", 980, 5);
		b.editareCont(1, "Pop", 500, 5);
		ArrayList<Account> c=b.afisareConturi1();
		String s=c.get(0).getType()+" "+c.get(0).getNumeTitular()+" "+c.get(0).getSuma()+" "+ c.get(0).getIdCont();
			assertEquals("1 Pop 500.0 5",s);
	}

	@Test
	void retragereNumerar()
	{
		Bank b=new Bank();
		b.addPerson("Pop", "Ion", "Turda");
		b.adaugareCont(1, "Pop", 980, 5);
		b.retragereNumerar("Pop", 500, 1);
		ArrayList<Account> c=b.afisareConturi1();
		String s=c.get(0).getType()+" "+c.get(0).getNumeTitular()+" "+c.get(0).getSuma()+" "+ c.get(0).getIdCont();
		assertEquals("1 Pop 480.0 5",s);
	}
	
	@Test
	void depunereNumerar()
	{
		Bank b=new Bank();
		b.addPerson("Pop", "Ion", "Turda");
		b.adaugareCont(1, "Pop", 900, 5);
		b.depunereNumerar("Pop", 500, 1);
		ArrayList<Account> c=b.afisareConturi1();
		String s=c.get(0).getType()+" "+c.get(0).getNumeTitular()+" "+c.get(0).getSuma()+" "+ c.get(0).getIdCont();
		assertEquals("1 Pop 1400.0 5",s);
	}

}
