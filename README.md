# LibrarySystem
## DataBase Script

```
-- Create the database
CREATE DATABASE IF NOT EXISTS librarie;
USE librarie;

-- Create the table `tbl_books`
CREATE TABLE `tbl_books` (
  `boo_title` varchar(100) NOT NULL,
  `boo_ISBM` int(11) NOT NULL,
  `boo_available` tinyint(1) NOT NULL,
  `boo_authors` int(11) DEFAULT NULL,
  PRIMARY KEY (`boo_ISBM`),
  KEY `authors` (`boo_authors`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Create the table `tbl_person`
CREATE TABLE `tbl_person` (
  `per_name` varchar(100) NOT NULL,
  `per_id` int(11) NOT NULL,
  `per_role` varchar(10) NOT NULL,
  PRIMARY KEY (`per_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Create the table `tbl_books_x_persons`
CREATE TABLE `tbl_books_x_persons` (
  `bxp_book_id` int(11) NOT NULL,
  `bxp_person_id` int(11) NOT NULL,
  `bxp_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`bxp_id`),
  KEY `persons` (`bxp_person_id`),
  KEY `books_new` (`bxp_book_id`),
  CONSTRAINT `books_new` FOREIGN KEY (`bxp_book_id`) REFERENCES `tbl_books` (`boo_ISBM`) ON DELETE CASCADE,
  CONSTRAINT `persons` FOREIGN KEY (`bxp_person_id`) REFERENCES `tbl_person` (`per_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
COMMIT;

