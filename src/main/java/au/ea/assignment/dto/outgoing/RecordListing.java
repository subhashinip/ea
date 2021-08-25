package au.ea.assignment.dto.outgoing;

import java.util.Set;
import java.util.TreeSet;

public class RecordListing implements Comparable<RecordListing>{
	
	private String recordLabel;
	private Set<Band> bands=new TreeSet<Band>();
	public String getRecordLabel() {
		return recordLabel;
	}
	public Set<Band> getBands() {
		return bands;
	}
	public void setRecordLabel(String recordLabel) {
		this.recordLabel = recordLabel;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bands == null) ? 0 : bands.hashCode());
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
		RecordListing other = (RecordListing) obj;
		if (bands == null) {
			if (other.bands != null)
				return false;
		} else if (!bands.equals(other.bands))
			return false;
		if (recordLabel == null) {
			if (other.recordLabel != null)
				return false;
		} else if (!recordLabel.equals(other.recordLabel))
			return false;
		return true;
	}
	@Override
	public int compareTo(RecordListing rl) {
		if(this.getRecordLabel()==null || rl.getRecordLabel()==null)
			return 1;
		return this.getRecordLabel().compareTo(rl.getRecordLabel());
	}

}
