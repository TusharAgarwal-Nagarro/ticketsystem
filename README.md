# ticketsystem
Spring Boot Sample Project For showcasing Spring boot Features:-

-	Logging (File and Console)
-	Caching
-	Monitoring (using Actuators)
-	Exception Handling
-	Multiple profiles for different environments

Following are the steps for running the sample Application : - 

1. Run SQL Script located at "\src\main\resources\sql" to create tables and insert records.
2. Only Login Functionality is integrated, User Registration is done via database only.
3. Launch the application with either dev or uat profile with following argument:-
   "-Dspring.profiles.active=dev"
4. Login with eg: username : Admin ,Password : P@ssw0rd
