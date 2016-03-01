@echo off
"C:\Program Files\MySQL\MySQL Server 5.7\bin\mysqldump.exe" -u root -p --no-data convertron > .\convertron_schema.sql
PAUSE