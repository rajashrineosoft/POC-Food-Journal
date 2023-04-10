package com.neosoft.poc.foodjournal.error;

public enum HttpStatusCode {
	
	NO_ENTRY_FOUND(101,"Resource Not Found"),
	
	NO_STUDENT_NAME_FOUND(202,"No student name found"),
	
	NO_CLASSID_FOUND(206,"please enter class Id"),
	
	NO_SCHOOL_NAME_FOUND(202, "No School Name Found"),
	
	NO_FOOD_FOUND(108,"No Food Found"),
	
	NO_REGION_FOUND(108,"No Region Found"),
	
	NO_REGION_ADDED(108,"Add a region in Educational Institution"),
	
	NO_REGION_ID_FOUND(206,"please enter Region Id"),
	
	USER_RETRIVED_SUCCESSFULLY(200,"User Retrived"),
	
	CLASS_RETRIVED_SUCCESSFULLY(200,"class Retrived"),
	
	NO_USER_MATCH_WITH_ID(109,"No User found with given Id "),
	
	NO_STUDENT_MATCH_WITH_ID(109,"No such student found with such id"),
	
	NO_CLASS_MATCH_WITH_ID(109,"No such class found with such id"),
	
    NO_PAYMENT_FOUND(108,"No Payment Found"),
    
    NO_PAYMENT_MATCH_WITH_ID(109,"No Payment found with given Id "),
	
	PAYMENT_RETRIVED_SUCCESSFULLY(200,"Payment Retrived"),
	
	STUDENT_RETRIVED_SUCCESSFULLY(200,"Student retrived"),
	
	CONTACTINFO_RETRIVED_SUCCESSFULLY(200,"Contact Info retrived successfully"),

    NO_CLASSCODE_FOUND(202,"No class code found"),
    
    RESOURCE_CREATED_SUCCESSFULLY(200,"Resource created successfully"),

	
	NO_CONTACTINFO_FOUND(108,"No contact info found"),

	 NO_EDUCATIONAL_INSTITUTION_FOUND(108,"No Educational Institution Found"),
		
	 NO_FOOD_MATCH_WITH_ID(109,"No Food found with given Id "),
		
	
	REGION_NAME_DUPLICATE(110,"region with given name already exist"),
	NO_TRANSFERCERTIFICATE_FOUND(108, "No Transfer Certificate Found"),
	
	NO_CONTACTINFO_MATCH_WITH_ID(109,"No such contact info found with such id"),

	NO_REGION_MATCH_WITH_ID(109, "No Region Match with ID"),
	
	NO_TRANSFER_CERTIFICATE_MATCH_WITH_ID(109,"No such Transfer Certificate found with such id"),
	
	
	RESOURCE_NOT_FOUND(108, "Does not exist"),

	RESOURCE_ALREADY_EXISTS(110, "Already exists"),
	ROLE_NOT_EXISTS(110, "Given Role Type Not Exist"),
	USERNAME_NOT_AVAILAIBLE(110, "Username Not Availaible"),
	ROLETYPE_NOT_AVAILAIBLE(110, "Role Type Not Availaible"),
	INVALID_COLUMN_NAME(111, "Invalid column name provided"),

	WRONG_DATA_TYPE(112, "Wrong datatype selected for non multivalued field"),

	IO_EXCEPTION(113, "I/O exception occurred"),

	JSON_PARSE_EXCEPTION(114, "JSON parse error occurred"),

	INVALID_FIELD_VALUE(116, "Value for field : {} is not expected as : {}"),

	CONNECTION_REFUSED(120, "Connection is refused from the server"),

	INVALID_CREDENTIALS(121, "Invalid credentials provided"),

	BAD_REQUEST_EXCEPTION(400, "Bad Request Occuured"),

	NULL_POINTER_EXCEPTION(500, "Received Null response"),

	SERVER_UNAVAILABLE(503, "Unable to Connect To the Server"),

	OPERATION_NOT_ALLOWED(405, "Operation is Not Allowed"),

	UNAUTHORIZED_EXCEPTION(401, "Unauthorized To Perform Request"),
	USER_DEACTIVATED(401, "User is deactivated"),

	FORBIDDEN_EXCEPTION(403, "Forbidden access attempted"),

	INTERNAL_SERVER_ERROR(500, "Internal Server Error Occured"),

	PROCESSING_NOT_COMPLETED(202, "Request cannot be Processed"),

	NOT_ACCEPTABLE_ERROR(406, "Request Not accpetable"),

	SUCCESSFUL(200, "Request Successfull"),
	
	CONTACTINFO_DELETED(200,"contact info deleted successfully"),

	TRANSFER_CERTIFICATE_DELETED(200, "Transfer Certificate Deleted Successfully"),

	RETREIVED_SUCCESSFULLY(200, "Data Retrieved Successfully"),

	STUDENT_DELETED(200, "Student Deleted Successfully"),
	STUDENT_PROMOTED_SUCCESSFULLY(200, "Student promoted Successfully"),
	STUDENT_DEMOTED_SUCCESSFULLY(200, "Student Demoted Successfully"),
	CONTACTINFO_UPDATED(200,"Contact info updated successfully"),

	FOOD_UPDATED(200,"Food  updated successfully"),
	
	FOOD_DELETED(200,"Food Deleted Successfully");
	


	private int code;
	private String message;

	HttpStatusCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}