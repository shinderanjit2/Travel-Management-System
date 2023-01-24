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

public class UserManagement {

	private JFrame frmUserManagement;
	private JTable btable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManagement window = new UserManagement();
					window.frmUserManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserManagement() {
		initialize();
		Connect();
		table_load();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtId;
	private JTextField txtFName;
	private JTextField txtLName;
	private JTextField txtMobile;
	private JTextField txtGender;
	private JTextField txtUsername;
	private JTextField txtMName;
	private JTextField txtAdd;
	private JTextField txtEMail;
	private JTextField txtDOB;
	
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
			String query="select * from users";
			//rs=pst.executeQuery();
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model = (DefaultTableModel)btable.getModel();
			
			int cols=rsmd.getColumnCount();
			String[] colName=new String[cols];
			for(int i=0;i<cols;i++)
				colName[i]=rsmd.getColumnName(i+1);
			model.setColumnIdentifiers(colName);
			String no,fname,mname,lname,add,mobile,email,gender,dob,username;
			
			while(rs.next())
			{
				no=rs.getString(1);
				fname=rs.getString(2);
				mname=rs.getString(3);
				lname=rs.getString(4);
				add=rs.getString(5);
				mobile=rs.getString(6);
				email=rs.getString(7);
				gender=rs.getString(8);
				dob=rs.getString(9);
				username=rs.getString(10);
				
				String row[]= {no,fname,mname,lname,add,mobile,email,gender,dob,username};
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
		frmUserManagement = new JFrame();
		frmUserManagement.setTitle("USER MANAGEMENT PAGE");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		
		//frmPackage1.setResizable(false);
		
		frmUserManagement.setSize(screenSize.width,height);
		//frmPackage1.setLocationRelativeTo(null);
		frmUserManagement.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmUserManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUserManagement.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int s=btable.getSelectedRow();
				JOptionPane.showMessageDialog(frmUserManagement, s, "s", 1);

			}
		});
		scrollPane.setBounds(59, 136, 1145, 152);
		frmUserManagement.getContentPane().add(scrollPane);
		
		btable = new JTable();
		btable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		btable.setFont(new Font("Arial Black", Font.PLAIN, 14));
		scrollPane.setViewportView(btable);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 204, 0));
		panel_1.setBounds(10, 10, 1502, 104);
		frmUserManagement.getContentPane().add(panel_1);
		
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
		panel.setBounds(1233, 136, 262, 152);
		frmUserManagement.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Search ID");
		lblNewLabel.setBounds(43, 26, 176, 25);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtId = new JTextField();
		txtId.setBounds(27, 61, 207, 25);
		panel.add(txtId);
		txtId.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtId.setColumns(10);
		
		JTextArea txtBookingSleep = new JTextArea();
		txtBookingSleep.setBorder(new LineBorder(Color.BLACK));
		txtBookingSleep.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtBookingSleep.setEditable(false);
		txtBookingSleep.setBounds(885, 313, 560, 484);
		frmUserManagement.getContentPane().add(txtBookingSleep);
		
		JButton btnShow = new JButton("SHOW");
		btnShow.setBounds(79, 96, 103, 33);
		panel.add(btnShow);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int no;
				String fname,mname,lname,add,mob,email,gender,dob,username;			
				try
				{
					String uname=txtId.getText();
					pst=con.prepareStatement("select * from users where username = ?");
					pst.setString(1, uname);
					rs=pst.executeQuery();
					
					if(rs.next()==true)
					{
						no=rs.getInt(1);
						fname=rs.getString(2);
						mname=rs.getString(3);
						lname=rs.getString(4);
						add=rs.getString(5);
						mob=rs.getString(6);
						email=rs.getString(7);
						gender=rs.getString(8);
						dob=rs.getString(9);
						username=rs.getString(10);
						
						
						txtFName.setText(fname);
						txtMName.setText(mname);
						txtLName.setText(lname);
						txtAdd.setText(add);
						txtMobile.setText(mob);
						txtEMail.setText(email);
						txtGender.setText(gender);
						txtDOB.setText(dob);
						txtUsername.setText(username);

						txtBookingSleep.setText("---------------------------------------------------------------"
								  + "\n\n"
								  +"                            12G TOURS & TRAVELS "
								  + "\n\n"
								  + "---------------------------------------------------------------"
								  + "\n\n"
								  + "                                     * BILL *"
								  + "\n\n"
								  + "       NAME	:  "+fname+" "+mname+" "+lname+" "
								  + "\n"
								  + "       ADRESS	:  "+add+" "
								  + "\n"
								  + "       MOBILE NO :  "+mob+" "
								  + "\n"
								  + "       EMAIL	:  "+email+" "
								  + "\n"
								  + "       GENDER  :  "+gender+" "
								  + "\n"
								  + "       DATE OF BIRTH  :  "+dob+" "
								  + "\n"
								  + "       USERNAME :"+username+" "
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
					JOptionPane.showMessageDialog(frmUserManagement, e1, "ID", 2);
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
		panel_2.setBounds(98, 321, 727, 460);
		frmUserManagement.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblName = new JLabel("First Name");
		lblName.setBounds(50, 28, 222, 25);
		panel_2.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtFName = new JTextField();
		txtFName.setBounds(50, 57, 222, 33);
		panel_2.add(txtFName);
		txtFName.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtFName.setColumns(10);
		
		JLabel lblSeatNo = new JLabel("Last Name");
		lblSeatNo.setBounds(50, 100, 222, 25);
		panel_2.add(lblSeatNo);
		lblSeatNo.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtLName = new JTextField();
		txtLName.setBounds(50, 128, 222, 33);
		panel_2.add(txtLName);
		txtLName.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtLName.setColumns(10);
		
		JLabel lblBookingId = new JLabel("Mobile No");
		lblBookingId.setBounds(50, 171, 222, 25);
		panel_2.add(lblBookingId);
		lblBookingId.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtMobile = new JTextField();
		txtMobile.setBounds(50, 200, 222, 33);
		panel_2.add(txtMobile);
		txtMobile.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtMobile.setColumns(10);
		
		JLabel lblPrice = new JLabel("Gender");
		lblPrice.setBounds(50, 243, 222, 25);
		panel_2.add(lblPrice);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtGender = new JTextField();
		txtGender.setBounds(50, 271, 222, 33);
		panel_2.add(txtGender);
		txtGender.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtGender.setColumns(10);
		
		JLabel lblDate = new JLabel("Username");
		lblDate.setBounds(50, 314, 222, 25);
		panel_2.add(lblDate);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtUsername = new JTextField();
		txtUsername.setBounds(50, 349, 222, 33);
		panel_2.add(txtUsername);
		txtUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtUsername.setColumns(10);
		
		JLabel lblTime = new JLabel("Middle Name");
		lblTime.setBounds(296, 28, 222, 25);
		panel_2.add(lblTime);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtMName = new JTextField();
		txtMName.setBounds(296, 57, 222, 33);
		panel_2.add(txtMName);
		txtMName.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtMName.setColumns(10);
		
		JLabel lblSource = new JLabel("Address");
		lblSource.setBounds(296, 100, 222, 25);
		panel_2.add(lblSource);
		lblSource.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtAdd = new JTextField();
		txtAdd.setBounds(296, 128, 222, 33);
		panel_2.add(txtAdd);
		txtAdd.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtAdd.setColumns(10);
		
		JLabel lblName_1_1 = new JLabel("Email ID");
		lblName_1_1.setBounds(296, 171, 222, 25);
		panel_2.add(lblName_1_1);
		lblName_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtEMail = new JTextField();
		txtEMail.setBounds(296, 200, 222, 33);
		panel_2.add(txtEMail);
		txtEMail.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtEMail.setColumns(10);
		
		JLabel lblSeatNo_1_1 = new JLabel("Date Of Birth");
		lblSeatNo_1_1.setBounds(296, 243, 222, 25);
		panel_2.add(lblSeatNo_1_1);
		lblSeatNo_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtDOB = new JTextField();
		txtDOB.setBounds(296, 271, 222, 33);
		panel_2.add(txtDOB);
		txtDOB.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtDOB.setColumns(10);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(new Color(0, 204, 0));
		btnUpdate.setBounds(201, 409, 139, 41);
		panel_2.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = txtId.getText();
				String fname,mname,lname,add,mob,email,gender,dob,username;				
				fname=txtFName.getText();
				mname=txtMName.getText();
				lname=txtLName.getText();
				add=txtAdd.getText();
				mob=txtMobile.getText();
				email=txtEMail.getText();
				gender=txtGender.getText();
				dob=txtDOB.getText();
				username=txtUsername.getText();
				try
				{
					pst=con.prepareStatement("update users set first_name=?,middle_name=?,last_name=?,address=?,mobile_no=?,email_id=?,gender=?,date_of_birth=?,username=? where username=?");
					pst.setString(1, fname);
					pst.setString(2, mname);
					pst.setString(3, lname);
					pst.setString(4, add);
					pst.setString(5, mob);
					pst.setString(6, email);
					pst.setString(7, gender);
					pst.setString(8, dob);
					pst.setString(9, username);
					pst.setString(10, id);
					int k=pst.executeUpdate();
					
					if(k==1)
					{
						JOptionPane.showConfirmDialog(frmUserManagement, "Are You Sure To Update User ?", "BOOKING UPDATION", 1, 3);
						
						int no;
//						String name,seat,booking_id,source,destination,price,date,time,status;
						
						//String id=txtId.getText();
						pst=con.prepareStatement("select * from users where username = ?");
						pst.setString(1, id);
						rs=pst.executeQuery();
						
						if(rs.next()==true)
						{
							no=rs.getInt(1);
							fname=rs.getString(2);
							mname=rs.getString(3);
							lname=rs.getString(4);
							add=rs.getString(5);
							mob=rs.getString(6);
							email=rs.getString(7);
							gender=rs.getString(8);
							dob=rs.getString(9);
							username=rs.getString(10);
							
							txtBookingSleep.setText("---------------------------------------------------------------"
									  + "\n\n"
									  +"                            12G TOURS & TRAVELS "
									  + "\n\n"
									  + "---------------------------------------------------------------"
									  + "\n\n"
									  + "                                     * BILL *"
									  + "\n\n"
									  + "       NAME	:  "+fname+" "+mname+" "+username+" "
									  + "\n"
									  + "       ADRESS	:  "+add+" "
									  + "\n"
									  + "       email	:  "+email+" "
									  + "\n"
									  + "       GENDER  :  "+gender+" "
									  + "\n"
									  + "       DATE OF BIRTH  :  "+dob+" "
									  + "\n"
									  + "       USERNAME :"+username+" "
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
						JOptionPane.showMessageDialog(frmUserManagement, "User Data Is Not Updated..!!","E",2);
					}
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frmUserManagement, e1, "E", 2);
				}
				
			}
		});
		btnUpdate.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(255, 69, 0));
		btnDelete.setBounds(366, 409, 139, 41);
		panel_2.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id,name,seat,booking_id,source,destination,price,date,time,status;
//				
				id=txtId.getText();
//				name=txtFName.getText();
//				seat=txtLName.getText();
//				booking_id=txtMobile.getText();
//				source=txtAdd.getText();
//				destination=txtEMail.getText();
//				price=txtGender.getText();
//				date=txtUsername.getText();
//				time=txtMName.getText();
//				status=txtDOB.getText();
				try
				{
					pst=con.prepareStatement("delete from users where username=?");
					pst.setString(1, id);
					int k=pst.executeUpdate();
					
					if(k==1)
					{
						JOptionPane.showConfirmDialog(frmUserManagement, "Are You Sure To Delete User Details ?", "USER DELETION", 1, 3);
						
						
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
						JOptionPane.showMessageDialog(frmUserManagement, "User Is Not Deleted..!!","BOOKING DELETION",2);
					}
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frmUserManagement, e1, "E", 2);
				}
				
			}
		});
		btnDelete.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage.main(null);
				frmUserManagement.setVisible(false);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(new Color(65, 105, 225));
		btnBack.setBounds(68, 409, 103, 41);
		panel_2.add(btnBack);
		
		
	}
}
