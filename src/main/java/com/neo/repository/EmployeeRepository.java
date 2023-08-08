package com.neo.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.neo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Employee save(Employee employee){

        dynamoDBMapper.save(employee);
        return employee;
    }

    public Employee getEmployeeById(String employeeId){
        return dynamoDBMapper.load(Employee.class, employeeId);
    }
    public String delete(String employeeId){
        Employee employee = dynamoDBMapper.load(Employee.class, employeeId);
        dynamoDBMapper.delete(employee);
        return "Employee deleted";
    }

    public String update(String employeeId, Employee employee){
        dynamoDBMapper.save(employee,
                new DynamoDBSaveExpression().withExpectedEntry("enployeeId",
                        new ExpectedAttributeValue(
                                new AttributeValue().withS(employeeId))));
        return employeeId;
    }

    public List<Employee> getAllEmployees(){
        return dynamoDBMapper.scan(Employee.class, new DynamoDBScanExpression());
    }

}
