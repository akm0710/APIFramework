Feature:Validate place API
Scenario Outline: Verify add Place API is working fine
Given Add Place API payload with "<language>" "<address>"
When User calls "addPlaceAPI" with "POST" HTTP request
Then API is Success with status code 200
And "status" in Response body is "OK"

Example:
|language	|address|
|English	|BAM|
|Odia		|BBSR|
|Hindi		|Pune|
|Kanada|Bengaluru|
Extra Added in GitHub Master
Change by Ashish