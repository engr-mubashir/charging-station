# Introduction

JAVA and Spring Boot framework-based Solution for Hubject's Charging Stations REST API challenge. The reason to choose Spring Boot is the ease of implementation and reduction of management overhead as it uses embedded Apache Tomcat servlet container (server) and Derby database for persistence. All the guidelines are followed as mentioned in the challenge description.

## Note
I have used a fixed radius (5 km) for finding a "perimeter around a geo location". So the Query will return the list of all the available geo locations (charging stations) within that distance including the input geo location itself.

### Requirements

- JAVA 1.8 or greater
- Spring Boot 2.2.x
- Maven 3.1.1 (tested)

### Installation

- Clone the repository `git clone https://github.com/engr-mubashir/charging-station.git`
- Related dependencies are included in `pom.xml` and will be installed automatically
- Build and Run

### Tests

- Run command to test the Charging Station REST API `mvnw test`

### Documentation

- Available at path `generated-docs/index.html`