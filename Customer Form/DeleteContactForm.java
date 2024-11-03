import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class DeleteContactForm extends JFrame{
	private JLabel lblTitle;
	
	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblNumber;
	private JLabel lblEmail;
	
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtNumber;
	private JTextField txtEmail;
	
	private JButton btnDelete;
	private JButton btnCancel;
	
	private ContactCollection contactCollection;
	
	DeleteContactForm(ContactCollection contactCollection){
		this.contactCollection=contactCollection;
		setSize(400,300);
		setTitle("Delete Contact Form");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//------------Add Title Label-----------------
		lblTitle=new JLabel("Delete Contact Form");
		lblTitle.setFont(new Font("",1,30));
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		add("North",lblTitle);
		
		//------------Add Button----------------------
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnDelete=new JButton("Delete Contact");
		btnDelete.setFont(new Font("",1,18));
		btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				boolean isDeleted=contactCollection.deleteContact(txtId.getText());				
				if(isDeleted){
					JOptionPane.showMessageDialog(null,"Deleted...");
				}else{
					JOptionPane.showMessageDialog(null,"Contact not found..");
				}
			}
		});

		buttonPanel.add(btnDelete);
		
		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,18));
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});
		buttonPanel.add(btnCancel);
		
		add("South",buttonPanel);
		
		JPanel labelPanel=new JPanel(new GridLayout(4,1,4,4));
		lblId=new JLabel("Id");
		lblId.setFont(new Font("",1,18));
		labelPanel.add(lblId);
		
		lblName=new JLabel("Name");
		lblName.setFont(new Font("",1,18));
		labelPanel.add(lblName);
		
		lblNumber=new JLabel("Number");
		lblNumber.setFont(new Font("",1,18));
		labelPanel.add(lblNumber);
		
		lblEmail=new JLabel("Email");
		lblEmail.setFont(new Font("",1,18));
		labelPanel.add(lblEmail);
		
		add("West",labelPanel);
		
		JPanel textPanel=new JPanel(new GridLayout(4,1,4,4));
		txtId=new JTextField(5);
		txtId.setFont(new Font("",1,18));
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		idTextPanel.add(txtId);
		txtId.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				Contact c1=contactCollection.searchContact(txtId.getText());				
				if(c1!=null){
					txtName.setText(c1.getName());
					txtNumber.setText(String.valueOf(c1.getNumber()));
					txtEmail.setText(""+c1.getEmail());
				}else{
					JOptionPane.showMessageDialog(null,"Contact not found..");
				}
			}
		});
		textPanel.add(idTextPanel);
		
		txtName=new JTextField(10);
		txtName.setFont(new Font("",1,18));
		JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameTextPanel.add(txtName);
		textPanel.add(nameTextPanel);
		
		txtNumber=new JTextField(15);
		txtNumber.setFont(new Font("",1,18));
		JPanel numberTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		numberTextPanel.add(txtNumber);
		textPanel.add(numberTextPanel);
		
		txtEmail=new JTextField(8);
		txtEmail.setFont(new Font("",1,18));
		JPanel emailTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		emailTextPanel.add(txtEmail);
		textPanel.add(emailTextPanel);
		
		add("Center",textPanel);
	}
}
