package com.pactera.shusi.controllor;

import com.pactera.shusi.entities.Application;
import com.pactera.shusi.entities.JenkinsJob;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyi cool.yzhang@gmail.com on 11/13/18.
 */
@RestController
@RequestMapping("/api/application")
public class ApplicationControllor {

    @RequestMapping(value = "/{applicationName}", method = RequestMethod.PUT)
    public Application createApplication(@PathVariable String applicationName) {
        Application app = new Application();

        List<JenkinsJob> jobs = new ArrayList<JenkinsJob>();
        JenkinsJob jenkinsJob = new JenkinsJob();
        jobs.add(jenkinsJob);

        app.setApplicationName(applicationName);

        return app;

    }

    @RequestMapping(value = "/{applicationName}/{jenkinsJobId}/status")
    @PostMapping
    public String getJenkinsJobStatus(@PathVariable String applicationName, @PathVariable String jenkinsJobId) {
        return null;
    }
}
