# User Management system using Command Line Interface (CLI)

## Features
  - Create User using command as create
    - Provide user attributes 
      - -n for name
      - -p for phone
      - -a for address
      - -e for email id

  - Read User using command as read
    - Provide user attributes
      - -n for name, read user by name
      - -i for id, read user by id 
      - --all get all users
      
  - Delete User using command as delete
    - Provide user attributes 
      - -i for id, delete user by id

  - Update Action
    - Provide user attributes
      - i for id, update user by id
      - -f fieldName
      - -v value of that field

OOAD - 
Used SOLID Design Principles to design User Management System using Command Line Interface (CLI)

Break Down
- action
- attributes (input)
- result (output)

Create Action
- Action Name : Create
- Attributes: -n, -p, -a, -e
- Result: Message with ID / Duplicate User not allowed!

Read Action
- Action Name : Read
- Attributes: -i, -n, -all, 
- Result: User Object (single User information) by id
- Result: (-all) User Objects (multiple user Information) by all

Delete Action
- Action Name : Delete
- Attributes: -i
- Result: message / User doesn't exists (success/failure)

- Data ?  User -- Model
- Operations
- Similarity

- User model
- Command interface
- User store use HashMap

