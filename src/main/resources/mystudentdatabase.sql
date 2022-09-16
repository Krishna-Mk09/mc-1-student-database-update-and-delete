create DATABASE IF NOT EXISTS `myschool`;

create TABLE IF NOT EXISTS `mystudents`(
`name` varchar(30) not null primary key,
`roll_number` int not null,
`grade` varchar(20) not null,
`total_marks` int not null
);

insert into `myschool`.`mystudents` (`name`, `roll_number`, `grade`, `total_marks`) VALUES ('vamshi', '1001', 'A', '95');
insert into `myschool`.`mystudents` (`name`, `roll_number`, `grade`, `total_marks`) VALUES ('krishna', '1002', 'A', '98');
insert into `myschool`.`mystudents` (`name`, `roll_number`, `grade`, `total_marks`) VALUES ('dany', '1003', 'B', '60');