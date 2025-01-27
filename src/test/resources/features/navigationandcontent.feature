Feature: Navigation and Access to Health Programs
 
Scenario: Navigate to a program and verify content
Given I am on West Florida AHEC Website homepage
When I click on the "<MenuProgram>"
And I select "<Program>" program
Then I should be navigated to the "<ProgramPage>" programspage
And I should see the page title as "<ProgramPageTitle>"
And I should see content related to the program

Examples: 
|	MenuProgram  | Program          | ProgramPage                                | ProgramPageTitle 																			        |
|	PROGRAMS		 | Tobacco          | https://westfloridaahec.org/tobacco/       | Tobacco - West Florida Area Health Education Center, Inc       |
| PROGRAMS     | AHEC Scholars    | https://westfloridaahec.org/ahec-scholars/ | AHEC Scholars - West Florida Area Health Education Center, Inc |
| PROGRAMS     | Healthy Aging    | https://westfloridaahec.org/healthy-aging/ | Healthy Aging - West Florida Area Health Education Center, Inc |
| PROGRAMS     | Covering Florida | https://westfloridaahec.org/navigators/    | Navigators - West Florida Area Health Education Center, Inc    |