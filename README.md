# DeliDish start

# Stap 1: Maak jezelf vertrouwd met de structuur
Download het project en open  het in intelliJ (gebruik intelliJ ultimate en gebruik je e-mail adres voor het aanvragen van een licentie) . 
Indien nodig stel je nog de java SDK in. Gebruik Java 8

# Stap 2: Controleer of je het project kan runnen met de DeliveryControllerTest configuration (gewoon op play duwen dus)
Als dat niet lukt en je weet niet hoe het wel moet lukken vraag dat dan aan de docent.

# Stap 3: Bekijk in de test.be.kdg.deliDish.application de klasse DeliveryControllerTest.java
Dit is de klasse waarin tests zijn opgenomen. Als je op play drukt zijn het deze tests die worden uitgevoerd. 
Lees de comments om beter te begrijpen hoe de tests werken.
Alle code onder de testpackage maken geen onderdeel van de eigenlijke applicatie. Deze package dient gewoon om testen uit te werken op de applicatie.

# Stap 4: Bekijk in de test.be.kdg.deliDish.application de klasse TestData. 
Deze klasse bevat alle testdata. Deze moet dus in de setUp() methode gebruikt worden om het systeem te initiëren.
Eigenlijk zou je aan deze klasse geen wijzigingen mogen doen omdat dan de Testen niet meer werken. Als je toch andere constructors in je code wil gebruiken, dan mag je (hoewel afgeraden) de code hierop aanpassen.

# Stap 5: Werk de TODO's uit voor opdracht 3
Als je de tests helemaal door hebt kan je beginnen aan de code en aan de diagrammen. 
Het einddoel bij de eerste oplevering is vanuit de DeliveryControllerTest class de test getAvailableDeliveries() op groen te krijgen bij het runnen (met achterliggend mooi ontworpen code). 
- De test roept getAvailableDeliveries() aan op de controller. Die krijg je dus al van ons cadeau
- Het domeinmodel is ook al voor een groot stuk beschikbaar. Voor reeds beschikbare domeinklassen mag je enkel toevoegingen doen. Bestaande methodes pas je best niet aan.
- Zorg ervoor dat je volgens de GRASP regels de code uitwerkt
- Je zal de initialisatie van het systeem ook moeten uitwerken. De testdata moet op de juiste plaats in de applicatie terechtkomen om er gebruik van te kunnen maken. De initialisatie start in de setUp() methode binnen test, maar ook de add-methods in de controller moeten aangemaakt worden.

