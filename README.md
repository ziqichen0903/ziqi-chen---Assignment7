# fancycalculator-ziqichen0903
fancycalculator-ziqichen0903 created by GitHub Classroom
Instructions
The workflow for this week’s assignment will be the same as the previous one: we will be writing code in our own individual repositories created by GitHub classroom. We will submit the assignment by pushing our changes to our GitHub repo, then submitting the Moodle assignment 7 with a link to our GitHub repo.
For instructions on setting up all the appropriate CASE tools for this workflow, see Assignment 6.
To find the GitHub classroom assignment for this week, go here.
Assignment
You’re a new hire at AtoZ corp. In your first sprint planning meeting with your new teammates, they assign you a few tickets for one of their products, Fancy Calculator. The tickets read:
Ticket 1. Defect: Equals sign causes exception message

Defect: The program emits an exception message with stack trace when the ‘equals’ button is pressed in some cases. First line of exception message: Exception in thread "AWT-EventQueue-0" java.lang.NumberFormatException: empty String


Steps to reproduce:
⦁	Start application.
⦁	Click equals sign

Desired Behavior: When the equals button is pressed (and no other buttons have been previously pressed), the calculator display should remain empty and no exception message should be printed to the console.

Ticket 2. Improvement: Add “random” button to calculator

We want to add a “random” button that, when pressed, will populate the display with a random double between 0 and 100. This value can then be used in further calculations.

To do this, we need to:
⦁	Extend Controller.calculateMono with the random number capability
⦁	Add a button in Display that is in the same row as Sin, Cos, Tan and to the right of Tan.
⦁	Hook up logic to the new button so the new random number method is called.

Your job is to complete these tickets over the next week.
Step 1: GitHub Issues
As a first step, you look at the repository on GitHub. You immediately see an issue: no README. You make a note that you’ll want to fix that later once you’re more familiar with this repo.
Your team writes down their tickets on sticky notes in the office. To track your tickets digitally, you create a GitHub issue for each one. 
To do this:
⦁	Click “Issues” (right next to code).
 
⦁	Click green “New Issue” button.
⦁	Give your issue a title and description (copy-pasting the above text is a fine way to go)
⦁	Click “Submit New Issue”
⦁	Now you see that your issue has been assigned a number:
 
