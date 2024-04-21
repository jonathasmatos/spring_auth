CREATE TABLE `users` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `username` VARCHAR(255) UNIQUE NOT NULL,
    `password` VARCHAR(255) NOT NULL
);

CREATE TABLE `roles` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE `user_roles` (
    `user_id` BIGINT,
    `role_id` BIGINT,
    PRIMARY KEY (`user_id`, `role_id`),
    FOREIGN KEY (`user_id`) REFERENCES `users`(`id`),
    FOREIGN KEY (`role_id`) REFERENCES `roles`(`id`)
);


-- INSERT ROLES
INSERT INTO `roles`(`id`, `name`) VALUES(2, 'USER');
INSERT INTO `roles`(`id`, `name`) VALUES(1, 'ADMIN');


-- INSERT USERS
INSERT INTO `users`(`id`, `name`, `username`, `password`) VALUES (1, 'Jonathas Matos', 'jonathas', '$2y$10$40jSsFob9nJj45rOFR.URO2BytoNfIVyXo98p2w3uk1Z7YD9ovaHG');
INSERT INTO `users`(`id`, `name`, `username`, `password`) VALUES (2, 'Leila Santos', 'leila', '$2y$10$OB0UE7c90Uk3ump4F6bpaeBHPqDc1UbFLM5vHk8IK23PQEw1Orq/K');



