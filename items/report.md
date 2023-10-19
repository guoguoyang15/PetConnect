# G21 Report

The following is a report template to help your team successfully provide all the details necessary for your report in a structured and organised manner. Please give a straightforward and concise report that best demonstrates your project. Note that a good report will give a better impression of your project to the reviewers.

Note that you should have removed ALL TEMPLATE/INSTRUCTION textes in your submission (like the current sentence), otherwise it hampers the professionality in your documentation.

*Here are some tips to write a good report:*

* `Bullet points` are allowed and strongly encouraged for this report. Try to summarise and list the highlights of your project (rather than give long paragraphs).*

* *Try to create `diagrams` for parts that could greatly benefit from it.*

* *Try to make your report `well structured`, which is easier for the reviewers to capture the necessary information.*

*We give instructions enclosed in square brackets [...] and examples for each sections to demonstrate what are expected for your project report. Note that they only provide part of the skeleton and your description should be more content-rich. Quick references about markdown by [CommonMark](https://commonmark.org/help/)*

## Table of Contents

1. [Team Members and Roles](#team-members-and-roles)
2. [Summary of Individual Contributions](#summary-of-individual-contributions)
3. [Application Description](#application-description)
4. [Application UML](#application-uml)
5. [Application Design and Decisions](#application-design-and-decisions)
6. [Summary of Known Errors and Bugs](#summary-of-known-errors-and-bugs)
7. [Testing Summary](#testing-summary)
8. [Implemented Features](#implemented-features)
9. [Team Meetings](#team-meetings)
10. [Conflict Resolution Protocol](#conflict-resolution-protocol)

## Administrative
- Firebase Repository Link: <insert-link-to-firebase-repository>
   - Confirm: I have already added comp21006442@gmail.com as a Developer to the Firebase project prior to due date.
- Two user accounts for markers' access are usable on the app's APK (do not change the username and password unless there are exceptional circumstances. Note that they are not real e-mail addresses in use):
   - Username: comp2100@anu.edu.au	Password: comp2100
   - Username: comp6442@anu.edu.au	Password: comp6442

## Team Members and Roles
The key area(s) of responsibilities for each member

| UID      | Name          | Role           |
|:---------|:--------------|:---------------|
| u7605165 | Hexuan Meng   | Algorithm      |
| u7568823 | Fan Yue       | Design Pattern |
| u7758372 | Jiasheng Li   | Android        |
| u7580614 | Zhining Zhang | Front End      |


## Summary of Individual Contributions

Specific details of individual contribution of each member to the project.

Each team member is responsible for writing **their own subsection**.

A generic summary will not be acceptable and may result in a significant lose of marks.

*[Summarise the contributions made by each member to the project, e.g. code implementation, code design, UI design, report writing, etc.]*

*[Code Implementation. Which features did you implement? Which classes or methods was each member involved in? Provide an approximate proportion in pecentage of the contribution of each member to the whole code implementation, e.g. 30%.]*

*you should ALSO provide links to the specified classes and/or functions*
Note that the core criteria of contribution is based on `code contribution` (the technical developing of the App).

*Here is an example: (Note that you should remove the entire section (e.g. "others") if it is not applicable)*

1. **UID1, Name1**  I have 30% contribution, as follows: <br>
  - **Code Contribution in the final App**
    - Feature A1, A2, A3 - class Dummy: [Dummy.java](https://gitlab.cecs.anu.edu.au/comp2100/group-project/ga-23s2/-/blob/main/items/media/_examples/Dummy.java)
    - XYZ Design Pattern -  class AnotherClass: [functionOne()](https://gitlab.cecs.anu.edu.au/comp2100/group-project/ga-23s2/-/blob/main/items/media/_examples/Dummy.java#L22-43), [function2()](the-URL)
    - ... (any other contribution in the code, including UI and data files) ... [Student class](../src/path/to/class/Student.java), ..., etc.*, [LanguageTranslator class](../src/path/to/class/LanguageTranslator.java): function1(), function2(), ... <br><br>

  - **Code and App Design** 
    - [What design patterns, data structures, did the involved member propose?]*
    - [UI Design. Specify what design did the involved member propose? What tools were used for the design?]* <br><br>

  - **Others**: (only if significant and significantly different from an "average contribution") 
    - [Report Writing?] [Slides preparation?]*
    - [You are welcome to provide anything that you consider as a contribution to the project or team.] e.g., APK, setups, firebase* <br><br>

2. **UID2, Name2**  I have xx% contribution, as follows: <br>
  - ...



## Application Description

*[What is your application, what does it do? Include photos or diagrams if necessary]*

*Here is a pet specific application example*

*PetBook is a social media application specifically targetting pet owners... it provides... certified practitioners, such as veterians are indicated by a label next to their profile...*

### Application Use Cases and or Examples

*[Provide use cases and examples of people using your application. Who are the target users of your application? How do the users use your application?]*

*Here is a pet training application example*

*Molly wants to inquiry about her cat, McPurr's recent troublesome behaviour*
1. *Molly notices that McPurr has been hostile since...*
2. *She makes a post about... with the tag...*
3. *Lachlan, a vet, writes a reply to Molly's post...*
4. ...
5. *Molly gives Lachlan's reply a 'tick' response*

*Here is a map navigation application example*

*Targets Users: Drivers*

* *Users can use it to navigate in order to reach the destinations.*
* *Users can learn the traffic conditions*
* ...

*Target Users: Those who want to find some good restaurants*

* *Users can find nearby restaurants and the application can give recommendations*
* ...

*List all the use cases in text descriptions or create use case diagrams. Please refer to https://www.visual-paradigm.com/guide/uml-unified-modeling-language/what-is-use-case-diagram/ for use case diagram.*

<hr> 

### Application UML
#### UML Class diagram of the whole application
![UML Class diagram of the whole application](UML_diagrams/MainActivity_structure.svg) <br>
#### UML Class diagram of Login and Sign up process
![UML Class diagram of Login and Sign up process](UML_diagrams/LoginActivity_structure.svg) <br>
#### UML Class diagram of AVL Tree implementation
![UML Class diagram of AVL Tree implementation](UML_diagrams/AVLTree_structure.svg) <br>

<hr>

## Code Design and Decisions

This is an important section of your report and should include all technical decisions made. Well-written justifications will increase your marks for both the report as well as for the relevant parts (e.g., data structure). This includes, for example,

- Details about the parser (describe the formal grammar and language used)

- Decisions made (e.g., explain why you chose one or another data structure, why you used a specific data model, etc.)

- Details about the design patterns used (where in the code, justification of the choice, etc)

*Please give clear and concise descriptions for each subsections of this part. It would be better to list all the concrete items for each subsection and give no more than `5` concise, crucial reasons of your design.

<hr>

### Data Structures

*[What data structures did your team utilise? Where and why?]*

Here is a partial (short) example for the subsection `Data Structures`:*

*I used the following data structures in my project:*

1. *LinkedList*
   * *Objective: used for storing xxxx for xxx feature.*
   * *Code Locations: defined in [Class X, methods Z, Y](https://gitlab.cecs.anu.edu.au/comp2100/group-project/ga-23s2/-/blob/main/items/media/_examples/Dummy.java#L22-43) and [class AnotherClass, lines l1-l2](url); processed using [dataStructureHandlerMethod](url) and ...
   * *Reasons:*
      * *It is more efficient than Arraylist for insertion with a time complexity O(1)*
      * *We don't need to access the item by index for xxx feature because...*
      * For the (part), the data ... (characteristics) ...

2. ...

3. ...

<hr>

### Design Patterns
*[What design patterns did your team utilise? Where and why?]*

1. *xxx Pattern*
   * *Objective: used for storing xxxx for xxx feature.*
   * *Code Locations: defined in [Class X, methods Z, Y](https://gitlab.cecs.anu.edu.au/comp2100/group-project/ga-23s2/-/blob/main/items/media/_examples/Dummy.java#L22-43) and [class AnotherClass, lines l1-l2](url); processed using [dataStructureHandlerMethod](url) and ...
   * *Reasons:*
      * ...

<hr>

### Parser

### <u>Grammar(s)</u>
*[How do you design the grammar? What are the advantages of your designs?]*
*If there are several grammars, list them all under this section and what they relate to.*

Production Rules:

    <Non-Terminal> ::= <some output>
    <Non-Terminal> ::= <some output>


### <u>Tokenizers and Parsers</u>

*[Where do you use tokenisers and parsers? How are they built? What are the advantages of the designs?]*

<hr>

### Others

*[What other design decisions have you made which you feel are relevant? Feel free to separate these into their own subheadings.]*

<br>
<hr>

## Implemented Features

### Basic Features
1. [LogIn]. Users must be able to log in (not necessarily sign up). (easy)
   * Important: You must include the following two accounts for markers' access to your App:
     * Username: comp2100@anu.edu.au&emsp;Password: comp2100
     * Username: comp6442@anu.edu.au&emsp;Password: comp6442
   * Code: [Class LoginActivity, method login](https://gitlab.cecs.anu.edu.au/u7758372/ga-23s2/-/blob/main/MyApplication/app/src/main/java/com/example/myapplication/LoginActivity.java#L57-100) and [method register](https://gitlab.cecs.anu.edu.au/u7758372/ga-23s2/-/blob/main/MyApplication/app/src/main/java/com/example/myapplication/LoginActivity.java#L102-134)
   * Description of your implementation:
     * User will log in by:
         1. Firebase Authentication if network is available,
         2. Local user information if (a) fails, by method [LocalCheckUserLoginInfo](https://gitlab.cecs.anu.edu.au/u7758372/ga-23s2/-/blob/main/MyApplication/app/src/main/java/com/example/myapplication/LoginActivity.java#L136-148).
     * And this method will check if:
         1. Input is empty,
         2. Input is in right format, by method [CheckComplianceOfUserData](https://gitlab.cecs.anu.edu.au/u7758372/ga-23s2/-/blob/main/MyApplication/app/src/main/java/com/example/myapplication/LoginActivity.java#L150-159).
     * And will display the corresponding result messages by Toast if login fails.

2. [DataFiles]. Description  ... ... (...)
   * Code to the Data File [users_interaction.json](link-to-file), [search-queries.xml](link-to-file), ...
   * Link to the Firebase repo: ...

3. [LoadShowData]. When a user is logged in, load data (from the file(s) and/or Firebase) at regular time intervals,
   and visualise the same in the App. <br> (e.g., If the main page contains a list of featured products, the user may see
   an increased number of products; <br> as well as receive notifications from interactions simulated from the data
   stream). (medium)
   * Code: [Class MainActivity, method loadShowData](https://gitlab.cecs.anu.edu.au/u7758372/ga-23s2/-/blob/main/MyApplication/app/src/main/java/com/example/myapplication/MainActivity.java#L89-109)
   * Description of your implementation:
     * The application will load data and show:
       1. All the data if user doesn't input a query in SearchActivity,
       2. Search result if user inputs a query in SearchActivity.

4. [Search]. Users must be able to search for information on your app. (medium)<br>
   The application is dependent on your app theme. E.g., search for information of products, users, by certain
   criteria (e.g. #apple $1-2).
   * Code: [Class X, methods Z, Y](https://gitlab.cecs.anu.edu.au/comp2100/group-project/ga-23s2/-/blob/main/items/media/_examples/Dummy.java#L22-43) and Class Y, ...
   * Description of feature: ... <br>
   * Description of your implementation: ... <br>

### Custom Features
Feature Category: Search-related features <br>
1. [Search-Invalid]. On top of giving search results from valid inputs, search functionality can process and <br>
correctly handle partially invalid search queries and give meaningful results. (medium)
   * Code: [Class X, methods Z, Y](https://gitlab.cecs.anu.edu.au/comp2100/group-project/ga-23s2/-/blob/main/items/media/_examples/Dummy.java#L22-43) and Class Y, ...
   * Description of your implementation: ...

2. [Search-Filter]. Sort and filter a list of items returned from searches, with the use of suitable UI components. (easy)
   * Code: [Class X, entire file](https://gitlab.cecs.anu.edu.au/comp2100/group-project/ga-23s2/-/blob/main/items/media/_examples/Dummy.java#L22-43) and Class Y, ...
   * Description of your implementation: ...

<br><br>
Feature Category: UI Design and Testing <br>
1. [UI-Layout]. Incorporate suitable layout adjustments in the UI components for portrait and landscape layout variants, as well as different screen sizes. (easy)
   * Code: [Class X, entire file](https://gitlab.cecs.anu.edu.au/comp2100/group-project/ga-23s2/-/blob/main/items/media/_examples/Dummy.java#L22-43) and Class Y, ...
   * [Class B](../src/path/to/class/file.java#L30-85): methods A, B, C, lines of code: 30 to 85
   * Description of your implementation: ...

<br><br>
Feature Category: Greater Data Usage, Handling and Sophistication <br>
1. [Data-Formats]. Read data from local files in at least 2 different formats (JSON, XML, etc.). (easy)
    * Code: [Class X, entire file](https://gitlab.cecs.anu.edu.au/comp2100/group-project/ga-23s2/-/blob/main/items/media/_examples/Dummy.java#L22-43) and Class Y, ...
    * [Class B](../src/path/to/class/file.java#L30-85): methods A, B, C, lines of code: 30 to 85
    * Description of your implementation: ...

<br><br>
Feature Category: Firebase Integration <br>
1. [FB-Auth]. Use Firebase to implement User Authentication/Authorisation. (easy)
    * Code: [Class LoginActivity, method login](https://gitlab.cecs.anu.edu.au/u7758372/ga-23s2/-/blob/main/MyApplication/app/src/main/java/com/example/myapplication/LoginActivity.java#L57-100) and [method register](https://gitlab.cecs.anu.edu.au/u7758372/ga-23s2/-/blob/main/MyApplication/app/src/main/java/com/example/myapplication/LoginActivity.java#L102-134)
    * Description of your implementation:
      * User will log in or sign up by Firebase Authentication if network is available,
      * And will display the corresponding result messages by Toast if login or sign up fails.

2. [FB-Persist]. Use Firebase to persist all data used in your app. (medium)
   * Code: [Class MainActivity, method updateDataFromFirebase](https://gitlab.cecs.anu.edu.au/u7758372/ga-23s2/-/blob/main/MyApplication/app/src/main/java/com/example/myapplication/MainActivity.java#L144-167)
   * Description of your implementation:
     * Method to fetch latest data from Firebase when network is available,
     * Load local data instead when it's fetching because this task is asynchronous,
     * So once it's done, it will update the data loaded by application.
<hr>

### Surprised Features

1. How to rank the items returned for a given search (a ranking algorithm);
   * Code: [Class AVLTree, method insert](https://gitlab.cecs.anu.edu.au/u7758372/ga-23s2/-/blob/main/MyApplication/app/src/main/java/com/example/myapplication/AVLTree/AVLTree.java#L35-67) and [Class Pet, method compareTo](https://gitlab.cecs.anu.edu.au/u7758372/ga-23s2/-/blob/main/MyApplication/app/src/main/java/com/example/myapplication/Pet.java#L49-52)
   * Explanations on solution:
       * All search results will be ranked depends on the cost of pets in our project, from low to high,
       * Because our application aims to 

2. Log previous searches and user information to improve search results;
   * Code: [Class SearchActivity, method onActivityResult](https://gitlab.cecs.anu.edu.au/u7758372/ga-23s2/-/blob/main/MyApplication/app/src/main/java/com/example/myapplication/SearchActivity.java#L85-120) and [Class MainActivity, method onBackPressed](https://gitlab.cecs.anu.edu.au/u7758372/ga-23s2/-/blob/main/MyApplication/app/src/main/java/com/example/myapplication/MainActivity.java#L169-183)
   * Explanations on solution:
     * Because of Android logic, information will lose in transferring between activities, especially returning from the next activity,
     * In our project, the query may not be updated in SearchActivity if users keep searching in MainActivity,
     * Thus, we want to return the last query from MainActivity to SearchActivity to maintain smooth user experiences.

3. A strategy for showing ads (promoted items);
   * Explanations on solution:
     * We have decided not to show ads at present for the following reasons:
       1. Showing ads early in the app's launching can give users a bad first impression.
       2. An application showing ads early in it launching is generally regarded as an **Adware**.
       3. As our application is for charity, we don't exploit poor displaced animals for profit.
     * However, if we are unable to keep running in the future, we may consider including a small amount of ads.

4. A new strategy for visualising the traditional list of results.
   * Not implemented.

- If implemented, explain how your solution addresses the task (any detail requirements will be released with the surprised feature specifications).
- State that "Surprised feature is not implemented" otherwise.

<br> <hr>

## Summary of Known Errors and Bugs

*[Where are the known errors and bugs? What consequences might they lead to?]*
*List all the known errors and bugs here. If we find bugs/errors that your team does not know of, it shows that your testing is not thorough.*

*Here is an example:*

1. *Bug 1:*
   - *A space bar (' ') in the sign in email will crash the application.*
   - ...

2. *Bug 2:*
3. ...

<br> <hr>


## Testing Summary

*[What features have you tested? What is your testing coverage?]*
*Please provide some screenshots of your testing summary, showing the achieved testing coverage. Feel free to provide further details on your tests.*

*Here is an example:*

1. Tests for Search
   - Code: [TokenizerTest Class, entire file](https://gitlab.cecs.anu.edu.au/comp2100/group-project/ga-23s2/-/blob/main/items/media/_examples/Dummy.java) for the [Tokenizer Class, entire file](https://gitlab.cecs.anu.edu.au/comp2100/group-project/ga-23s2/-/blob/main/items/media/_examples/Dummy.java#L22-43)
   - *Number of test cases: ...*
   - *Code coverage: ...*
   - *Types of tests created and descriptions: ...*

2. xxx

...

<br> <hr>


## Team Management

### Meetings Records
* Link to the minutes of your meetings like above. There must be at least 4 team meetings.
  (each commited within 2 days aftre the meeting)
* Your meetings should also have a reasonable date spanning across Week 6 to 11.*


- *[Team Meeting 1](meeting1.md)*
- ...
- ...
- [Team Meeting 4](link_to_md_file.md)
- ... (Add any descriptions if needed) ...

<hr>

### Conflict Resolution Protocol
1. **Open Communication**:
- Encourage open and honest communication within the team. Team members should feel comfortable expressing concerns, ideas, and feedback.

2. **Define Clear Roles and Responsibilities**:
- Ensure that each team member understands their role and responsibilities. Clear job descriptions can help prevent conflicts arising from misunderstandings about who should do what.

3. **Regular Meetings**:
- Hold regular team meetings to discuss progress, challenges, and potential conflicts. These meetings can be daily stand-ups, weekly check-ins, or as needed.

4. **Documentation**:
- Keep thorough documentation of project requirements, design decisions, and coding standards. This documentation serves as a reference point to resolve disputes based on facts.

5. **Issue Tracking**:
- Use project management tools like JIRA, Trello, or Asana to track issues and feature requests. Ensure that every concern or feature request is documented, assigned, and tracked.

6. **Peer Review**:
- Implement a peer review process for code, design, and other project elements. Peer reviews can catch issues early and improve overall quality.

7. **Mediation**:
- Designate a mediator or team lead responsible for conflict resolution. When conflicts arise, team members can approach the mediator for assistance.

8. **Private Discussions**:
- When conflicts occur, encourage team members to have private, one-on-one discussions before involving the entire team. Often, issues can be resolved at this level.

9. **Conflict Resolution Meeting**:
- If a conflict persists, schedule a dedicated conflict resolution meeting. During this meeting:
    - Identify the root cause of the conflict.
    - Listen to all parties involved.
    - Brainstorm potential solutions.
    - Collaboratively agree on a resolution plan.
    - Assign responsibilities and set deadlines for implementing the solution.

10. **Escalation**:
- Define a clear escalation process for conflicts that cannot be resolved within the team. This might involve involving higher-level management or stakeholders.

11. **Follow-Up**:
- After implementing a resolution, follow up to ensure that the conflict has been resolved satisfactorily. Make adjustments if necessary.

12. **Learn and Improve**:
- After conflicts are resolved, conduct a post-mortem or lessons learned session to identify ways to prevent similar conflicts in the future.

13. **Positive Team Culture**:
- Foster a positive team culture that values collaboration, respect, and diversity of thought. A healthy team culture can preempt many conflicts.

14. **Training and Development**:
- Invest in training and professional development opportunities for team members to improve their skills and reduce conflicts stemming from knowledge gaps.

15. **Conflict Prevention**:
- Whenever possible, focus on preventing conflicts by establishing clear processes, standards, and expectations from the outset of the project.
