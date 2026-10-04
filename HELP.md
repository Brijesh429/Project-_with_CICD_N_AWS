# Getting Started

## GitHub Actions deployment to Tomcat

The workflow in `.github/workflows/ci-cd.yml` runs tests and creates a WAR on pushes
and pull requests targeting `main` or `master`. It deploys only after a successful
push to either branch. The manual **Run workflow** option also runs the build; it
does not deploy unless triggered by a push.

Configure these repository secrets under **Settings > Secrets and variables > Actions**:

* `TOMCAT_MANAGER_URL`: HTTPS Tomcat Manager text endpoint, for example
  `https://tomcat.example.com:8443/manager/text`.
* `TOMCAT_USER`: a Tomcat account with the `manager-script` role.
* `TOMCAT_PASSWORD`: that account's password.

Optionally configure the repository variable `TOMCAT_CONTEXT_PATH` to choose the
deployed application path; it defaults to `/springboot`. Tomcat must be reachable
from GitHub-hosted runners and configured with the Manager text interface. Use a
Tomcat version compatible with the Spring Boot version in `pom.xml` (Tomcat 11 for
Spring Boot 4.x).

Set the `DB_PASSWORD` environment variable wherever the application runs. Database
credentials should not be committed to source control.

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/4.1.1/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/4.1.1/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/4.1.1/reference/web/servlet.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.
