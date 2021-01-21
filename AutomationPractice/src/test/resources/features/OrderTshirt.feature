Feature: User Order T-Shirt and verify in Order history

@SmokeTest
Scenario: User Order T-Shirt and verify in Order history
Given User is on My Store page
When User click on Tshirt and navigate to T-Shirts Page
And User Add T-shirt To cart 
Then User verify order History for T-Shirt