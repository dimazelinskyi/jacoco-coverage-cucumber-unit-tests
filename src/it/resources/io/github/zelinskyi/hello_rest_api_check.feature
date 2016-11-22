Feature: Test API github call

  Background:
    Given let variable "apiPath" equal to "/gherkin-and-jacoco-integration/hello"

  Scenario Outline: If a layout call is made with an incorrect brand/device, the api should return a 400.

    When the client performs GET request on {(apiPath)}
    Then status code is <status>

    Examples:
      | status |
      | 200    |