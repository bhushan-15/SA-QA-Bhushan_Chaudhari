**How to Run shared Code in IDE(Eclipse)**

Prereuisites:
- Java installed
- Eclipse IDE installed
- Chrome browser installed
- Internet connection

---

Steps:
1. Open Eclipse.
2. Import your project:
   - Click File > Import > General > Existing Projects into Workspace.
   - Choose your project folder.
   - Click Finish.
3. Add Selenium and WebDriverManager libraries:
   - Download these JAR files:
     - Selenium Java 
     - WebDriverManager 
   - In Eclipse, right-click on project > Build Path > Add External Archives.
   - Select the downloaded JAR files and add them.

4. Run your tests:
   - Open `PositivePurchaseFlow.java`.
   - Right-click inside the code editor > Run As > Java Application.
   - and See the test running in Chrome.
     
   - Repeat for `NegativeLoginFlow.java`.



