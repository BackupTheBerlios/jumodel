/*
Created		2007-11-07
Modified		2007-11-21
Project		Biuro podró¿y
Model		
Company		ASSECO & UHC
Author		K£, RL, KS, SP
Version		1.0
Database		mySQL 5 
*/




















drop table IF EXISTS OfferPromotions;
drop table IF EXISTS Complaints;
drop table IF EXISTS Remarks;
drop table IF EXISTS Reservations;
drop table IF EXISTS Expeditions;
drop table IF EXISTS Offers;
drop table IF EXISTS Categories;
drop table IF EXISTS Quarters;
drop table IF EXISTS Transports;
drop table IF EXISTS Travels;
drop table IF EXISTS Promotions;
drop table IF EXISTS Users;




Create table Users (
	UserID Int UNSIGNED NOT NULL AUTO_INCREMENT,
	Name Varchar(50) NOT NULL,
	Surname Varchar(50) NOT NULL,
	Email Varchar(50) NOT NULL,
	Pesel Varchar(11) NOT NULL,
	DateOfBirth Date,
	PhoneNumber Varchar(50),
	PostCode Varchar(6),
	Street Varchar(50),
	Nr Varchar(10),
	NIP Varchar(10),
	Login Varchar(50) NOT NULL,
	Password Varchar(50) NOT NULL,
	Role Enum('CUSTOMER','EMPLOYEE','MANAGER') NOT NULL,
	Description Varchar(500),
	UNIQUE (Pesel),
	UNIQUE (Login),
 Primary Key (UserID)) ENGINE = InnoDB
AUTO_INCREMENT = 0;

Create table Promotions (
	PromotionID Int UNSIGNED NOT NULL AUTO_INCREMENT,
	Name Varchar(50) NOT NULL,
	PercentValue Smallint NOT NULL,
	Description Varchar(500),
	UNIQUE (Name),
 Primary Key (PromotionID)) ENGINE = InnoDB
AUTO_INCREMENT = 0;

Create table Travels (
	TravelID Int UNSIGNED NOT NULL AUTO_INCREMENT,
	Name Varchar(200) NOT NULL,
	Country Varchar(50) NOT NULL,
	Place Varchar(50) NOT NULL,
	Description Varchar(500),
 Primary Key (TravelID)) ENGINE = InnoDB
AUTO_INCREMENT = 0;

Create table Transports (
	TransportID Int UNSIGNED NOT NULL AUTO_INCREMENT,
	Company Varchar(250),
	Type Enum('COACH','PLANE','SHIP','TRAIN','BUS','OTHER') NOT NULL,
	AmountOfPlaces Mediumint,
	Description Varchar(500),
 Primary Key (TransportID)) ENGINE = InnoDB
AUTO_INCREMENT = 0;

Create table Quarters (
	QuarterID Int UNSIGNED NOT NULL AUTO_INCREMENT,
	Name Varchar(200) NOT NULL,
	Address Varchar(250),
	Type Enum('HOTEL','MOTEL','CAMP_SITE','CARAVAN_SITE','OTHER') NOT NULL,
	Luxury Enum('ENOUGH','NORMAL','GOOD','VERY_GOOD','EXCELLENT','LUXURIOUS') NOT NULL,
	Description Varchar(500),
 Primary Key (QuarterID)) ENGINE = InnoDB
AUTO_INCREMENT = 0;

Create table Categories (
	CategoryID Int UNSIGNED NOT NULL AUTO_INCREMENT,
	Name Varchar(50),
	Description Varchar(500),
 Primary Key (CategoryID)) ENGINE = InnoDB
AUTO_INCREMENT = 0;

