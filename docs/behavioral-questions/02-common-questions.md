# __Common Questions__

* __What's your motivation for having a new job opportunity?__
  * Working in an international environment with people from different countries and cultures.
  * Working in an environment that have different kind of problems so that I can push myself to develop efficient solutions.
  * Working in an environment that I have chance to;
    * take responsiblity
    * make decisions
    * propose new ideas
    * share my technical knowledge with my teammates and discuss about different solutions and learn from them.

* __Why do you want to work abroad?__
  * To work in an international environment, for sharing my technical knowlegde with people from different countries and cultures and learn from their experiences. I belive this will develop me both in terms of technical and social skills.

* __Why do you want to work in XXXX (Germany/Berlin, Netherlands/Amsterdam)?__
  * Travelled to XXXX 2 times and liked the city. (What did you like??)
  * Have friends living in XXXX and they're happy to live in there.

* __Why do you want to work in XXXX?__
  * Liked your take home coding challenge. Instead of a too much fundamental data structures and algorithms oriented task, it was a task which is more close to a daily task.
  * Liked the positive psychology in our remote pair-programming session. I had some problems during the interview (maven was not working correctly, building was slow etc), but you motivated to fix them. These are very important when working in a team.

* __What is the the most challenging project you worked for?__
  * Inhouse Crm Tool, migrating the database as-is from SqlServer to Oracle with identifying the database model and translating it to our new data model. Because there were no technical documentation about the data model and insights of the application.

* __What is the the most challenging problem/issue you faced?__
  * __Situation__
    * Sent push notification to come to mobil login, because we will give a promotion code to first 1000 login users. Business people sent it to 10.000.000 customers instead of 10.000
    * Some mobile users started to face timeout problems
  * __Action__
    * Used graphana to find the performance and understand that we had 100 times larger volume in the mobile login.
    * This affected the performance of our campaign management services because of the throughtput and cpu/memory usage
    * We have 2 passive nodes. Communicated with Infra team and activated them. Response times started to be normal after a while.
  * __Result__
    * We vertically scaled out campaign management servers (hardware sizing)
    * Added 2 approval steps to sending pn process so that no one can send pn to a high volume of customer set by mistake.

* __What is the project that makes you most proud for being involved?__
  * Inhouse Campaign Management Tool
    * _Reasons_ :
      * Company was paying too much licence fee for the application. Now, we do not pay any additional fee.
      * Finding support was very difficult, since application was a little bit outdated and finding a consultant was not too easy. Now we develop it inhouse with our developers, do not need a consultant.
      * Time to bring an idea to production was almost 1 year. Now it's mostly in a month.
      * We bring an idea to production very easily. We have agility. We can have customer feedback in a very early stage and customers are happy for this purpose.
    * _Goal_ :
      * Maximize the value of each customer relationship and help the business people to retain profitable customers.
      * Contact with the customer in the correct time and from the correct channel.
      * We implement a _strategy_ to provide next-best-action and next-best-offer.
      * __Next-Best-Action :__ decide the best action to take with that customer during an interaction. Can be executed in any inbound and outbound channel. Uses a paradigm :
        * __Listen :__ get customer interactions and responses
        * __Learn :__ run strategies on customer data
        * __Act :__ provide next-best-action and offer
          * TakeNoAction
          * MakeAnOffer
      * __Next-Best-Offer :__ provides best profitable offer to be presented to the customer.
    * _Stages_ :
      * __Propositions :__ Get all valid and active propositions
      * __Volume Constraints :__
      * __Contact Policy :__ How many offers should be offered to the customer in a specific channel and time interval.
      * __Eligibility / Relevancy :__ Checks if a specific customer is eligible to have an offer or not
      * __Prioritization :__ Rank propositions according to the priorities of both the proposition and customer (_profitability_)
      * __Arbitration :__ Number of propositions to be sent to the customer.

