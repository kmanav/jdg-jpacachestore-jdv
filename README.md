## JDG Cache on/using JDV View

### Use Case
The enterprise data is spread over mutiple data sources. There is a need to get rapid yet real time access to this data and not worry about querying the data or transforming the data into usable objects. 

### Solution
* Use JBoss Data Virtualization (JDV) for solving the multidata source problem
 * JDV provides real time access to the underlying data sources 
 * JDV can expose a view that takes care of all the complexities involved in data transformation that one would have to otherwise handle in application code
* Use JBoss Data Grid (JDG) for Enterprise Caching needs
 * Using JDG's JPA Cache Store in embedded mode, one can using an existing relational table to load (store) the data into (out of) a cache
 * The JPA Cache Store hides the complexities of transforming the relational roles into Java objects and store/retrive from cache

### Prerequisites
* Knowledge of how to deploy a VDB (virtual database) onto JDV runtime
* Follow instructions for the the project [dvdemo](https://github.com/vchintal/dvdemo) and deploy the VDB on a JDV runtime
* Install the [teiid-8.13.1-jdbc.jar](https://repository.jboss.org/nexus/service/local/repositories/releases/content/org/jboss/teiid/teiid/8.13.1/teiid-8.13.1-jdbc.jar) into local Maven repository using the following command
```sh
mvn install:install-file \
-Dfile="<path>/teiid-8.13.1-jdbc.jar" \
-DgroupId=org.jboss.teiid \
-DartifactId=teiid-client-jdbc \
-Dversion=8.13.1 \
-Dpackaging=jar
```
### Execution
Run this project's executable using the following command. The command will create a JDG cache in embedded mode that, upon startup, preloads the cache from the `Customers.all_customers` view table exposed by the `dvdemo.vdb` running within JDV runtime. 

```sh 
mvn clean package exec:exec
```
