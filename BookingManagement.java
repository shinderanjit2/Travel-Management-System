package package1;

import java.awt.EventQueue;


import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class BookingManagement {

	private JFrame frmBookingManagement;
	private JTable btable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingManagement window = new BookingManagement();
					window.frmBookingManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookingManagement() {
		initialize();
		Connect();
		table_load();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtSeatNo;
	private JTextField txtBookingId;
	private JTextField txtPrice;
	private JTextField txtDate;
	private JTextField txtTime;
	private JTextField txtSource;
	private JTextField txtDestination;
	private JTextField txtStatus;
	
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
	
	public void table_load()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travels","root","");
			Statement st = con.createStatement();
			String query="select * from booking";
			//rs=pst.executeQuery();
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model = (DefaultTableModel)btable.getModel();
			
			int cols=rsmd.getColumnCount();
			String[] colName=new String[cols];
			for(int i=0;i<cols;i++)
				colName[i]=rsmd.getColumnName(i+1);
			model.setColumnIdentifiers(colName);
			String no,name,seat,booking_id,price,source,destination,date,time,status;
			
			while(rs.next())
			{
				no=rs.getString(1);
				name=rs.getString(2);
				seat=rs.getString(3);
				booking_id=rs.getString(4);
				source=rs.getString(5);
				destination=rs.getString(6);
				price=rs.getString(7);
				date=rs.getString(8);
				time=rs.getString(9);
				status=rs.getString(10);
				
				String row[]= {no,name,seat,booking_id,source,destination,price,date,time,status};
				model.addRow(row);
			}
			st.close();
			con.close();
			
		}catch(Exception e)
		{
			System.out.print(e);
		}
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBookingManagement = new JFrame();
		frmBookingManagement.setTitle("BOOKING MANAGEMENT PAGE");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		
		//frmPackage1.setResizable(false);
		
		frmBookingManagement.setSize(screenSize.width,height);
		//frmPackage1.setLocationRelativeTo(null);
		frmBookingManagement.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmBookingManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBookingManagement.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int s=btable.getSelectedRow();
				JOptionPane.showMessageDialog(frmBookingManagement, s, "s", 1);

			}
		});
		scrollPane.setBounds(59, 136, 1145, 152);
		frmBookingManagement.getContentPane().add(scrollPane);
		
		btable = new JTable();
		btable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		btable.setFont(new Font("Arial Black", Font.PLAIN, 14));
		scrollPane.setViewportView(btable);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 204, 0));
		panel_1.setBounds(10, 10, 1502, 104);
		frmBookingManagement.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("TWELVE G");
		lblNewLabel_1.setForeground(new Color(102, 51, 255));
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 44));
		lblNewLabel_1.setBounds(615, 0, 271, 85);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblToursAndTravels_1 = new JLabel("TOURS AND TRAVELS");
		lblToursAndTravels_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblToursAndTravels_1.setForeground(Color.RED);
		lblToursAndTravels_1.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblToursAndTravels_1.setBounds(619, 68, 263, 36);
		panel_1.add(lblToursAndTravels_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setBounds(1233, 136, 191, 152);
		frmBookingManagement.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Booking Id");
		lblNewLabel.setBounds(7, 26, 176, 25);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtId = new JTextField();
		txtId.setBounds(33, 61, 124, 25);
		panel.add(txtId);
		txtId.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtId.setColumns(10);
		
		JTextArea txtBookingSleep = new JTextArea();
		txtBookingSleep.setBorder(new LineBorder(Color.BLACK));
		txtBookingSleep.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtBookingSleep.setEditable(false);
		txtBookingSleep.setBounds(896, 313, 449, 484);
		frmBookingManagement.getContentPane().add(txtBookingSleep);
		
		JButton btnShow = new JButton("SHOW");
		btnShow.setBounds(44, 96, 103, 33);
		panel.add(btnShow);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int no;
				String name,seat,booking_id,source,destination,price,date,time,status;
				
				try
				{
					String id,n;
					id=txtId.getText();
					n=txtId.getText();
					pst=con.prepareStatement("select * from booking where booking_id = ? || name=?");
					pst.setString(1, id);
					pst.setString(2, n);
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
						
						
						txtName.setText(name);
						txtSeatNo.setText(seat);
						txtBookingId.setText(booking_id);
						txtSource.setText(source);
						txtDestination.setText(destination);
						txtPrice.setText(price);
						txtDate.setText(date);
						txtTime.setText(time);
						txtStatus.setText(status);

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
						
//						btnCancel.setVisible(true);
						
						
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
					JOptionPane.showMessageDialog(frmBookingManagement, e1, "ID", 2);
				}
				
			}
		});
		btnShow.setForeground(Color.WHITE);
		btnShow.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnShow.setBackground(new Color(65, 105, 225));
		
	;
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(135, 206, 235));
		panel_2.setBorder(new LineBorder(Color.DARK_GRAY));
		panel_2.setBounds(98, 321, 624, 476);
		frmBookingManagement.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(50, 28, 222, 25);
		panel_2.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtName = new JTextField();
		txtName.setBounds(50, 57, 222, 33);
		panel_2.add(txtName);
		txtName.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtName.setColumns(10);
		
		JLabel lblSeatNo = new JLabel("Seat No");
		lblSeatNo.setBounds(50, 100, 222, 25);
		panel_2.add(lblSeatNo);
		lblSeatNo.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtSeatNo = new JTextField();
		txtSeatNo.setBounds(50, 128, 222, 33);
		panel_2.add(txtSeatNo);
		txtSeatNo.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtSeatNo.setColumns(10);
		
		JLabel lblBookingId = new JLabel("Booking ID");
		lblBookingId.setBounds(50, 171, 222, 25);
		panel_2.add(lblBookingId);
		lblBookingId.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtBookingId = new JTextField();
		txtBookingId.setBounds(50, 200, 222, 33);
		panel_2.add(txtBookingId);
		txtBookingId.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtBookingId.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(50, 243, 222, 25);
		panel_2.add(lblPrice);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtPrice = new JTextField();
		txtPrice.setBounds(50, 271, 222, 33);
		panel_2.add(txtPrice);
		txtPrice.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtPrice.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(50, 314, 222, 25);
		panel_2.add(lblDate);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtDate = new JTextField();
		txtDate.setBounds(50, 349, 222, 33);
		panel_2.add(txtDate);
		txtDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtDate.setColumns(10);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(296, 28, 222, 25);
		panel_2.add(lblTime);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtTime = new JTextField();
		txtTime.setBounds(296, 57, 222, 33);
		panel_2.add(txtTime);
		txtTime.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtTime.setColumns(10);
		
		JLabel lblSource = new JLabel("Source");
		lblSource.setBounds(296, 100, 222, 25);
		panel_2.add(lblSource);
		lblSource.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtSource = new JTextField();
		txtSource.setBounds(296, 128, 222, 33);
		panel_2.add(txtSource);
		txtSource.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtSource.setColumns(10);
		
		JLabel lblName_1_1 = new JLabel("Destination");
		lblName_1_1.setBounds(296, 171, 222, 25);
		panel_2.add(lblName_1_1);
		lblName_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtDestination = new JTextField();
		txtDestination.setBounds(296, 200, 222, 33);
		panel_2.add(txtDestination);
		txtDestination.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtDestination.setColumns(10);
		
		JLabel lblSeatNo_1_1 = new JLabel("Status");
		lblSeatNo_1_1.setBounds(296, 243, 222, 25);
		panel_2.add(lblSeatNo_1_1);
		lblSeatNo_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtStatus = new JTextField();
		txtStatus.setBounds(296, 271, 222, 33);
		panel_2.add(txtStatus);
		txtStatus.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtStatus.setColumns(10);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(new Color(0, 204, 0));
		btnUpdate.setBounds(242, 410, 139, 41);
		panel_2.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id,name,seat,booking_id,source,destination,price,date,time,status;
				
				id=txtId.getText();
				name=txtName.getText();
				seat=txtSeatNo.getText();
				booking_id=txtBookingId.getText();
				source=txtSource.getText();
				destination=txtDestination.getText();
				price=txtPrice.getText();
				date=txtDate.getText();
				time=txtTime.getText();
				status=txtStatus.getText();
				try
				{
					pst=con.prepareStatement("update booking set name=?,seat_no=?,booking_id=?,source=?,destination=?,price=?,date=?,time=?, status=? where booking_id=?");
					pst.setString(1, name);
					pst.setString(2, seat);
					pst.setString(3, booking_id);
					pst.setString(4, source);
					pst.setString(5, destination);
					pst.setString(6, price);
					pst.setString(7, date);
					pst.setString(8, time);
					pst.setString(9, status);
					pst.setString(10, id);
					int k=pst.executeUpdate();
					
					if(k==1)
					{
						JOptionPane.showConfirmDialog(frmBookingManagement, "Are You Sure To Update Booking ?", "BOOKING UPODATION", 1, 3);
						
						int no;
//						String name,seat,booking_id,source,destination,price,date,time,status;
						
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
						JOptionPane.showMessageDialog(frmBookingManagement, "Booking Is Not Cancelled..!!","E",2);
					}
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frmBookingManagement, e1, "E", 2);
				}
				
			}
		});
		btnUpdate.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(255, 69, 0));
		btnDelete.setBounds(415, 410, 139, 41);
		panel_2.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
