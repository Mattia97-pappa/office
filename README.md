Employees Management📌



👀 Il codice sorgente completo si trova in src, suddiviso in package chiari:

controller → gestione delle rotte

entity → entità del database

repository → interfaccia con il DB

security & config → login, autenticazione e accessi

Accedi all'app dal browser vai su http://localhost:8080

▶️ Per eseguire il progetto Clona la repository con il seguente comando su gitbash


```bash

git clone https://github.com/Mattia97-pappa/office.git
cd office


```
Per far funzionare il tutto copia le tabelle. Crea un record in AdmUser di un amministratore per accedere.  roles "admin"



```tabella adm
CREATE TABLE `admuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
```
```tabella employees
CREATE TABLE `employees` (
  `employeeNumber` int(11) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `extension` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `officeCode` int(11) NOT NULL,
  `reportsTo` int(11) DEFAULT NULL,
  `jobTitle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employeeNumber`),
  KEY `reportsTo` (`reportsTo`),
  KEY `officeCode` (`officeCode`),
  CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`reportsTo`) REFERENCES `employees` (`employeeNumber`),
  CONSTRAINT `employees_ibfk_2` FOREIGN KEY (`officeCode`) REFERENCES `offices` (`officeCode`)
) ENGINE=InnoDB AUTO_INCREMENT=1722 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
```
```tabella offices
CREATE TABLE `offices` (
  `officeCode` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `addressLine1` varchar(255) DEFAULT NULL,
  `addressLine2` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `postalCode` varchar(255) DEFAULT NULL,
  `territory` varchar(255) DEFAULT NULL,
  `employeeNumber` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`officeCode`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
 ```
🎥 Demo Videos

-
  [Watch on Vimeo](https://vimeo.com/1076063258)
