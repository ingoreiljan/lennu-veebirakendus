#### CGI proovitöö


Töö eesmärk luua lennuplaneerija veebirakendus. Järgnevalt täpsem ülesanne:

Ülesandeks on luua lennureisijale lennu planeerimise ja lennukis istekohtade soovitamise
veebirakendus.
Reisija soovib lennata sihtkohta ja peab saama rakendada erinevaid filtreid, mille alusel talle lende
soovitatakse.
Lisaks peab rakendus soovitama lennukis istekohti, võttes arvesse tema eelistusi (kas ta eelistab
istuda akna all, rohkem jalaruumi, lähemal väljapääsule jne). Istekoha soovitamine peab toimuma
lennuki istekohtade plaanil. Juba kinni olevad istekohad võiks genereerida juhuslikult, näited, millega
kohtade soovitamisel võiks arvestada, on välja toodud allpool.

Tehnoloogiad
Ülesande lahendamiseks ei ole ette nähtud kindlat front-end raamistikku. Rakenduse back-endis
tuleks kasutada Spring Boot’i ning viimast Java LTS versiooni. Tuleb kasutada versioonikontrolli (Git).

Lahenduse etapid
Lennu valimine
Kasutaja peaks alguses nägema lennuplaani kõigi lendudega. Kasutaja peab saama lennuplaani
filtreerida, näited filtritest, mida võib rakendada (nimekiri ei ole lõplik)
• Sihtkoht
• Kuupäev
• Lennuaeg
• Hind
Istekohtade soovitamine
Kui lend on valitud, peab kasutajale soovitama istekoha(d), sõltuvalt sellest, mitmele inimesele ta
soovib piletid osta. Soovitused tuleks kuvada lennuki istekohtade plaanil. Lennuki suuruse ja istmete
konfiguratsiooni võib vabalt valida, juba hõivatud istekohad peaksid olema genereeritud juhuslikult.
Siinkohal võiks arvestada järgmiste võimalike filtritega (nimekiri ei ole lõplik)
• Istekoht akna all
• Rohkem jalaruumi
• Lähedal väljapääsule
• Istekohad kõrvuti (kui ostetakse korraga mitu piletit)
