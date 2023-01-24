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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPage {

	private JFrame frmAdminPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage window = new AdminPage();
					window.frmAdminPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminPage = new JFrame();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		
		frmAdminPage.setResizable(false);
		
		frmAdminPage.setSize(1439,778);
		frmAdminPage.setLocationRelativeTo(null);		frmAdminPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminPage.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 204, 0));
		panel_1.setBounds(23, 10, 1379, 125);
		frmAdminPage.getContentPane().add(panel_1);
		
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
		
		JButton btnManageUsers = new JButton("MANAGE USERS");
		btnManageUsers.setForeground(Color.WHITE);
		btnManageUsers.setBackground(new Color(153, 50, 204));
		btnManageUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserManagement.main(null);
				frmAdminPage.setVisible(false);
			}
		});
		btnManageUsers.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnManageUsers.setBounds(207, 275, 264, 191);
		frmAdminPage.getContentPane().add(btnManageUsers);
		
		JButton btnManageBooking = new JButton("MANAGE BOOKING");
		btnManageBooking.setForeground(Color.WHITE);
		btnManageBooking.setBackground(new Color(153, 50, 204));
		btnManageBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookingManagement.main(null);
				frmAdminPage.setVisible(false);
			}
		});
		btnManageBooking.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnManageBooking.setBounds(611, 275, 264, 191);
		frmAdminPage.getContentPane().add(btnManageBooking);
		
		JButton btnManageComplaints = new JButton("MANAGE COMPLAINTS");
		btnManageComplaints.setForeground(Color.WHITE);
		btnManageComplaints.setBackground(new Color(153, 50, 204));
		btnManageComplaints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComplaintManagement.main(null);
				frmAdminPage.setVisible(false);
			}
		});
		btnManageComplaints.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnManageComplaints.setBounds(1037, 275, 264, 191);
		frmAdminPage.getContentPane().add(btnManageComplaints);
		
		JButton btnLogOut = new JButton("LOGOUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(frmAdminPage, "Are You Sure To Log Out ?", "BOOKING UPODATION", 1, 3);

				JOptionPane.showMessageDialog(null, "Log Out Successfull..!!","Logout Success..!!",JOptionPane.INFORMATION_MESSAGE);

				LoginPage.main(null);
				frmAdminPage.setVisible(false);
			}
		});
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogOut.setBackground(new Color(0, 204, 0));
		btnLogOut.setBounds(1278, 163, 124, 33);
		frmAdminPage.getContentPane().add(btnLogOut);
	}
}
