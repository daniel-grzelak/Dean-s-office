package daniel.grzelak.classes;

public class Entry {

	private int id;
	private int idS;
	private int idU;
	
	public Entry() {
		
	}
	
	public Entry(int id, int idS, int idU) {
		super();
		this.id = id;
		this.idS = idS;
		this.idU = idU;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdS() {
		return idS;
	}

	public void setIdS(int idS) {
		this.idS = idS;
	}

	public int getIdU() {
		return idU;
	}

	public void setIdU(int idU) {
		this.idU = idU;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + idS;
		result = prime * result + idU;
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
		Entry other = (Entry) obj;
		if (id != other.id)
			return false;
		if (idS != other.idS)
			return false;
		if (idU != other.idU)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Entry [id=" + id + ", idS=" + idS + ", idU=" + idU + "]";
	}


	
	
}
