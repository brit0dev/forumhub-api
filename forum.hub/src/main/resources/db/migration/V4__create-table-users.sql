create table `users`(
    `id` bigint not null auto_increment PRIMARY KEY,
    `login` varchar(120) not null,
    `password` varchar(255) not null
);