Step 2: Spotless
Looking back at the GitHub repo home screen, you see more good/bad news. Good news: they’re using GitHub CI for this project to automatically run unit tests. This is a good practice that allows them to always know whether their codebase is passing all tests. Bad news: the tests are failing right now. You click through the GitHub CI to see where the failure is: spotless! You know how to fix this one.
Since other members of your team are working on their own tickets at the same time, you all use Github flow so that you don’t step on each other’s toes while making your changes. To make your spotless fix:
⦁	Clone the repository on to your local machine (if you haven’t already).
⦁	Open a terminal in the repo directory (if you use PyCharm, open the project then click “terminal” at the bottom of the window). 
⦁	Create a new branch to work on with the command `git checkout -b fix-spotless` to create a branch named “fix-spotless” and check it out. 
⦁	Now if you run `git status`, you’ll see that it says you are on the “fix-spotless” branch.
⦁	You can also run `git branch` to see the complete list of branches on your machine.
⦁	You know that you can run `gradlew :spotlessApply` to fix spotless issues, but why not fix them automatically every time you run `gradlew build`? To do this, you add the following block to the bottom of your build.gradle file:
afterEvaluate {
    tasks.getByName('spotlessCheck').dependsOn(tasks.getByName('spotlessApply'))
}
⦁	After adding this block of code, you run `gradlew build`. You know that this command will automatically format files using Spotless, so you run `git status` afterwards to see what changed. Use `git add …` to stage all changed files for commit, then commit them with `git commit –m “Spotless clean-up + fix spotless issues on build”
⦁	Now that you’ve completed this unit of work, you want to check it in by merging it back into the main branch in GitHub. To do this:
⦁	Run `git push`. This command will fail because you haven’t yet created this branch in GitHub. The error message tells you the command to run in order to make it happen. Run that command.
⦁	Now, go to GitHub in your web browser. You’ll likely see a pop-up message that invites you to make a Pull Request. Click it. If you don’t see the message, Click where it says “2 branches”, then click the “Create Pull Request” button next to your branch.
⦁	You can write a brief title and description for this change, then click the button to create the pull request. 
⦁	If you were working on a team for real, you would have team members review your PR and okay it. You can notify your teammates by simply leaving a comment with @ + their GitHub username (if you want feedback from me, you can write “@acontry” and it will ping me).
⦁	You should see the CI build progress along and eventually pass:
 
⦁	At this point, you can click the down arrow on the “Merge pull request” button and click “Squash and Merge”. This approach squashes all commits you make in this branch into a single commit, then merges it with the main branch.
⦁	You don’t need to save this working branch anymore, so you can optionally delete it through the new GitHub UI that appears.
⦁	At this point, you’ve merged your PR into the main branch! The final step is to update your local copy with the new changes. To do this:
⦁	Run `git checkout main` to check out the main branch.
⦁	Run `git pull` to pull the latest updates. You should see info about your most recent commit.
⦁	Optionally: delete your local feature branch with `git branch -d fix-spotless`
Step 3: Fix Defect Ticket
With your first PR merged, you have a handle for the workflow. You want to use that workflow now when working on your tickets: one branch for each ticket. Use a GitHub PR to merge your changes in. 
One extra thing when working on your tickets: In the PR title, start it with #1 (where #1 is the issue number that you are fixing). GitHub will automatically link it to the issue which is super handy. Once you’ve merged your PR for a ticket, feel free to close that GitHub issue to indicate that it is done.
Now you can get started on finding and fixing the defect. First, you want to reproduce the defect. To run the program and see the calculator UI, you can:
⦁	click the green “play” arrow in FancyCalculator class in IntelliJ
⦁	Run `gradlew build`, then ` java -jar build/libs/calculator-1.0-SNAPSHOT.jar `
After looking at the stack trace and examining the code, you should be able to find the source of the error. Once you’ve located and fixed it, verify your fix by repeating the defect reproduction steps.
Step 4: Improvement Ticket
To add this additional button, you’ll want to trace how an existing calculator operation works. A handy way to do this:
⦁	Start at the Calculator class and choose an operation.
⦁	In IntelliJ, put your cursor over a method or variable that you wish to find uses of and hit ctrl+B (command+B on mac).
⦁	Choose a reference to jump to, and repeat this process as necessary to see where that method is called.
Once you understand how to add a calculator operation and wire it up to a button in the display, go ahead and do so.
You should test your new button by manually opening the calculator and clicking it. We want to go further though: since we added new functionality to the Calculator class, we should write a unit test for it. There’s a challenge, though: this method is not deterministic. How can we write a good test? This is where mocking comes in. Mocking allows us to “stub” a method call: instead of running the real method, instead we can simply return a pre-defined value. We’ll use Mockito – see their docs for more on how to do this.
For our test, we’ll assume that we’re using Random.nextDouble() to generate the random number that powers the calculator random method (this all still applies if you used a different method). In our unit test, we want to mock a Random object and stub out the nextDouble method, like this:
import static org.mockito.Mockito.*;  // At top of file
// In test method:
Random random = mock(Random.class);
when(random.nextDouble()).thenReturn(0.1);
With this setup, the nextDouble() call of this Random object will return 0.1. Deterministic! Now, we need to get an instance of the Calculator class to use this mocked Random object. One way to do this is to write the Calculator class so that a Random object is a class property (we do this by adding a constructor which sets the random object). Then, we can add a setter method so that we can set the random object whenever we want. With this design, in our test we can set the random object as our mocked version, then write a test to ensure that 0.1 is returned.
With the random button implemented and tested, you should commit your changes using the same git branch + GitHub PR flow as described before.
Step 5: README
Since you’re making sure to leave every repo you touch better than how you left it, you spend some time to write a brief README to describe what this repo is, in addition to anything that could be helpful for other developers:
⦁	How to build the project
⦁	How GitHub CI works
⦁	Etc.
