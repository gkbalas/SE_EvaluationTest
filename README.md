Software Engineer Evaluation Test (Java)

1. A class named ​ StatisticUtilsArray​ . This class will be responsible for providing a set of
statistical values for ​ an array of double values. ​ More specifically, the statistical
metrics that need to be implemented are the following:
a. Minimum Value
b. Maximum Value
c. Median Value
d. Mean Value
e. Standard Deviation

Instead of writing (the trivial) code to estimate those metrics, it is necessary to ​ add a
library in your maven project that will do this for you​. There are a lot of choices out
there, you can choose whatever you feel confident with. (Done)

2. A class named ​ StatisticUtilsArrayList​. This class should be able to provide the
aforementioned metrics, but for ​ an array list of double values (this is not the same
as the array mentioned above)​. As with the previous class, it is necessary to add a
library that will do this for you in your maven project. It may be the same one used in
the previous point, it may not. (Done)

3. A class named AscendingMinima. ​ This class should implement the Ascending Minima
Algorithm. You can read about that algorithm in the following ​ link and, also, feel free
to search for other implementations over the Internet if you want to. (Done)

4. The aforementioned classes must be ​ Javadoc​ , ​ fully documented (Javadoc and
overline comments), and ​ fully tested​ , using the ​ JUnit ​ and ​ Maven Surefire.
For the first two classes, please be sure to check for ​ normal and corner cases for all
the methods that you will create. For the third class, you should include at least some
of the examples/ test cases that are contained in the provided link, that will show that
the implementation you have created is working as it is supposed to. (Done)

5. Finally, your assignment must be uploaded to a ​ public git repo (Github or Bitbucket is
fine), so that your code will be reachable for evaluation. Please, be as kind as to create
the ​ README ​ documentation in the description of the repo. (Done)

Assignment Additional Points

The following features will be positively assessed in your code evaluation. Please, make sure
you first have completed the task, before trying to implement any of those additional points.

1. Implementing additional classes for points 1 and 2 that will utilize ​ Java Streams ​ for
the estimation of the statistical metrics needed.

2. Implementing the class of point 2 in such a way that can handle all Numerical data
types, by using ​ Generics​. (Used the trump type ? extending Integer class)

3. Implementing ​ Ascending Minima ​ using the most efficient data structures for that
case. (Used ArrayList as the most efficient, because ArrayList uses pointers for iteration in the list)
