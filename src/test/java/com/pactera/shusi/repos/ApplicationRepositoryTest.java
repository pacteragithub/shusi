package com.pactera.shusi.repos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.pactera.shusi.entities.Application;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhangyi cool.yzhang@gmail.com on 11/15/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationRepositoryTest {

    @Autowired
    private ApplicationRepository repository;

    private Application application;

    @After
    public void purgeTestingData() {
        if (application != null && application.getId() != 0) {
            repository.delete(application);
        }
    }

    @Test
    public void testSave() {
        application = new Application();
        application.setApplicationName("testAppName");
        application.setGithubUrl("testGiturl");

        assertEquals(0, application.getId());

        repository.save(application);

        assertNotEquals(0, application.getId());
    }
}
