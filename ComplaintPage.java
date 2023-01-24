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
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ComplaintPage {

	private JFrame frmComplaintPage;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComplaintPage window = new ComplaintPage();
					window.frmComplaintPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ComplaintPage() {
		initialize();
		Connect();
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
			JOptionPane.showMessageDialog(frmComplaintPage, e, "DATABASE WARNING",1);
			//System.out.print(e);
		}
		catch(SQLException e1)
		{
			JOptionPane.showMessageDialog(frmComplaintPage, e1, "DATABASE WARNING",2);
			//System.out.print(e1);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmComplaintPage = new JFrame();
		frmComplaintPage.setTitle("COMPLAINT PAGE");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		
		frmComplaintPage.setResizable(false);
		
		frmComplaintPage.setSize(462,651);
		frmComplaintPage.setLocationRelativeTo(null);
		frmComplaintPage.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmComplaintPage.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 204, 0));
		panel.setBounds(10, 10, 428, 125);
		frmComplaintPage.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("TWELVE G");
		lblNewLabel.setForeground(new Color(102, 51, 255));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 60));
		lblNewLabel.setBounds(28, 0, 372, 85);
		panel.add(lblNewLabel);
		
		JLabel lblToursAndTravels = new JLabel("TOURS AND TRAVELS");
		lblToursAndTravels.setHorizontalAlignment(SwingConstants.CENTER);
		lblToursAndTravels.setForeground(Color.RED);
		lblToursAndTravels.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblToursAndTravels.setBounds(82, 79, 263, 36);
		panel.add(lblToursAndTravels);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(20, 190, 58, 22);
		frmComplaintPage.getContentPane().add(lblName);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtName.setBounds(20, 222, 382, 46);
		frmComplaintPage.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblComplaint = new JLabel("Complaint");
		lblComplaint.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblComplaint.setBounds(20, 300, 103, 22);
		frmComplaintPage.getContentPane().add(lblComplaint);
		
		JTextArea txtComplaint = new JTextArea();
		txtComplaint.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtComplaint.setLineWrap(true);
		txtComplaint.setBounds(20, 332, 382, 179);
		frmComplaintPage.getContentPane().add(txtComplaint);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try
				{
					
				
				String name,complaint;
				
				name=txtName.getText();
				complaint=txtComplaint.getText();
				
				if(name.equals(""))
				{
					JOptionPane.showMessageDialog(txtName, "Please Enter Your Name", "Name",2);
				}
				else if(complaint.equals(""))
				{
					JOptionPane.showMessageDialog(txtName, "Please Enter Your Complaint", "Complaint",2);
				}
				
				else
				{
					pst=con.prepareStatement("insert into complaints(name,complaint) values(?,?)");
					pst.setString(1, name);
					pst.setString(2, complaint);
					int k=pst.executeUpdate();
					
					if(k==1)
					{
						JOptionPane.showMessageDialog(frmComplaintPage, "Thank You..!!", "SucessFull", 1);
					}
				}
				
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frmComplaintPage, e1);
				}
				
				
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(51, 204, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(159, 558, 130, 33);
		frmComplaintPage.getContentPane().add(btnNewButton);
	}
}
