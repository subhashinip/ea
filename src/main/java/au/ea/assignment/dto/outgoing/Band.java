package au.ea.assignment.dto.outgoing;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Band implements Comparable<Band>{
	
	private String bandName;
	private Set<String> festivalNames=new TreeSet<String>();
	
	public String getBandName() {
		return bandName;
	}
	public Set<String> getFestivalNames() {
		return festivalNames;
	}
	public void setBandName(String bandName) {
		this.bandName = bandName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bandName == null) ? 0 : bandName.hashCode());
		result = prime * result + ((festivalNames == null) ? 0 : festivalNames.hashCode());
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
		if (bandName == null) {
			if (other.bandName != null)
				return false;
		} else if (!bandName.equals(other.bandName))
			return false;
		if (festivalNames == null) {
			if (other.festivalNames != null)
				return false;
		} else if (!festivalNames.equals(other.festivalNames))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Band b) {
		return this.getBandName().compareTo(b.getBandName());
	}

}
