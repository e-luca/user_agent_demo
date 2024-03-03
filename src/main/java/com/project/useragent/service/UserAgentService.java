package com.project.useragent.service;

import ch.qos.logback.classic.Logger;
import com.project.useragent.dao.UserAgentEntity;
import com.project.useragent.dao.UserAgentRepository;
import com.project.useragent.model.UserAgent;
import org.apache.coyote.BadRequestException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAgentService {

    @Autowired
    private UserAgentRepository repository;
    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserAgentService.class);

    public List<UserAgent> getAll() {
        Iterable<UserAgentEntity> data = repository.findAll();
        ArrayList<UserAgent> result = new ArrayList();

        data.forEach(d -> {
            result.add(d.convert());
        });

        return result;
    }

    public UserAgent create(String browser) {
        try {
            if (browser.isEmpty()) throw new BadRequestException("Browser field should not be empty!");

            UserAgentEntity request = new UserAgentEntity(browser);
            UserAgentEntity result = repository.save(request);

            return result.convert();
        } catch (BadRequestException e) {
            logger.info("Bad request exception: " + e.getMessage());
        }
        catch (Exception e) {
            logger.info("Unexpected exception: " + e.getMessage());
        }

        return null;
    }

    public UserAgent delete(Long id) {
        try {
            UserAgentEntity data = repository.findById(id).orElseThrow();
            repository.delete(data);

            return data.convert();
        } catch (Exception e) {
            logger.info("Unexpected exception: " + e.getMessage());
        }

        return null;
    }
}
