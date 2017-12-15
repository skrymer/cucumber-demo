# cucumber-demo

## Run the tests

### Using IDE 
use RunCukesTest to run tests in your IDE - uses a JunitRunner 

### Using gradle

run ./gradlew cucumber from command line
 
using selenium hub:
 
`gradle cucumber -Dcucumber.tags='@some_tag' -Dcucumber.browser='remote_chrome' -Dcucumber.remote.url='http://someurl:4444'` 