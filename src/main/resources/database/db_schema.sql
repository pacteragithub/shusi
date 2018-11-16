USE shusi;

DROP TABLE IF EXISTS `jenkins_job`;
DROP TABLE IF EXISTS `application`;
DROP TABLE IF EXISTS `jenkins_server`;

CREATE TABLE `application` (
  `application_id`   BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  `application_name` VARCHAR(255) NOT NULL,
  `github_url`       VARCHAR(255) NOT NULL
);



CREATE TABLE `jenkins_server` (
  `jenkins_server_id` BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  `server_address`    VARCHAR(255) NOT NULL
);



CREATE TABLE `jenkins_job` (
  `jenkins_job_id`    BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  `job_name`          VARCHAR(255) NOT NULL,
  `type`              VARCHAR(50)  NOT NULL,
  `status`            VARCHAR(50)  NOT NULL,
  `application_id`    BIGINT(20)   NOT NULL,
  `jenkins_server_id` BIGINT(20)   NOT NULL,
  FOREIGN KEY (application_id) REFERENCES application (application_id),
  FOREIGN KEY (jenkins_job_id) REFERENCES jenkins_server (jenkins_server_id)

);