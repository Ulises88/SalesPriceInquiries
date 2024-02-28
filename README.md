# README

# SalesPriceInquiries

SalesPriceInquiries is a web service designed to manage sales price inquiries. It allows users to make inquiries about
product prices, on the pvp catalog.

# Installation

Clone this repository on your local machine:


------------------------------------------------------------------------------------------------------

     git clone https://github.com/Ulises88/SalesPriceInquiries/tree/develop/feature/salespriceinquiries | 

# Main class

Access the project directory:

-------------------------------------------------------------------------------
cd mx/com/uncertaincompany/salespriceinquiries/SalesPriceInquiriesApplication

# Install the necessary dependencies to maven:

<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter</artifactId>

<groupId>com.h2database</groupId>
<artifactId>h2</artifactId>
<scope>runtime</scope>

<groupId>org.projectlombok</groupId>
<artifactId>lombok</artifactId>
<version>1.18.24</version>

<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-test</artifactId>
<scope>test</scope>

<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>

<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-data-jpa</artifactId>

<groupId>org.apache.commons</groupId>
<artifactId>commons-lang3</artifactId>
<version>3.0</version>

# Configure the database

Read the database-setup.md document

# Test BD:

Open your browser and go to http://localhost:8080/h2-console to start using the console of database.

# Schema Price Table:

| Field          | Description                                                                                                                                    |
|----------------|------------------------------------------------------------------------------------------------------------------------------------------------|
| BRAND_ID       | Foreign key of the group chain.                                                                                                                |
| START_DATE     | Start date of the price tariff validity range.                                                                                                 |
| END_DATE       | End date of the price tariff validity range.                                                                                                   |
| PRICE_LIST     | Identifier of the applicable price tariff.                                                                                                     |
| PRODUCT_ID     | Product identifier.                                                                                                                            |
| PRIORITY       | Price application disambiguator. If two tariffs overlap in a date range, the one with the highest priority (highest numeric value) is applied. |
| PRICE          | Final sale price.                                                                                                                              |
| CURR           | Currency ISO.                                                                                                                                  |
| LAST_UPDATE    | Last date of modified.                                                                                                                         |
| LAST_UPDATE_BY | Last user who modified the table.                                                                                                              |

# Test Service.

Open your browser and introduce to http://localhost:8080/salesinquiries the parameters to realize the query.

For example:
http://localhost:8080/salesinquiries?date=2020-06-14%2016:00:00&product_id=35455&brand_id=1

This will display the list of records that match the parameters.

# Credits

This project was developed by Ulises Ortega.


# Contact

If you have any questions or suggestions, feel free to contact me via email: ulisesorteg@gmail.com


