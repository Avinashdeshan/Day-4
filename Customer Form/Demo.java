class Demo{
	public static void main(String args[]){
		ContactCollection ContactCollection=new ContactCollection();
		new AddContactForm(ContactCollection).setVisible(true);
		new DeleteContactForm(ContactCollection).setVisible(true);
		new SearchContactForm(ContactCollection).setVisible(true);
		new ViewContactForm(ContactCollection).setVisible(true);
		new UpdateContactForm(ContactCollection).setVisible(true);
	}
}
