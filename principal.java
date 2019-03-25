package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import bank.Bank;


public class principal {
	private JFrame frame;
	Bank b=new Bank();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal window = new principal();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		});
		}

	public principal() {
		initialize();
	}
	private void initialize() {
	frame = new JFrame();
	frame.setBounds(700, 300, 550, 400);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	b.addPerson("Dondas", "Bianca", "Spiru Haret");
	JButton btnPerson = new JButton("Person");
	btnPerson.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			personGui frame1=new personGui();
			frame1.getFrame().setVisible(true);
			frame1.setB(b);
			//frame.setVisible(false);
		}
		
	});
	btnPerson.setBounds(200, 75, 130, 50);
	frame.getContentPane().add(btnPerson);
	
	JButton btnAccount = new JButton("Account");
	btnAccount.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			accountGui frame1=new accountGui();
			frame1.getFrame().setVisible(true);
			frame1.setB(b);
			//frame.setVisible(false);
		}
	});
	btnAccount.setBounds(200, 170, 130, 50);
	frame.getContentPane().add(btnAccount);
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}

	public Bank getB() {
		return b;
	}

	public void setB(Bank b) {
		this.b = b;
	 }

}