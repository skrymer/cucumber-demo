# cucumber-demo

## Run the tests

run ./gradlew from command line
 
using selenium hub:
 
`gradle cucumber -Dcucumber.tags='@some_tag' -Dcucumber.browser='remote_chrome' -Dcucumber.remote.url='http://someurl:4444'` 