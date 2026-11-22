
CREATE TABLE `locations` (
                             `id` int NOT NULL AUTO_INCREMENT,
                             `slug` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL UNIQUE,
                             `designation` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
                             `address` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                             `locality_id` int NOT NULL,
                             `website` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                             `phone` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             KEY `idx_locations_locality_id` (`locality_id`),
                             CONSTRAINT `fk_locations_locality`
                                 FOREIGN KEY (`locality_id`)
                                     REFERENCES `localities` (`id`)
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_unicode_ci;
