# mysql-connection-example

This is an example of connecting MySQL server from Java program.

## Usage

set environment variables:

- DB_HOST
- DB_PORT
- DB_NAME
- DB_USER
- DB_PASSWORD

```
MySQLConnection mysql = new MySQLConnection();
String[] tables = new String[1];
tables[0] = "users"; // Pass the table name you want to select. This does not have to be just one.
ResultSet[] result = mysql.main(tables);
```

NOTE:
You need to prepare MySQL connector. Download the jar file from here:  
http://dev.mysql.com/downloads/connector/j/
