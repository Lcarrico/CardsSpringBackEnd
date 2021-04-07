# RevaCards

## User stories
|As a(n) | I want to | So that |
|--------|-----------|---------|
Anon Learner|Create an account|I can save my cards and stacks
Reg Learner|Create a card|I can memorize something
Reg Learner|Create a stack of cards|I can have my cards categorized
Reg Learner|Update card|I can correct my typos/mistakes
Reg Learner|Update stack of cards|I can fix the subject name or add new related subjects
Reg Learner|Delete card|I can erase my embarrassing card names
Reg Learner|Delete stack of cards|I can get rid of the weird stacks I made...
Reg Learner|Fork Cards|I can steal soneone else's card and add it to my stack
Reg Learner|Fork Stack of cards	|I can use someone else's stack and modify it
Reg Learner|Search by Tags|I can to be able to learn from flashcards of a specific subject
Reg Learner|Add Tag to Card|I can add different subjects to my cards and make them easily found by other learners

## Endpoints
|Request Description|Request Verb|URI|
|-------------------|------------|---|
Stack Links|
Get all Stack Links|Get|	/stackLinks
Get Stack Link By Id|Get|	/stackLinks/{stackLinkId}
Get Stack Links By Learner Id	|Get|	/stackLinks?learnerId=learnerId
Get Stack Links By Relationship	|Get|	/stackLinks?relationship=relationship
Create Stack Link	|Post|	/stackLinks
Update Stack Link	|Put|	/stackLinks/{stackLinkId}
Remove Stack Link	|Del|	/stackLinks/{stackLinkId}
Learners|
Get all Learners	|Get|	/learners
Get Learner By Id	|Get|	/learners/{learnerId}
Get Learner By Username	|Get|	/learners?username=learnerName
Create Learner	|Post|	/learners
Update Learner	|Put|	/learners/{learnerId}
Remove Learner	|Del|	/learners/{learnerId}
Stacks|
Get All Stacks	|Get|	/stacks
Get Stack By Id	|Get|	/stacks/{stackId}
Get Stack By Stack Name|Get|	/stacks?stackName=stackName
Get Stack By Stack Description	|Get|	/stacks?stackDescription=stackDescription
Create Stack	|Post|	/stacks
Update Stack	|Put|	/stacks/{stackId}
Remove Stack	|Del|	/stacks/{stackId}
Cards|
Get All Cards	|Get|	/cards
Get Card By Id	|Get|	/cards/{cardId}
Create Card	|Post|	/cards
Update Card	|Put|	/cards/{cardId}
Remove Card	|Del|	/cards/{cardId}
Topics|		
Get All Topics	|Get|	/topics
Get Topic By Id	|Get|	/topics/{topicId}
Get Topic By Name	|Get|	/topics?topicName=topicName
Create Topic	|Post|	/topics
Update Topic	|Put|	/topics/{topicId}
Remove Topic	|Del|	/topics/{topicId}
Tags|
Get All Tags	|Get|	/tags
Get Tag By Id	|Get|	/tags/{tagId}
Get Tag By Name	|Get|	/tags?tagName=tagName
Create Tag	|Post|	/tags
Update Tag	|Put|	/tags/{tagId}
Remove Tag	|Del|	/tags/{tagId}
Login|
Get JWT By User and Password	|Post|	/login
Topic Links|
Get All Topic Links	|Get|	/topicLinks
Get Topic Link By Id	|Get|	/topicLinks/{topicLinkId}
Get Topic Links By Topic Id	|Get|	/topicLinks?topicId=topicId
Get Topic Links By Stack Id	|Get|	/topicLinks?stackId=stackId
Create Topic Link	|Post|	/topicLinks
Update Topic Link	|Put|	/topicLinks/{topicLinkId}
Remove Topic Link	|Del|	/topicLinks/{topicLinkId}
Tag Links|
Get All Tag Links	|Get|	/tagLinks
Get Tag Link By Id	|Get|	/tagLinks/{tagLinkId}
Get Tag Links By Tag Id|Get|	/tagLinks?tagId=tagId
Get Tag Links By Card Id	|Get|	/tagLinks?cardId=cardId
Create Tag Link	|Post|	/tagLinks
Update Tag Link	|Put|	/tagLinks/{tagLinkId}
Remove Tag Link	|Del|	/tagLinks/{tagLinkId}
Card Links|
Get all Card Links	|Get|	/cardLinks
Get Card Link By Id	|Get|	/cardLinks/{cardLinkId}
Get Card Link By Card Id	|Get|	/cardLinks?cardId=cardId
Get Card Links By Stack Id	|Get|	/cardLinks?stackId=stackId
Create Card Link	|Post|	/cardLinks
Update Card Link	|Put|	/cardLinks/{cardLinkId}
Remove Card Link	|Del|	/cardLinks/{cardLinkId}
