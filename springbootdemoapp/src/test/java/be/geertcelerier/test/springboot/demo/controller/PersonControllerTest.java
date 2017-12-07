package be.geertcelerier.test.springboot.demo.controller;

import be.geertcelerier.test.springboot.demo.DemoApplication;
import be.geertcelerier.test.springboot.demo.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration
public class PersonControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Mock
    private PersonService personService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetAllPersons() throws Exception {
        Mockito.when(personService.getAllPersons()).thenReturn(null);

        mockMvc.perform(get("/persons"))
                .andExpect(status().isOk());
    }
}
