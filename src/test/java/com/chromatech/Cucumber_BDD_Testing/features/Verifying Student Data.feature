Feature: Verifying Student Data

  @Regression @Kei @AG3CP-27
  Scenario Outline: Student Data Displays as Expected
    Given a user is on the Chroma Tech Academy practice site "https://mexil.it/chroma/site/login"
    And user enters username "general@teacher.com" in username text box
    And enters password "123456" in password text box
    And clicks on Sign In button
    And user is directed to the CTSMS dashboard page "https://mexil.it/chroma/admin/admin/dashboard"
    And verifies a student with "<Admission No>" is not an existing student
    And creates a test category "<Category>"
    And a CTSMS admin or faculty member is on the student admission page "https://mexil.it/chroma/student/create"
    And the user fills out all fields "<Admission No>", "<Roll Number>", "<Class>", "<Section>", "<First Name>", "<Last Name>", "<Gender>", "<Date of Birth>", "<Category>", "<Email>", "<Admission Date>", "<Blood Group>", "<As on Date>", "<Mobile Number>", "<Height>", "<Weight>", "<Father Name>", "<Father Phone>", "<Father Occupation>", "<Mother Name>", "<Mother Phone>", "<Mother Occupation>", "<Guardian Email>", "<Guardian Address>"
    And clicks save
    When a student has been admitted with "<Admission No>" and "<Full Name>"
    And an admin navigates to a student record with "<Admission No>"
    Then all data submitted with the record should display as expected "<Admission No>", "<Roll Number>", "<Class>", "<Section>", "<Full Name>" "<Gender>", "<Date of Birth>", "<Category>", "<Email>", "<Admission Date>", "<Blood Group>", "<As on Date>", "<Mobile Number>", "<Height>", "<Weight>", "<Father Name>", "<Father Phone>", "<Father Occupation>", "<Mother Name>", "<Mother Phone>", "<Mother Occupation>", "<Guardian Email>", "<Guardian Address>"
    And find record on the bulk delete page with "<Class>", "<Section>", "<Admission No>"
    And delete test account with "<Admission No>"
    And delete the test category

    Examples:
      | Admission No | Roll Number | Class | Section               | First Name | Last Name | Full Name | Gender | Date of Birth | Category | Email             | Admission Date | Blood Group | As on Date | Mobile Number | Height | Weight | Father Name  | Father Phone | Father Occupation | Mother Name | Mother Phone | Mother Occupation | Guardian Email     | Guardian Address | Bank Account Number | Bank Name    | IFSC Code | National Identification Number | Local Identification Number | Previous School Details                     | Note                                                                                     | Title 1 | Title 2 | Title 3 | Title 4     |
      | 333333333333 | 98765       | SDET  | Cucumber Fundamentals | Amy        | Doe       | Amy Doe   | Female | 03/03/1993    | Selenium | amy.doe@email.com | 07/03/2024     | O+          | 12/04/2024 | 1234567890    | 180    | 75     | John Doe Sr. | 0987654321   | Engineer          | Jane Doe    | 1122334455   | Doctor            | guardian@email.com | 123 Main Street  | 123456789112        | Example Bank | 32412345  | 1234567890                     | 11112345                    | XYZ School, 123 Street, ABC City, DEF State | Enjoys programming in Java and using Selenium for test automation. Has a dog named Fido. | Sister  | Brother | Dog     | Grandfather |