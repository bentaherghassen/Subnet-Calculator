
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Toolkit;

	 /**
	 *
	 *@author bentaherghassen
	 * 
	 */

public class InterFace extends JFrame{
	
	private static final long serialVersionUID = 1L;
	public Calculator Cal = new Calculator();
	private JPanel contentPane;
	
	
	int xx,xy;
	
	protected JLabel Message;
	protected JLabel Network;
	protected JLabel BroadcastAddLabel;
	protected JLabel BroadcastAdd;
	protected JLabel FirstIpAdd;
	protected JLabel LastIpAdd;
	protected JLabel NumberOfHosts;
	protected JLabel WildCard;
	private JTextField IpAdd;
	private JTextField Subnet;
	
	protected JLabel MessageLabel;
	protected JLabel NetworkLabel;
	protected JLabel FirstIpAddLabel;
	protected JLabel LastIpAddLabel;
	protected JLabel NumberOfHostsLabel;
	protected JLabel WildCardLabel;

/**
 * Launch the application.
 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterFace frame = new InterFace();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

/**
 * 
 * Create the frame.
*/
	public InterFace () {
	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bentaherghassen\\eclipse-workspace\\Subnet Calculator\\images\\calculator-icon.png"));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 354);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(236,236,236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 346, 490);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel(".GHASSEN </ BEN TAHER > ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Ubuntu bold", Font.PLAIN, 11));
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setBounds(68, 267, 214, 18);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 xx = e.getX();
			     xy = e.getY();
			}
		});
		label.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				int x = arg0.getXOnScreen();
	            int y = arg0.getYOnScreen();
	            InterFace.this.setLocation(x - xx, y - xy);  
			}
		});
		label.setBounds(-38, 0, 420, 256);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(new ImageIcon("C:\\Users\\bentaherghassen\\eclipse-workspace\\Subnet Calculator\\images\\bg.jpg"));
		panel.add(label);
		
		JLabel lblGhassenBenTaher = new JLabel("- COPYRIGHT .©");
		lblGhassenBenTaher.setHorizontalAlignment(SwingConstants.CENTER);
		lblGhassenBenTaher.setForeground(new Color(240, 248, 255));
		lblGhassenBenTaher.setFont(new Font("Ubuntu", Font.PLAIN, 10));
		lblGhassenBenTaher.setBounds(103, 293, 141, 18);
		panel.add(lblGhassenBenTaher);
		
		
		// Exit the prog
		JLabel lbl_close = new JLabel("X");
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.exit(0);
			}
		});
		lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_close.setForeground(new Color(241, 57, 83));
		lbl_close.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		lbl_close.setBounds(691, 0, 37, 27);
		contentPane.add(lbl_close);
		
		JPanel MainPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) MainPanel.getLayout();
		flowLayout.setHgap(30);
		flowLayout.setAlignment(FlowLayout.TRAILING);
		MainPanel.setBackground(new Color(236,236,236));
		MainPanel.setBounds(356, 17, 347, 33);
		contentPane.add(MainPanel);
		
		IpAdd = new JTextField();
		IpAdd.setText("192.168.0.1");
		IpAdd.setFont(new Font("Ubuntu", Font.PLAIN, 10));
		IpAdd.setColumns(10);
		MainPanel.add(IpAdd);
		
		Subnet = new JTextField();
		Subnet.setText("255.255.255.0");
		Subnet.setFont(new Font("Ubuntu", Font.PLAIN, 10));
		Subnet.setColumns(10);
		MainPanel.add(Subnet);
		
		Button enter = new Button("Enter");
		enter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (IpAdd.getText().matches(".*[0-9]+.*")) {
					Message.setText("Results!");
					Cal.clearMessage();
					String IP = IpAdd.getText();
					String Netmask = Subnet.getText();
					Cal.setIP(IP);
					Cal.setSubnet(Netmask);
					Cal.init();
					Message.setText(Cal.getMessage());
					Subnet.setText(Cal.getSubnet());
					Network.setText(Cal.getNetwork());
					BroadcastAdd.setText(Cal.getBroadcast());
					FirstIpAdd.setText(Cal.getFirstadd());
					LastIpAdd.setText(Cal.getLastadd());
					NumberOfHosts.setText(Cal.getNumberOfHosts() + "");
					WildCard.setText(Cal.getWildcard());
				}
				
			}
				
				
			
		});
		enter.setForeground(Color.WHITE);
		enter.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		enter.setBackground(new Color(1, 50, 67));
		MainPanel.add(enter);
		
		JPanel InformationPanel = new JPanel();
		InformationPanel.setBackground(new Color(236,236,236));
		InformationPanel.setBounds(355, 74, 358, 275);
		InformationPanel.setLayout(new GridLayout(7, 2));
		//InformationPanel.setBorder(BorderFactory.createTitledBorder("Results"));
		MessageLabel = new JLabel("Message:");
		MessageLabel.setFont(new Font("Ubuntu", Font.PLAIN, 10));
		contentPane.add(InformationPanel);
		WildCard = new JLabel("");
		WildCard.setFont(new Font("Ubuntu", Font.PLAIN, 10));
		InformationPanel.setLayout(new GridLayout(0, 2, 0, 0));
		InformationPanel.add(MessageLabel);
		Message = new JLabel("");
		Message.setFont(new Font("Ubuntu", Font.PLAIN, 10));
		InformationPanel.add(Message);
		NetworkLabel = new JLabel("Network:");
		NetworkLabel.setFont(new Font("Ubuntu", Font.PLAIN, 10));
		InformationPanel.add(NetworkLabel);
		Network = new JLabel("");
		Network.setFont(new Font("Ubuntu", Font.PLAIN, 10));
		InformationPanel.add(Network);
		FirstIpAddLabel = new JLabel("First IP:");
		FirstIpAddLabel.setFont(new Font("Ubuntu", Font.PLAIN, 10));
		InformationPanel.add(FirstIpAddLabel);
		FirstIpAdd = new JLabel("");
		FirstIpAdd.setFont(new Font("Ubuntu", Font.PLAIN, 10));
		InformationPanel.add(FirstIpAdd);
		LastIpAddLabel = new JLabel("Last IP:");
		LastIpAddLabel.setFont(new Font("Ubuntu", Font.PLAIN, 10));
		InformationPanel.add(LastIpAddLabel);
		LastIpAdd = new JLabel("");
		LastIpAdd.setFont(new Font("Ubuntu", Font.PLAIN, 10));
		InformationPanel.add(LastIpAdd);
		NumberOfHostsLabel = new JLabel("Number Of Hosts: ");
		NumberOfHostsLabel.setFont(new Font("Ubuntu", Font.PLAIN, 10));
		InformationPanel.add(NumberOfHostsLabel);
		NumberOfHosts = new JLabel("");
		NumberOfHosts.setFont(new Font("Ubuntu", Font.PLAIN, 10));
		InformationPanel.add(NumberOfHosts);
		BroadcastAddLabel = new JLabel("Broadcast Address:");
		BroadcastAddLabel.setFont(new Font("Ubuntu", Font.PLAIN, 10));
		InformationPanel.add(BroadcastAddLabel);
		BroadcastAdd = new JLabel("");
		BroadcastAdd.setFont(new Font("Ubuntu", Font.PLAIN, 10));
		InformationPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{MessageLabel, Message, NetworkLabel, Network, FirstIpAddLabel, FirstIpAdd, LastIpAddLabel, LastIpAdd, NumberOfHostsLabel, NumberOfHosts, BroadcastAddLabel, BroadcastAdd, WildCardLabel, WildCard}));
		InformationPanel.add(BroadcastAdd);
		WildCardLabel = new JLabel("Wildcard:");
		WildCardLabel.setFont(new Font("Ubuntu", Font.PLAIN, 10));
		InformationPanel.add(WildCardLabel);
		InformationPanel.add(WildCard);
	}
}