package package1;

import java.awt.Dimension;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Packages implements MouseListener{

	private JFrame frmPackages;
	int seatno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Packages window = new Packages();
					window.frmPackages.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Packages() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPackages = new JFrame();
		frmPackages.setTitle("Packages");

		

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		
		frmPackages.setResizable(false);
		
		frmPackages.setSize(1439,778);
		frmPackages.setLocationRelativeTo(null);
		
		
		//frmBookingPage.setBounds(100, 100, 1464, 775);
		frmPackages.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPackages.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 204, 0));
		panel_1.setBounds(25, 10, 1379, 125);
		frmPackages.getContentPane().add(panel_1);
		
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
		
		JLabel lblNewLabel = new JLabel("SELECT YOUR JOURNEY..!!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(599, 164, 227, 31);
		frmPackages.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Package1.main(null);
			}
		});
		panel.setBackground(new Color(153, 51, 0));
		panel.setBorder(new LineBorder(Color.BLACK));
		panel.setBounds(55, 226, 271, 225);
		frmPackages.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Package1.main(null);
			}
		});
		panel_2.setBackground(Color.YELLOW);
		panel_2.setBorder(new LineBorder(Color.BLACK));
		panel_2.setBounds(31, 10, 208, 42);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblPuneMumbai = new JLabel("PUNE --> MUMBAI");
		lblPuneMumbai.setBounds(13, 5, 182, 31);
		panel_2.add(lblPuneMumbai);
		lblPuneMumbai.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuneMumbai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Package1.main(null);
			}
		});
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new LineBorder(Color.BLACK));
		panel_3.setBounds(31, 66, 208, 130);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("TIME   :   09:00 AM");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(23, 30, 162, 20);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("PRICE : RS. 500/-");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(23, 60, 155, 20);
		panel_3.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("DATE : FLEXIBLE");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_2.setBounds(23, 90, 155, 20);
		panel_3.add(lblNewLabel_2_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Package5.main(null);
				frmPackages.setVisible(false);
			}
		});
		panel_4.setBackground(new Color(153, 51, 0));
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(Color.BLACK));
		panel_4.setBounds(55, 474, 271, 225);
		frmPackages.getContentPane().add(panel_4);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(Color.BLACK));
		panel_2_1.setBackground(Color.YELLOW);
		panel_2_1.setBounds(31, 10, 208, 42);
		panel_4.add(panel_2_1);
		
		JLabel lblPuneMumbai_1 = new JLabel("PUNE --> NAGPUR");
		lblPuneMumbai_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuneMumbai_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPuneMumbai_1.setBounds(13, 5, 182, 31);
		panel_2_1.add(lblPuneMumbai_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new LineBorder(Color.BLACK));
		panel_3_1.setBackground(Color.WHITE);
		panel_3_1.setBounds(31, 66, 208, 130);
		panel_4.add(panel_3_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("TIME   :   09:00 AM");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_3.setBounds(23, 30, 162, 20);
		panel_3_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("PRICE : RS. 1000/-");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBounds(23, 60, 162, 20);
		panel_3_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("DATE : FLEXIBLE");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_2_1.setBounds(23, 90, 155, 20);
		panel_3_1.add(lblNewLabel_2_2_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Package2.main(null);
				frmPackages.setVisible(false);
			}
		});
		panel_5.setBackground(new Color(153, 51, 0));
		panel_5.setLayout(null);
		panel_5.setBorder(new LineBorder(Color.BLACK));
		panel_5.setBounds(394, 226, 271, 225);
		frmPackages.getContentPane().add(panel_5);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBorder(new LineBorder(Color.BLACK));
		panel_2_2.setBackground(new Color(255, 255, 0));
		panel_2_2.setBounds(31, 10, 208, 42);
		panel_5.add(panel_2_2);
		
		JLabel lblPuneMumbai_2 = new JLabel("PUNE --> BARAMATI");
		lblPuneMumbai_2.setForeground(Color.BLACK);
		lblPuneMumbai_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuneMumbai_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPuneMumbai_2.setBounds(13, 5, 182, 31);
		panel_2_2.add(lblPuneMumbai_2);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Package2.main(null);
			}
		});
		panel_3_2.setLayout(null);
		panel_3_2.setBorder(new LineBorder(Color.BLACK));
		panel_3_2.setBackground(Color.WHITE);
		panel_3_2.setBounds(31, 66, 208, 130);
		panel_5.add(panel_3_2);
		
		JLabel lblNewLabel_2_4 = new JLabel("TIME   :   09:00 AM");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_4.setBounds(23, 30, 162, 20);
		panel_3_2.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("PRICE : RS. 500/-");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_2.setBounds(23, 60, 155, 20);
		panel_3_2.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("DATE : FLEXIBLE");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_2_2.setBounds(23, 90, 155, 20);
		panel_3_2.add(lblNewLabel_2_2_2);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Package6.main(null);
				frmPackages.setVisible(false);
			}
		});
		panel_4_1.setBackground(new Color(153, 51, 0));
		panel_4_1.setLayout(null);
		panel_4_1.setBorder(new LineBorder(Color.BLACK));
		panel_4_1.setBounds(394, 474, 271, 225);
		frmPackages.getContentPane().add(panel_4_1);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new LineBorder(Color.BLACK));
		panel_2_1_1.setBackground(Color.YELLOW);
		panel_2_1_1.setBounds(31, 10, 208, 42);
		panel_4_1.add(panel_2_1_1);
		
		JLabel lblPuneMumbai_1_1 = new JLabel("PUNE --> ALIBAUG");
		lblPuneMumbai_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuneMumbai_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPuneMumbai_1_1.setBounds(13, 5, 182, 31);
		panel_2_1_1.add(lblPuneMumbai_1_1);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setBorder(new LineBorder(Color.BLACK));
		panel_3_1_1.setBackground(Color.WHITE);
		panel_3_1_1.setBounds(31, 66, 208, 130);
		panel_4_1.add(panel_3_1_1);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("TIME   :   09:00 AM");
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_3_1.setBounds(23, 30, 162, 20);
		panel_3_1_1.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("PRICE : RS. 800/-");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1.setBounds(23, 60, 155, 20);
		panel_3_1_1.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("DATE : FLEXIBLE");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_2_1_1.setBounds(23, 90, 155, 20);
		panel_3_1_1.add(lblNewLabel_2_2_1_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Package3.main(null);
			}
		});
		panel_6.setBackground(new Color(153, 51, 0));
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(Color.BLACK));
		panel_6.setBounds(744, 226, 271, 225);
		frmPackages.getContentPane().add(panel_6);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.setLayout(null);
		panel_2_3.setBorder(new LineBorder(Color.BLACK));
		panel_2_3.setBackground(Color.YELLOW);
		panel_2_3.setBounds(31, 10, 208, 42);
		panel_6.add(panel_2_3);
		
		JLabel lblPuneMumbai_3 = new JLabel("PUNE --> SATARA");
		lblPuneMumbai_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuneMumbai_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPuneMumbai_3.setBounds(13, 5, 182, 31);
		panel_2_3.add(lblPuneMumbai_3);
		
		JPanel panel_3_3 = new JPanel();
		panel_3_3.setLayout(null);
		panel_3_3.setBorder(new LineBorder(Color.BLACK));
		panel_3_3.setBackground(Color.WHITE);
		panel_3_3.setBounds(31, 66, 208, 130);
		panel_6.add(panel_3_3);
		
		JLabel lblNewLabel_2_5 = new JLabel("TIME   :   09:00 AM");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_5.setBounds(23, 30, 162, 20);
		panel_3_3.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("PRICE : RS. 500/-");
		lblNewLabel_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_3.setBounds(23, 60, 155, 20);
		panel_3_3.add(lblNewLabel_2_1_3);
		
		JLabel lblNewLabel_2_2_3 = new JLabel("DATE : FLEXIBLE");
		lblNewLabel_2_2_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_2_3.setBounds(23, 90, 155, 20);
		panel_3_3.add(lblNewLabel_2_2_3);
		
		JPanel panel_4_2 = new JPanel();
		panel_4_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Package7.main(null);
				frmPackages.setVisible(false);
			}
		});
		panel_4_2.setBackground(new Color(153, 51, 0));
		panel_4_2.setLayout(null);
		panel_4_2.setBorder(new LineBorder(Color.BLACK));
		panel_4_2.setBounds(744, 474, 271, 225);
		frmPackages.getContentPane().add(panel_4_2);
		
		JPanel panel_2_1_2 = new JPanel();
		panel_2_1_2.setLayout(null);
		panel_2_1_2.setBorder(new LineBorder(Color.BLACK));
		panel_2_1_2.setBackground(Color.YELLOW);
		panel_2_1_2.setBounds(31, 10, 208, 42);
		panel_4_2.add(panel_2_1_2);
		
		JLabel lblPuneMumbai_1_2 = new JLabel("PUNE --> AMRAVATI");
		lblPuneMumbai_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuneMumbai_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPuneMumbai_1_2.setBounds(13, 5, 182, 31);
		panel_2_1_2.add(lblPuneMumbai_1_2);
		
		JPanel panel_3_1_2 = new JPanel();
		panel_3_1_2.setLayout(null);
		panel_3_1_2.setBorder(new LineBorder(Color.BLACK));
		panel_3_1_2.setBackground(Color.WHITE);
		panel_3_1_2.setBounds(31, 66, 208, 130);
		panel_4_2.add(panel_3_1_2);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("TIME   :   09:00 AM");
		lblNewLabel_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_3_2.setBounds(23, 30, 162, 20);
		panel_3_1_2.add(lblNewLabel_2_3_2);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("PRICE : RS. 1500/-");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1_2.setBounds(23, 60, 162, 20);
		panel_3_1_2.add(lblNewLabel_2_1_1_2);
		
		JLabel lblNewLabel_2_2_1_2 = new JLabel("DATE : FLEXIBLE");
		lblNewLabel_2_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_2_1_2.setBounds(23, 90, 155, 20);
		panel_3_1_2.add(lblNewLabel_2_2_1_2);
		
		JPanel panel_7 = new JPanel();
		panel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Package4.main(null);
			}
		});
		panel_7.setBackground(new Color(153, 51, 0));
		panel_7.setLayout(null);
		panel_7.setBorder(new LineBorder(Color.BLACK));
		panel_7.setBounds(1094, 226, 271, 225);
		frmPackages.getContentPane().add(panel_7);
		
		JPanel panel_2_4 = new JPanel();
		panel_2_4.setLayout(null);
		panel_2_4.setBorder(new LineBorder(Color.BLACK));
		panel_2_4.setBackground(Color.YELLOW);
		panel_2_4.setBounds(31, 10, 208, 42);
		panel_7.add(panel_2_4);
		
		JLabel lblPuneMumbai_4 = new JLabel("PUNE --> KOLHAPUR");
		lblPuneMumbai_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuneMumbai_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPuneMumbai_4.setBounds(13, 5, 182, 31);
		panel_2_4.add(lblPuneMumbai_4);
		
		JPanel panel_3_4 = new JPanel();
		panel_3_4.setLayout(null);
		panel_3_4.setBorder(new LineBorder(Color.BLACK));
		panel_3_4.setBackground(Color.WHITE);
		panel_3_4.setBounds(31, 66, 208, 130);
		panel_7.add(panel_3_4);
		
		JLabel lblNewLabel_2_6 = new JLabel("TIME   :   09:00 AM");
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_6.setBounds(23, 30, 162, 20);
		panel_3_4.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_2_1_4 = new JLabel("PRICE : RS. 1000/-");
		lblNewLabel_2_1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_4.setBounds(23, 60, 162, 20);
		panel_3_4.add(lblNewLabel_2_1_4);
		
		JLabel lblNewLabel_2_2_4 = new JLabel("DATE : FLEXIBLE");
		lblNewLabel_2_2_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_2_4.setBounds(23, 90, 155, 20);
		panel_3_4.add(lblNewLabel_2_2_4);
		
		JPanel panel_4_3 = new JPanel();
		panel_4_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Package8.main(null);
				frmPackages.setVisible(false);
			}
		});
		panel_4_3.setBackground(new Color(153, 51, 0));
		panel_4_3.setLayout(null);
		panel_4_3.setBorder(new LineBorder(Color.BLACK));
		panel_4_3.setBounds(1094, 474, 271, 225);
		frmPackages.getContentPane().add(panel_4_3);
		
		JPanel panel_2_1_3 = new JPanel();
		panel_2_1_3.setLayout(null);
		panel_2_1_3.setBorder(new LineBorder(Color.BLACK));
		panel_2_1_3.setBackground(Color.YELLOW);
		panel_2_1_3.setBounds(26, 10, 219, 42);
		panel_4_3.add(panel_2_1_3);
		
		JLabel lblPuneMumbai_1_3 = new JLabel("PUNE --> AURANGABAD");
		lblPuneMumbai_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuneMumbai_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPuneMumbai_1_3.setBounds(6, 5, 206, 31);
		panel_2_1_3.add(lblPuneMumbai_1_3);
		
		JPanel panel_3_1_3 = new JPanel();
		panel_3_1_3.setLayout(null);
		panel_3_1_3.setBorder(new LineBorder(Color.BLACK));
		panel_3_1_3.setBackground(Color.WHITE);
		panel_3_1_3.setBounds(31, 66, 208, 130);
		panel_4_3.add(panel_3_1_3);
		
		JLabel lblNewLabel_2_3_3 = new JLabel("TIME   :   09:00 AM");
		lblNewLabel_2_3_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_3_3.setBounds(23, 30, 162, 20);
		panel_3_1_3.add(lblNewLabel_2_3_3);
		
		JLabel lblNewLabel_2_1_1_3 = new JLabel("PRICE : RS. 1500/-");
		lblNewLabel_2_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1_3.setBounds(23, 60, 162, 20);
		panel_3_1_3.add(lblNewLabel_2_1_1_3);
		
		JLabel lblNewLabel_2_2_1_3 = new JLabel("DATE : FLEXIBLE");
		lblNewLabel_2_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_2_1_3.setBounds(23, 90, 155, 20);
		panel_3_1_3.add(lblNewLabel_2_2_1_3);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage.main(null);
				frmPackages.setVisible(false);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(new Color(65, 105, 225));
		btnBack.setBounds(55, 162, 103, 33);
		frmPackages.getContentPane().add(btnBack);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		Object lbl1 = null;
		Object lbl2 = null;
		if(e.getSource()==lbl1)
		{
			seatno=1;
		}
		else if(e.getSource()==lbl2)
		{
			seatno=2;
		}
		JOptionPane.showMessageDialog(frmPackages, seatno);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
