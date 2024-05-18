Feature: Create An Account.

  Background: 
    Given user launched the browser.
    When user entered url verify user landed on luma home page.

  @SignUp
  Scenario: Verify User is able create an account.
    And click on create an account option.
    Then verify user landed on create new customer account page.
    And fill the personal information.
    And click on create and account button.
    Then verify account created sucessfully.
    