* __Tell me about a challenging interaction or a conflict with a teammate?__
  * __situation :__ One was not contributing much, staying quiet during the meetings, struggled to complete his works. This was an issue because it shifted more work on the other team members.
  * __action :__ First wanted to understand why acting like this. Tried to understand if the cause is laziness, absence of willingness or are there any other works he has to deal with. Asked open-ended questions like what do you think about the project and how we perform? He told that he do not have any past experience in working such a big project and can not see the whole picture. I understand that it was not about laziness or absence of willingness. I told him that this is normal and tried to give him details about the high-level architecture, components of the system and how they interact with each other.
  * __result :__ He started to performn better as a result. We were happy to work with him on a future project.

* __How does the code review process work?__
  * Consistency with the overall application design
  * Coding conventions and standards
  * Using best practices
  * Having unit/integration test
  * Looking for potential business security issues
  * Do not review for more than 60 minutes at a time

* __How much requests/transactions does your application that and how do you scale it?__
  * Mobile Application
    * We keep track of request counts and response times for different layers
    * 100 active sessions in a minute
    * 2000 requests per second
    * 150 ms average response time

* __How is your pipeline looks like? How do you deploy an idea to production? CI/CD, FastDeployments etc.__
  * ?

* __How do you troubleshoot a problem?__
  * __Define the Problem :__ Explain why the situation was problematic. When does a situation or circumstance become problematic?
  * __Analyze the Problem :__ How you gather data (if a problem I use logs, if a performance related issue I use mostly graphana)
  * __Generate possible solutions with reasons :__ scale
  * __Select the best solution :__ explain the objective and select practical or best solution
  * __Lessons learned :__ explain detail what accomplished.

* __How do you troubleshoot a slow application?__
  * Graphana : Max and Avg values for
    * Resource(Cpu/Memory/Disk) usage statistics
    * Request per second
    * Response time
  * Have alarms for;
    * poor performing queries
    * service & query level timeout thresholds
    * connection timeoutsh

* __How to scale up a web application? When to horizontal scale, when to vertical scale?__
  * __Vertical scaling__ refers to adding more resources (CPU/RAM/DISK) to your server (database or application server is still remains one) as on demand. Some of the reasons to scale vertically includes increasing IOPS (Input / Ouput Operations), amplifying CPU/RAM capacity, as well as disk capacity. The risk for downtimes is much higher than using horizontal scaling. Scaling beyond that capacity results in downtime and comes with an upper limit.
  * __Horizontal scaling__ refers to adding more processing units or phyiscal machines to your server or database. Is a must use technology – whenever a high availability of services are required. It means growing the number of nodes in the cluster, reducing the responsibilities of each member node by spreading the key space wider

* __How to scale a database?__
  * ?

* __Selecting the right database for microservice environment?__
  * _Performance_ : read heavy or write heavy?
    * _Read performance_ : how fast you can run queries and retrieve results. it's strictly dependant upon how well you organize the data and indexes
    * _Write performance_ : determine the number of write operations per second in the environment
  * _Latency_ : we need a low latency database for a microservice environment. as a best practice deploying a service close to its database will minimize the network latency.
    * Low : less than 1ms
    * Moderate : more than 100ms
    * High : more than 1sec
  * _Resource efficiency_ : the database footprint should be minimal while retaining the ability to scale on demand.
  * _Provisioning efficiency_ : in a microservice environment we may need a database service to support on-demand creation

* __When a story is ready for spring backlog? How do you do story refinement (backlog grooming) ?__
  * completely groommed
  * acceptance criteria is written
  * no open questions attached to it
  * main idea of refinement is to increase the team’s understanding of project deliverables

* __If you see that some one from your team writes a dirty code, what do you do?__
  * In my experience this type of situations occur when some feature is developed under significant time pressure. So I may understand the reasons under the hood most of the time.
  * Being non-argumentative is very important in these situations because we may end up with communication problems.
  * At least unit or integration tests should be written. If not, I propose to write them.
  * After that, we can look for possible refactoring or decomposing options. And also working on coding conventions and best practices if they're broken.