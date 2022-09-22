Meta:
@contextMenu

Scenario: Verify Context Menu
Meta:
@contextMenu
Given the user is in home page
When the user navigate to 'context_menu'
Then 'You selected a context menu' text should be displayed on alert upon context click