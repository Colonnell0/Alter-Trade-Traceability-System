-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 04, 2016 at 02:01 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `traceability_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `account_id` int(11) NOT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `middlename` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `street` varchar(50) DEFAULT NULL,
  `barangay` varchar(50) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `contact_number` varchar(90) DEFAULT NULL,
  `email_address` varchar(90) DEFAULT NULL,
  `position_id` int(11) DEFAULT NULL,
  `username` varchar(10) DEFAULT NULL,
  `passowrd` varchar(300) DEFAULT NULL,
  `security_question_id` int(11) DEFAULT NULL,
  `answer` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bagging_tagging`
--

CREATE TABLE `bagging_tagging` (
  `bagging_tagging_id` int(11) NOT NULL,
  `growers_record_id` int(11) DEFAULT NULL,
  `description` varchar(60) DEFAULT NULL,
  `bagging_tagging_value` int(11) DEFAULT NULL,
  `date_update` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `city_id` int(11) NOT NULL,
  `city` varchar(70) DEFAULT NULL,
  `province_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`city_id`, `city`, `province_id`) VALUES
(1, 'Dumaguete City', 1);

-- --------------------------------------------------------

--
-- Table structure for table `color_code`
--

CREATE TABLE `color_code` (
  `color_code_id` int(11) NOT NULL,
  `color_code` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `color_code`
--

INSERT INTO `color_code` (`color_code_id`, `color_code`) VALUES
(1, 'Yellow'),
(2, 'Green');

-- --------------------------------------------------------

--
-- Table structure for table `contaiment`
--

CREATE TABLE `contaiment` (
  `containment_id` int(11) NOT NULL,
  `risk_containment` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contaiment`
--

INSERT INTO `contaiment` (`containment_id`, `risk_containment`) VALUES
(1, 'Chemical'),
(2, 'Organic');

-- --------------------------------------------------------

--
-- Table structure for table `gender`
--

CREATE TABLE `gender` (
  `gender_id` int(11) NOT NULL,
  `description` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gender`
--

INSERT INTO `gender` (`gender_id`, `description`) VALUES
(1, 'Male'),
(2, 'Female');

-- --------------------------------------------------------

--
-- Table structure for table `growers_record`
--

CREATE TABLE `growers_record` (
  `growers_record_id` int(11) NOT NULL,
  `name` varchar(80) DEFAULT NULL,
  `street` varchar(80) DEFAULT NULL,
  `barangay` varchar(80) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `color_code_id` int(11) DEFAULT NULL,
  `contaiment_id` int(11) DEFAULT NULL,
  `price_id` int(11) DEFAULT NULL,
  `date_created` date DEFAULT NULL,
  `date_deleted` date NOT NULL,
  `status_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `growers_record`
--

INSERT INTO `growers_record` (`growers_record_id`, `name`, `street`, `barangay`, `city_id`, `color_code_id`, `contaiment_id`, `price_id`, `date_created`, `date_deleted`, `status_id`) VALUES
(1, 'Green Thumb Organic Fertilizer ', 'Pleasant ville', 'Banilad', 1, 1, 1, 1, '2015-09-14', '0000-00-00', 1),
(2, 'THE PLANTATION', 'zapote steet', 'Balugo', 1, 2, 2, 2, '2016-08-04', '0000-00-00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `harvest`
--

CREATE TABLE `harvest` (
  `harvest_id` int(11) NOT NULL,
  `growers_record_id` int(11) DEFAULT NULL,
  `number_of_harvest` int(11) DEFAULT NULL,
  `date_update` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `income`
--

CREATE TABLE `income` (
  `income_id` int(11) NOT NULL,
  `growers_record_id` int(11) DEFAULT NULL,
  `income` double DEFAULT NULL,
  `date_update` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `num_match`
--

CREATE TABLE `num_match` (
  `num_match_id` int(11) NOT NULL,
  `growers_record_id` int(11) DEFAULT NULL,
  `number_match` varchar(20) DEFAULT NULL,
  `date_update` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `position`
--

CREATE TABLE `position` (
  `position_id` int(11) NOT NULL,
  `position` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `position`
--

INSERT INTO `position` (`position_id`, `position`) VALUES
(1, 'Manager'),
(2, 'Field Manager');

-- --------------------------------------------------------

--
-- Table structure for table `price`
--

CREATE TABLE `price` (
  `price_id` int(11) NOT NULL,
  `price_description` varchar(50) DEFAULT NULL,
  `price_value` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `price`
--

INSERT INTO `price` (`price_id`, `price_description`, `price_value`) VALUES
(1, 'Improve Bolangon Old Banana (1 BoB)', 1.1),
(2, 'Old Banana ( OB )', 1);

-- --------------------------------------------------------

--
-- Table structure for table `province`
--

CREATE TABLE `province` (
  `province_id` int(11) NOT NULL,
  `province` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `province`
--

INSERT INTO `province` (`province_id`, `province`) VALUES
(1, 'Negros Oriental'),
(2, 'Negros Occidental');

-- --------------------------------------------------------

--
-- Table structure for table `security_question`
--

CREATE TABLE `security_question` (
  `security_question_id` int(11) NOT NULL,
  `security_description` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `status_id` int(11) NOT NULL,
  `description` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`status_id`, `description`) VALUES
(1, 'Active'),
(2, 'Deactivate');

-- --------------------------------------------------------

--
-- Table structure for table `worker`
--

CREATE TABLE `worker` (
  `worker_id` int(11) NOT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `middlename` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `gender_id` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `elementary` varchar(100) NOT NULL,
  `highschool` varchar(100) NOT NULL,
  `college` varchar(100) NOT NULL,
  `undergraduate` varchar(100) NOT NULL,
  `vocational` varchar(100) NOT NULL,
  `skills` varchar(100) NOT NULL,
  `street` varchar(70) DEFAULT NULL,
  `barangay` varchar(70) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `contact_number` varchar(80) DEFAULT NULL,
  `email_address` varchar(80) DEFAULT NULL,
  `position_id` int(11) DEFAULT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `status_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `worker`
--

INSERT INTO `worker` (`worker_id`, `firstname`, `middlename`, `lastname`, `gender_id`, `age`, `elementary`, `highschool`, `college`, `undergraduate`, `vocational`, `skills`, `street`, `barangay`, `city_id`, `contact_number`, `email_address`, `position_id`, `start_date`, `end_date`, `status_id`) VALUES
(1, 'Anne', 'Ganda', 'Curtis', 2, 33, 'WEST', 'NOHS', 'NORSU', '', '', '', NULL, NULL, 1, NULL, NULL, 1, '2016-08-08', '0000-00-00', 1),
(2, 'Cristine', 'Aguillera', 'Reyes', 2, 43, '', '', '', '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, '2016-08-07', '9999-12-31', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`account_id`),
  ADD KEY `city_id` (`city_id`),
  ADD KEY `security_question_id` (`security_question_id`),
  ADD KEY `position_id` (`position_id`);

--
-- Indexes for table `bagging_tagging`
--
ALTER TABLE `bagging_tagging`
  ADD PRIMARY KEY (`bagging_tagging_id`),
  ADD KEY `growers_record_id` (`growers_record_id`);

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`city_id`),
  ADD KEY `province_id` (`province_id`);

--
-- Indexes for table `color_code`
--
ALTER TABLE `color_code`
  ADD PRIMARY KEY (`color_code_id`);

--
-- Indexes for table `contaiment`
--
ALTER TABLE `contaiment`
  ADD PRIMARY KEY (`containment_id`);

--
-- Indexes for table `gender`
--
ALTER TABLE `gender`
  ADD PRIMARY KEY (`gender_id`);

--
-- Indexes for table `growers_record`
--
ALTER TABLE `growers_record`
  ADD PRIMARY KEY (`growers_record_id`);

--
-- Indexes for table `harvest`
--
ALTER TABLE `harvest`
  ADD PRIMARY KEY (`harvest_id`),
  ADD KEY `growers_record_id` (`growers_record_id`);

--
-- Indexes for table `income`
--
ALTER TABLE `income`
  ADD PRIMARY KEY (`income_id`),
  ADD KEY `growers_record_id` (`growers_record_id`);

--
-- Indexes for table `num_match`
--
ALTER TABLE `num_match`
  ADD PRIMARY KEY (`num_match_id`),
  ADD KEY `growers_record_id` (`growers_record_id`);

--
-- Indexes for table `position`
--
ALTER TABLE `position`
  ADD PRIMARY KEY (`position_id`);

--
-- Indexes for table `price`
--
ALTER TABLE `price`
  ADD PRIMARY KEY (`price_id`);

--
-- Indexes for table `province`
--
ALTER TABLE `province`
  ADD PRIMARY KEY (`province_id`);

--
-- Indexes for table `security_question`
--
ALTER TABLE `security_question`
  ADD PRIMARY KEY (`security_question_id`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`status_id`);

--
-- Indexes for table `worker`
--
ALTER TABLE `worker`
  ADD PRIMARY KEY (`worker_id`),
  ADD KEY `city_id` (`city_id`),
  ADD KEY `position_id` (`position_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `account_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `bagging_tagging`
--
ALTER TABLE `bagging_tagging`
  MODIFY `bagging_tagging_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `city`
--
ALTER TABLE `city`
  MODIFY `city_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `color_code`
--
ALTER TABLE `color_code`
  MODIFY `color_code_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `contaiment`
--
ALTER TABLE `contaiment`
  MODIFY `containment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `gender`
--
ALTER TABLE `gender`
  MODIFY `gender_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `growers_record`
--
ALTER TABLE `growers_record`
  MODIFY `growers_record_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `harvest`
--
ALTER TABLE `harvest`
  MODIFY `harvest_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `income`
--
ALTER TABLE `income`
  MODIFY `income_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `num_match`
--
ALTER TABLE `num_match`
  MODIFY `num_match_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `position`
--
ALTER TABLE `position`
  MODIFY `position_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `price`
--
ALTER TABLE `price`
  MODIFY `price_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `province`
--
ALTER TABLE `province`
  MODIFY `province_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `security_question`
--
ALTER TABLE `security_question`
  MODIFY `security_question_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `status`
--
ALTER TABLE `status`
  MODIFY `status_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `worker`
--
ALTER TABLE `worker`
  MODIFY `worker_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`),
  ADD CONSTRAINT `account_ibfk_2` FOREIGN KEY (`security_question_id`) REFERENCES `security_question` (`security_question_id`),
  ADD CONSTRAINT `account_ibfk_3` FOREIGN KEY (`position_id`) REFERENCES `position` (`position_id`);

--
-- Constraints for table `bagging_tagging`
--
ALTER TABLE `bagging_tagging`
  ADD CONSTRAINT `bagging_tagging_ibfk_1` FOREIGN KEY (`growers_record_id`) REFERENCES `growers_record` (`growers_record_id`);

--
-- Constraints for table `city`
--
ALTER TABLE `city`
  ADD CONSTRAINT `city_ibfk_1` FOREIGN KEY (`province_id`) REFERENCES `province` (`province_id`);

--
-- Constraints for table `harvest`
--
ALTER TABLE `harvest`
  ADD CONSTRAINT `harvest_ibfk_1` FOREIGN KEY (`growers_record_id`) REFERENCES `growers_record` (`growers_record_id`);

--
-- Constraints for table `income`
--
ALTER TABLE `income`
  ADD CONSTRAINT `income_ibfk_1` FOREIGN KEY (`growers_record_id`) REFERENCES `growers_record` (`growers_record_id`);

--
-- Constraints for table `num_match`
--
ALTER TABLE `num_match`
  ADD CONSTRAINT `num_match_ibfk_1` FOREIGN KEY (`growers_record_id`) REFERENCES `growers_record` (`growers_record_id`);

--
-- Constraints for table `worker`
--
ALTER TABLE `worker`
  ADD CONSTRAINT `worker_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`),
  ADD CONSTRAINT `worker_ibfk_2` FOREIGN KEY (`position_id`) REFERENCES `position` (`position_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
