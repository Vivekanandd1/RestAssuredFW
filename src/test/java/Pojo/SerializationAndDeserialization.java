package Pojo;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class SerializationAndDeserialization {
	
	@Test
	public void CreateJsonObjectFromEmployeeClassObject() throws JsonProcessingException {
		Employee emp = new Employee();
		emp.setFirstname("Vivek");
		emp.setLastname("Deshmukh");
		emp.setAge(28);
		emp.setGender("Male");
		emp.setSalary(10000);
		
		Employee emp1 = new Employee();
		emp1.setFirstname("Vatsal");
		emp1.setLastname("Deshmukh");
		emp1.setAge(22);
		emp1.setGender("Male");
		emp1.setSalary(12000);
		
		Employee emp2 = new Employee();
		emp2.setFirstname("Damini");
		emp2.setLastname("Deshmukh");
		emp2.setAge(28);
		emp2.setGender("Male");
		emp2.setSalary(10000);
		
		
		List<Employee> empss = new ArrayList<>();
		empss.add(emp);
		empss.add(emp1);
		empss.add(emp2);
		ObjectMapper obMap = new ObjectMapper();
		String value = obMap.writerWithDefaultPrettyPrinter().writeValueAsString(empss);
		System.out.println(value);
		
		RequestSpecification res = RestAssured.given();
		res.baseUri("http://httpbin.org/post");
		res.contentType(ContentType.JSON);
		res.body(value);
		Response resp = res.post();
		resp.prettyPrint();
		System.out.println("---------------------------------------------------------------");
              
		ResponseBody Rbody = resp.getBody();
		 JsonPath Jpath = Rbody.jsonPath();
		List<Employee> allEmpl = Jpath.getList("json", Employee.class);
		
		for(Employee emp11: allEmpl) {
			System.out.println(emp11.getFirstname());
		}
		
		
		
	}
	

}
