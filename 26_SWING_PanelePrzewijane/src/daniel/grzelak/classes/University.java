package daniel.grzelak.classes;

public class University {
	
	private int id;
	private String nameU;
	private String address;
	private String mailU;
	private String phoneU;
	
	public University() {
		
	}

	


	public University(int id, String nameU, String address, String mailU, String phoneU) {
		super();
		this.id = id;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + id;
		result = prime * result + ((mailU == null) ? 0 : mailU.hashCode());
		result = prime * result + ((nameU == null) ? 0 : nameU.hashCode());
		result = prime * result + ((phoneU == null) ? 0 : phoneU.hashCode());
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
		University other = (University) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id != other.id)
			return false;
		if (mailU == null) {
			if (other.mailU != null)
				return false;
		} else if (!mailU.equals(other.mailU))
			return false;
		if (nameU == null) {
			if (other.nameU != null)
				return false;
		} else if (!nameU.equals(other.nameU))
			return false;
		if (phoneU == null) {
			if (other.phoneU != null)
				return false;
		} else if (!phoneU.equals(other.phoneU))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "University [id=" + id + ", nameU=" + nameU + ", address=" + address + ", mailU=" + mailU + ", phoneU="
				+ phoneU + "]";
	}
	
	
	
}
