Feature: Signin functionality.

 Background: 
    Given user launched the browser.
    When user entered url verify user landed on luma home page.
  @SignIn
  Scenario Outline: Verify multiple Users is able to signin.
    When user clicked on signin option.
    Then verify user landed on Customer Login page.
    And user entered emailId As "<emailID>" and password as "<password>".
    And user clicked on signin button.
    Then verify landed on home page.
    And select dress type.

    Examples: 
      | emailID              | password     |
      | GiLcLIBK@Yopmail.com | hcAeMcDR@123 |
      