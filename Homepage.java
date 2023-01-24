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

public class Homepage {

	private JFrame frmHomepage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage window = new Homepage();
					window.frmHomepage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Homepage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHomepage = new JFrame();
		frmHomepage.setTitle("HOMEPAGE");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		
		frmHomepage.setResizable(false);
		
		frmHomepage.setSize(1439,778);
		frmHomepage.setLocationRelativeTo(null);
		frmHomepage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHomepage.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 204, 0));
		panel_1.setBounds(23, 10, 1379, 125);
		frmHomepage.getContentPane().add(panel_1);
		
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
		
		JButton btnNewButton = new JButton("MY BOOKINGS");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(153, 50, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookingInfo.main(null);
				frmHomepage.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(598, 275, 228, 191);
		frmHomepage.getContentPane().add(btnNewButton);
		
		JButton btnPlanMyJourney = new JButton("PLAN MY JOURNEY");
		btnPlanMyJourney.setForeground(Color.WHITE);
		btnPlanMyJourney.setBackground(new Color(153, 50, 204));
		btnPlanMyJourney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Packages.main(null);
				frmHomepage.setVisible(false);
			}
		});
		btnPlanMyJourney.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnPlanMyJourney.setBounds(194, 275, 228, 191);
		frmHomepage.getContentPane().add(btnPlanMyJourney);
		
		JButton btnAddComplaintsuggestion = new JButton("ADD COMPLAINT");
		btnAddComplaintsuggestion.setForeground(Color.WHITE);
		btnAddComplaintsuggestion.setBackground(new Color(153, 50, 204));
		btnAddComplaintsuggestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComplaintPage.main(null);
			}
		});
		btnAddComplaintsuggestion.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAddComplaintsuggestion.setBounds(1024, 275, 228, 191);
		frmHomepage.getContentPane().add(btnAddComplaintsuggestion);
		
		JButton btnLogOut = new JButton("LOGOUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frmHomepage, "Logout Successfully..!!", "logout", 1);
				LoginPage.main(null);
				frmHomepage.setVisible(false);
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setBackground(new Color(0, 204, 0));
		btnLogOut.setBounds(1278, 158, 124, 33);
		frmHomepage.getContentPane().add(btnLogOut);
	}
}
