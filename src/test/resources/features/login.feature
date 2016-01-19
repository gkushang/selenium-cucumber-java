Feature: Login

  In order to save PayPal offers
  As a user
  I want to be able to login and save to my wallet

  @invalid_login
  Scenario: User tries to login with invalid credentials

    When user tries to login with invalid credentials
    Then he sees the error message


  @empty_login
  Scenario: User tries to login with invalid credentials

    When user tries to login with invalid credentials
    Then he sees the error message
