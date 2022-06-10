Feature: SignUp to AzureWebsites

Scenario Outline: SignUp
Given User is on SignUp Page
When User clicks on ChooseLanguage DropDown
Then Validate Available Languages
When "<FullName>" & "<OrganizationName>" & "<EmailID>" is Entered
Then SignUp should be successful

Examples:
| FullName | OrganizationName | EmailID |
| Ashvin Parmar | Ashvin Parmar | parmar.ashvin@gmail.com |

