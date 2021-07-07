# nishWork
it is just a test repository Backend: SpringBoot / Frontend: Reactjs

Tip: Before running the frontend part (React), type "run install" on the terminal and run it to install "node_modules"

CUSTOMER:

POST POST/api/addCustomers
	post new customers
	http://localhost:8070/api/addCustomers
	
POST POST/api/addCustomer
	post a new customer
	http://localhost:8070/api/addCustomer

GET GET/api/customers
	get all customers
	http://localhost:8070/api/customers
	
GET GET/api/customer/{id}
	get a customer
	http://localhost:8070/api/addCustomer/{id}
	
PUT PUT/api/update
	update a customer
	http://localhost:8070/api/update

DELETE DELETE/api/deleteCustomer/{id}
	destroy a customer
	http://localhost:8070/api/deleteCustomer/{id}
	
----------------------------------------------------
----------------------------------------------------
DOCUMENT:

POST POST/api/customers/{id}/uploadFile
	upload a new file for a customer
	http://localhost:8070/api/customers/{id}/uploadFile
	
GET GET/api/downloadFile/{id}
	download a file
	http://localhost:8070/api/downloadFile/{id}
	
GET GET/api/files
	get all files
	http://localhost:8070/api/files
	
GET GET/api/customer/{id}/files
	get a customer's all files
	http://localhost:8070/api/customer/{id}/files
	
GET GET/api/files/{id}
	get a file
	http://localhost:8070/api/files/{id}
	
PUT PUT/api/file/update/
	update a file
	http://localhost:8070/api/file/update

DELETE DELETE/api/deleteFile/{id}
	destroy a file
	http://localhost:8070/api/deleteFile/{id}
