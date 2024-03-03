package com.project.useragent.service;

import com.project.useragent.model.UserAgent;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserAgentServiceTest {

    @Autowired
    private UserAgentService service;

    @MockBean
    private UserAgentService mockedService;
    private static final UserAgent userAgent1 = new UserAgent();
    private static final UserAgent userAgent2 = new UserAgent();
    private static final UserAgent userAgent3 = new UserAgent();

    @Test
    public void getAll() {
        ArrayList<UserAgent> userAgents = new ArrayList(Arrays.asList(userAgent1, userAgent2, userAgent3));

        when(mockedService.getAll()).thenReturn(userAgents);
        List<UserAgent> result = service.getAll();

        assertEquals(userAgents.size(), result.size());
        assertTrue(result.containsAll(userAgents));

        verify(mockedService, times(1)).getAll();
    }

    @Test
    public void createWithException() {
        String browser = "";
        BadRequestException expected = new BadRequestException("Browser field should not be empty!");

        try {
            service.create(browser);
        } catch (Exception actual) {
            assertEquals(actual.getMessage(), expected.getMessage());
        }


        verify(mockedService, times(1)).create(browser);
    }

    @Test
    public void create() {
        String browser = "Mozilla";
        UserAgent userAgent = new UserAgent();

        userAgent.setBrowser(browser);

        when(mockedService.create(browser)).thenReturn(userAgent);
        UserAgent result = service.create(browser);

        assertEquals(result.getBrowser(), userAgent.getBrowser());

        verify(mockedService, times(1)).create(browser);
    }

    @Test
    public void deleteWithException() {
        Long id = 0L;
        NoSuchElementException expected = new NoSuchElementException();

        try {
            service.delete(id);
        } catch (Exception ex) {
            assertEquals(expected.getMessage(), ex.getMessage());
        }

        verify(mockedService, times(1)).delete(id);
    }

    @Test
    public void delete() {
        Long id = 1L;
        UserAgent userAgent = new UserAgent();
        userAgent.setId(id);

        when(mockedService.delete(id)).thenReturn(userAgent);
        UserAgent result = service.delete(id);

        assertEquals(result.getId(), userAgent.getId());

        verify(mockedService, times(1)).delete(id);
    }
}
