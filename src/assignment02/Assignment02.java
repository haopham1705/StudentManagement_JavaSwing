package assignment02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.DropMode;
import javax.swing.UIManager;

public class Assignment02 {

	private JFrame frame;
	private JTextField tfID;
	private JTextField tfName;
	private JTextField tfAge;
	private JTextField tfAddress;
	private JTextField tfEmail;

	/**
	 * Launch the application.
	 */
	private ArrayList<NhanVien>listNV=new ArrayList<NhanVien>();
	private int currentIndex=-1; 
	private JTextField tfSalary;
	private JTextField disID;
	private JTextField disName;
	private JTextField disAge;
	private JTextField disAddress;
	private JTextField disEmail;
	private JTextField disSalary;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Assignment02 window = new Assignment02();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Assignment02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 637, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.ITALIC, 12));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String qtion=JOptionPane.showInputDialog(null,"Nhap ID cần xóa","Delete",JOptionPane.INFORMATION_MESSAGE);
				String ids=(qtion);
				for(NhanVien nv:listNV){
					if(nv.getID()==ids){
						listNV.remove(nv);
						JOptionPane.showMessageDialog(frame, "Xóa thành công","Message",JOptionPane.INFORMATION_MESSAGE);
						save();
						currentIndex--;
						display();
						break;
						
					}
				}
			}
		});
		
		JButton btnOpen = new JButton("Open");
		btnOpen.setFont(new Font("Tahoma", Font.ITALIC, 12));
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});
		
		JButton btnPrivious = new JButton("Previous");
		btnPrivious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentIndex--;
		        if(currentIndex<0){
		            currentIndex = listNV.size()-1;//Cuoi danh sach
		        }
		        display();
			}
		});
		btnPrivious.setBounds(331, 282, 93, 23);
		frame.getContentPane().add(btnPrivious);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentIndex++;
				if(currentIndex>listNV.size()){
					currentIndex=0;
					
				}
				display();
			}
		});
		btnNext.setBounds(439, 282, 86, 23);
		frame.getContentPane().add(btnNext);
		btnOpen.setBounds(530, 94, 74, 37);
		frame.getContentPane().add(btnOpen);
		btnDelete.setBounds(530, 218, 73, 37);
		frame.getContentPane().add(btnDelete);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.ITALIC, 12));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetInfo();
			}
		});
		btnReset.setBounds(530, 156, 74, 37);
		frame.getContentPane().add(btnReset);
		
		disSalary = new JTextField();
		disSalary.setColumns(10);
		disSalary.setBounds(346, 235, 174, 20);
		frame.getContentPane().add(disSalary);
		
		disAge = new JTextField();
		disAge.setColumns(10);
		disAge.setBounds(346, 142, 174, 20);
		frame.getContentPane().add(disAge);
		
		disEmail = new JTextField();
		disEmail.setColumns(10);
		disEmail.setBounds(346, 204, 174, 20);
		frame.getContentPane().add(disEmail);
		
		disAddress = new JTextField();
		disAddress.setColumns(10);
		disAddress.setBounds(346, 173, 174, 20);
		frame.getContentPane().add(disAddress);
		
		disName = new JTextField();
		disName.setColumns(10);
		disName.setBounds(346, 111, 174, 20);
		frame.getContentPane().add(disName);
		
		disID = new JTextField();
		disID.setColumns(10);
		disID.setBounds(346, 75, 174, 20);
		frame.getContentPane().add(disID);
		
		JLabel lblNewLabel = new JLabel("EMPLOYEE MANAGEMENT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBounds(93, 0, 352, 48);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setBounds(38, 81, 63, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("NAME :");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(38, 114, 63, 14);
		frame.getContentPane().add(lblName);
		
		JTextPane textPane = new JTextPane();
		textPane.setDropMode(DropMode.INSERT);
		textPane.setBackground(SystemColor.controlHighlight);
		textPane.setBounds(331, 59, 194, 218);
		frame.getContentPane().add(textPane);
		
		JLabel lblAge = new JLabel("AGE :");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAge.setBounds(38, 145, 63, 14);
		frame.getContentPane().add(lblAge);
		
		JLabel lblAddress = new JLabel("ADDRESS :");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddress.setBounds(38, 176, 63, 14);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblEmail = new JLabel("EMAIL :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(38, 207, 63, 14);
		frame.getContentPane().add(lblEmail);
		
		tfID = new JTextField();
		tfID.setBounds(126, 75, 174, 20);
		frame.getContentPane().add(tfID);
		tfID.setColumns(10);
		
		tfName = new JTextField();
		tfName.setBounds(126, 111, 174, 20);
		frame.getContentPane().add(tfName);
		tfName.setColumns(10);
		
		tfAge = new JTextField();
		tfAge.setColumns(10);
		tfAge.setBounds(126, 142, 174, 20);
		frame.getContentPane().add(tfAge);
		
		tfAddress = new JTextField();
		tfAddress.setColumns(10);
		tfAddress.setBounds(126, 173, 174, 20);
		frame.getContentPane().add(tfAddress);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(126, 204, 174, 20);
		frame.getContentPane().add(tfEmail);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		btnSave.setFont(new Font("Tahoma", Font.ITALIC, 12));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NhanVien nv=new NhanVien();
				nv.setID(tfID.getText());
				nv.setName(tfName.getText());
				nv.setAge(Integer.parseInt(tfAge.getText()));
				nv.setAddress(tfAddress.getText());
				nv.setEmail(tfEmail.getText());
				nv.setSalary(Double.parseDouble(tfSalary.getText()));
				listNV.add(nv);
				save();
				reset();
				
				
				
			}
		});
		btnSave.setBounds(126, 275, 74, 37);
		frame.getContentPane().add(btnSave);
		
		JButton btnNew = new JButton("New");
		btnNew.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		btnNew.setFont(new Font("Tahoma", Font.ITALIC, 12));
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnNew.setBounds(226, 275, 74, 37);
		frame.getContentPane().add(btnNew);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int qtion=JOptionPane.showConfirmDialog(frame, "Muốn thoát ra không?","Message",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(qtion==JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(505, 335, 59, 37);
		frame.getContentPane().add(btnExit);
		
		tfSalary = new JTextField();
		tfSalary.setColumns(10);
		tfSalary.setBounds(126, 235, 174, 20);
		frame.getContentPane().add(tfSalary);
		
		JLabel lblSalary = new JLabel("SALARY :");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSalary.setBounds(38, 238, 63, 14);
		frame.getContentPane().add(lblSalary);
		
	}
	//method save
	public void save(){
		try{
			FileOutputStream fos=new FileOutputStream("NhanVienList.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(listNV);
			oos.close();
			fos.close();
			JOptionPane.showMessageDialog(frame, "Lưu thành công !","Message",JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception ex){
			JOptionPane.showMessageDialog(frame, " Bị lỗi, không thể lưu !","Message", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//method hien thi
	public void display(){
		NhanVien nv=listNV.get(currentIndex);
		disID.setText(nv.getID());
		disName.setText(nv.getName());
		disAge.setText(String.valueOf(nv.getAge()));
		disAddress.setText(nv.getAddress());
		disEmail.setText(nv.getEmail());
		disSalary.setText(String.valueOf(nv.getSalary()));
	
	}
	//method open
	public void open(){
		try{
			FileInputStream fis=new FileInputStream("NhanVienList.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			listNV=(ArrayList<NhanVien>) ois.readObject();
			ois.close();
			fis.close();
			if(listNV.size()>0){
				currentIndex=0;
				this.display();
				JOptionPane.showMessageDialog(frame,"Mở danh sách thành công","Massage",JOptionPane.INFORMATION_MESSAGE);
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(frame,"Mở danh sách lỗi","Massage",JOptionPane.INFORMATION_MESSAGE);

			
		}
	}
	public void reset(){
		tfID.setText("");
		tfName.setText("");
		tfAge.setText("");
		tfAddress.setText("");
		tfEmail.setText("");
		tfSalary.setText("");
		
	}
	public void resetInfo(){
		disID.setText("");
		disName.setText("");
		disAge.setText("");
		disAddress.setText("");
		disEmail.setText("");
		disSalary.setText("");
	}
}
