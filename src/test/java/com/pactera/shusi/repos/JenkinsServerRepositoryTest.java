package com.pactera.shusi.repos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.pactera.shusi.entities.JenkinsServer;
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
public class JenkinsServerRepositoryTest {


    @Autowired
    private JenkinsServerRepository repository;

    private JenkinsServer server;

    @After
    public void purgeTestingData() {
        if (server != null && server.getId() != 0) {
            repository.delete(server);
        }
    }

    @Test
    public void testSave() {
        server = new JenkinsServer();
        server.setServerAddress("testingAddress");

        assertEquals(0, server.getId());

        repository.save(server);

        assertNotEquals(0, server.getId());
    }

}
