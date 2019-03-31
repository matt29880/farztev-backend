-- Country
INSERT INTO `country` VALUES (1,'Switzerland','CH','The swiss description','The swiss trip','The swiss why','The swiss favorite','The swiss conclusion','1970-01-15 07:56:07.910000','1970-01-15 07:56:07.912000','1970-01-15 07:56:07.911000','1970-01-15 07:56:07.913000',1,'EUROPE');

-- Article
INSERT INTO `article` VALUES (1,'qsdqsd','[]','2019-03-25 19:59:06.659000','2019-03-25 19:59:06.659000',1,1);

-- Album type
INSERT INTO `album_type` VALUES (1,'The album type',1);

-- Album
INSERT INTO `album` (`id`, `name`, `description`, `created`, `updated`, `online`, `album_type`) VALUES ('1', 'Zug', 'The beautiful city of Zug', '2019-03-25 19:59:06.659000', '2019-03-25 19:59:06.659000', '1', '1');

-- Media
INSERT INTO `media` (`id`, `name`, `type`, `created`, `updated`, `online`, `url`, `album_id`) VALUES ('1', 'Gwen', 'PHOTO', '2019-03-31 15:20:41', '2019-03-31 15:20:41', '1', '', '1');
