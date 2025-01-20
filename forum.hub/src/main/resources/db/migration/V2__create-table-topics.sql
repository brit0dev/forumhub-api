create table `topics`(
    `id` bigint not null auto_increment PRIMARY KEY,
    `title` varchar(120) not null,
    `message` varchar(255) not null,
    `created` TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,
    `state` tinyint not null,
    `author` varchar(100) not null,
    `course` varchar(100) not null
);

