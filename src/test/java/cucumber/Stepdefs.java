package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefs {

    @Given("a client makes a deposit of {int} on {string}")
    public void a_client_makes_a_deposit_of_on(Integer amount, String date) {
    }

    @Given("a deposit of {int} on {string}")
    public void a_deposit_of_on(Integer amount, String date) {
    }

    @Given("a withdrawal of {int} on {string}")
    public void a_withdrawal_of_on(Integer amount, String date) {
    }

    @When("they print their bank statement")
    public void they_print_their_bank_statement() {
    }

    @Then("they would see")
    public void they_would_see(String statement) {

    }

}
