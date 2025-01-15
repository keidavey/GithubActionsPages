Feature: Valid Credentials Login

  @Regression @AG3CP-48 @ValerieYa
  Scenario: Valid Credentials Login
    Given a user is on the Chroma Tech Academy practice site "https://mexil.it/chroma/site/login"
    When user enters username "general@teacher.com" in username text box
    And enters password "123456" in password text box
    And clicks on Sign In button
    Then user is directed to the CTSMS dashboard page "https://mexil.it/chroma/admin/admin/dashboard"