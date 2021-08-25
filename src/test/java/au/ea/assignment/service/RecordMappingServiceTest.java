package au.ea.assignment.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import au.ea.assignment.dto.incoming.Band;
import au.ea.assignment.dto.incoming.MusicFestival;
import au.ea.assignment.dto.outgoing.RecordListing;

public class RecordMappingServiceTest {
	
	RecordMappingService rms=new RecordMappingService();
	
	@Test
	public void testMappingToRecordListing() {
		MusicFestival mf1=new MusicFestival();
		mf1.setName("mf1");
		Band b1=new Band();
		b1.setName("b1");
		b1.setRecordLabel("RL1");
		mf1.setBands(Arrays.asList(b1));
		
		List<RecordListing> rl=rms.mapToRecordListing(Arrays.asList(mf1));
		
		assertTrue(rl.size() ==1);
		assertTrue(rl.get(0).getRecordLabel().equals("RL1"));
		assertTrue(rl.get(0).getBands().size() ==1);
		
		au.ea.assignment.dto.outgoing.Band outGoingBand=new au.ea.assignment.dto.outgoing.Band();
		outGoingBand.setBandName("b1");
		outGoingBand.getFestivalNames().add("mf1");
		
		assertTrue(rl.get(0).getBands().contains(outGoingBand));
		
		
	}

}
