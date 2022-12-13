# Employee-Management-System

## REST APIs

##### Create Employee  @PostMapping("/addEmployee")
    * sample Request =>
    * *
      {
      "addressRequests": [
      {
      "addressType": "CURRENT",
      "city": "Pune",
      "pinCode": "411001",
      "state": "Maharashtra"
      },
      {
      "addressType": "PERMANENT",
      "city": "Aurangabad",
      "pinCode": "431005",
      "state": "Maharashtra"
      }
      ],
      "employeeRequest": {
      "department": "ENGINEERING",
      "employeeAge": 25,
      "employeeFirstName": "Chandradip",
      "employeeLastName": "Shivankar",
      "gender": "MALE"
      }
      }

      
 * * Sample Response =>
    * *{
      "message": "Employee is Added!",
      "data": {
      "responseStatus": {
      "statusMsg": "SUCCESS",
      "statusCode": "1"
      },
      "employeeId": 1,
      "employeeFirstName": "Chandradip",
      "employeeLastName": "Shivankar",
      "employeeAge": 25,
      "gender": "MALE",
      "department": "ENGINEERING",
      "employeeCreatedDate": "14-12-2022-00-33-21",
      "employeeUpdatedDate": "14-12-2022-00-33-21",
      "addressResponses": [
      {
      "addressId": 1,
      "city": "Pune",
      "state": "Maharashtra",
      "pinCode": "411001",
      "addressType": "CURRENT",
      "addressCreatedDate": "14-12-2022-00-33-21",
      "addressUpdatedDate": "14-12-2022-00-33-21"
      },
      {
      "addressId": 2,
      "city": "Aurangabad",
      "state": "Maharashtra",
      "pinCode": "431005",
      "addressType": "PERMANENT",
      "addressCreatedDate": "14-12-2022-00-33-21",
      "addressUpdatedDate": "14-12-2022-00-33-21"
      }
      ]
      }
      }
 

####  2) Get All Employee Details  @GetMapping("/getAllEmployeeInfo")
* Sample Response =>
  *  {
     "message": "All Employee Fetched Successfully!",
     "data": [
     {
     "responseStatus": {
     "statusMsg": "SUCCESS",
     "statusCode": "1"
     },
     "employeeId": 1,
     "employeeFirstName": "Chandradip",
     "employeeLastName": "Shivankar",
     "employeeAge": 25,
     "gender": "MALE",
     "department": "ENGINEERING",
     "employeeCreatedDate": "14-12-2022-01-12-05",
     "employeeUpdatedDate": "14-12-2022-01-12-05",
     "addressResponses": [
     {
     "addressId": 1,
     "city": "Pune",
     "state": "Maharashtra",
     "pinCode": "411001",
     "addressType": "CURRENT",
     "addressCreatedDate": "14-12-2022-01-12-05",
     "addressUpdatedDate": "14-12-2022-01-12-05"
     },
     {
     "addressId": 2,
     "city": "Aurangabad",
     "state": "Maharashtra",
     "pinCode": "431005",
     "addressType": "PERMANENT",
     "addressCreatedDate": "14-12-2022-01-12-05",
     "addressUpdatedDate": "14-12-2022-01-12-05"
     }
     ]
     },
     {
     "responseStatus": {
     "statusMsg": "SUCCESS",
     "statusCode": "1"
     },
     "employeeId": 2,
     "employeeFirstName": "Kapil",
     "employeeLastName": "Jadhav",
     "employeeAge": 26,
     "gender": "MALE",
     "department": "IT_SUPPORT",
     "employeeCreatedDate": "14-12-2022-01-14-45",
     "employeeUpdatedDate": "14-12-2022-01-14-45",
     "addressResponses": [
     {
     "addressId": 3,
     "city": "Nashik",
     "state": "Maharashtra",
     "pinCode": "411001",
     "addressType": "CURRENT",
     "addressCreatedDate": "14-12-2022-01-14-45",
     "addressUpdatedDate": "14-12-2022-01-14-45"
     },
     {
     "addressId": 4,
     "city": "Jalna",
     "state": "Maharashtra",
     "pinCode": "431005",
     "addressType": "PERMANENT",
     "addressCreatedDate": "14-12-2022-01-14-45",
     "addressUpdatedDate": "14-12-2022-01-14-45"
     }
     ]
     }
     ]
     }