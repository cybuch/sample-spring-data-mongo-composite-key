package ovh.cybuch.composite.key;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class StudentChairmanEndpointIntegrationTest {

	private static final String VALID_STUDENT_ID = "123";
	private static final String VALID_GROUP_ID = "123";
	private static final String VALID_ENDPOINT_PATH = "/students/" + VALID_STUDENT_ID + "/group/" + VALID_GROUP_ID;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldCreateAndReadStudentChairman() throws Exception {
		mockMvc.perform(post(VALID_ENDPOINT_PATH))
				.andExpect(status().isCreated());
		
		mockMvc.perform(get(VALID_ENDPOINT_PATH))
				.andExpect(status().isOk());
	}
}
