import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class ViewContactForm extends JFrame{
	private JTable tblCustomer;
	private DefaultTableModel dtm; 
	private JButton btnReload;
	private ContactCollection contactCollection;
	
	ViewContactForm(ContactCollection contactCollection){
		this.contactCollection = contactCollection;
		setTitle("View Contact Form");
		setSize(400,300);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);
		
		JLabel lblTitle=new JLabel("View Contact Form");
		lblTitle.setFont(new Font("",1,30));
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		add("North",lblTitle);
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnReload=new JButton("Reload");
		btnReload.setFont(new Font("",1,20));
		btnReload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				Contact[] contacts=contactCollection.getContactObjects();
				dtm.setRowCount(0);
				for(Contact c1 : contacts){
					Object[] rowData={c1.getId(),c1.getName(),c1.getNumber(),c1.getEmail()};
					dtm.addRow(rowData);
				}
			}
		});
		buttonPanel.add(btnReload);
		add("South",buttonPanel);
		
		String[] columnNames={"Customer Id","Name","Number","Email"};
		dtm=new DefaultTableModel(columnNames,0); 
		tblCustomer=new JTable(dtm);
		JScrollPane tablePane=new JScrollPane(tblCustomer);
		add("Center",tablePane);
	}
}

