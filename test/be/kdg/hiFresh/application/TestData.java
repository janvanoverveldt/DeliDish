package be.kdg.hiFresh.application;

import be.kdg.foundation.contact.Adres;
import be.kdg.foundation.contact.ContactInfo;
import be.kdg.foundation.contact.Gemeente;
import be.kdg.foundation.qualified.Hoeveelheid;
import be.kdg.hiFresh.domain.leverancier.Contract;
import be.kdg.hiFresh.domain.leverancier.ContractPeriode;
import be.kdg.hiFresh.domain.leverancier.Leverancier;
import be.kdg.hiFresh.domain.recept.Ingredient;
import be.kdg.hiFresh.domain.recept.Product;
import be.kdg.hiFresh.domain.recept.Recept;
import be.kdg.hiFresh.domain.recept.WeekAanbod;
import org.threeten.extra.YearWeek;

import java.time.Duration;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.*;

import static be.kdg.foundation.qualified.Eenheid.*;
import static be.kdg.hiFresh.domain.recept.Label.*;

/**
 * Deze klasse bevat test data.
 * Zij mag enkel gebruikt worden bij het initialiseren van het systeem,
 * om de test data in het systeem te stoppen
 * Bij het uitvoeren van de tests worden dan de data in het systeem gebruikt,
 * en mag deze klasse niet meer aangesproken worden.
 *
 * @author Jan de Rijke.
 */
class TestData {
    private List<Recept> recepten = new ArrayList<>();
    private List<Contract> contracten = new ArrayList<>();
    private List<WeekAanbod> planning = new ArrayList<>();

