CREATE TABLE `Person` (
  `person_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `country` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
CREATE TABLE `Pattern` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `Detail` varchar(245) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
CREATE TABLE `employee` (
    `joining_date` DATE NULL DEFAULT NULL,
    `department_name` VARCHAR(50) NULL DEFAULT NULL,
    `person_id` int(11) unsigned NOT NULL,
     `department_id` BIGINT(20) NULL DEFAULT NULL,
    PRIMARY KEY (`emp_id`),
    CONSTRAINT `FK_PERSON` FOREIGN KEY (`person_id`) REFERENCES `Person` (`person_id`),
    CONSTRAINT `FK_DEPT` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`)
   )ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
 
CREATE TABLE `owner` (
    `stocks` BIGINT(11) NULL DEFAULT NULL,
    `partnership_stake` BIGINT(11) NULL DEFAULT NULL,
    `person_id` int(11) unsigned NOT NULL
    CONSTRAINT `FK_PERSON2` FOREIGN KEY (`person_id`) REFERENCES `Person` (`person_id`)
)ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `department` (
    `department_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `dept_name` VARCHAR(50) NOT NULL DEFAULT '0',
    PRIMARY KEY (`department_id`)
)ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `marks_details` (  
   `person_id` int(11) unsigned NOT NULL,
  `test_id` int(11) unsigned NOT NULL AUTO_INCREMENT,  
  `subject` varchar(100) DEFAULT NULL,  
  `max_marks` varchar(100) DEFAULT NULL,  
  `marks_obtained` varchar(100) DEFAULT NULL,  
  `result` varchar(100) DEFAULT NULL,  
  PRIMARY KEY (`test_id`),  
  CONSTRAINT `FK_marks_details_student` FOREIGN KEY (`person_id`) REFERENCES `Person` (`person_id`)  
)ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;



commit;