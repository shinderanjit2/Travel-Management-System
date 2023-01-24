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

public class ComplaintManagement {

	private JFrame frmComplaintPage;
	private JTable btable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComplaintManagement window = new ComplaintManagement();
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
	public ComplaintManagement() {
		initialize();
		Connect();
		table_load();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtId;
	
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
			String query="select * from complaints";
			//rs=pst.executeQuery();
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model = (DefaultTableModel)btable.getModel();
			
			int cols=rsmd.getColumnCount();
			String[] colName=new String[cols];
			for(int i=0;i<cols;i++)
				colName[i]=rsmd.getColumnName(i+1);
			model.setColumnIdentifiers(colName);
			String no,name,complaint;
			
			while(rs.next())
			{
				no=rs.getString(1);
				name=rs.getString(2);
				complaint=rs.getString(3);
				
				String row[]= {no,name,complaint};
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
		frmComplaintPage = new JFrame();
		frmComplaintPage.setTitle("COMPLAINT MANAGEMENT PAGE");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		
		//frmPackage1.setResizable(false);
		
		frmComplaintPage.setSize(screenSize.width,height);
		//frmPackage1.setLocationRelativeTo(null);
		frmComplaintPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmComplaintPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmComplaintPage.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int s=btable.getSelectedRow();
				JOptionPane.showMessageDialog(frmComplaintPage, s, "s", 1);

			}
		});
		scrollPane.setBounds(59, 136, 1145, 152);
		frmComplaintPage.getContentPane().add(scrollPane);
		
		btable = new JTable();
		btable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		btable.setFont(new Font("Arial Black", Font.PLAIN, 14));
		scrollPane.setViewportView(btable);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 204, 0));
		panel_1.setBounds(10, 10, 1502, 104);
		frmComplaintPage.getContentPane().add(panel_1);
		
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
		frmComplaintPage.getContentPane().add(panel);
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
		txtBookingSleep.setBounds(481, 313, 533, 472);
		frmComplaintPage.getContentPane().add(txtBookingSleep);
		
		JButton btnShow = new JButton("SHOW");
		btnShow.setBounds(79, 96, 103, 33);
		panel.add(btnShow);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int no;
				String name,complaint;			
				try
				{
					String n=txtId.getText();
					pst=con.prepareStatement("select * from complaints where no = ?");
					pst.setString(1, n);
					rs=pst.executeQuery();
					
					if(rs.next()==true)
					{
						no=rs.getInt(1);
						name=rs.getString(2);
						complaint=rs.getString(3);
						
						txtBookingSleep.setText("---------------------------------------------------------------"
								  + "\n\n"
								  +"                            12G TOURS & TRAVELS "
								  + "\n\n"
								  + "---------------------------------------------------------------"
								  + "\n\n"
								  + "       NAME : "+name+""
								  + "\n"
								  + "  "
								  + "\n"
								  + "       COMPLAINT :  "
								  + "\n\n"
								  + "       "+complaint+" "
								);
								}
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frmComplaintPage, e1, "ID", 2);
				}
				
			}
		});
		btnShow.setForeground(Color.WHITE);
		btnShow.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnShow.setBackground(new Color(65, 105, 225));
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage.main(null);
				frmComplaintPage.setVisible(false);
				
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(new Color(65, 105, 225));
		btnBack.setBounds(107, 313, 103, 40);
		frmComplaintPage.getContentPane().add(btnBack);
		
	;
		
		
	}
}
