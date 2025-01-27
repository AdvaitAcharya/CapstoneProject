Feature: Form Submission

Scenario: Submit a form with valid information and successfully.
 Given I am on West Florida AHEC Website homepage
 When I click on "<MenuProgram>" menu
 And I select "<ProgramHealthyAging>" program page
 And I am navigated to "<ProgramPageOfHealthyAging>" program page
 And I fill in the "First" field with "Advait" inputdata
 And I fill in the "Last" field with "Acharya" inputdata 
 And I fill in the "Phone" field with "(123) 456-7890" inputdata
 And I fill in the "Email" field with "acharyaadvait11@gmail.com" inputdata
 And I select the "Which program are you interested in? (Check all that apply)" option "Tai Chi for Arthritis"
 And I select the "Which county do you live in?" option "Escambia"
 And I select the "Which class format do you prefer?" option "Virtual"
 And I select the "I am best described as:" option "cog-6-option-An individual looking to take classes wherever they may be available in my county"
 And I fill in the "Please help us by telling us how/​where you heard about us:" field with "Internet" inputdata
 And I select the "I would like to be notified by email when classes are available in my area" option "I would like to be notified by email when classes are available in my area"
 And I submit the form
 Then I should see the success message "Thank you for filling out the form. Your response has been recorded."


Examples: 
|	MenuProgram  | ProgramHealthyAging   | ProgramPageOfHealthyAging                  |
| PROGRAMS     | Healthy Aging         | https://westfloridaahec.org/healthy-aging/ |