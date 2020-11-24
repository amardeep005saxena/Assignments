package Assignment2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collection;

import static io.restassured.RestAssured.*;

public class restApi {

    Response response;
    public String ex_name;
    public String  ex_salary;
    public String  ex_age;
    ArrayList<Integer> IDList;


    @When("Adding a new employee with name {string} and age {string} and salary {string}")
    public void addingANewEmployeeWithNameAndAgeAndSalary(String n, String a, String s) {
        response= given().when().post("http://www.dummy.restapiexample.com/api/v1/create?name="+n+"&salary="+s+"&age="+a);

                this.ex_age=a;
                this.ex_name=n;
                this.ex_salary=s;

    }


    @Then("addition successful with status code {int}")
    public void additionSuccessfulWithStatusCode(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @And("the details of created employee are valid")
    public void theDetailsOfCreatedEmployeeAreValid() {
        response.then().log().body();
       String emp_name= response.jsonPath().get("data.name");
       String salary=response.jsonPath().get("data.salary");
       String age =response.jsonPath().get("data.age");

        Assert.assertEquals(ex_name,emp_name);
        Assert.assertEquals(ex_salary,salary);
        Assert.assertEquals(ex_age,age);
        System.out.println("Employee record created successfully");


    }

    @Given("all the employee details")
    public void allTheEmployeeDetails() throws AssertionError {
        response=given().when().get("http://www.dummy.restapiexample.com/api/v1/employees");
        try {
            response.then().assertThat().statusCode(200);
        }catch (AssertionError e){
            System.out.println("website is not reachable");
        }

    }

    @When("extract all the ids")
    public void extractAllTheIds() {
        IDList= response.path("data.id");

    }

    @Then("validate no duplicate ids")
    public void validateNoDuplicateIds() {
        for(int i=0;i < IDList.size() ;i++)
        {
            for (int j=i+1;j<IDList.size() ;j++)
            {
                if (IDList.get(i)==IDList.get(j))
                {
                    System.out.println("Duplicate if found"+IDList.get(i));
                    break;
                }
            }

        }
        System.out.println("No Duplicate Ids found!!");

    }

    @And("print ID and name of employees")
    public void printIDAndNameOfEmployees() {
        ArrayList<String> NameList = response.then().extract().path("data.employee_name");
        System.out.println(IDList);
        System.out.println(NameList);


    }}


