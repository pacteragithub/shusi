package com.pactera.shusi.repos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.pactera.shusi.entities.Application;
import com.pactera.shusi.entities.JenkinsJob;
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
@SpringBootTest
@RunWith(SpringRunner.class)
public class JenkinsJobRepositoryTest {

    @Autowired
    private JenkinsJobRepository repository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private JenkinsServerRepository jenkinsServerRepository;

    private JenkinsJob theEntity;
    private Application application;
    private JenkinsServer jenkinsServer;

    @After
    public void purgeTestingData() {
        if (theEntity != null && theEntity.getJobId() != 0) {
            repository.delete(theEntity);
        }

        if (application != null && application.getId() != 0) {
            applicationRepository.delete(application);
        }

        if (jenkinsServer != null && jenkinsServer.getId() != 0) {
            jenkinsServerRepository.delete(jenkinsServer);
        }

    }

    @Test
    public void testSave() {
        application = new Application();
        application.setApplicationName("testApplicationName");
        application.setGithubUrl("testGithubUrl");

        jenkinsServer = new JenkinsServer();
        jenkinsServer.setServerAddress("testServerAddress");

        theEntity = new JenkinsJob();
        theEntity.setApplication(application);
        theEntity.setJenkinsServer(jenkinsServer);
        theEntity.setJobNName("testJobName");
        theEntity.setStatus("testStatus");
        theEntity.setType("testType");

        assertEquals(0, theEntity.getJobId());

        repository.save(theEntity);

        assertNotEquals(0, theEntity.getJobId());
    }

}
