package io.hubject.chargingstation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class WebLayerTest {

	@Autowired
	private MockMvc MockMvc;

	@Test
	public void queryStations() throws Exception {
		this.MockMvc
				.perform(post("/stations")
						.content(
								"{\"stationId\":\"132\",\"latitude\":\"41.40338\",\"longitude\":\"2.17403\",\"postalCode\":\"10318\"}")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andDo(print()).andDo(document("PersistStations"));

		this.MockMvc.perform(get("/stations/132")).andExpect(status().isOk()).andDo(print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.stationId").value("132")).andDo(document("QueryByID"));

		this.MockMvc.perform(get("/stations/code/10318")).andExpect(status().isOk()).andDo(print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[*].postalCode").value("10318")).andDo(document("QueryByPostalCode"));

		this.MockMvc.perform(get("/stations/location/41.40338/2.17403")).andExpect(status().isOk()).andDo(print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].latitude").value("41.40338")).andDo(document("QueryByLocation"));
	}
}
