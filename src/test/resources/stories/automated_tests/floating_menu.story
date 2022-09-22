Meta:
@floatingMenu

Scenario: Floating Menu
Meta:
@floatingMenu
Given the user is in home page
When the user navigate to 'floating_menu'
And the user scroll to bottom of page
Then floating menu should still be displayed