Feature: User Update Personal Information

@SmokeTest
Scenario: User Update Personal details on portal
Given User is on My Store page
When User sign into account
And User Click on my personal information on My Account page
And User Enter details in key and value and save them
		|First name     | Amit |
		|Lastname       | singh|
		|Oldpassword    |123456|
		|Newpassword    |123456|
		|Confirmpassword|123456|
Then User verify details are saved
