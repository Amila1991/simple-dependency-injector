# simple-dependency-injector
Simple dependency injection library for Java

#### Design Considerations
* AOP annotation based dependency injection for Java
* Support Singleton and Prototype bean creation
* Implement context to manage the beans(objects).
* Use following design patterns
    * Factory Design Pattern
    * Singleton Design Pattern
    * Prototype Design Pattern
    
#### Limitations
1. Only support beans which have no argument constructor.
2. Not support subclass beans inject to parent references.
3. Only support injecting bean to field(Constructor and method injections are not supported) 
4. Dependency injection is not support to `static` or `final` fields. 

#### Getting Started

Follow steps which are mentioned in below before use this library.

###### Step 1
Clone the library using below command
 
 `git clone https://github.com/Amila1991/simple-dependency-injector.git`
 
###### Step 2
Build the library using below command

`mvn clean install`

###### Step 3

Add following dependency and plugin in your consumer project's `pom` 
* Dependency

        <dependency>
            <groupId>org.cordnerds.simple.dependency.injector</groupId>
            <artifactId>simple-dependency-injector</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        
* Plugin

        <plugin>
            <groupId>org.codehaus.mojo</groupId>
            <artifactId>aspectj-maven-plugin</artifactId>
            <version>1.11</version>
            <configuration>
                <complianceLevel>1.8</complianceLevel>
                <source>1.8</source>
                <target>1.8</target>
                <aspectLibraries>
                    <aspectLibrary>
                        <groupId>org.cordnerds.simple.dependency.injector</groupId>
                        <artifactId>simple-dependency-injector</artifactId>
                    </aspectLibrary>
                </aspectLibraries>
            </configuration>
            <executions>
                <execution>
                    <goals>
                        <goal>compile</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
 
 <br>
 
 Define Dependency Injection(DI) Bean class using `org.cordnerds.simple.dependency.injector.annotation.Component`

     @Component
     public class Test {
     }
     
 Define the injectable field using `org.cordnerds.simple.dependency.injector.annotation.Inject`
 
     @Component
     public class Test {
     
         @Inject
         private Test2 test2;
     
         @Inject
         public Test1 test3;
     }
  
Load dependency injection bean using `org.cordnerds.simple.dependency.injector.context.DIContext`
 
       Context context = DIContext.getContext();
       TestMain main = new TestMain();
       main.t1 = context.getBean(Test.class);
     

