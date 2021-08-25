package au.ea.assignment.dto.incoming;

public class Band {
	
	private String name;
	private String recordLabel;
	
	public String getName() {
		return name;
	}
	public String getRecordLabel() {
		return recordLabel;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRecordLabel(String recordLabel) {
		this.recordLabel = recordLabel;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((recordLabel == null) ? 0 : recordLabel.hashCode());
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
		Band other = (Band) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (recordLabel == null) {
			if (other.recordLabel != null)
				return false;
		} else if (!recordLabel.equals(other.recordLabel))
			return false;
		return true;
	}

}
