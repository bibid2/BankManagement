package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import account.Account;
import bank.Bank;
import person.Person;

public class accountGui {
	Bank b=new Bank();
	public Bank getB() {
		return b;
	}

	public void setB(Bank b) {
		this.b = b;
	}


	private JLabel label1,label2, label3, label4;
	private JButton btn1, btn2, btn3, btn4, btn5, btn6;
	private JTextField t1,t2,t3, t4;
	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					accountGui window1 = new accountGui();
					window1.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		}

	public accountGui() {
		initialize();	
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 300, 800, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		label1=new JLabel();
		label1.setText("Nume Titular: ");
		label1.setBounds(50, 60, 200, 50);
		frame.getContentPane().add(label1);
		t1=new JTextField();
		t1.setBounds(300,75, 100, 20);
		frame.getContentPane().add(t1);
		
		label2=new JLabel();
		label2.setText("Suma: ");
		label2.setBounds(50, 100, 200, 50);
		frame.getContentPane().add(label2);
		t2=new JTextField();
		t2.setBounds(300,115, 100, 20);
		frame.getContentPane().add(t2);
		
		label3=new JLabel();
		label3.setText("Tip cont: ");
		label3.setBounds(50, 140, 200, 50);
		frame.getContentPane().add(label3);
		t3=new JTextField();
		t3.setBounds(300,155, 100, 20);
		frame.getContentPane().add(t3);
		
		label4=new JLabel();
		label4.setText("Id cont:" );
		label4.setBounds(50, 180, 200, 50);
		frame.getContentPane().add(label4);
		t4=new JTextField();
		t4.setBounds(300, 190, 100, 20);
		frame.getContentPane().add(t4);
		btn1=new JButton();
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type=t3.getText();
				String nume=t1.getText();
				String suma=t2.getText();
				String id=t4.getText();
				b.adaugareCont(Integer.parseInt(type), nume, Double.parseDouble(suma), Integer.parseInt(id));
				b.afisareConturi();
			}
		});
		btn1.setText("Adaugare");
		btn1.setBounds(50, 220, 150, 20);
		frame.getContentPane().add(btn1);
		
		
		btn2=new JButton();
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type=t3.getText();
				String nume=t1.getText();
				String suma=t2.getText();
				String id=t4.getText();
				b.stergereCont(Integer.parseInt(type), nume, Double.parseDouble(suma), Integer.parseInt(id));
				b.afisareConturi();
			}
		});
		btn2.setText("Stergere");
		btn2.setBounds(50, 250, 150, 20);
		frame.getContentPane().add(btn2);
		
		btn3=new JButton();
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type=t3.getText();
				String nume=t1.getText();
				String suma=t2.getText();
				String id=t4.getText();
				b.editareCont(Integer.parseInt(type), nume, Double.parseDouble(suma), Integer.parseInt(id));
				b.afisareConturi();
			}
		});
		btn3.setText("Editare");
		btn3.setBounds(50, 280, 150, 20);
		frame.getContentPane().add(btn3);
		
		
		btn4=new JButton();
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				String [] columnNames= {"Nume", "Suma", "Id" };
				columnNames[0]="Nume";
				columnNames[1]="Suma";
				columnNames[2]="Id";
				ArrayList<Account> conturi = new ArrayList<Account>();
				System.out.println("IDURI CONTURI");
				Object [][] data= new Object[100][];
				for(int i=0;i<100;i++)
				{
					data[i]=new Object[100];
				}
				int nr=0;
				
				for(Entry<Person, ArrayList<Account>> entry : b.getPersons().entrySet())
				{
					for(Account a : entry.getValue())
					{	System.out.println(a.getIdCont());
						conturi.add(a);	
					}
				}
				for(Account a : conturi)
				{
					int nrField=0;
					data[nr][nrField++]=a.getNumeTitular();
					data[nr][nrField++]=a.getSuma();
					data[nr][nrField++]=a.getIdCont();					
					nr++;
				}
				JTable tabel=new JTable(data, columnNames);				
				JScrollPane scroll= new JScrollPane(tabel);scroll.setBounds(450, 100, 250, 100);
				scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				frame.add(scroll, BorderLayout.CENTER);				
				b.afisareConturi();
			}
		});
		btn4.setText("Vizualizare");
		btn4.setBounds(50, 310, 150, 20);
		frame.getContentPane().add(btn4);
		
		btn5=new JButton();
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type=t3.getText();
				String nume=t1.getText();
				String suma=t2.getText();
				String id=t4.getText();
				b.depunereNumerar(nume, Double.parseDouble(suma), Integer.parseInt(type));
				b.afisareConturi();
			}
		});
		btn5.setText("Depunere");
		btn5.setBounds(230, 280, 150, 20);
		frame.getContentPane().add(btn5);
		
		btn6=new JButton();
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type=t3.getText();
				String nume=t1.getText();
				String suma=t2.getText();
				String id=t4.getText();
				b.retragereNumerar(nume,Double.parseDouble(suma), Integer.parseInt(type));
				b.afisareConturi();
		
			}
		});
		btn6.setText("Extragere");
		btn6.setBounds(230, 240, 150, 20);
		frame.getContentPane().add(btn6);
		
		//Bank b= new Bank();
		//b.afisarePersoane();
		frame.setVisible(true);
		JButton btnInapoi = new JButton("Back");
		btnInapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal frame1=new principal();
				frame1.getFrame().setVisible(true);
				frame1.setB(b);
				frame.setVisible(false);
				b.afisareConturi();
			}
		});
		btnInapoi.setBounds(400, 260, 130, 20);
		frame.getContentPane().add(btnInapoi);	
	
	}
	

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}