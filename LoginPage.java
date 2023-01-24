package package1;

import java.awt.EventQueue;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.DropMode;

public class LoginPage {

	private JFrame frmLoginPage;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frmLoginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginPage = new JFrame();
		frmLoginPage.setTitle("LOGIN PAGE");
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		
		frmLoginPage.setResizable(false);
		
		frmLoginPage.setSize(462,651);
		frmLoginPage.setLocationRelativeTo(null);
		
		//frmLoginPage.setBounds(100, 100, 462, 651);
		frmLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginPage.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 204, 0));
		panel.setBounds(24, 32, 403, 125);
		frmLoginPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TWELVE G");
		lblNewLabel.setForeground(new Color(102, 51, 255));
		lblNewLabel.setBounds(26, 0, 372, 85);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 60));
		
		JLabel lblToursAndTravels = new JLabel("TOURS AND TRAVELS");
		lblToursAndTravels.setHorizontalAlignment(SwingConstants.CENTER);
		lblToursAndTravels.setForeground(Color.RED);
		lblToursAndTravels.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblToursAndTravels.setBounds(80, 79, 263, 36);
		panel.add(lblToursAndTravels);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		panel_1.setBounds(48, 198, 352, 315);
		frmLoginPage.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 26));
		lblNewLabel_1.setBounds(21, 39, 194, 25);
		panel_1.add(lblNewLabel_1);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Arial Black", Font.BOLD, 26));
		txtUsername.setBounds(31, 74, 291, 35);
		panel_1.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 26));
		lblNewLabel_1_1.setBounds(21, 145, 194, 25);
		panel_1.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travels","root","");
					Statement stmt = con.createStatement();
					String sql = "select * from users where username = '"+txtUsername.getText()+"' and password = '"+txtPassword.getText().toString()+"' ";
					ResultSet rs = stmt.executeQuery(sql);
					String username=txtUsername.getText();
					String password=txtPassword.getText();
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null, "Login Successfull..!!","Login Success..!!",JOptionPane.INFORMATION_MESSAGE);
						Homepage.main(null);
						frmLoginPage.setVisible(false);

					}
					else if(username.equals("admin") && password.equals("admin1"))
					{
						JOptionPane.showMessageDialog(null, "Login Successfull..!!","Login Success..!!",JOptionPane.INFORMATION_MESSAGE);
						AdminPage.main(null);
						frmLoginPage.setVisible(false);
					}
					else if(username.equals("admin2") && password.equals("admin2"))
					{
						JOptionPane.showMessageDialog(null, "Login Successfull..!!","Login Success..!!",JOptionPane.INFORMATION_MESSAGE);
						AdminPage.main(null);
						frmLoginPage.setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Check The Credentials..!!");

					}
					con.close();
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Database Error..!!", "Database Error", 2);
					//System.out.print(e1);
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 204, 0));
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 24));
		btnNewButton.setBounds(111, 241, 129, 43);
		panel_1.add(btnNewButton);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtPassword.setBounds(31, 180, 291, 35);
		panel_1.add(txtPassword);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		panel_2.setBounds(48, 548, 352, 32);
		frmLoginPage.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("SIGN UP AS NEW USER.");
		lblNewLabel_2.setBounds(0, 0, 352, 32);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(0, 204, 0));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setToolTipText("Sign Up");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				frmLoginPage.setVisible(false);
				SignUpPage.main(null);
			}
		});
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 22));
	}
}
