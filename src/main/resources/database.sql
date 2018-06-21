CREATE TABLE employee_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES employee (ID_employee),
  FOREIGN KEY (role_id) REFERENCES roles (ID_roles),

  UNIQUE (user_id, role_id)
)
  ENGINE = InnoDB;

CREATE TABLE employer_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES employer (ID_employer),
  FOREIGN KEY (role_id) REFERENCES roles (ID_roles),

  UNIQUE (user_id, role_id)
)
  ENGINE = InnoDB;