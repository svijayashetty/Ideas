# Ideas


ASSIGNMENT: 
I am starting a flight booking portal. 
I want to build a system quickly to provide shortest route from Start to Destination.

ASSUMPTION: 
The shortest path is calculated depending on the stopovers. 
Hence the cost associated with each route is defauled to 1. 
Frequency of flights is not considered for shortest path calculation.

RUN: 
Open Main.java. Set the FILE_PATH appropriately. Run it.

CHANGE INPUT: 
You can change the input by updating the input.csv file. The input.csv file contains: [SourceAirport DestinationAirport Frequency] h b 1 b a 1 a f 1 b c 1 c e 5 c d 1 d e 1 e b 1

CHANGE SOURCE & DESTINATION AIRPORTS: 
The output shows the shortest path from "h" to "e". You can change the source destination by updating Main.java Airport source = new Airport("h", "h"); Airport destination = new Airport("e", "e");

CODE COVERAGE: 
The line coverage is 90% whereas branch coverage is at 80%.

DESIGN PATTERNS:
Singleton(For Factory Instance Creation), 
Strategy(For Input Reader, Algo and Output Writer), 
Factory(For creating different instance based on Input).

DOMAIN MODEL:
1. Airport with id and name. 
2. Route with id, source and destination airports and frequency of flights for that route. 
3. Graph. It has list of airports and and Routes.

Thanks & Regards, 
Vijayalaxmi Shetty.


**************************************************************************************************************************************************************************************************************************************************


28-07-2015: 
Updated code with Service Facade, Validation Using Chain Of Responsibility.
This has brought down the code coverage. 




