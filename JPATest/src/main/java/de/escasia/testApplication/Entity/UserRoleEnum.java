package de.escasia.testApplication.Entity;

public enum UserRoleEnum {

	ShopBesitzer(1, "ShopOwner"),
	Mitarbeiter(2,"Employee"),
	Manager (3, "Manager");
	
	public static final String ShopOwner = "ShopOwner";
	public static final String Employee_ = "Employee";
	public static final String manager = "Manager";
	
	private int id; 
	private String label;
	private UserRoleEnum(int id, String label){
		this.id = id;
		this.label = label;
	}
	public int getId() {
		return id;
	}
	public String getLabel() {
		return label;
	}
	public UserRoleEnum getEnum() {
		return this;
	}
}
