package daniel.grzelak.classes;

public class StudentUniversity {
	private int id;
	private String name;
	private String surname;
	private int age;
	private int studyYear;
	private String mailS;
	private String phoneS;
	private String nameU;
	private String address;
	private String mailU;
	private String phoneU;
	
	
	
	public StudentUniversity()
	{
		
	}
	
	public StudentUniversity(int id, String name, String surname, int age, int studyYear, String mailS,
			String phoneS, String nameU, String address, String mailU, String phoneU) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.studyYear = studyYear;
		this.mailS = mailS;
		this.phoneS = phoneS;
		this.nameU = nameU;
		this.address = address;
		this.mailU = mailU;
		this.phoneU = phoneU;
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
	public void setStudyYear(int studyYear) {
		this.studyYear = studyYear;
	}
	public String getMailS() {
		return mailS;
	}
	public void setMailS(String mailS) {
		this.mailS = mailS;
	}
	public String getPhoneS() {
		return phoneS;
	}
	public void setPhoneS(String phoneS) {
		this.phoneS = phoneS;
	}
	public String getNameU() {
		return nameU;
	}
	public void setNameU(String nameU) {
		this.nameU = nameU;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMailU() {
		return mailU;
	}
	public void setMailU(String mailU) {
		this.mailU = mailU;
	}
	public String getPhoneU() {
		return phoneU;
	}
	public void setPhoneU(String phoneU) {
		this.phoneU = phoneU;
	}
	

	@Override
	public String toString() {
		return "StudentUniversity [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age
				+ ", studyYear=" + studyYear + ", mailS=" + mailS + ", phoneS=" + phoneS + ", nameU=" + nameU
				+ ", address=" + address + ", mailU=" + mailU + ", phoneU=" + phoneU + "]";
	}
	
	
	
	
}
