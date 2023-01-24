package package1;

import java.awt.EventQueue;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class SignUpPage {

	protected static final Window frmLoginPage = null;
	private JFrame frmSignUpPage;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtMobileNo;
	private JTextField txtMiddleName;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtConfirmPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpPage window = new SignUpPage();
					window.frmSignUpPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUpPage() {
		initialize();
		Connect();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtEmailID;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public void Connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/travels","root","");
		}catch(ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(frmLoginPage, e, "DATABASE WARNING",1);
			//System.out.print(e);
		}
		catch(SQLException e1)
		{
			JOptionPane.showMessageDialog(frmLoginPage, e1, "DATABASE WARNING",2);
			//System.out.print(e1);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignUpPage = new JFrame();
		frmSignUpPage.setTitle("Registration Page");
		

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		
		frmSignUpPage.setResizable(false);
		
		frmSignUpPage.setSize(1174,800);
		frmSignUpPage.setLocationRelativeTo(null);
		
		//frmSignUp.setBounds(100, 100, 1002, 775);
		frmSignUpPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSignUpPage.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 204, 0));
		panel.setBounds(54, 25, 1060, 125);
		frmSignUpPage.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("TWELVE G");
		lblNewLabel.setForeground(new Color(102, 51, 255));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 60));
		lblNewLabel.setBounds(344, 0, 372, 85);
		panel.add(lblNewLabel);
		
		JLabel lblToursAndTravels = new JLabel("TOURS AND TRAVELS");
		lblToursAndTravels.setHorizontalAlignment(SwingConstants.CENTER);
		lblToursAndTravels.setForeground(Color.RED);
		lblToursAndTravels.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblToursAndTravels.setBounds(398, 79, 263, 36);
		panel.add(lblToursAndTravels);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1.setBounds(54, 212, 116, 29);
		frmSignUpPage.getContentPane().add(lblNewLabel_1);
		
		txtFirstName = new JTextField();
		txtFirstName.setToolTipText("First Name Middle Name Last Name");
		txtFirstName.setFont(new Font("Arial Black", Font.BOLD, 18));
		txtFirstName.setBounds(204, 211, 255, 29);
		frmSignUpPage.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(54, 322, 116, 29);
		frmSignUpPage.getContentPane().add(lblNewLabel_1_1);
		
		txtLastName = new JTextField();
		txtLastName.setToolTipText("First Name Middle Name Last Name");
		txtLastName.setFont(new Font("Arial Black", Font.BOLD, 18));
		txtLastName.setColumns(10);
		txtLastName.setBounds(204, 321, 255, 29);
		frmSignUpPage.getContentPane().add(txtLastName);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mobile No");
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(576, 213, 116, 29);
		frmSignUpPage.getContentPane().add(lblNewLabel_1_2);
		
		txtMobileNo = new JTextField();
		txtMobileNo.setToolTipText("First Name Middle Name Last Name");
		txtMobileNo.setFont(new Font("Arial Black", Font.BOLD, 18));
		txtMobileNo.setColumns(10);
		txtMobileNo.setBounds(763, 211, 326, 29);
		frmSignUpPage.getContentPane().add(txtMobileNo);
		
		JLabel lblNewLabel_1_3 = new JLabel("Address");
		lblNewLabel_1_3.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(54, 382, 116, 29);
		frmSignUpPage.getContentPane().add(lblNewLabel_1_3);
		
		JTextArea txtAddress = new JTextArea();
		txtAddress.setLineWrap(true);
		txtAddress.setFont(new Font("Arial Black", Font.BOLD, 18));
		txtAddress.setBounds(204, 381, 255, 107);
		frmSignUpPage.getContentPane().add(txtAddress);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Date Of Birth");
		lblNewLabel_1_3_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_3_1.setBounds(576, 376, 140, 29);
		frmSignUpPage.getContentPane().add(lblNewLabel_1_3_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setFont(new Font("Arial Black", Font.BOLD, 18));
		dateChooser.setBounds(763, 376, 184, 29);
		frmSignUpPage.getContentPane().add(dateChooser);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setFont(new Font("Arial Black", Font.BOLD, 18));
		rdbtnMale.setBounds(763, 326, 81, 21);
		frmSignUpPage.getContentPane().add(rdbtnMale);
		
		JLabel lblNewLabel_1_4 = new JLabel("Gender");
		lblNewLabel_1_4.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(576, 322, 81, 29);
		frmSignUpPage.getContentPane().add(lblNewLabel_1_4);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Arial Black", Font.BOLD, 18));
		rdbtnFemale.setBounds(846, 326, 101, 21);
		frmSignUpPage.getContentPane().add(rdbtnFemale);
		
		JLabel lblNewLabel_1_5 = new JLabel("Middle Name");
		lblNewLabel_1_5.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_5.setBounds(54, 266, 140, 29);
		frmSignUpPage.getContentPane().add(lblNewLabel_1_5);
		
		txtMiddleName = new JTextField();
		txtMiddleName.setToolTipText("First Name Middle Name Last Name");
		txtMiddleName.setFont(new Font("Arial Black", Font.BOLD, 18));
		txtMiddleName.setColumns(10);
		txtMiddleName.setBounds(204, 265, 255, 29);
		frmSignUpPage.getContentPane().add(txtMiddleName);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(54, 519, 1060, 9);
		frmSignUpPage.getContentPane().add(separator);
		
		JLabel lblNewLabel_1_6 = new JLabel("Create Username");
		lblNewLabel_1_6.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_6.setBounds(75, 558, 189, 29);
		frmSignUpPage.getContentPane().add(lblNewLabel_1_6);
		
		txtUsername = new JTextField();
		txtUsername.setToolTipText("First Name Middle Name Last Name");
		txtUsername.setFont(new Font("Arial Black", Font.BOLD, 18));
		txtUsername.setColumns(10);
		txtUsername.setBounds(306, 557, 255, 29);
		frmSignUpPage.getContentPane().add(txtUsername);
		
		JLabel lblNewLabel_1_7 = new JLabel("Create Password");
		lblNewLabel_1_7.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_7.setBounds(75, 613, 189, 29);
		frmSignUpPage.getContentPane().add(lblNewLabel_1_7);
		
		txtPassword = new JTextField();
		txtPassword.setToolTipText("First Name Middle Name Last Name");
		txtPassword.setFont(new Font("Arial Black", Font.BOLD, 18));
		txtPassword.setColumns(10);
		txtPassword.setBounds(306, 612, 255, 29);
		frmSignUpPage.getContentPane().add(txtPassword);
		
		JLabel lblNewLabel_1_7_1 = new JLabel("Confirm Password");
		lblNewLabel_1_7_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_7_1.setBounds(603, 614, 199, 29);
		frmSignUpPage.getContentPane().add(lblNewLabel_1_7_1);
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setToolTipText("First Name Middle Name Last Name");
		txtConfirmPassword.setFont(new Font("Arial Black", Font.BOLD, 18));
		txtConfirmPassword.setColumns(10);
		txtConfirmPassword.setBounds(834, 613, 255, 29);
		frmSignUpPage.getContentPane().add(txtConfirmPassword);
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setBackground(new Color(0, 204, 0));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fname,mname,lname,add,mob,email,gender = null,dob,username,password, cpassword;
				
				fname = txtFirstName.getText();
				mname = txtMiddleName.getText();
				lname = txtLastName.getText();
				add = txtAddress.getText();
				mob = txtMobileNo.getText();
				email = txtEmailID.getText();
				SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
				dob = dateformat.format(dateChooser.getDate());
				username = txtUsername.getText();
				password = txtPassword.getText();
				cpassword = txtConfirmPassword.getText();
				
				if(rdbtnMale.isSelected())
				{
					gender = "Male";
				}
				else if(rdbtnFemale.isSelected())
				{
					gender = "Female";
				}
				
				try {
				
						pst = con.prepareStatement("insert into users(first_name,middle_name,last_name,address,mobile_no,email_id,gender,date_of_birth,username,password)values(?,?,?,?,?,?,?,?,?,?)");
						pst.setString(1, fname);
						pst.setString(2, mname);
						pst.setString(3, lname);
						pst.setString(4, add);
						pst.setString(5, mob);
						pst.setString(6, email);
						pst.setString(7, gender);
						pst.setString(8, dob);
						pst.setString(9, username);
						pst.setString(10, password);
						
						if(password.equals(cpassword))
						{
							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Registration Is Successfull..!! \n Please Login Now","Success..!!",JOptionPane.INFORMATION_MESSAGE);
							LoginPage.main(null);
							frmSignUpPage.setVisible(false);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Passwords Does Not Matched..!!","Passwords..!!",JOptionPane.INFORMATION_MESSAGE);
						}
						
	
				
				}catch(Exception e1)
				{
					System.out.print(e1);
				}
				
			}
		});
		btnSignUp.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnSignUp.setBounds(394, 698, 132, 43);
		frmSignUpPage.getContentPane().add(btnSignUp);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(50, 665, 1060, 9);
		frmSignUpPage.getContentPane().add(separator_1);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtFirstName.setText("");
				txtMiddleName.setText("");
				txtLastName.setText("");
				txtMobileNo.setText("");
				txtEmailID.setText("");
				txtAddress.setText("");
				txtUsername.setText("");
				txtPassword.setText("");
				txtConfirmPassword.setText("");
			}
		});
		btnReset.setForeground(Color.WHITE);
		btnReset.setBackground(new Color(0, 204, 0));
		btnReset.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnReset.setBounds(618, 698, 132, 43);
		frmSignUpPage.getContentPane().add(btnReset);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(new Color(0, 204, 0));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSignUpPage.setVisible(false);
				LoginPage.main(null);
			}
		});
		btnBack.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnBack.setBounds(174, 698, 132, 43);
		frmSignUpPage.getContentPane().add(btnBack);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(new Color(0, 204, 0));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnExit.setBounds(846, 698, 132, 43);
		frmSignUpPage.getContentPane().add(btnExit);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email ID");
		lblNewLabel_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(576, 274, 116, 29);
		frmSignUpPage.getContentPane().add(lblNewLabel_1_1_1);
		
		txtEmailID = new JTextField();
		txtEmailID.setToolTipText("First Name Middle Name Last Name");
		txtEmailID.setFont(new Font("Arial Black", Font.BOLD, 18));
		txtEmailID.setColumns(10);
		txtEmailID.setBounds(763, 265, 326, 29);
		frmSignUpPage.getContentPane().add(txtEmailID);
	}
}
