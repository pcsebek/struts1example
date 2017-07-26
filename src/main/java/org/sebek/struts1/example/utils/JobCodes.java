package org.sebek.struts1.example.utils;

public enum JobCodes {
	HELPDESK("1"),
	TECHLEVELI("2"),
	TECHLEVELII("3"),
	TECHLEVELIII("4"),
	TECHMANAGERI("5"),
	TECHMANAGERII("6"),
	TECHMANAGERIII("7"),
	CTO("8");

	private String id;
	
	JobCodes(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		String description;
		switch (this) {
			case HELPDESK:
				description = "Help Desk";
				break;
			case TECHLEVELI:
				description = "Tech Level I";
				break;
			case TECHLEVELII:
				description = "Tech Level II";
				break;
			case TECHLEVELIII:
				description = "Tech Level III";
				break;
			case TECHMANAGERI:
				description = "Tech Manager I";
				break;
			case TECHMANAGERII:
				description = "Tech Manager II";
				break;
			case TECHMANAGERIII:
				description = "Tech Manager III";
				break;
			default:
				description = "CTO";
				break;
		}
		return description;
	}
}
