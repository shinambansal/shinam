Feature: Login into Application

Scenario: Validate Login into Application
    Given Initialize the browser with Chrome
    When Navigate to "http://newtours.demoaut.com/" Site
    And User enters user "mercury" and password "mercury"
    Then User Logged in "True"


@LoginMercury
Scenario Outline: Validate Login into Application
    Given Initialize the browser with Chrome
    When Navigate to "http://newtours.demoaut.com/" Site
    And User enters user <username> and password <password>
    Then User Logged in <flag>
    And Close Browser
    |one1|one2|
    |two1|two2|
Examples:
	|username	|password	|flag	|
	|mercury	|mercury	|True	|
	|mercurys	|123		|False	|
#
##TASKKILL /IM chromedriver.exe /F