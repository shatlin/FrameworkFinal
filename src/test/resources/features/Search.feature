@smokes
Feature: Search

      Scenario: Successful search

      Scenario Outline: Successful search Scenarios
      Given i am a user accessing the home page
      When I perform search with "<SearchString>"
      Then I should see <ResultCountExpected> number of results

        Examples:

         |SearchString|ResultCountExpected|
         |Blouse|1|

  Scenario Outline: Successful search With Repeated Search
    Given i am a user accessing the home page
    When I perform repeated search with "<SearchString>" and "<ResultCountExpected>"
    Then I should see expected number of results

    Examples:

      |SearchString|ResultCountExpected|
      |Blouse,Dress,T-Shirt|1,7,1|


