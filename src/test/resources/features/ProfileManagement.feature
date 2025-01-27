Feature: Profile Management

Scenario: Password Recovery

Given I am on West Florida AHEC Website homepage
When I click on "<MyAccount>" page
And I am navigated to the "<MyAccountPage>" page
And I click on "Lost your password?"
And I am navigated to the "<lost-password>" reset page
And I fill in the "<Username_or_Email>" field with "advait_acharya"
And I click on Reset password
Then I should see "Password reset email has been sent." message on the page