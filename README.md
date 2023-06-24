# Szállítószalag (2023. tavasz - magyar, mint idegen nyelv)
- [Feladatlap](https://www.oktatas.hu/bin/content/dload/erettsegi/feladatok_2023tavasz_emelt/e_infma_23maj_fl.pdf#page=10)
- [Forrasok](https://www.oktatas.hu/bin/content/dload/erettsegi/feladatok_2023tavasz_emelt/e_infmafor_23maj_fl.zip)
---
Egy speciális, kör alakú üzemcsarnokban különböző anyagok szállításához körpályán
mozgó szállítószalagot állítottak üzembe. Erre a szalagra bárhol feltehetnek bármilyen anyagot
egy rekeszbe zárva, annak beállításával, hogy hova szánják. A célhelyen a szalagról
automatikusan lekerül a rekesz. A szalag az óramutató járásával egyező irányban mozog, akkor
indul el, ha rekesz kerül rá és addig mozog, amíg van rajta szállítandó rekesz. Az ilyen szállítási
feladatokat kell feldolgoznia.

Rendelkezésére áll a `szallit.txt` nevű adatfájl, amelynek első sorában két egész szám
található, egymástól egy szóközzel elválasztva. Az első a szállítószalag hossza, a második
a szállítószalag egy egységnyi elmozdulásához szükséges idő. A fájl további legfeljebb 1000
sorában soronként négy egész szám található, egymástól szóközzel elválasztva. Az első szám
megadja, hogy mikor tették a szalagra a rekeszt. A következő kettő megmutatja, hogy honnan
hova tart a szállítás (a megtett út a szalag hosszánál mindig kevesebb). Az utolsó pedig
a szállítandó tömeget jelenti. A hosszúságot és a pozíciókat távolságegységben, az időt
időegységben, a tömeget pedig tömegegységben adták meg. Az adatfájl egyetlen adata sem
nagyobb 500-nál.

Például: 
```text
200 3
1 134 64 34
14 22 129 83
14 135 54 21
23 31 40 61
...
```

A példában a fájl első 5 sora látható. Az első sor mutatja, hogy 200 egység hosszú a szalag,
és egy egységnyi távolságot 3 időegység alatt tesz meg. A 2. sor tartalmazza az első rekesz
adatait. A 3. sor szerint a 14. időegységben a 22-es hosszúságegységnél felhelyeznek egy
rekeszt, amely a 129-es hosszúságegységnél kerül le. A rekesz 83 egység tömegű. A rekesz
tehát 129-22=107 egység utat tesz meg, és a 14+107*3=335-ös időegységben ér célba.
A következő sorban szereplő rekesz szintén a 14. időegységben kerül a szalagra, a 135-ös
hosszúságegységtől az 54-es hosszúságegységig halad. A megtett távolság ezért
a 0 hosszúságegységig 200-135 egység, azt követően pedig 54 egység, azaz összesen
119 egységnyi távolságot tesz meg a 21 egység tömegű rekesz.

Készítsen programot, amely az állomány adatait felhasználva az alábbi kérdésekre válaszol!
A program forráskódját mentse `szalag` néven! A program megírásakor a felhasználó által
megadott adatok helyességét, érvényességét nem kell ellenőriznie, és feltételezheti, hogy
a rendelkezésre álló adatok a leírtaknak megfelelnek.

A képernyőre írást igénylő részfeladatok esetén – a mintához tartalmában hasonlóan – írja
ki a képernyőre a feladat sorszámát (például: `2. feladat`), és utaljon a kiírt tartalomra is!
Ha a felhasználótól kér be adatot, jelenítse meg a képernyőn, hogy milyen értéket vár! Mindkét
esetben az ékezetmentes kiírás is elfogadott.

1. Olvassa be a `szallit.txt` állomány adatait, és annak felhasználásával oldja meg
   a következő feladatokat!
2. Kérje be egy szállítás sorszámát, majd írassa ki annak indulási és célhelyét! (A szállításokat
   1-től sorszámozzuk.) 
3. Készítsen függvényt `tav` néven, amely megadja a szállítás távolságát a szalag hosszának,
   valamint az indulási és a célhelynek ismeretében! A függvényt használja fel a későbbi
   feladatok megoldása során. A függvényfejet az alábbiaknak megfelelően készítse el,
   megoldásában az ott szereplő változóneveket használja!
    ```text
   Függvény tav(szalaghossz, indulashelye, erkezeshelye : egész szám): egész szám
    ```   
4. Határozza meg, hogy a rendelkezésre álló szállítások során mekkora volt a legnagyobb
   szállítási távolság! Írja a képernyőre a maximális távolságot és az összes ilyen hosszúságú
   szállítás sorszámát!
5. Adja meg, mekkora tömeg haladt el összesen a 0 pozíciójú hely előtt! Az onnan induló vagy
   oda érkező rekeszeket ne vegye figyelembe!
6. Kérjen be egy időpontot, és határozza meg az adott időpontban szállított rekeszek
   sorszámát! Az éppen akkor induló rekeszeket vegye figyelembe, de a célba érőket ne!
   Ha nem volt szállított rekesz, akkor a rekeszek sorszáma helyett az „üres” szót írja ki!
7. Hozza létre a `tomeg.txt` fájlt, amely megadja, hogy az egyes helyekről összességében
   mennyi tömeget szállítottak el! Azok a helyek ne jelenjenek meg a fájlban, ahonnan nem
   történt szállítás! (A fájlba írt adatok sorrendje tetszőleges.)

Példa a szöveges kimenetek kialakításához:
```text
2. feladat
   Adja meg, melyik adatsorra kíváncsi! 3
   Honnan: 135 Hova: 54
4. feladat
   A legnagyobb távolság: 195
   A maximális távolságú szállítások sorszáma: 31 33
5. feladat
   A kezdőpont előtt elhaladó rekeszek össztömege: 957
6. feladat
   Adja meg a kívánt időpontot! 300
   A szállított rekeszek halmaza: 1 2 3 6 7 10 11
```

Példa az tomeg.txt szöveges állomány tartalmára:
```text
   5 37
   12 35
   16 26
   17 33
   18 41
   22 83
   ...
```
