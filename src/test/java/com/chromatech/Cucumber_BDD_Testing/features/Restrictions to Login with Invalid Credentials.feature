Feature: Restrictions to Login with Invalid Credentials

  @Regression @AG3CP-50 @ValerieYa
  Scenario: Restrictions to Login with Invalid Credentials
    Given a user is on the Chroma Tech Academy practice site "https://mexil.it/chroma/site/login"
    When user enters invalid username "firstgeneral@teacher.com" in username text box
    And enters invalid password "654321" in password text box
    And clicks on Sign In button
    Then the user should see an error message