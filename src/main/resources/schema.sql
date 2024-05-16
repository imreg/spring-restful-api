DROP TABLE IF EXISTS Job;
DROP TABLE IF EXISTS Type;
DROP TABLE IF EXISTS Company;

CREATE TABLE IF NOT EXISTS Type (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(256) NOT NULL
);

CREATE TABLE IF NOT EXISTS Company (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(256) NOT NULL,
    description TEXT,
    email VARCHAR(256) NOT NULL,
    phone VARCHAR(256) NOT NULL
);

CREATE TABLE IF NOT EXISTS Job (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(256) NOT NULL,
    type_id INT,
    location VARCHAR(256) NOT NULL,
    description TEXT,
    salary VARCHAR(256) NOT NULL,
    company_id INT, -- Foreign key column referencing Company table
    FOREIGN KEY (type_id) REFERENCES Type(id),
    FOREIGN KEY (company_id) REFERENCES Company(id)
);