String id,name,seat,booking_id,source,destination,price,date,time,status;
				
				id=txtId.getText();
				name=txtName.getText();
				seat=txtSeatNo.getText();
				booking_id=txtBookingId.getText();
				source=txtSource.getText();
				destination=txtDestination.getText();
				price=txtPrice.getText();
				date=txtDate.getText();
				time=txtTime.getText();
				status=txtStatus.getText();
				try
				{
					pst=con.prepareStatement("delete from booking where booking_id=?");
					pst.setString(1, id);
					int k=pst.executeUpdate();
					
					if(k==1)
					{
						JOptionPane.showConfirmDialog(frmBookingManagement, "Are You Sure To Delete Booking Details ?", "BOOKING DELETION", 1, 3);
						
						
							txtBookingSleep.setText("---------------------------------------------------------------"
									  + "\n\n"
									  +"                            12G TOURS & TRAVELS "
									  + "\n\n"
									  + "---------------------------------------------------------------"
									  + "\n\n"
									  + "        "
									  + "\n"
									  + "        "
									  + "\n"
									  + "       "
									  + "\n"
									  + "       BOOKING DETAILS DELETED SUCCESSFULLY..!! "
									  + "\n"
									  + "      "
									  + "\n"
									  + "      "
									  + "\n"
									  + "  "
									  + "\n"
									  + "        "
									  + "\n"
									  + "        "
									  + "\n\n"
									  + "---------------------------------------------------------------"
									  + "\n\n"
									  
									);
						}
						
						
					
					else
					{
						JOptionPane.showMessageDialog(frmBookingManagement, "Booking Is Not Deleted..!!","BOOKING DELETION",2);
					}
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frmBookingManagement, e1, "E", 2);
				}
				
			}
		});
		btnDelete.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id=txtId.getText();
				String s="CONFIRMED";
				try
				{
					pst=con.prepareStatement("update booking set status=? where booking_id=?");
					pst.setString(1, s);
					pst.setString(2, id);
					int k=pst.executeUpdate();
					
					if(k==1)
					{
						JOptionPane.showMessageDialog(frmBookingManagement, "Booking Confirmed", "Booking Confirmation", 1);
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
						JOptionPane.showMessageDialog(frmBookingManagement, "Booking Is Not Confirmed..!!","E",2);
					}
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frmBookingManagement, e1, "E", 2);
				}
			}
		});
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnConfirm.setBackground(new Color(0, 204, 0));
		btnConfirm.setBounds(316, 344, 146, 41);
		panel_2.add(btnConfirm);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage.main(null);
				frmBookingManagement.setVisible(false);
			}
		});
		btnBack.setBounds(97, 410, 103, 41);
		panel_2.add(btnBack);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(new Color(65, 105, 225));
		
		
	}
}
