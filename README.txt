
Assumptions:
The idea of this challenge is to create a small UI test automation suite, for a popular website
(www.IMDb.com), using a tool/standard of your choice (preferably Selenium, or equivalent).


The tests should confirm:
1. The Top 250 ( http://www.pageobjects.imdb.com/chart/top ) page returns at least 1 movie , in the list.
2. The previous should be true, for each of the sorting options :
3. The previous should also be true, when navigating to the Western genre:


Considerations:
When designing your tests, please have in mind the test suite may easily grow to 100’s of them.
Easy addition, debugging and maintenance should be taken into account.

-------- My comments on this task:
I have taken some assumptions.
#1. Selenium will be used to do this taks.
#2. I will use JUnit for couple of reasons.
    - when started I searched for simplification and focused on other aspects, I considered Cucumber but this will require
        more time to work on this to migrate
    - I think that Cucumber will do same actions but wrapped around Given/When/Then steps + some overhead but will be
        harder to check for you
    - if we have hundreds of tests I would go with JUnit as first step and then consider Cucumber.
#3. Maven is used.
#4. Log4j is used.

Below some comments on my implementation.

I've done web driver factory, capabilities factory and some helpers to simiplify initiation of web driver and make it
easier to switch when needed in test suite. I'm sure that web driver switching might be plugged in to maven profiles to
nicely change it when testing. I also need two exec files for Firefox and Chrome to launch it on my computer so I've
added also system properties handler to wire both when starting test suite.

I've introduced Page Object Design Pattern, so if you look into test cases - there are no direct actions on WebDriver.
The implementation hides it and you call methods only on page objects. The main page is ImdbPage which is the first one
mentioned. WesternGenreImdbPage is generated from ImdbPage just as you navigate with browser. This is the best pattern
to make it maintainable. As you can see there small hierarchy of page object classes on top which is AbstractPage object
which contains all common page actions that are possible. It might be extended and page object hierarchy might be also
growing when needed.

When it comes to navigation and Selenium web elements searching I've used xPath. As you can see it is defined in special
xPathMap and might be retrieved from it. This is a point to improve - I mean probably getting wired with Spring beans where
those map values can be stored. XPath values are generated from designer inspector from Chrome - probably might be improved
to make tests more stable when page content will be changed in future - I didn't focus on that since the page structure
is complicated.

Logging. There is initiation of WebDriver logging in DriverFactory. This logging is on DEBUG level now and shows a lot about
what driver is doing. I've also done log4j on AbstractPage (to show example how it might look like) so if you launch it
it is visible both from driver and classes.

Structure of tests was separated from test tools where are all classes needed for setup and so on. One test file contains
set of tests for one page. It initiates the driver independently from other. It might be extended with test on the same
page. Packages can be used to structure pages from different domains.

NOTE: If you go through code - there are comments to highlight some points.