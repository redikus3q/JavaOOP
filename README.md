# JavaOOP
## Description
Online ticketing API made to ease the process of purchasing tickets to your favourite event.

## Classes explanation
It currently contains a City and Address class which are self explanatory. An address has a city field because every address must be in a city.

The Client class also contains an address field, along with the first and last name fields.

Then there's the Venue class, which represents the building or area in which an event will take place, and the Organizer class which is pretty self explanatory.

The Performer abstract class from which there are derived the SoloArtist and Band class is a class that describes the artist(s) that perform at an event.

The Band class contains a list of solo artists as a field.

The most important class perhaps is the Event abstract class, from which there are a few classes derived that further describe more specific events, such as concerts.It contains a performer, an organizer and a venue.

The final class that links everything up is the Ticket class which contains a client and an event field. This is what links the client to an event,once a ticket is purchased.

For a visual depiction of this there's a picture in the repo, or you can generate the dependency diagram in IntelliJ.

## Services and main classes
The services are made to link up the main class with the classes.

The ticket service contains a purchase ticket function, and a find ticket by id function, which are pretty self explanatory. The tickets are placed in a map so that they can easily be accessed by id.

The event service is able to create events. The events are placed in a sorted TreeSet (alphabetically by name).
