@smoke
Feature: Create Account

      Scenario: Creating new user Account
      Given i am a user accessing the home page
      When I click on Sign-in link
        Then I should see authentication page
      When I enter email address and click Create Account
        |shatlin4@gmail.com|
        Then system should display create Account Page
      Then I populate all user fields and Register
        |Title|FirstName|LastName|Password|DateOfBirth |MonthOfBirth| YearOfBirth|NewLetterCheckbox|SpecialOfferCheckbox|Company|Address1| Address2|City|State|Zip|Additional Information|HomePhone|MobilePhone|Alias|
        |Mr.|Shatlin|Denistan|dia123sh34|8|June|1977|Sign up for our newsletter!|Receive special offers from our partners!|Home|93 Mile Downe, French Lane| Morningside|Sandton|Florida|23213|No Additional Information|0743760123|0743760124|HomeAddress|






