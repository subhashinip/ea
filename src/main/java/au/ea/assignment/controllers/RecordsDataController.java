package au.ea.assignment.controllers;

import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import au.ea.assignment.dto.incoming.MusicFestival;
import au.ea.assignment.dto.outgoing.RecordListing;
import au.ea.assignment.service.RecordMappingService;

@RestController
public class RecordsDataController {

	private static final List<RecordListing> EMPTY_RESPONSE = Collections.emptyList();
	private static final String uri = "https://eacp.energyaustralia.com.au/codingtest/api/v1/festivals";

	@Autowired
	private RecordMappingService recordMappingService;

	@GetMapping("/")
	public List<RecordListing> index() throws Exception {

		List<MusicFestival> musicFestivals = null;
		List<RecordListing> response = EMPTY_RESPONSE;

		RestTemplate restTemplate = new RestTemplate();
		try {
			String result = restTemplate.getForObject(uri, String.class);

			ObjectMapper mapper = new ObjectMapper();

			musicFestivals = mapper.readValue(result, new TypeReference<List<MusicFestival>>() {
			});

			if (musicFestivals == null || musicFestivals.isEmpty()) {
				return response;
			}

			response = recordMappingService.mapToRecordListing(musicFestivals);

		} catch (Exception e) {
			System.err.println(e);
			return EMPTY_RESPONSE;
		}

		return response;

	}

}