Feature: Student Admission with Unique Admission Number

  @Regression @AG3CP-13 @Chris
  Scenario Outline: Student Admission with Unique Admission Number
    Given a user is on the Chroma Tech Academy practice site "https://mexil.it/chroma/site/login"
    And user enters username "general@teacher.com" in username text box
    And enters password "123456" in password text box
    And clicks on Sign In button
    And user is directed to the CTSMS dashboard page "https://mexil.it/chroma/admin/admin/dashboard"
    And verifies a student with "<Admission No>" is not an existing student
    And verifies a sibling with "112358132134" is not an existing student
    And creates a test category "<Category>"
    When a CTSMS admin or faculty member is on the student admission page "https://mexil.it/chroma/student/create"
    And creates a test sibling with admission number "112358132134", class "SDET", section "Cucumber Fundamentals", first name "Group Three Sibling", gender "Female", date of birth "03/03/1993", guardian name "Group Three Guardian", guardian phone number "3333333333"
    And adds a sibling
    And the user fills out all fields "<Admission No>", "<Roll Number>", "<Class>", "<Section>", "<First Name>", "<Last Name>", "<Gender>", "<Date of Birth>", "<Category>", "<Email>", "<Admission Date>", "<Blood Group>", "<As on Date>", "<Mobile Number>", "<Height>", "<Weight>", "<Father Name>", "<Father Phone>", "<Father Occupation>", "<Mother Name>", "<Mother Phone>", "<Mother Occupation>", "<Guardian Email>", "<Guardian Address>"
    And uploads family member photos
    And clicks the Add More Details button
    And adds Student Address Details
    And adds Miscellaneous Details "<Bank Account Number>", "<Bank Name>", "<IFSC Code>", "<National Identification Number>", "<Local Identification Number>", "<Previous School Details>", "<Note>"
    And uploads documents "<Title 1>", "<Title 2>", "<Title 3>", "<Title 4>"
    And clicks save
    And adds a sibling
    And the user fills out all fields "<Admission No>", "<Roll Number>", "<Class>", "<Section>", "<First Name>", "<Last Name>", "<Gender>", "<Date of Birth>", "<Category>", "<Email>", "<Admission Date>", "<Blood Group>", "<As on Date>", "<Mobile Number>", "<Height>", "<Weight>", "<Father Name>", "<Father Phone>", "<Father Occupation>", "<Mother Name>", "<Mother Phone>", "<Mother Occupation>", "<Guardian Email>", "<Guardian Address>"
    And uploads family member photos
    And clicks the Add More Details button
    And adds Student Address Details
    And adds Miscellaneous Details "<Bank Account Number>", "<Bank Name>", "<IFSC Code>", "<National Identification Number>", "<Local Identification Number>", "<Previous School Details>", "<Note>"
    And uploads documents "<Title 1>", "<Title 2>", "<Title 3>", "<Title 4>"
    And clicks save
    Then the user should see "The Admission No field must contain a unique value."
    Then navigate to test student "<Class>", "<Section>", "<Admission No>"
    And delete test account with "<Admission No>"
    And delete test sibling account with admission number "112358132134"
    And delete the test category

    Examples:
      | Admission No | Roll Number | Class | Section               | First Name | Last Name | Gender | Date of Birth | Category | Email                        | Admission Date | Blood Group | As on Date | Mobile Number | Height | Weight | Father Name    | Father Phone | Father Occupation | Mother Name    | Mother Phone | Mother Occupation | Guardian Email     | Guardian Address | Bank Account Number | Bank Name | IFSC Code | National Identification Number | Local Identification Number | Previous School Details                 | Note                                | Title 1 | Title 2 | Title 3 | Title 4     |
      | 1260225082   | 237333333   | SDET  | Cucumber Fundamentals | Winston    | Sir       | Male   | 07/19/2010    | Selenium | shardey_uchidae@hawaiian.fpl | 05/22/1985     | O+          | 02/16/2014 | 1003770370    | 144 cm | 44 kg  | Lewis Hamilton | 1000440440   | F1 Driver         | Logan Browning | 1000420421   | Actress           | lewis.ham@f1.email | 120 Frank Street | 31425451            | Progress  | 2234202   | 81314296                       | 134323422                   | Berger St 2321, Duston, Alabama, 812349 | Computers earnings jerry cigarette. | Brother | Sister  | Dog     | Grandmother |