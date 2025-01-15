Feature: Adding and deleting student categories

  @Regression @Nahun @AG3CP-20
  Scenario Outline: Adding and deleting student categories
    Given a user is on the Chroma Tech Academy practice site "https://mexil.it/chroma/site/login"
    And user enters username "general@teacher.com" in username text box
    And enters password "123456" in password text box
    And clicks on Sign In button
    And user is directed to the CTSMS dashboard page "https://mexil.it/chroma/admin/admin/dashboard"
    Then user clicks on student information submodule
    And creates a test category "Selenium"
    And delete the test category
