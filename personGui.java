package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import account.Account;
import bank.Bank;
import person.Person;

public class personGui {
	
	public Bank getB() {
		return b;
	}

	public void setB(Bank b) {
		this.b = b;
	}




	//Bank b =new HashMap<Persons, ArrayList<Account>>();
	Bank b=new Bank();
	private JLabel label1,label2, label3;
	private JButton btn1, btn2, btn3, btn4;
	private JTextField t1,t2,t3;
	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					personGui window = new personGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		}

	public personGui() {
		initialize();
	}
	private void initialize() {
	frame = new JFrame();
	frame.setBounds(700, 300, 800, 400);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
	label1=new JLabel();
	label1.setText("Nume: ");
	label1.setBounds(50, 100, 200, 50);
	frame.getContentPane().add(label1);
	t1=new JTextField();
	t1.setBounds(300,115, 100, 20);
	frame.getContentPane().add(t1);
	
	label2=new JLabel();
	label2.setText("Prenume ");
	label2.setBounds(50, 140, 200, 50);
	frame.getContentPane().add(label2);
	t2=new JTextField();
	t2.setBounds(300,155, 100, 20);
	frame.getContentPane().add(t2);
	
	label3=new JLabel();
	label3.setText("Adresa ");
	label3.setBounds(50, 180, 200, 50);
	frame.getContentPane().add(label3);
	t3=new JTextField();
	t3.setBounds(300,195, 100, 20);
	frame.getContentPane().add(t3);
	
	
	btn1=new JButton();
	btn1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//Bank b= new Bank();
			String n=t1.getText();
			String p=t2.getText();
			String a=t3.getText();
			b.addPerson(n, p, a);
			b.afisarePersoane();
		}
	});
	btn1.setText("Adaugare");
	btn1.setBounds(50, 220, 150, 20);
	frame.getContentPane().add(btn1);
	
	
	btn2=new JButton();
	btn2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String n=t1.getText();
			String p=t2.getText();
			String a=t3.getText();
			//System.out.println(n+" "+p+" "+a);
			b.stergerePersoana(n, p, a);
			b.afisarePersoane();
		}
	});
	btn2.setText("Stergere");
	btn2.setBounds(50, 250, 150, 20);
	frame.getContentPane().add(btn2);
	
	btn3=new JButton();
	btn3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//Bank b= new Bank();
			String n=t1.getText();
			String p=t2.getText();
			String a=t3.getText();
			b.editarePersoana(n, p, a);
			b.afisarePersoane();
		}
	});
	btn3.setText("Editare");
	btn3.setBounds(50, 280, 150, 20);
	frame.getContentPane().add(btn3);
	
	
	btn4=new JButton();
	btn4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//Bank b= new Bank();
		/*	HashMap<Person, ArrayList<Account>> st = new HashMap<Person, ArrayList<Account>>();
			 JTable t=new JTable(b.vizualizarePersoane(st));
			    JPanel p=new JPanel();
			    p.add(t);
			    JFrame f=new JFrame();
			    f.add(p);
			    f.setSize(200,200);
			    f.setVisible(true);
			//b.vizualizarePersoane();
			//b.afisarePersoane();*/
			ArrayList<Person> pers=new ArrayList<Person>();
			pers=b.vizualizarePersoane();
			//for(Person p : pers)
				//System.out.println(p.getNume());
				
			String [] columnNames= new String [3];
			
			columnNames[0]="Nume";
			columnNames[1]="Prenume";
			columnNames[2]="Adresa";
			Object [][] data= new Object[100][];
			for(int i=0;i<100;i++)
			{
				data[i]=new Object[100];
			}
			int nr=0;
			for(Person p1: pers)
			{
				int nrField=0;
				data[nr][nrField++]=p1.getNume();
				data[nr][nrField++]=p1.getPrenume();
				data[nr][nrField++]=p1.getAdresa();
				nr++;	
			}
	
			JTable tabel=new JTable(data, columnNames);
			
			JScrollPane scroll= new JScrollPane(tabel);
			scroll.setBounds(450, 100, 250, 100);
			scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			frame.add(scroll, BorderLayout.CENTER);
		   
	
		}
	});
	btn4.setText("Vizualizare");
	btn4.setBounds(50, 310, 150, 20);
	frame.getContentPane().add(btn4);
	frame.setVisible(true);
	
	
	JButton btnInapoi = new JButton("Back");
	btnInapoi.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			principal frame1=new principal();
			frame1.getFrame().setVisible(true);
			frame1.setB(b);
			frame.setVisible(false);
		}
	});
	btnInapoi.setBounds(350, 260, 130, 20);
	frame.getContentPane().add(btnInapoi);
	//Bank b= new Bank();
	//b.afisarePersoane();
	
	}


	
	
	public JFrame getFrame() {
		return frame;
	}

}
