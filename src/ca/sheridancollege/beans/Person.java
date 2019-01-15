package ca.sheridancollege.beans;

public class Person {
	private String email;
	private String color;
	private String age;
	private String[] skills;
	
	public Person() {
		super();
	}

	public Person(String email, String color, String age, String[] skills) {
		super();
		this.email = email;
		this.color = color;
		this.age = age;
		this.skills = skills;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		String javaSkills = "";
		for (int i = 0; i < skills.length; i++) {
			javaSkills += "<li>" + skills[i] + "</li><br>";
		}
		return  "Email: " + email + "<br> Favorite Color: " + color + "<br> Age Group: " + age 
				+ "<br> Java Skills:"
				+ "<ul>" + javaSkills
				+ "</ul>";
	}

}
