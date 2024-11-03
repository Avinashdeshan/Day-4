
class Contact{
	private String id;
	private String name;
	private int number;
	private String email;
	

	Contact(String id, String name, int number, String email){
		this.id=id;
		this.name=name;
		this.number=number;
		this.email=email;
	}
	public String getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public int getNumber(){
		return number;
	}
	public String getEmail(){
		return email;
	}
	public void setId(String id){
		this.id=id;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setNumber(int number){
		this.number=number;
	}
	public void setEmail(String email){
		this.email=email;
	}
	
	public boolean equals(Contact contact){
		return this.id.equalsIgnoreCase(contact.id);
	}
}
