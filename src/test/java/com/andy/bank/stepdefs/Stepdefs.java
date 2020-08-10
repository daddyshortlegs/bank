package com.andy.bank.stepdefs;

import com.andy.bank.AccountService;
import com.andy.bank.BankAccountService;
import com.andy.bank.ConsolePrinter;
import com.andy.bank.TransactionDate;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class Stepdefs {
    private AccountService accountService;
    @Mock
    private TransactionDate transactionDate;
    @Mock
    private ConsolePrinter consolePrinter;

    @Before
    public void before() {
        MockitoAnnotations.openMocks(this);
        accountService = new BankAccountService(transactionDate);
    }

    @Given("a client makes a deposit of {int} on {string}")
    public void a_client_makes_a_deposit_of_on(int amount, String date) {
        given(transactionDate.current()).willReturn(date);
        accountService.deposit(amount);
    }

    @Given("a deposit of {int} on {string}")
    public void a_deposit_of_on(Integer amount, String date) {
        given(transactionDate.current()).willReturn(date);
        accountService.deposit(amount);
    }

    @Given("a withdrawal of {int} on {string}")
    public void a_withdrawal_of_on(Integer amount, String date) {
        given(transactionDate.current()).willReturn(date);
        accountService.withdraw(amount);
    }

    @When("they print their bank statement")
    public void they_print_their_bank_statement() {
        accountService.printStatement();
    }

    @Then("they would see")
    public void they_would_see(String statement) {
        verify(consolePrinter).output(statement);
    }
}
