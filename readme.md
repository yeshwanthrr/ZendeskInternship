# Zendesk Coding Challenge for Software Engineering Internship

This project performs a http connection to Zendesk API using Scala programing language and displays the tickets using Swings GUI.

# Prerequisites!

  - Scala(2.12.12)
  - SDK(1.3)
  - Oracle JDK(1.8)
  - Intellij Idea or any SBT supported IDE
  
### How to Run

- Execute the Build jar- ZendeskIntern
- To modify the code  
    - Download and extract the zip
    - Import the project to your IDE 
    - Install all dependencies
    - Run the main method

### Functionalities Implemented
- By default, the GUI shows 25 tickets per page
- Click Next to load the next 25 tickets
- Click Prev to move to previous page
- To view the individual ticket - enter the id and select search.



##Dependencies

```sh
libraryDependencies ++=  Seq(
  "org.scalaj" %% "scalaj-http" % "2.4.2",
  "com.typesafe.play" %% "play-json" % "2.7.3",
  "org.apache.commons" % "commons-lang3" % "3.9",
  "org.scalatest" %% "scalatest" % "3.0.8" % "test"
)
```






