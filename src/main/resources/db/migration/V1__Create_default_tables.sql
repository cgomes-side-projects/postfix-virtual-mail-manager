
CREATE TABLE `virtual_domains` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  `active` TINYINT(1) default 1,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `virtual_users` (
  `id` int(11) NOT NULL auto_increment,
  `domain_id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(106) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  FOREIGN KEY (domain_id) REFERENCES virtual_domains(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `virtual_aliases` (
  `id` int(11) NOT NULL auto_increment,
  `domain_id` int(11) NOT NULL,
  `source` varchar(100) NOT NULL,
  `destination` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (domain_id) REFERENCES virtual_domains(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*
 * domains_view is used to expose to postfix valid and active domains
 */
CREATE VIEW `domains_view` AS
  select  `id`,
          `name` AS `domain`
  from `virtual_domains`;


/*
 * users_view is used to expose to postfix virtual users with full email and password
 */
CREATE VIEW `users_view` AS
  select
    `u`.`id`,
    concat(`u`.`email`,'@',`d`.`name`) AS `email`,
    `u`.`password`
  from `virtual_users` as u
  left join `virtual_domains` as d
    on `u`.`domain_id` = `d`.`id`;

/*
 * insert some recorts to test
 */
INSERT INTO virtual_domains(`name`) VALUES ('teste.com'), ('company.com.br');
INSERT INTO virtual_users(`domain_id`, `email`, `password`) VALUES (1, 'carlos', 'abc123'), (2, 'su', 'qweryoup');
