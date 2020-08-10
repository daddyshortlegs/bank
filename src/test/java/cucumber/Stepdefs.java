package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Stepdefs {

    @Given("a client makes a deposit of {int} on {int}-{int}-{int}")
    public void a_client_makes_a_deposit_of_on(Integer int1, Integer int2, Integer int3, Integer int4) {
    }

    @Given("a deposit of {int} on {int}-{int}-{int}")
    public void a_deposit_of_on(Integer int1, Integer int2, Integer int3, Integer int4) {
    }

    @Given("a withdrawal of {int} on {int}-{int}-{int}")
    public void a_withdrawal_of_on(Integer int1, Integer int2, Integer int3, Integer int4) {
    }

    @When("they print their bank statement")
    public void they_print_their_bank_statement() {
    }

}