    // Hieronder wordt de testdata opgezet.
    // 1. Contracten worden opgesteld.
    // 2. Producten worden opgesteld en aan contractperiodes gekoppeld.
    // 3. Met behulp van de aangemaakte producten worden recepten opgesteld.
    // 4. Er wordt een aabod van 2 weken voor tot 6 weken na de huidige datum gegenereerd met random gekozen recepten
    TestData() {

        //1. Maak contracten aan. Ze worden later aan een productgekoppeld
        voegContractenToe();

        Product garnalen = new Product(
                "garnalen",
                MonthDay.of(9, 15),
                MonthDay.of(10, 15),
                new Hoeveelheid(200, GRAM)
        );
        maakProductContractPeriodes(contracten, garnalen, 7.0);

        Product kokosmelk = new Product(
                "kokosmelk",
                new Hoeveelheid(20, CENTILITER));
        maakProductContractPeriodes(contracten, kokosmelk, 5.0);
        Product kokosnoot = new Product(
                "kokosnoot",
                new Hoeveelheid(1, STUK));
        maakProductContractPeriodes(contracten, kokosnoot, 2.0);
        Product citroengras = new Product(
                "citroengras",
                new Hoeveelheid(2, STUK));
        maakProductContractPeriodes(contracten, citroengras, 2.0);
        Product limoen = new Product(
                "limoen",
                new Hoeveelheid(1, STUK)); // gemiddeld 30ml, 2 el
        maakProductContractPeriodes(contracten, limoen, 0.5);
        Product citroen = new Product("citroen", new Hoeveelheid(5, STUK));
        maakProductContractPeriodes(contracten, citroen, 2.0);
        Product look = new Product("knoflook", new Hoeveelheid(24, TEEN));
        maakProductContractPeriodes(contracten, look, 1.0);
        Product koriander = new Product("verse koriander", new Hoeveelheid(20, STUK));
        maakProductContractPeriodes(contracten, koriander, 1.0);
        Product sjalot = new Product(
                "sjalot",
                MonthDay.of(7, 1),
                MonthDay.of(8, 1),
                new Hoeveelheid(40, STUK)
        );
        maakProductContractPeriodes(contracten, sjalot, 1.0);
        Product gember = new Product(  // 2 cm = 2 theelepels = 15gram
                "gember",
                MonthDay.of(4, 1),
                MonthDay.of(6, 1),
                new Hoeveelheid(150, GRAM)
        );
        maakProductContractPeriodes(contracten, gember, 2.0);
        Product curryPasta = new Product("currypasta", new Hoeveelheid(60, THEELEPEL));
        maakProductContractPeriodes(contracten, curryPasta, 3.0);
        Product mie = new Product("Eiermie", new Hoeveelheid(250, GRAM));
        maakProductContractPeriodes(contracten, mie, 0.5);
        Product peulErwten = new Product(
                "peulerwten",
                MonthDay.of(6, 1),
                MonthDay.of(7, 1),
                new Hoeveelheid(200, GRAM)
        );
        maakProductContractPeriodes(contracten, peulErwten, 3.0);
        Product babymais = new Product(
                "babymais",  // gemiddeld gewicht: 12g
                MonthDay.of(7, 15),
                MonthDay.of(8, 15),
                new Hoeveelheid(32, STUK)
        );
        maakProductContractPeriodes(contracten, babymais, 2.0);
        Product paprika = new Product( //150g
                "paprika",
                MonthDay.of(8, 1),
                MonthDay.of(10, 1),
                new Hoeveelheid(7, GRAM)
        );
        maakProductContractPeriodes(contracten, paprika, 4.0);
        Product koolVis = new Product(
                "koolvis",
                MonthDay.of(6, 1),
                MonthDay.of(1, 1),
                new Hoeveelheid(1000, GRAM)
        );
        maakProductContractPeriodes(contracten, koolVis, 10.0);
        Product pepertje = new Product(
                "chilipeper",
                MonthDay.of(8, 1),
                MonthDay.of(9, 1),
                new Hoeveelheid(2, STUK)
        );
        maakProductContractPeriodes(contracten, pepertje, 1.0);
        Product brasem = new Product("brasem", new Hoeveelheid(1000, GRAM));
        maakProductContractPeriodes(contracten, brasem, 15.0);
        Product pijpajuin = new Product("pijpajuin", new Hoeveelheid(1, STUK));
        maakProductContractPeriodes(contracten, pijpajuin, 1.0);
        Product tamarinde = new Product("tamarinde", new Hoeveelheid(30, CENTILITER));
        maakProductContractPeriodes(contracten, tamarinde, 8.0);
        Product lende = new Product("runderlende", new Hoeveelheid(1000, GRAM));
        maakProductContractPeriodes(contracten, lende, 17.0);
        Product citroenBlad = new Product("limoenblad", new Hoeveelheid(15, STUK));
        maakProductContractPeriodes(contracten, citroenBlad, 0.65);
        Product aubergine = new Product(
                "aubergine",
                MonthDay.of(8, 1),
                MonthDay.of(10, 1),
                new Hoeveelheid(2, STUK)
        );
        maakProductContractPeriodes(contracten, aubergine, 1);
        Product laos = new Product("galanga", new Hoeveelheid(50, CENTIMETER));
        maakProductContractPeriodes(contracten, laos, 1);
        Product kip = new Product("kip", new Hoeveelheid(1000, GRAM));
        maakProductContractPeriodes(contracten, kip, 6);
        Product pinda = new Product("pindas", new Hoeveelheid(300, GRAM));
        maakProductContractPeriodes(contracten, pinda, 2);
        Product rijst = new Product("rijst", new Hoeveelheid(1000, GRAM));
        maakProductContractPeriodes(contracten, rijst, 2);
        Product sla = new Product("sla", new Hoeveelheid(1, STUK));
        maakProductContractPeriodes(contracten, sla, 1);
        Product mihoen = new Product("mihoen", new Hoeveelheid(500, GRAM));
        maakProductContractPeriodes(contracten, mihoen, 25);
        Product tofoe = new Product("tofu", new Hoeveelheid(170, GRAM));
        maakProductContractPeriodes(contracten, tofoe, 2);
        Product sperziebonen = new Product(
                "princessenbonen",
                MonthDay.of(7, 1),
                MonthDay.of(8, 1),
                new Hoeveelheid(500, GRAM));
        maakProductContractPeriodes(contracten, sperziebonen, 4);
        Product wortelen = new Product(
                "wortelen",
                MonthDay.of(6, 1),
                MonthDay.of(9, 1),
                new Hoeveelheid(500, GRAM));
        maakProductContractPeriodes(contracten, wortelen, 1);
        Product broccoli = new Product(
                "broccoli", // gemiddeld gewicht: 240g
                MonthDay.of(7, 1),
                MonthDay.of(10, 1),
                new Hoeveelheid(500, GRAM));
        maakProductContractPeriodes(contracten, broccoli, 2);
        Product bleekselder = new Product(
                "bleekselder",
                MonthDay.of(7, 1),
                MonthDay.of(10, 1),
                new Hoeveelheid(5, STENGEL));
        maakProductContractPeriodes(contracten, bleekselder, 1.49);
        Product ajuin = new Product("ui", new Hoeveelheid(8, STUK));
        maakProductContractPeriodes(contracten, ajuin, 1);
        Product garnaalpasta = new Product("garnaalpasta", new Hoeveelheid(227, GRAM));
        maakProductContractPeriodes(contracten, garnaalpasta, 2.53);
        Product biefstuk = new Product("biefstuk", new Hoeveelheid(1000, GRAM));
        maakProductContractPeriodes(contracten, biefstuk, 20);
        Product bieslook = new Product("bieslook", new Hoeveelheid(3, THEELEPEL));
        maakProductContractPeriodes(contracten, bieslook, 1.5);
        Product pompelmoes = new Product("pompelmoes", new Hoeveelheid(1, STUK));
        maakProductContractPeriodes(contracten, pompelmoes, 0.85);
        Product sojascheuten = new Product("sojascheuten", new Hoeveelheid(250, GRAM));
        maakProductContractPeriodes(contracten, sojascheuten, 1);
        Product zwarteBonen = new Product(
                "zwarte gefermenteerde bonen",
                new Hoeveelheid(40, THEELEPEL));
        maakProductContractPeriodes(contracten, zwarteBonen, 2);
        Product komkommer = new Product(
                "komkommer",
                MonthDay.of(3, 1),
                MonthDay.of(9, 1),
                new Hoeveelheid(1, STUK));
        maakProductContractPeriodes(contracten, komkommer, 0.5);
        Product bloemkool = new Product(
                "bloemkool",
                MonthDay.of(7, 1),
                MonthDay.of(10, 1),
                new Hoeveelheid(1, STUK));
        maakProductContractPeriodes(contracten, bloemkool, 1);
        Product champignons = new Product("champignons", new Hoeveelheid(250, GRAM));
        maakProductContractPeriodes(contracten, champignons, 1);


        Recept recept = new Recept(
                "Zoete curry van garnalen en kokos",
                Duration.ofMinutes(50),
                1,
                List.of(
                        "Pers de limoen.",
                        "Laat de garnalen 30' in de kokosmelk en het limoensap marineren.",
                        "fruit de gesnipperde sjalotjes en geperste knoflook in olie in een wok.",
                        "Voeg de gember en currypasta toe en roorbak 1-2'.",
                        "Voeg de garnalenmarinade toe en verhit 5' op een laag vuur.",
                        "Garneer met limoen en kokosschilfers en serveer met rijst."
                ),
                List.of(
                        new Ingredient(garnalen, new Hoeveelheid(100, GRAM)),
                        new Ingredient(kokosmelk, new Hoeveelheid(4, CENTILITER)),
                        new Ingredient(limoen, new Hoeveelheid(0.4, STUK)),
                        new Ingredient(look, new Hoeveelheid(0.25, TEEN)),
                        new Ingredient(sjalot, new Hoeveelheid(1, STUK)),
                        new Ingredient(gember, new Hoeveelheid(10, GRAM)),
                        new Ingredient(curryPasta, new Hoeveelheid(1, THEELEPEL)),
                        new Ingredient(rijst, new Hoeveelheid(100, GRAM))
                )
        );
        recept.addLabel(VIS);
        recept.addLabel(GLUTENVRIJ);
        recepten.add(recept);

        recept = new Recept(
                "Garnalen met eiermie",
                Duration.ofMinutes(30),
                1,
                List.of(
                        "Kook de garnalen tot ze gaar zijn en laat uitlekken.",
                        "Kook de eiermie",
                        "Wok de peultjes, maïs en paprika 4' in olie.",
                        "Voeg de currypasta en 1 tl vissaus toe en bak nog 2'",
                        "Roer 3 cl visbouillon, de garnalen en de mie door het mengsel.",
                        "Pers de limoen en roer er een halve tl maïzena door.",
                        "Doe in de wok en laat binden terwijl je roer. "
                ),
                List.of(
                        new Ingredient(garnalen, new Hoeveelheid(100, GRAM)),
                        new Ingredient(mie, new Hoeveelheid(40, GRAM)),
                        new Ingredient(limoen, new Hoeveelheid(0.2, STUK)),
                        new Ingredient(peulErwten, new Hoeveelheid(30, GRAM)),
                        new Ingredient(babymais, new Hoeveelheid(3, STUK)),
                        new Ingredient(paprika, new Hoeveelheid(0.2, STUK)),
                        new Ingredient(curryPasta, new Hoeveelheid(1, THEELEPEL))
                )
        );
        recept.addLabel(VIS);
        recept.addLabel(GLUTENVRIJ);
        recept.addLabel(LIGHT);
        recept.addLabel(KINDER);
        recepten.add(recept);

        recept = new Recept(
                "Gestoomde koolvis",
                Duration.ofMinutes(25),
                1,
                List.of(
                        "Snij de vis in dikke repen.",
                        "Snipper de sjalotjes en het citroengras over de vis en stoom tot de vis gaar is.",
                        "Pers de limoen en voeg er een halve el vissaus en een halve tl palmsuiker aan toe.",
                        "Pers de knoflook en voeg er de gesnipperde pepertjes bij.'",
                        "Begiet de vis met het limoensapmengsel.",
                        "Bestrooi met het pepermengsel en serveer."
                ),
                List.of(
                        new Ingredient(koolVis, new Hoeveelheid(100, GRAM)),
                        new Ingredient(sjalot, new Hoeveelheid(0.5, STUK)),
                        new Ingredient(citroengras, new Hoeveelheid(0.25, STUK)),
                        new Ingredient(look, new Hoeveelheid(0.5, TEEN)),
                        new Ingredient(babymais, new Hoeveelheid(3, STUK)),
                        new Ingredient(limoen, new Hoeveelheid(0.3, STUK)),
                        new Ingredient(pepertje, new Hoeveelheid(0.5, STUK))
                )
        );
        recept.addLabel(VIS);
        recept.addLabel(GLUTENVRIJ);
        recept.addLabel(LIGHT);
        recepten.add(recept);

        recept = new Recept(
                "Gebakken brasem met tamarinde",
                Duration.ofMinutes(35),
                2,
                List.of(
                        "Snij de vissen aan beide kanten 2-3 keer in en bestrooi met bloem.",
                        "Wok de vissen 5' aan elke kant in olie.",
                        "Pers de knoflook, en snij gember, uitjes en pepers fijn en fruit alles.",
                        "Verwarm het tamarindesap  samen met 1 tl soyasaus, 0,5 el palmsuiker en 0,5 el vissaus "
                                + "en giet over de vis."
                ),
                List.of(
                        new Ingredient(brasem, new Hoeveelheid(100, GRAM)),
                        new Ingredient(pijpajuin, new Hoeveelheid(2, STUK)),
                        new Ingredient(gember, new Hoeveelheid(1, THEELEPEL)),
                        new Ingredient(look, new Hoeveelheid(0.5, TEEN)),
                        new Ingredient(tamarinde, new Hoeveelheid(4, CENTILITER)),
                        new Ingredient(pepertje, new Hoeveelheid(0.5, STUK))
                )
        );
        recept.addLabel(VIS);
        recept.addLabel(GLUTENVRIJ);
        recept.addLabel(LIGHT);
        recepten.add(recept);

        recepten.add(new Recept(
                "Curry met rundsvlees",
                Duration.ofMinutes(30),
                2,
                List.of(
                        "Roerbak de curry in een wok met olie gedurende 2'.",
                        "Voeg de in repen gesneden lende toe en laat lichtbruin bakken.",
                        "Voeg de kokosmelk en 1 tl vissaus toe en laat 5' doorkoken.",
                        "Zet het vuur laag en voeg de gescheurde citroenblaadjss, de in 4 gesneden aubergines, de"
                                + " in schijfjeds gesneden laos de pepers en een halve tl palmsuiker toe ",
                        "Laat koken tot de aubergine gaar is.",
                        "Serveer met rijst."
                ),
                List.of(
                        new Ingredient(lende, new Hoeveelheid(100, GRAM)),
                        new Ingredient(curryPasta, new Hoeveelheid(1, EETLEPEL)),
                        new Ingredient(laos, new Hoeveelheid(0.5, CENTIMETER)),
                        new Ingredient(kokosmelk, new Hoeveelheid(10, CENTILITER)),
                        new Ingredient(citroenBlad, new Hoeveelheid(1, STUK)),
                        new Ingredient(pepertje, new Hoeveelheid(0.5, STUK)),
                        new Ingredient(rijst, new Hoeveelheid(100, GRAM)),
                        new Ingredient(aubergine, new Hoeveelheid(2, STUK))
                )
        ));
        recept = new Recept(
                "Kruidige rijst met kip",
                Duration.ofMinutes(25),
                4,
                List.of(
                        "Kook de rijst.",
                        "Kook de kip en snij het vlees in reepjes.",
                        "Snij de bonen in stukjes van 2.5 cm.",
                        "Blancheer de bonen in kokend water tot ze net zacht zijn.",
                        "Verhit 1 tl olie en de currypasta 4' roerend in de wok.",
                        "Voeg de kip en rijst toe en roerbak 2'.",
                        "Voeg 2 tl vissaus  toe en schep om."
                ),
                List.of(
                        new Ingredient(kip, new Hoeveelheid(60, GRAM)),
                        new Ingredient(sperziebonen, new Hoeveelheid(40, GRAM)),
                        new Ingredient(curryPasta, new Hoeveelheid(2, THEELEPEL)),
                        new Ingredient(rijst, new Hoeveelheid(100, GRAM))
                )
        );
        recept.addLabel(GLUTENVRIJ);
        recept.addLabel(KINDER);
        recept.addLabel(LIGHT);
        recept = new Recept(
                "Tofu met knapperige mihoen",
                Duration.ofMinutes(20),
                2,
                List.of(
                        "Wok de mihoen al omkerend even in olie op 180°C.",
                        "Laat de mihoen op keukenpapier uitlekken.",
                        "Snij de tofu in blokjes en bak in de olie aan alle kanten bruin.",
                        "Schep de tofu uit de olie en zet apart.",
                        "Schil de groenten en snij in stukjes.",
                        "Wok de wortel, broccoli, selder en ui bijtgaar in een weinig olie",
                        "Rasp de gember",
                        "Voeg de tofu en mihoe, garnalenpasta, gember, 2tl soyasaus, 2 tl azijn en 2 tl suiker "
                                + "toe in de wok en schep door elkaar."
                ),
                List.of(
                        new Ingredient(mihoen, new Hoeveelheid(30, GRAM)),
                        new Ingredient(tofoe, new Hoeveelheid(50, GRAM)),
                        new Ingredient(wortelen, new Hoeveelheid(0.5, STUK)),
                        new Ingredient(broccoli, new Hoeveelheid(25, GRAM)),
                        new Ingredient(bleekselder, new Hoeveelheid(0.5, STENGEL)),
                        new Ingredient(ajuin, new Hoeveelheid(0.25, STUK)),
                        new Ingredient(garnaalpasta, new Hoeveelheid(2, GRAM)),
                        new Ingredient(gember, new Hoeveelheid(5, GRAM))
                )
        );
        recept.addLabel(GLUTENVRIJ);
        recept.addLabel(LIGHT);
        recepten.add(recept);
        recept = new Recept(
                "Chian Mai",
                Duration.ofMinutes(40),
                1,
                List.of(
                        "Pers de knoflook.",
                        "Snipper de sjalotjes.",
                        "Fruit de knoflook en sjalotjes glazig in de olie.",
                        "Voeg de currypasta toe en kruid met een snuifje kurkuma, komijn en gemalen koriander. "
                                + "Roerbak 1'",
                        "Voeg de kokosmelk toe en breng aan de kook.",
                        "Snij de biefstuk in dunne plakjes",
                        "Voeg het vlees toe en laat 15-20' zachtjes garen.",
                        "Kook de eiermie 1'.",
                        "Pers de citroen en voeg 2tl citroensap toe aan de wok met de rundercurry",
                        "Snij de bieslook fijn en voeg 1 tl toe.",
                        "Voeg 1 el vissaus  , 15g palmsuiker en 1 tl soyasaus toe en roer om",
                        "Laat de eiermie uitlekken en leg op een serveerschaal. Schep de rundercurry erop"
                ),
                List.of(
                        new Ingredient(look, new Hoeveelheid(0.5, TEEN)),
                        new Ingredient(sjalot, new Hoeveelheid(1, STUK)),
                        new Ingredient(curryPasta, new Hoeveelheid(1, THEELEPEL)),
                        new Ingredient(biefstuk, new Hoeveelheid(50, GRAM)),
                        new Ingredient(citroen, new Hoeveelheid(0.2, STUK)),
                        new Ingredient(bieslook, new Hoeveelheid(1, THEELEPEL)),
                        new Ingredient(mie, new Hoeveelheid(100, GRAM)),
                        new Ingredient(kokosmelk, new Hoeveelheid(7, CENTILITER))
                )
        );

        recept.addLabel(GLUTENVRIJ);
        recepten.add(recept);
        recept = new Recept(
                "Thaise rijstsalade",
                Duration.ofMinutes(25),
                3,
                List.of(
                        "Kook de rijst.",
                        "Verdeel de pompelmoes in partjes en verwijder het vliesjes.",
                        "Snij de komkommer overlangs in vier en dan in dunne schijfjes.",
                        "Snij de pijpajuintjes diagonaal fijn",
                        "Schil de gember en snij in dunne reepjes.",
                        "Snij de zachte stengel uit het citroegras en snij deze fijn.",
                        "Pers de citroen en maak een sausje met 1 el sitroensap, 3cl vissaus en 2 tl suiker",
                        "Zet alle ingrediënten op tafel en laat iedereen zijn slaatje samenstellen"
                ),
                List.of(
                        new Ingredient(rijst, new Hoeveelheid(100, GRAM)),
                        new Ingredient(pompelmoes, new Hoeveelheid(0.25, STUK)),
                        new Ingredient(komkommer, new Hoeveelheid(0.2, STUK)),
                        new Ingredient(pijpajuin, new Hoeveelheid(2, STUK)),
                        new Ingredient(gember, new Hoeveelheid(6, GRAM)),
                        new Ingredient(kokosnoot, new Hoeveelheid(0.05, STUK)),
                        new Ingredient(sojascheuten, new Hoeveelheid(15, GRAM)),
                        new Ingredient(citroengras, new Hoeveelheid(0.5, STENGEL)),
                        new Ingredient(garnalen, new Hoeveelheid(15, GRAM))
                )
        );
        recept.addLabel(VIS);
        recept.addLabel(GLUTENVRIJ);
        recepten.add(recept);
        recept = new Recept(
                "Komkommersalade",
                Duration.ofMinutes(10),
                1,
                List.of(
                        "Snij de komkommer in 0,5 cm dikke schijfjes.",
                        "Snij de paprika in reepjes.",
                        "Pel de pinda's.",
                        "Verdeel de slablaadjes over een serveerschaal, leg de komkommer in hete midden en de "
                                + "paprika errond. Strooi de pinda's ervover",
                        "Pers de citroen.",
                        "Verwijder de zaadjes uit het pepertje en snij het fijn.",
                        "Snij de korianderblaadjes fijn.",
                        "Maak een dressing met 2tl citroensap, de peper, de koriander en 1 tl vissaus",
                        " Druppel de dressing net voor het serveren over de salade"
                ),
                List.of(
                        new Ingredient(sla, new Hoeveelheid(0.2, STUK)),
                        new Ingredient(paprika, new Hoeveelheid(0.25, STUK)),
                        new Ingredient(komkommer, new Hoeveelheid(0.2, STUK)),
                        new Ingredient(pinda, new Hoeveelheid(10, GRAM)),
                        new Ingredient(citroen, new Hoeveelheid(0.2, STUK)),
                        new Ingredient(pepertje, new Hoeveelheid(0.25, STUK)),
                        new Ingredient(koriander, new Hoeveelheid(2, STENGEL))
                )
        );
        recept.addLabel(VEGAN);
        recept.addLabel(GLUTENVRIJ);
        recepten.add(recept);
        recept = new Recept(
                "Tofusalade",
                Duration.ofMinutes(10),
                1,
                List.of(
                        "Snij de tofu in blokjes en bak in de olie aan alle kanten bruin.",
                        "Schep de tofu uit de olie en zet apart.",
                        "Pers de knoflook en laat fruiten in een weinig olie in de wok.",
                        "Verdeel de broccoli in roosjes.",
                        "Voeg de zwarte bonen en 1tl soyasaus toe en roerbak 1'.",
                        "Los wat maïzena en 2 el groentebouillon op in water.",
                        "Voeg toe aan de wok en verhit tot de saus  licht gebonden is ",
                        "Leg de groenten op een serveerschaal zet in de koelkast."
                        , "Verdeel de tofublokjes net voor het serveren over de salade."
                ),
                List.of(
                        new Ingredient(tofoe, new Hoeveelheid(50, GRAM)),
                        new Ingredient(look, new Hoeveelheid(0.5, TEEN)),
                        new Ingredient(broccoli, new Hoeveelheid(0.1, STUK)),
                        new Ingredient(peulErwten, new Hoeveelheid(30, GRAM)),
                        new Ingredient(zwarteBonen, new Hoeveelheid(1, THEELEPEL))
                )
        );
        recept.addLabel(VEGAN);
        recept.addLabel(GLUTENVRIJ);
        recept.addLabel(LIGHT);
        recepten.add(recept);
        recept = new Recept(
                "Gemengde roergebakken groenten",
                Duration.ofMinutes(20),
                1,
                List.of(
                        "Snij de pepertjes diagonaal en doe ze in een schaaltje met 2 el azijn, als dipsaus.",
                        "Snij bloemkool, brocolli, paprika en sjalot.",
                        "Wok de groenten toe ze bijtgaar zijn",
                        "Voeg 1tl soyasaus toe'."
                ),
                List.of(
                        new Ingredient(sjalot, new Hoeveelheid(0.25, STUK)),
                        new Ingredient(look, new Hoeveelheid(1, TEEN)),
                        new Ingredient(broccoli, new Hoeveelheid(0.1, STUK)),
                        new Ingredient(peulErwten, new Hoeveelheid(30, GRAM)),
                        new Ingredient(paprika, new Hoeveelheid(0.25, STUK)),
                        new Ingredient(babymais, new Hoeveelheid(0.25, STUK)),
                        new Ingredient(pepertje, new Hoeveelheid(2, STUK)),
                        new Ingredient(bloemkool, new Hoeveelheid(0.1, STUK))
                )
        );
        recept.addLabel(VIS);
        recept.addLabel(GLUTENVRIJ);
        recept.addLabel(LIGHT);
        recepten.add(recept);

        // We stellen menu's samen voor 8 weken
        int weken = 8;
        for (int w = 0; w < weken; w++) {
            // weekaanbod van 2 weken geleden tot binnen 6 weken
            // prijs tussen 8 en 12
            WeekAanbod aanbod = new WeekAanbod(YearWeek.now().plusWeeks(w - 2), 8 + Math.random() * 4);
            // neem  willekeurige recepten
            Collections.shuffle(recepten);
            Iterator<Recept> r = recepten.iterator();
            // weekaanbod uit het verleden is volledig, uit de toekomst niet
            int size = w < 3 ? WeekAanbod.SIZE : (int) (WeekAanbod.SIZE * Math.random());
            for (int i = 0; i < size; i++) {
                aanbod.voegToe(r.next(), i + 1);
            }
            planning.add(aanbod);
        }

    }

