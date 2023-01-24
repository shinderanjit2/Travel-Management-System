package package1;

import java.awt.Dimension;


import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.border.EtchedBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;

public class Package8 {

	private JFrame frmPackage8;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Package8 window = new Package8();
					window.frmPackage8.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Package8() {
		initialize();
		Connect();
//		Bill();
	}


	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	int seatno;

	
	public void Connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/travels","root","");
		}catch(ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(frmPackage8, e, "DATABASE WARNING",1);
			//System.out.print(e);
		}
		catch(SQLException e1)
		{
			JOptionPane.showMessageDialog(frmPackage8, e1, "DATABASE WARNING",2);
			//System.out.print(e1);
		}
	}
	
	/*
	public void Bill()
	{
		String name,source,destination,time;
		int seat;
		int price;
		
		name = txtName.getText();
		seat = seatno;
		source = "Pune";
		destination = "AURANGABAD";
		price = 500;
		SimpleDateFormat date_form = new SimpleDateFormat("dd-MM-yyyy");
		String date = date_form.format(txtDate.getDate());
		
		txtBill.setText(txtBill.getText()+name);
	}
	*/
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frmPackage8 = new JFrame();
		frmPackage8.setTitle("PACKAGE8");
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		
		//frmPackage8.setResizable(false);
		
		frmPackage8.setSize(screenSize.width,height);
		//frmPackage8.setLocationRelativeTo(null);
		frmPackage8.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		//frmPackage8.setBounds(100, 100, 1428, 784);
		frmPackage8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPackage8.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 204, 0));
		panel.setBounds(36, 10, 1450, 125);
		frmPackage8.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("TWELVE G");
		lblNewLabel.setForeground(new Color(102, 51, 255));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 60));
		lblNewLabel.setBounds(539, 0, 372, 85);
		panel.add(lblNewLabel);
		
		JLabel lblToursAndTravels = new JLabel("TOURS AND TRAVELS");
		lblToursAndTravels.setHorizontalAlignment(SwingConstants.CENTER);
		lblToursAndTravels.setForeground(Color.RED);
		lblToursAndTravels.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblToursAndTravels.setBounds(593, 79, 263, 36);
		panel.add(lblToursAndTravels);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(778, 169, 98, 22);
		frmPackage8.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(68, 287, 60, 22);
		frmPackage8.getContentPane().add(lblNewLabel_1_1);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtName.setBounds(138, 282, 367, 34);
		frmPackage8.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 0));
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(56, 155, 449, 77);
		frmPackage8.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 0));
		panel_2.setBounds(26, 15, 119, 56);
		panel_4.add(panel_2);
		panel_2.setForeground(new Color(255, 255, 0));
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "FROM", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_2.setLayout(null);
		
		JLabel lblSource = new JLabel("PUNE");
		lblSource.setBounds(26, 14, 66, 28);
		lblSource.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblSource);
		lblSource.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(255, 255, 0));
		panel_2_1.setBounds(153, 15, 157, 56);
		panel_4.add(panel_2_1);
		panel_2_1.setLayout(null);
		panel_2_1.setForeground(Color.YELLOW);
		panel_2_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "TO", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		
		JLabel lblDestination = new JLabel("AURANGABAD");
		lblDestination.setHorizontalAlignment(SwingConstants.CENTER);
		lblDestination.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDestination.setBounds(14, 14, 133, 28);
		panel_2_1.add(lblDestination);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(new Color(255, 255, 0));
		panel_2_2.setBounds(320, 15, 119, 56);
		panel_4.add(panel_2_2);
		panel_2_2.setLayout(null);
		panel_2_2.setForeground(Color.YELLOW);
		panel_2_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "TIME", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		
		JLabel lblTime = new JLabel("09:00 AM");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTime.setBounds(15, 14, 89, 28);
		panel_2_2.add(lblTime);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4_1.setBackground(Color.YELLOW);
		panel_4_1.setBounds(515, 155, 163, 77);
		frmPackage8.getContentPane().add(panel_4_1);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.setLayout(null);
		panel_2_3.setForeground(Color.YELLOW);
		panel_2_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "PRICE", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_2_3.setBackground(Color.YELLOW);
		panel_2_3.setBounds(26, 15, 119, 56);
		panel_4_1.add(panel_2_3);
		
		JLabel lblSource_1 = new JLabel("RS. 1000/-");
		lblSource_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSource_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSource_1.setBounds(10, 14, 99, 28);
		panel_2_3.add(lblSource_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.DARK_GRAY));
		panel_1.setBounds(62, 385, 512, 302);
		frmPackage8.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton b1 = new JButton("1");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=1;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 1 Is Selected", "Seat Booking", 1);
				b1.setForeground(Color.WHITE);
				b1.setBackground(new Color(51,51,102));
			}
		});
		b1.setForeground(Color.WHITE);
		b1.setBackground(new Color(0, 204, 0));
		b1.setFont(new Font("Tahoma", Font.BOLD, 16));
		b1.setBounds(10, 10, 54, 37);
		panel_1.add(b1);
		
		JButton b4 = new JButton("4");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=4;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 4 Is Selected", "Seat Booking", 1);
				b4.setBackground(new Color(51,51,102));
			}
		});
		b4.setForeground(Color.WHITE);
		b4.setBackground(new Color(0, 204, 0));
		b4.setFont(new Font("Tahoma", Font.BOLD, 15));
		b4.setBounds(74, 10, 54, 37);
		panel_1.add(b4);
		
		JButton b7 = new JButton("7");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=7;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 7 Is Selected", "Seat Booking", 1);
				b7.setBackground(new Color(51,51,102));
			}
		});
		b7.setForeground(Color.WHITE);
		b7.setBackground(new Color(0, 204, 0));
		b7.setFont(new Font("Tahoma", Font.BOLD, 15));
		b7.setBounds(161, 10, 54, 37);
		panel_1.add(b7);
		
		JButton b2 = new JButton("2");
		b2.setForeground(Color.WHITE);
		b2.setBackground(new Color(0, 204, 0));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=2;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 2 Is Selected", "Seat Booking", 1);
				b2.setBackground(new Color(51,51,102));
			}
		});
		b2.setFont(new Font("Tahoma", Font.BOLD, 15));
		b2.setBounds(10, 57, 54, 37);
		panel_1.add(b2);
		
		JButton b5 = new JButton("5");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=5;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 5 Is Selected", "Seat Booking", 1);
				b5.setBackground(new Color(51,51,102));
			}
		});
		b5.setForeground(Color.WHITE);
		b5.setBackground(new Color(0, 204, 0));
		b5.setFont(new Font("Tahoma", Font.BOLD, 15));
		b5.setBounds(74, 57, 54, 37);
		panel_1.add(b5);
		
		JButton b8 = new JButton("8");
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=8;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 8 Is Selected", "Seat Booking", 1);
				b8.setBackground(new Color(51,51,102));
			}
		});
		b8.setForeground(Color.WHITE);
		b8.setBackground(new Color(0, 204, 0));
		b8.setFont(new Font("Tahoma", Font.BOLD, 15));
		b8.setBounds(161, 57, 54, 37);
		panel_1.add(b8);
		
		JButton b3 = new JButton("3");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=3;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 3 Is Selected", "Seat Booking", 1);
				b3.setBackground(new Color(51,51,102));
			}
		});
		b3.setForeground(Color.WHITE);
		b3.setBackground(new Color(0, 204, 0));
		b3.setFont(new Font("Tahoma", Font.BOLD, 15));
		b3.setBounds(10, 104, 54, 37);
		panel_1.add(b3);
		
		JButton b6 = new JButton("6");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=6;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 6 Is Selected", "Seat Booking", 1);
				b6.setBackground(new Color(51,51,102));
			}
		});
		b6.setBackground(new Color(0, 204, 0));
		b6.setForeground(Color.WHITE);
		b6.setFont(new Font("Tahoma", Font.BOLD, 15));
		b6.setBounds(74, 104, 54, 37);
		panel_1.add(b6);
		
		JButton b9 = new JButton("9");
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=9;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 9 Is Selected", "Seat Booking", 1);
				b9.setBackground(new Color(51,51,102));
			}
		});
		b9.setBackground(new Color(0, 204, 0));
		b9.setForeground(Color.WHITE);
		b9.setFont(new Font("Tahoma", Font.BOLD, 15));
		b9.setBounds(161, 104, 54, 37);
		panel_1.add(b9);
		
		JButton b10 = new JButton("10");
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=10;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 10 Is Selected", "Seat Booking", 1);
				b10.setBackground(new Color(51,51,102));
			}
		});
		b10.setBackground(new Color(0, 204, 0));
		b10.setForeground(Color.WHITE);
		b10.setFont(new Font("Tahoma", Font.BOLD, 15));
		b10.setBounds(231, 10, 54, 37);
		panel_1.add(b10);
		
		JButton b11 = new JButton("11");
		b11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=11;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 11 Is Selected", "Seat Booking", 1);
				b11.setBackground(new Color(51,51,102));
			}
		});
		b11.setBackground(new Color(0, 204, 0));
		b11.setForeground(Color.WHITE);
		b11.setFont(new Font("Tahoma", Font.BOLD, 15));
		b11.setBounds(231, 57, 54, 37);
		panel_1.add(b11);
		
		JButton b12 = new JButton("12");
		b12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=12;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 12 Is Selected", "Seat Booking", 1);
				b12.setBackground(new Color(51,51,102));
			}
		});
		b12.setBackground(new Color(0, 204, 0));
		b12.setForeground(Color.WHITE);
		b12.setFont(new Font("Tahoma", Font.BOLD, 15));
		b12.setBounds(231, 104, 54, 37);
		panel_1.add(b12);
		
		JButton b13 = new JButton("13");
		b13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=13;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 13 Is Selected", "Seat Booking", 1);
				b13.setBackground(new Color(51,51,102));
			}
		});
		b13.setForeground(Color.WHITE);
		b13.setBackground(new Color(0, 204, 0));
		b13.setBounds(320, 10, 54, 37);
		panel_1.add(b13);
		b13.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton b14 = new JButton("14");
		b14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=14;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 14 Is Selected", "Seat Booking", 1);
				b14.setBackground(new Color(51,51,102));
			}
		});
		b14.setForeground(Color.WHITE);
		b14.setBackground(new Color(0, 204, 0));
		b14.setBounds(320, 57, 54, 37);
		panel_1.add(b14);
		b14.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton b15 = new JButton("15");
		b15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=15;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 15 Is Selected", "Seat Booking", 1);
				b15.setBackground(new Color(51,51,102));
			}
		});
		b15.setForeground(Color.WHITE);
		b15.setBackground(new Color(0, 204, 0));
		b15.setBounds(320, 104, 54, 37);
		panel_1.add(b15);
		b15.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton b16 = new JButton("16");
		b16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=16;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 16 Is Selected", "Seat Booking", 1);
				b16.setBackground(new Color(51,51,102));
			}
		});
		b16.setForeground(Color.WHITE);
		b16.setBackground(new Color(0, 204, 0));
		b16.setBounds(384, 10, 54, 37);
		panel_1.add(b16);
		b16.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton b17 = new JButton("17");
		b17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=17;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 17 Is Selected", "Seat Booking", 1);
				b17.setBackground(new Color(51,51,102));
			}
		});
		b17.setForeground(Color.WHITE);
		b17.setBackground(new Color(0, 204, 0));
		b17.setBounds(384, 57, 54, 37);
		panel_1.add(b17);
		b17.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton b18 = new JButton("18");
		b18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=18;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 18 Is Selected", "Seat Booking", 1);
				b18.setBackground(new Color(51,51,102));
			}
		});
		b18.setForeground(Color.WHITE);
		b18.setBackground(new Color(0, 204, 0));
		b18.setBounds(384, 104, 54, 37);
		panel_1.add(b18);
		b18.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton b19 = new JButton("19");
		b19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=19;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 19 Is Selected", "Seat Booking", 1);
				b19.setBackground(new Color(51,51,102));
			}
		});
		b19.setForeground(Color.WHITE);
		b19.setBackground(new Color(0, 204, 0));
		b19.setBounds(448, 10, 54, 37);
		panel_1.add(b19);
		b19.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton b20 = new JButton("20");
		b20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=20;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 20 Is Selected", "Seat Booking", 1);
				b20.setBackground(new Color(51,51,102));
			}
		});
		b20.setForeground(Color.WHITE);
		b20.setBackground(new Color(0, 204, 0));
		b20.setBounds(448, 57, 54, 37);
		panel_1.add(b20);
		b20.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton b21 = new JButton("21");
		b21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=21;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 21 Is Selected", "Seat Booking", 1);
				b21.setBackground(new Color(51,51,102));
			}
		});
		b21.setForeground(Color.WHITE);
		b21.setBackground(new Color(0, 204, 0));
		b21.setBounds(448, 104, 54, 37);
		panel_1.add(b21);
		b21.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton b22 = new JButton("22");
		b22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=22;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 22 Is Selected", "Seat Booking", 1);
				b22.setBackground(new Color(51,51,102));
			}
		});
		b22.setForeground(Color.WHITE);
		b22.setBackground(new Color(0, 204, 0));
		b22.setFont(new Font("Tahoma", Font.BOLD, 15));
		b22.setBounds(10, 161, 54, 37);
		panel_1.add(b22);
		
		JButton b23 = new JButton("23");
		b23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=23;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 23 Is Selected", "Seat Booking", 1);
				b23.setBackground(new Color(51,51,102));
			}
		});
		b23.setForeground(Color.WHITE);
		b23.setBackground(new Color(0, 204, 0));
		b23.setFont(new Font("Tahoma", Font.BOLD, 15));
		b23.setBounds(10, 208, 54, 37);
		panel_1.add(b23);
		
		JButton b24 = new JButton("24");
		b24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=24;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 24 Is Selected", "Seat Booking", 1);
				b24.setBackground(new Color(51,51,102));
			}
		});
		b24.setForeground(Color.WHITE);
		b24.setBackground(new Color(0, 204, 0));
		b24.setFont(new Font("Tahoma", Font.BOLD, 15));
		b24.setBounds(10, 255, 54, 37);
		panel_1.add(b24);
		
		JButton b25 = new JButton("25");
		b25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=25;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 25 Is Selected", "Seat Booking", 1);
				b25.setBackground(new Color(51,51,102));
			}
		});
		b25.setForeground(Color.WHITE);
		b25.setBackground(new Color(0, 204, 0));
		b25.setFont(new Font("Tahoma", Font.BOLD, 15));
		b25.setBounds(74, 161, 54, 37);
		panel_1.add(b25);
		
		JButton b26 = new JButton("26");
		b26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=26;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 26 Is Selected", "Seat Booking", 1);
				b26.setBackground(new Color(51,51,102));
			}
		});
		b26.setForeground(Color.WHITE);
		b26.setBackground(new Color(0, 204, 0));
		b26.setFont(new Font("Tahoma", Font.BOLD, 15));
		b26.setBounds(74, 208, 54, 37);
		panel_1.add(b26);
		
		JButton b27 = new JButton("27");
		b27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=27;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 27 Is Selected", "Seat Booking", 1);
				b27.setBackground(new Color(51,51,102));
			}
		});
		b27.setForeground(Color.WHITE);
		b27.setBackground(new Color(0, 204, 0));
		b27.setFont(new Font("Tahoma", Font.BOLD, 15));
		b27.setBounds(74, 255, 54, 37);
		panel_1.add(b27);
		
		JButton b28 = new JButton("28");
		b28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=28;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 28 Is Selected", "Seat Booking", 1);
				b28.setBackground(new Color(51,51,102));
			}
		});
		b28.setForeground(Color.WHITE);
		b28.setBackground(new Color(0, 204, 0));
		b28.setFont(new Font("Tahoma", Font.BOLD, 15));
		b28.setBounds(161, 161, 54, 37);
		panel_1.add(b28);
		
		JButton b29 = new JButton("29");
		b29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=29;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 29 Is Selected", "Seat Booking", 1);
				b29.setBackground(new Color(51,51,102));
			}
		});
		b29.setForeground(Color.WHITE);
		b29.setBackground(new Color(0, 204, 0));
		b29.setFont(new Font("Tahoma", Font.BOLD, 15));
		b29.setBounds(161, 208, 54, 37);
		panel_1.add(b29);
		
		JButton b30 = new JButton("30");
		b30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=30;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 30 Is Selected", "Seat Booking", 1);
				b30.setBackground(new Color(51,51,102));
			}
		});
		b30.setForeground(Color.WHITE);
		b30.setBackground(new Color(0, 204, 0));
		b30.setFont(new Font("Tahoma", Font.BOLD, 15));
		b30.setBounds(161, 255, 54, 37);
		panel_1.add(b30);
		
		
		JButton b31 = new JButton("31");
		b31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=31;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 31 Is Selected", "Seat Booking", 1);
				b31.setBackground(new Color(51,51,102));
			}
		});
		b31.setForeground(Color.WHITE);
		b31.setBackground(new Color(0, 204, 0));
		b31.setFont(new Font("Tahoma", Font.BOLD, 15));
		b31.setBounds(231, 161, 54, 37);
		panel_1.add(b31);
		
		JButton b32 = new JButton("32");
		b32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=32;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 32 Is Selected", "Seat Booking", 1);
				b32.setBackground(new Color(51,51,102));
			}
		});
		b32.setForeground(Color.WHITE);
		b32.setBackground(new Color(0, 204, 0));
		b32.setFont(new Font("Tahoma", Font.BOLD, 15));
		b32.setBounds(231, 208, 54, 37);
		panel_1.add(b32);
		
		JButton b33 = new JButton("33");
		b33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=33;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 33 Is Selected", "Seat Booking", 1);
				b33.setBackground(new Color(51,51,102));
			}
		});
		b33.setForeground(Color.WHITE);
		b33.setBackground(new Color(0, 204, 0));
		b33.setFont(new Font("Tahoma", Font.BOLD, 15));
		b33.setBounds(231, 255, 54, 37);
		panel_1.add(b33);
		
		JButton b34 = new JButton("34");
		b34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=34;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 34 Is Selected", "Seat Booking", 1);
				b34.setBackground(new Color(51,51,102));
			}
		});
		b34.setForeground(Color.WHITE);
		b34.setBackground(new Color(0, 204, 0));
		b34.setBounds(320, 161, 54, 37);
		panel_1.add(b34);
		b34.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton b35 = new JButton("35");
		b35.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=35;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 35 Is Selected", "Seat Booking", 1);
				b35.setBackground(new Color(51,51,102));
			}
		});
		b35.setForeground(Color.WHITE);
		b35.setBackground(new Color(0, 204, 0));
		b35.setBounds(320, 208, 54, 37);
		panel_1.add(b35);
		b35.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton b36 = new JButton("36");
		b36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=36;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 36 Is Selected", "Seat Booking", 1);
				b36.setBackground(new Color(51,51,102));
			}
		});
		b36.setForeground(Color.WHITE);
		b36.setBackground(new Color(0, 204, 0));
		b36.setBounds(320, 255, 54, 37);
		panel_1.add(b36);
		b36.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton b37 = new JButton("37");
		b37.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=37;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 37 Is Selected", "Seat Booking", 1);
				b37.setBackground(new Color(51,51,102));
			}
		});
		b37.setForeground(Color.WHITE);
		b37.setBackground(new Color(0, 204, 0));
		b37.setBounds(384, 161, 54, 37);
		panel_1.add(b37);
		b37.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton b38 = new JButton("38");
		b38.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=38;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 38 Is Selected", "Seat Booking", 1);
				b38.setBackground(new Color(51,51,102));
			}
		});
		b38.setForeground(Color.WHITE);
		b38.setBackground(new Color(0, 204, 0));
		b38.setBounds(384, 208, 54, 37);
		panel_1.add(b38);
		b38.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton b39 = new JButton("39");
		b39.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=39;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 39 Is Selected", "Seat Booking", 1);
				b39.setBackground(new Color(51,51,102));
			}
		});
		b39.setForeground(Color.WHITE);
		b39.setBackground(new Color(0, 204, 0));
		b39.setBounds(384, 255, 54, 37);
		panel_1.add(b39);
		b39.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton b40 = new JButton("40");
		b40.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=40;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 40 Is Selected", "Seat Booking", 1);
				b40.setBackground(new Color(51,51,102));
			}
		});
		b40.setForeground(Color.WHITE);
		b40.setBackground(new Color(0, 204, 0));
		b40.setBounds(448, 161, 54, 37);
		panel_1.add(b40);
		b40.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton b41 = new JButton("41");
		b41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=41;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 41 Is Selected", "Seat Booking", 1);
				b41.setBackground(new Color(51,51,102));
			}
		});
		b41.setForeground(Color.WHITE);
		b41.setBackground(new Color(0, 204, 0));
		b41.setBounds(448, 208, 54, 37);
		panel_1.add(b41);
		b41.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton b42 = new JButton("42");
		b42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatno=42;
				JOptionPane.showMessageDialog(frmPackage8, "Seat 42 Is Selected", "Seat Booking", 1);
				b42.setBackground(new Color(51,51,102));
			}
		});
		b42.setForeground(Color.WHITE);
		b42.setBackground(new Color(0, 204, 0));
		b42.setBounds(448, 255, 54, 37);
		panel_1.add(b42);
		b42.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JCalendar txtDate = new JCalendar();
		txtDate.setBorder(new LineBorder(Color.GRAY));
		txtDate.getDayChooser().getDayPanel().setBorder(new LineBorder(Color.GRAY));
		txtDate.getYearChooser().getSpinner().setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDate.getMonthChooser().getComboBox().setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDate.setBounds(600, 438, 385, 249);
		frmPackage8.getContentPane().add(txtDate);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 204, 0));
		panel_3.setBorder(new LineBorder(Color.DARK_GRAY));
		panel_3.setBounds(62, 352, 119, 34);
		frmPackage8.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Select Seat");
		lblNewLabel_1_1_1.setBounds(1, 1, 117, 32);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JTextArea txtBill = new JTextArea();
		txtBill.setEditable(false);
		txtBill.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtBill.setBounds(1026, 155, 449, 608);
		frmPackage8.getContentPane().add(txtBill);

		JButton btnNewButton = new JButton("BOOK NOW");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name,source,destination,time;
				int seat;
				int price;
				
				int min=100;
				int max=999;
				
				String status="BOOKED";
				
				int booking_id=(int)Math.floor(Math.random()*(max-min+1)+min);
				
				name = txtName.getText();
				seat = seatno;
				source = lblSource.getText();
				time = lblTime.getText();
				destination = lblDestination.getText();
				price = 1500;
				SimpleDateFormat date_form = new SimpleDateFormat("dd-MM-yyyy");
				String date = date_form.format(txtDate.getDate()); 
				
				try {
					
					pst = con.prepareStatement("select * from booking where seat_no=? and date=?");
					pst.setInt(1, seat);
					pst.setString(2, date);
					rs = pst.executeQuery();
					
					if(rs.next()==true)
					{
						JOptionPane.showMessageDialog(frmPackage8, "Seat "+seat+" Is Already Booked On "+date+"\n Please Select The Another Seat..!!", "Seat full", 2);
					}
					else if(name.equals(""))
					{
						JOptionPane.showMessageDialog(frmPackage8, "Please Enter Your Name..!!","Name",2);
					}
					else if(seatno==0)
					{
						JOptionPane.showMessageDialog(frmPackage8, "Please Select The Seat..!!","Seat",2);
					}
					else if(date==null)
					{
						JOptionPane.showMessageDialog(frmPackage8, "Please Select The Date..!!","Date",2);
					}
					
					else
					{
						pst=con.prepareStatement("insert into booking(name,seat_no,booking_id,price,date,source,destination,time,status) values(?,?,?,?,?,?,?,?,?)");
						pst.setString(1, name);
						pst.setInt(2, seat);
						pst.setInt(3, booking_id);
						pst.setInt(4, price);
						pst.setString(5, date);
						pst.setString(6, source);
						pst.setString(7, destination);
						pst.setString(8, time);
						pst.setString(9, status);
						int k=pst.executeUpdate();
						
						if(k==1)
						{
							JOptionPane.showMessageDialog(frmPackage8, "SEAT BOOKED SUCCESSFULLY..!!","Successfull",1);
							
							txtBill.setText("---------------------------------------------------------------"
									  + "\n\n"
									  +"                            12G TOURS & TRAVELS "
									  + "\n\n"
									  + "---------------------------------------------------------------"
									  + "\n\n"
									  + "                                     * BILL *"
									  + "\n\n"
									  + "       NAME	:  "+name+" "
									  + "\n"
									  + "       SEAT NO	:  "+seat+" "
									  + "\n"
									  + "       BOOKING ID  :  "+booking_id+" "
									  + "\n"
									  + "       PRICE	:  "+price+" "
									  + "\n"
									  + "       DATE	:  "+date+" "
									  + "\n"
									  + "       TIME	:  "+time+" "
									  + "\n"
									  + "       SOURCE	:  "+source+" "
									  + "\n"
									  + "       DESTINATION : "+destination+" "
									  + "\n"
									  + "       STATUS : "+status+" "
									  + "\n\n"
									  + "---------------------------------------------------------------"
									  + "\n\n"
									  + "Rules :\n"
									  + "1) Please Wear Mask While Journey.\n"
									  + "2) Download Aarogya Setu App."
									);
						
							
						}
						else
						{
							JOptionPane.showMessageDialog(frmPackage8, "Somthing Went Wrong..!!","Errorr",2);
						}
					
						
					
					}
					
	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(243, 719, 152, 44);
		frmPackage8.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage.main(null);
				frmPackage8.setVisible(false);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBackground(new Color(0, 128, 128));
		btnBack.setBounds(68, 719, 98, 44);
		frmPackage8.getContentPane().add(btnBack);
		
	}
}
