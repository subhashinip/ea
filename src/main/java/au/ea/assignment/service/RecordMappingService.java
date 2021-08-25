package au.ea.assignment.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import au.ea.assignment.dto.incoming.Band;
import au.ea.assignment.dto.incoming.MusicFestival;
import au.ea.assignment.dto.outgoing.RecordListing;

@Service
public class RecordMappingService {

	public List<RecordListing> mapToRecordListing(List<MusicFestival> musicFestivals) {
		Map<String, RecordListing> recordLabelToRecordListing = new HashMap<String, RecordListing>();

		for (MusicFestival musicFestival : musicFestivals) {
			for (Band band : musicFestival.getBands()) {

				String recordLabel = band.getRecordLabel();
				if (recordLabelToRecordListing.containsKey(recordLabel)) {
					RecordListing recordListing = recordLabelToRecordListing.get(recordLabel);
					for (au.ea.assignment.dto.outgoing.Band outGoingBand : recordListing.getBands()) {
						if (outGoingBand.getBandName().equals(band.getName())) {
							outGoingBand.getFestivalNames().add(musicFestival.getName());
						}
					}

				} else {
					au.ea.assignment.dto.outgoing.Band outGoingBand = new au.ea.assignment.dto.outgoing.Band();
					outGoingBand.setBandName(band.getName());
					outGoingBand.getFestivalNames().add(musicFestival.getName());
					RecordListing outGoingRecordListing = new RecordListing();
					outGoingRecordListing.setRecordLabel(band.getRecordLabel());
					outGoingRecordListing.getBands().add(outGoingBand);

					recordLabelToRecordListing.put(recordLabel, outGoingRecordListing);
				}
			}
		}
		List<RecordListing> recordListings = new ArrayList<RecordListing>(recordLabelToRecordListing.values());

		Collections.sort(recordListings);

		return recordListings;
	}

}
