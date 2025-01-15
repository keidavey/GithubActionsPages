Feature: Human Resource Module

  @Regression @Nahun @AG3CP-52
  Scenario: Human Resource Module displays
    Given a user is on the Chroma Tech Academy practice site "https://mexil.it/chroma/site/login"
    And user enters username "general@teacher.com" in username text box
    And enters password "123456" in password text box
    And clicks on Sign In button
    When user is directed to the CTSMS dashboard page "https://mexil.it/chroma/admin/admin/dashboard"
    And the user clicks on the Human Resource module
    Then the following submodules are displayed "Staff Directory", "Staff Attendance", "Payroll", "Approve Leave Request", "Apply Leave", "Leave Type", "Teachers Rating", "Department", "Designation"