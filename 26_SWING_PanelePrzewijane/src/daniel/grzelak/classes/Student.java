package daniel.grzelak.classes;

public class Student {

	private int id;
	private String name;
	private String surname;
	private int age;
	private int studyYear;
	private String mail;
	private String phone;
	
	public Student() {
		
	}

	public Student(int id, String name, String surname, int age, int studyYear, String mail, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.studyYear = studyYear;
		this.mail = mail;
		this.phone = phone;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getStudyYear() {
		return studyYear;
	}

	public void setStudyYear(int rokStudiow) {
		this.studyYear = rokStudiow;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + studyYear;
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + age;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (studyYear != other.studyYear)
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (age != other.age)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Surname: " + surname + ", Age: " + age + ", study year: "
				+ studyYear + ", mail: " + mail + ", phone: " + phone;
	}
	
	
	
}
