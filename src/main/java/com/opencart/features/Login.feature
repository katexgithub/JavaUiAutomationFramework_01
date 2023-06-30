Feature: Login Feature Test Suite

  Scenario Outline: An error message is displayed when login is performed with invalid data <attribute>
    Given the "https://andreisecuqa.host/index.php?route=account/login&language=en-gb" is accessed
    And the following data is entered into the login form:
      | <email>    |
      | <password> |
    When loginButton is clicked
    Then the following error message are displayed:
      | Warning: No match for E-Mail Address and/or Password. |
    Examples:
      | attribute | email                   | password    |
      | email     | someemail@gmail.com     | password123 |
      | password  | otheremail123@gmail.com | password456 |

  Scenario Outline: A valid user is able to log into the system
    Given the "https://andreisecuqa.host/index.php?route=account/login&language=en-gb" is accessed
    And the following data is entered into the login form:
      | <email>    |
      | <password> |
    When loginButton is clicked
    Then the current url contains the following keyword: "account"
    Examples:
      | email                  | password   |
      | some_2_email@gmail.com | passw02123 |

