# dsoa-drone-delivery

# Del 1 - Klassen Node

Klassen node fungerar enligt specifikation, och den utvecklade jag vidare när det behövdes. 


# Del 2 - Skriv ut namnen på alla biblioteken samt lista grannarna

Jag skapade en metod i Utils klassen som returnerar en String med alla bibliotek man matar in i den. Sen skapade jag en metod "displayNodesAndLinks()" i klassen UI, som printar ut dem. 


# Del 3 - Skapa funktionalitet för att interaktivt mäta geografiskt avstånd mellan två noder

Jag skapade metoden "calculateH()" i klassen node. Metoden använder sig av "getDistance()" som finns i Utils klassen. 
I UI klassen skapade jag "displayGeoDistance() som tar emot startnod och slutnod, och printar ut geografiska avståndet mellan dem. 
Jag skapade också metoden "getNodeByKey()" som tar emot en lista av nodes och en key, och returnerar noden på basis av den. 
Till sist skapade jag metoderna "prompStartNode()" och "promptGoalNode()", som frågar efter start och slutnod. Metoderna returnerar en nod.  


# Del 4 - Implementera A* algoritmen för att beräkna kortaste rutten två noder

Den här var klurig. Jag kollade YouTube videon som Fredde länkade på itslearning, och gjorde en egen implementation med inspiration av Freddes pseudokod. Jag skapade också en helper metod "getNodeSmallestF()" i Utils klassen för att göra koden i aStar metoden lättare att förstå. 


# Del 5 – Bättre UI/UX

Ingla klasser skriver ut något förutom en UI klass. Main anropar bara de här klasserna från UI, och på det här sättet tycker jag att både koden och UI:n blev lättare att läsa och förstå. 


# Del 6 – Implementera Sorteringsalgoritm

Fredde gav ett bra exempel av en sorteringsalgoritm på föreläsningen, och jag implementerade ungefär samma i projektet. Metoderna sortNodesByName och sortNodesByLat är ungefär lika, men den ena jämför String och den andra double. För att originala ArrayListen inte skulle modifieras använde jag "new ArrayList (originalList)". Jag testade också på olika sätt att den originala ArrayListen var omodifierad. 


# Del 7 – Stil och logik

I bland är det bra att vara lite för noggrann. Jag tycker att koden är prydlig, och så långt jag vet har jag kodat "rätt" i java. 