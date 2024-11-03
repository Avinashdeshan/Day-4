
class ContactCollection{
	private Contact[] contactArray;
	
	ContactCollection(){
		contactArray=new Contact[0];
	}
	public boolean addContact(Contact contact){
		extendsArray();
		contactArray[contactArray.length-1]=contact;
		return true;
	}
	public Contact searchContact(String id){
		for (int i = 0; i <contactArray.length; i++){
			if(contactArray[i].getId().equalsIgnoreCase(id)){
				return contactArray[i];
			}
		}
		return null;
	}
	public int size(){
		return contactArray.length;
	}
	public Contact get(int index){
		if(index>=0 && index<size()){
			return contactArray[index];
		}
		return null;
	}
	private void extendsArray(){
		Contact[] tempContactArray=new Contact[contactArray.length+1];
		for (int i = 0; i < contactArray.length; i++){
			tempContactArray[i]=contactArray[i];
		}
		contactArray=tempContactArray;
	}	
	public boolean deleteContact(String id){
		int index=-1;
		for (int i = 0; i < contactArray.length; i++){
			if(contactArray[i].getId().equalsIgnoreCase(id)){
				index=i;
				break;
			}
		}
		if(index==-1){
			return false;
		}else{
			for (int i = index; i < contactArray.length-1; i++){
				contactArray[i]=contactArray[i+1];
			}
			Contact[] tempContactArray=new Contact[contactArray.length-1];
			for (int i = 0; i < tempContactArray.length; i++){
				tempContactArray[i]=contactArray[i];
			}
			contactArray=tempContactArray;
			return true;	
		}
	}
	public boolean updateContact(Contact contact){
		int index=searchContact(contact);
		if(index!=-1){
			contactArray[index]=contact;
			return true;
		}
		return false;
	}
	public int searchContact(Contact contact){
		for (int i = 0; i < contactArray.length; i++){
			if(contact.getId().equalsIgnoreCase(contactArray[i].getId())){
				return i;	
			}
		}
		return -1;
	}
	public void printcontact(){
		System.out.printf("%-8s%-15s%-20s%10s\n","Id","Name","Number","Email");
		System.out.println("-----------------------------------------------------");
		for(Contact c1 :contactArray){
			System.out.println(c1);
		}
	}	
	public Contact[] getContactObjects(){
		Contact[] tempContactArray=new Contact[contactArray.length];
		for (int i = 0; i < contactArray.length; i++){
			tempContactArray[i]=contactArray[i];
		}
		return tempContactArray;
	}
	public String autoGenerateId(){
		if(size()==0){
			return "C001";
		}else{
			int lastNumber=Integer.parseInt(contactArray[contactArray.length-1].getId().substring(1));
			return String.format("C%03d",lastNumber+1);
		}
		//return size()==0 ? "C001":String.format("C%04d",Integer.parseInt(customerArray[customerArray.length-1].getId().substring(1))+1);
	}	
	
}

