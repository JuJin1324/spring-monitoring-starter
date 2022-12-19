package starter.spring.monitoring.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2022/12/09
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = "management.metrics.export.prometheus.enabled=true")
@AutoConfigureMockMvc
public abstract class AbstractControllerIntegrationTest {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MockMvc      mockMvc;
}
