-- Create a new database called 'CourseraDatabase'
-- Create the new database if it does not exist already
DROP DATABASE CourseraDatabase;
CREATE DATABASE CourseraDatabase;
USE CourseraDatabase;
SET FOREIGN_KEY_CHECKS =0;
-- Create a new table called 'CUSTOMER' in schema 'CourseraDatabase'
-- Drop the table if it already exists
-- Create the table in the specified schema
CREATE TABLE CourseraDatabase.CUSTOMER
(
    CUSTNO VARCHAR(5) NOT NULL, -- primary key column
    CUSTNAME VARCHAR(50) NOT NULL,
    ADDRESS VARCHAR(100) NOT NULL,
    INTERNAL CHAR(1) NOT NULL,
    CONTACT VARCHAR(50) NOT NULL,
    PHONE VARCHAR(11) NOT NULL,
    CITY VARCHAR(20) NOT NULL,
    STATE VARCHAR(10) NOT NULL,
    ZIP VARCHAR(10),
    PRIMARY KEY(CUSTNO)
    -- specify more columns here
);



-- Create a new table called 'FACILITY' in schema 'CourseraDatabase'
-- Drop the table if it already exists
-- Create the table in the specified schema
CREATE TABLE CourseraDatabase.FACILITY
(
    FACNO VARCHAR(5) NOT NULL, -- primary key column
    FACNAME VARCHAR(50) NOT NULL,
    PRIMARY KEY(FACNO)
    -- specify more columns here
);


-- Create a new table called 'Location' in schema 'CourseraDatabase'
-- Drop the table if it already exists
-- Create the table in the specified schema
CREATE TABLE CourseraDatabase.LOCATION
(
    LOCNO VARCHAR(5) NOT NULL, -- primary key column
    FACNO VARCHAR(5) NOT NULL,
    LOCNAME VARCHAR(20) NOT NULL,
    PRIMARY KEY(LOCNO),
    FOREIGN KEY(FACNO) REFERENCES FACILITY(FACNO)
    -- specify more columns here
);

-- Create a new table called 'EVENTREQUEST' in schema 'CourseraDatabase'
-- Drop the table if it already exists
-- Create the table in the specified schema
CREATE TABLE CourseraDatabase.EVENTREQUEST
(
    EVENTNO VARCHAR(5) NOT NULL, -- primary key column
    DATEHELD DATE NOT NULL,
    DATEREQ DATE NOT NULL,
    CUSTNO VARCHAR(5) NOT NULL,
    FACNO VARCHAR(5) NOT NULL,
    DATEAUTH DATE NOT NULL,
    STATUS VARCHAR(8) NOT NULL,
    ESTCOST VARCHAR(8) NOT NULL,
    ESTAUDIENCE VARCHAR(10) NOT NULL,
    BUDNO VARCHAR(8),
    PRIMARY KEY(EVENTNO),
    FOREIGN KEY(CUSTNO) REFERENCES CUSTOMER(CUSTNO),
    FOREIGN KEY(FACNO) REFERENCES FACILITY(FACNO)
    -- specify more columns here
);

-- Create a new table called 'EMPLOYEE' in schema 'CourseraDatabase'
-- Drop the table if it already exists
-- Create the table in the specified schema
CREATE TABLE CourseraDatabase.EMPLOYEE
(
    EMPNO VARCHAR(5) NOT NULL, -- primary key column
    EMPNAME VARCHAR(50) NOT NULL,
    DEPARTMENT VARCHAR(20) NOT NULL,
    EMAIL VARCHAR(20) NOT NULL,
    PHONE VARCHAR(8) NOT NULL,
    PRIMARY KEY(EMPNO)
    -- specify more columns here
);


-- Create a new table called 'EVENTPLAN' in schema 'CourseraDatabase'
-- Drop the table if it already exists
-- Create the table in the specified schema
CREATE TABLE CourseraDatabase.EVENTPLAN
(
    PLANNO VARCHAR(5) NOT NULL, -- primary key column
    EVENTNO VARCHAR(5) NOT NULL,
    WORKDATE DATE NOT NULL,
    NOTES VARCHAR(50),
    ACTIVITY VARCHAR(10) NOT NULL,
    EMPNO VARCHAR(5),
    PRIMARY KEY(PLANNO),
    FOREIGN KEY(EVENTNO) REFERENCES EVENTREQUEST(EVENTNO),
    FOREIGN KEY(EMPNO) REFERENCES EMPLOYEE(EMPNO)
    -- specify more columns here
);

-- Create a new table called 'RESOURCETABLE' in schema 'CourseraDatabase'
-- Drop the table if it already exists
-- Create the table in the specified schema
CREATE TABLE CourseraDatabase.RESOURCETBL
(
    RESNO VARCHAR(5) NOT NULL, -- primary key column
    RESNAME VARCHAR(20) NOT NULL,
    RATE VARCHAR(10) NOT NULL,
    PRIMARY KEY(RESNO)
    -- specify more columns here
);


-- Create a new table called 'EVENTPLANLINE' in schema 'CourseraDatabase'
-- Drop the table if it already exists
-- Create the table in the specified schema
CREATE TABLE CourseraDatabase.EVENTPLANLINE
(
    PLANNO VARCHAR(5) NOT NULL, -- primary key column
    LINENO VARCHAR(50) NOT NULL,
    TIMESTART TIME NOT NULL,
    TIMEEND TIME NOT NULL,
    NUMBERFLD INT NOT NULL,
    LOCNO VARCHAR(5) NOT NULL,
    RESNO VARCHAR(5) NOT NULL,
    PRIMARY KEY(PLANNO,LINENO),
    FOREIGN KEY(PLANNO) REFERENCES EVENTPLAN(PLANNO),
    FOREIGN KEY(LOCNO) REFERENCES LOCATION(LOCNO),
    FOREIGN KEY (RESNO) REFERENCES RESOURCETBL(RESNO)
    -- specify more columns here
);
