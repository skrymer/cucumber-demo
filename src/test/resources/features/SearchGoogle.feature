@smoke @wof
Feature: Search google

Scenario Outline:
  Given I navigate to the google home page
  When searching for '<q>'
  Then I should see '<text>' on the page

Examples:
  | q		| text			|
  | sonni	| awesome		|
  | google	| google    	|