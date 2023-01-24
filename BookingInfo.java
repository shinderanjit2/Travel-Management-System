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
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextArea;
import java.sql.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookingInfo {

	private JFrame frmBookingInfo;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingInfo window = new BookingInfo();
					window.frmBookingInfo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookingInfo() {
		initialize();
		Connect();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	public void Connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/travels","root","");
		}catch(ClassNotFoundException e)
		{
			System.out.print(e);
		}
		catch(SQLException e1)
		{
			System.out.print(e1);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBookingInfo = new JFrame();
		frmBookingInfo.setTitle("BOOKING INFORMATION PAGE");
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		
		frmBookingInfo.setResizable(false);
		
		frmBookingInfo.setSize(1439,778);
		frmBookingInfo.setLocationRelativeTo(null);
		frmBookingInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBookingInfo.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 204, 0));
		panel_1.setBounds(23, 10, 1379, 125);
		frmBookingInfo.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("TWELVE G");
		lblNewLabel_1.setForeground(new Color(102, 51, 255));
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 60));
		lblNewLabel_1.setBounds(503, 0, 372, 85);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblToursAndTravels_1 = new JLabel("TOURS AND TRAVELS");
		lblToursAndTravels_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblToursAndTravels_1.setForeground(Color.RED);
		lblToursAndTravels_1.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblToursAndTravels_1.setBounds(558, 79, 263, 36);
		panel_1.add(lblToursAndTravels_1);
		
		JTextArea txtBookingSleep = new JTextArea();
		txtBookingSleep.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtBookingSleep.setEditable(false);
		txtBookingSleep.setBounds(446, 145, 449, 515);
		frmBookingInfo.getContentPane().add(txtBookingSleep);
		
		JLabel lblNewLabel = new JLabel("Enter Your Booking Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(57, 260, 228, 25);
		frmBookingInfo.getContentPane().add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
					
			}
		});
		txtId.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtId.setBounds(57, 295, 222, 25);
		frmBookingInfo.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JButton btnCancel = new JButton("CANCEL TICKET");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				String id=txtId.getText();
				String s="CANNCELLED";
				try
				{
					pst=con.prepareStatement("update booking set status=? where booking_id=?");
					pst.setString(1, s);
					pst.setString(2, id);
					int k=pst.executeUpdate();
					
					if(k==1)
					{
						JOptionPane.showConfirmDialog(frmBookingInfo, "Are You Sure To Cancel Booking ?", "BOOKING CANCELLATION", 1, 3);
						
						int no;
						String name,seat,booking_id,source,destination,price,date,time,status;
						
						//String id=txtId.getText();
						pst=con.prepareStatement("select * from booking where booking_id = ?");
						pst.setString(1, id);
						rs=pst.executeQuery();
						
						if(rs.next()==true)
						{
							no=rs.getInt(1);
							name=rs.getString(2);
							seat=rs.getString(3);
							booking_id=rs.getString(4);
							source=rs.getString(5);
							destination=rs.getString(6);
							price=rs.getString(7);
							date=rs.getString(8);
							time=rs.getString(9);
							status=rs.getString(10);
							
							txtBookingSleep.setText("---------------------------------------------------------------"
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
									  + "       STATUS :"+status+" "
									  + "\n\n"
									  + "---------------------------------------------------------------"
									  + "\n\n"
									  + "Rules :\n"
									  + "1) Please Wear Mask While Journey.\n"
									  + "2) Download Aarogya Setu App."
									);
						}
						
						
					}
					else
					{
						JOptionPane.showMessageDialog(frmBookingInfo, "Booking Is Not Cancelled..!!","E",2);
					}
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frmBookingInfo, e1, "E", 2);
				}
				
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancel.setBackground(Color.RED);
		btnCancel.setBounds(581, 682, 208, 33);
		frmBookingInfo.getContentPane().add(btnCancel);
		btnCancel.setVisible(false);
		
		JButton btnShow = new JButton("SHOW");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int no;
				String name,seat,booking_id,source,destination,price,date,time,status;
				
				try
				{
					String id=txtId.getText();
					pst=con.prepareStatement("select * from booking where booking_id = ?");
					pst.setString(1, id);
					rs=pst.executeQuery();
					
					if(rs.next()==true)
					{
						no=rs.getInt(1);
						name=rs.getString(2);
						seat=rs.getString(3);
						booking_id=rs.getString(4);
						source=rs.getString(5);
						destination=rs.getString(6);
						price=rs.getString(7);
						date=rs.getString(8);
						time=rs.getString(9);
						status=rs.getString(10);
						

						txtBookingSleep.setText("---------------------------------------------------------------"
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
								  + "       STATUS :"+status+" "
								  + "\n\n"
								  + "---------------------------------------------------------------"
								  + "\n\n"
								  + "Rules :\n"
								  + "1) Please Wear Mask While Journey.\n"
								  + "2) Download Aarogya Setu App."
								);
						
						btnCancel.setVisible(true);
						
						
					}
					
					else
					{
						txtBookingSleep.setText("---------------------------------------------------------------"
								  + "\n\n"
								  +"                            12G TOURS & TRAVELS "
								  + "\n\n"
								  + "---------------------------------------------------------------"
								  + "\n\n"
								  + "                    "
								  + "\n\n"
								  + "         "
								  + "\n"
								  + "        "
								  + "\n"
								  + "       "
								  + "\n"
								  + "     NO BOOKING DETAILS FOUND..!! "
								  + "\n"
								  + "        "
								  + "\n"
								  + "    "
								  + "\n"
								  + "       "
								  + "\n"
								  + "        "
								  + "\n\n"
								  + "---------------------------------------------------------------"
								  + "\n\n"
								  + ""
								  + "\n"
								  + ""
								);
					}
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frmBookingInfo, e1, "ID", 2);
				}
				
			}
		});
		btnShow.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnShow.setForeground(Color.WHITE);
		btnShow.setBackground(new Color(65, 105, 225));
		btnShow.setBounds(120, 342, 103, 33);
		frmBookingInfo.getContentPane().add(btnShow);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage.main(null);
				frmBookingInfo.setVisible(false);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(new Color(65, 105, 225));
		btnBack.setBounds(38, 165, 103, 33);
		frmBookingInfo.getContentPane().add(btnBack);
		
	
	}
}