Create table Offers (
	OfferID Int UNSIGNED NOT NULL AUTO_INCREMENT,
	TravelID Int UNSIGNED NOT NULL,
	TransportID Int UNSIGNED NOT NULL,
	QuarterID Int UNSIGNED NOT NULL,
	CategoryID Int UNSIGNED NOT NULL,
	Name Varchar(50) NOT NULL,
	Price Decimal(10,4) NOT NULL,
	Description Varchar(500),
	UNIQUE (Name),
 Primary Key (OfferID)) ENGINE = InnoDB
AUTO_INCREMENT = 0;

Create table Expeditions (
	ExpeditionID Int UNSIGNED NOT NULL AUTO_INCREMENT,
	OfferID Int UNSIGNED NOT NULL,
	DateStop Datetime NOT NULL,
	DateFrom Date NOT NULL,
	DateTo Date NOT NULL,
	AmountOfPlaces Mediumint NOT NULL,
	MinPersons Mediumint NOT NULL,
	Description Varchar(500),
 Primary Key (ExpeditionID)) ENGINE = InnoDB
AUTO_INCREMENT = 0;

Create table Reservations (
	ReservationID Int UNSIGNED NOT NULL AUTO_INCREMENT,
	UserID Int UNSIGNED NOT NULL,
	ExpeditionID Int UNSIGNED NOT NULL,
	Prepayment Decimal(10,4),
	Date Timestamp,
	Status Enum('RESERVED', 'CANCELLED', 'ACCEPTED', 'PAID' ) NOT NULL,
	Description Varchar(500),
 Primary Key (ReservationID)) ENGINE = InnoDB
AUTO_INCREMENT = 0;

Create table Remarks (
	RemarkID Int UNSIGNED NOT NULL AUTO_INCREMENT,
	ExpeditionID Int UNSIGNED NOT NULL,
	Name Varchar(50) NOT NULL,
	Description Varchar(500),
	UNIQUE (Name),
 Primary Key (RemarkID)) ENGINE = InnoDB
AUTO_INCREMENT = 0;

Create table Complaints (
	ComplaintID Int UNSIGNED NOT NULL AUTO_INCREMENT,
	ReservationID Int UNSIGNED NOT NULL,
	Date Timestamp,
	Description Varchar(500),
 Primary Key (ComplaintID)) ENGINE = InnoDB
AUTO_INCREMENT = 0;

Create table OfferPromotions (
	OfferPromotionsID Int UNSIGNED NOT NULL AUTO_INCREMENT,
	PromotionID Int UNSIGNED NOT NULL,
	OfferID Int UNSIGNED NOT NULL,
	DateFrom Datetime NOT NULL,
	DateTo Datetime NOT NULL,
	Description Varchar(500),
 Primary Key (OfferPromotionsID)) ENGINE = InnoDB
AUTO_INCREMENT = 0;












Alter table Reservations add Foreign Key (UserID) references Users (UserID) on delete cascade on update cascade;
Alter table OfferPromotions add Foreign Key (PromotionID) references Promotions (PromotionID) on delete cascade on update cascade;
Alter table Offers add Foreign Key (TravelID) references Travels (TravelID) on delete cascade on update cascade;
Alter table Offers add Foreign Key (TransportID) references Transports (TransportID) on delete cascade on update cascade;
Alter table Offers add Foreign Key (QuarterID) references Quarters (QuarterID) on delete cascade on update cascade;
Alter table Offers add Foreign Key (CategoryID) references Categories (CategoryID) on delete cascade on update cascade;
Alter table Expeditions add Foreign Key (OfferID) references Offers (OfferID) on delete cascade on update cascade;
Alter table OfferPromotions add Foreign Key (OfferID) references Offers (OfferID) on delete cascade on update cascade;
Alter table Reservations add Foreign Key (ExpeditionID) references Expeditions (ExpeditionID) on delete cascade on update cascade;
Alter table Remarks add Foreign Key (ExpeditionID) references Expeditions (ExpeditionID) on delete cascade on update cascade;
Alter table Complaints add Foreign Key (ReservationID) references Reservations (ReservationID) on delete cascade on update cascade;















/* Users permissions */






