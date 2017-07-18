**Travix - Problem to be solved**

**Background:**

BusyFlights is a flights search solution which aggregates flight results initially from 2 different suppliers (CrazyAir and ToughJet). A future iteration (not part of the test) may add more suppliers.

**Busy Flights API**

API Endpoint to search flights example : /flights/RBT/PRS?departureDate=170718&returnDate=170725&passengers=2

**Busy Flights Design**

- Knowing that the loading flights from crazyAir & ToughJet are a time consuming tasks. To scaling these services, we use Java’s Future callback together with Spring @Async Thread execution. the best practice is to start this in a new thread and handle the service asynchronously.
- FlightClientService : contains two services to load CrazyAirFlights & ToughJetFlights from REST API endpoints.
- FlightService : handles the management of asynchronous calls, load flights from FlightClientService and converts (using converters classes) results to the requested BusyFlights structure.
- Utils : 
	+ CrazyAirFactory : to create CrazyAirRequest used on crazyAir API endpoint.
	+ ToughJetFactory : to create ToughJetRequest used on toughJet API endpoint.
	+ CrazyAirFlightConverter :  is an adapter to convert crazyAirFlights (result of crazyAir endpoint) to BusyFlights.
	+ ToughJetFlightConverter :  is an adapter to convert toughJetFlights (result of toughJet endpoint) to BusyFlights.