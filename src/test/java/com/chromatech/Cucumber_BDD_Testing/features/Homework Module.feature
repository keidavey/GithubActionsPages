Feature: Homework Module

  @Regression @Nahun @AG3CP-10
  Scenario: Add Homework Module Displays
    Given a user is on the Chroma Tech Academy practice site "https://mexil.it/chroma/site/login"
    And user enters username "general@teacher.com" in username text box
    And enters password "123456" in password text box
    And clicks on Sign In button
    And user is directed to the CTSMS dashboard page "https://mexil.it/chroma/admin/admin/dashboard"
    When the user clicks on the Homework module
    Then the "Add Homework" module displays