    List<Recept> getRecepten() {
        return recepten;
    }

    List<Contract> getContracten() {
        return contracten;
    }

    List<WeekAanbod> getPlanning() {
        return planning;
    }

    private void voegContractenToe() {
        contracten.add(new Contract(
                new Leverancier("Boer Koekoek", new ContactInfo(
                        new Adres("Vorte Koestraat", "12", new Gemeente("9112", "Sinaai"), lattitude, longitude, position), "bestel@koekoek.be",
                        "+3237777645"),
                        "BE0987333873"
                        , 5),
                1,
                LocalDate.of(2017, 3, 5)));
        contracten.add(new Contract(new Leverancier("Fred Willemssen", new ContactInfo(
                new Adres("Kettermuit", "1", new Gemeente("9100", "Sint-Niklaas"), lattitude, longitude, position), "fred"
                + ".willemssen@gmail.com",
                "+3237771059"),
                "BE0386020522", 7), 2, LocalDate.of(2017, 5, 3)));
        contracten.add(new Contract(new Leverancier("Filip Kruchten", new ContactInfo(
                new Adres("Boechoutdreef", "14", new Gemeente("2150", "Borsbeek"), lattitude, longitude, position), "Filip007@hotmail"
                + ".com",
                "+3235675656"),
                "BE0784997689", 6), 3, LocalDate.of(2017, 5, 30)));
    }


    // Methode wordt gebruikt om contractperiodes aan te maken.
    private void maakProductContractPeriodes(
            Collection<Contract> contracten, Product prod, double prijs) {
        Hoeveelheid hoeveelheid = prod.getStandaardHoeveelheid();
        Random random = new Random();
        // used to make sure that there is at least one contract valid today
        boolean first = true;
        for (Contract contract : contracten) {
            LocalDate start = LocalDate.now().minusWeeks(2);
            int weeks = 8;
            if (!first) {
                start.plusWeeks(random.nextInt(weeks / 2));
                weeks = random.nextInt(weeks);
            } else {
                first = false;
            }
            double variance = 0.1;
            final ContractPeriode periode = new ContractPeriode(
                    prijs * (1.0 - variance) + random.nextDouble() * prijs * 2 * variance,
                    start,
                    start.plusWeeks(weeks),
                    new Hoeveelheid(hoeveelheid.getAantal() * random.nextInt(2000), hoeveelheid.getEenheid()),
                    prod,
                    contract
            );
            contract.add(periode);
        }
    }

}