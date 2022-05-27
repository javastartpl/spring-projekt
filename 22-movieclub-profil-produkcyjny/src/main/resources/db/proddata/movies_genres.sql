use movieclub;

insert into genre (name, description)
values ('Akcja', 'Filmy, w których dużo się dzieje. Idealne na nudny wieczór.'),
       ('Fantasy', 'Filmy ze świata magii i zjawisk nadprzyrodzonych'),
       ('Dramat', 'Filmowe historie, przy których możesz licyć na wzruszające chwile'),
       ('Animacja', 'Historie nie tylko dla najmłodszych');

insert into movie (title, original_title, release_year, promoted, genre_id, youtube_trailer_id, description, short_description, poster)
values ('Avengers', 'The Avengers', 2012, true, 1, 'eOrNdBpGMv8',
        'Nick Fury jest szefem międzynarodowej agencji S.H.I.E.L.D., która czuwa nad światowym bezpieczeństwem. W obliczu globalnego zagrożenia staje przed zadaniem stworzenia drużyny, która podoła najbardziej nieprawdopodobnym wyzwaniom.
	Do swojego zespołu rekrutuje ludzi z niezwykłymi zdolnościami. Znajdą się w nim słynne postaci z uniwersum Marvela - Iron Man, Hulk, Thor, Kapitan Ameryka, Sokole Oko i Czarna Wdowa. Porozumienie w drużynie złożonej z takich indywidualności nie będzie łatwe do osiągnięcia.
	Fury wie jednak, że tylko działając wspólnie mogą ocalić świat przed zniszczeniem.',
        'Grupa superbohaterów, na czele z Thorem, Iron Manem i Hulkiem, łączy siły, by obronić Ziemię przed inwazją kosmitów.', 'avengers.jpg'),
       ('Władca pierścieni', 'The Lord of The Rings', 2001, false, 2, 'V75dMMIW2B4',
        'Młody hobbit Frodo Baggins (Elijah Wood) otrzymuje od swojego wuja magiczny pierścień. Pierścień ten może jego posiadaczowi dać władzę absolutną, dlatego jest tak pożądany przez Saurona (Sala Baker), mrocznego władcę Mordoru.
	Pragnie on rządzić Śródziemiem i zniewolić zamieszkujące je ludy. Jedynym ratunkiem jest zniszczenie tego pierścienia, czego można dokonać tylko i wyłącznie wrzucając go do Szczeliny Zagłady, gdzie został on kiedyś wykuty.
	Frodo, wraz z grupą lojalnych przyjaciół, złożoną z hobbitów, ludzi, czarodzieja, krasnoluda i elfa musi zniszczyć magiczny pierścień.
	Drużyna wyrusza w drogę do Szczeliny Zagłady, co oznacza, że będzie musiała przejść przez terytorium Czarnego Władcy i będzie zmuszona walczyć nie tylko ze złem czającym się wokół, ale i z wewnętrznymi waśniami oraz niszczącym wpływem samego Pierścienia. ',
        'Podróż hobbita z Shire i jego ośmiu towarzyszy, której celem jest zniszczenie potężnego pierścienia pożądanego przez Czarnego Władcę - Saurona.', 'lotr.jpg'),
       ('Forrest Gump', 'Forrest Gump', 1994, false, 3, 'bLvqoHBptjg',
        'Jeszcze nie było filmu, który jak "Forrest Gump" Roberta Zemeckisa z porywającą kreacją Toma Hanksa odniósłby równy sukces kasowy i artystyczny. W ciągu trzech burzliwych dekad Forrest zmienia się z lekceważonego inwalidy w gwiazdę amerykańskiego futbolu;
	z bohatera wojny w Wietnamie staje się królem krewetek; od honorów Białego Domu przechodzi w ramiona ukochanej. Jest odzwierciedleniem naszej epoki, ostatnim niewinnym w czasach, kiedy Ameryka utraciła swoją niewinność. Serce podpowiada mu w sprawach, których nie ogarnie jego umysł.
	Jest człowiekiem zasad, a jego sukcesy inspirują wszystkich. Forrest Gump to historia pewnego życia. ',
        'Historia życia Forresta, chłopca o niskim ilorazie inteligencji z niedowładem kończyn, który staje się miliarderem i bohaterem wojny w Wietnamie.', 'forrest_gump.jpg'),
       ('Joker', 'Joker', 2019, true, 3, 'zAGVQLHvwOY',
        'Historia jednego z cieszących się najgorszą sławą superprzestępców uniwersum DC — Jokera. Przedstawiony przez Phillipsa obraz śledzi losy kultowego czarnego charakteru, człowieka zepchniętego na margines.
	To nie tylko kontrowersyjne studium postaci, ale także opowieść ku przestrodze w szerszym kontekście.',
        'Strudzony życiem komik popada w obłęd i staje się psychopatycznym mordercą.', 'joker.jpg'),
       ('Deadpool', 'Deadpool', 2016, false, 1, 'ONHBaC-pfsk',
        'Ekranizacja jednego z najoryginalniejszych komiksów Marvel Comics. Wade Wilson (Ryan Reynolds) - niegdyś agent służb specjalnych, a obecnie najemnik - poddany zostaje nielegalnemu eksperymentowi, w wyniku którego nabywa niezwykłych mocy samouzdrawiania.
	Odtąd staje się znany jako "Deadpool" i wyposażony w nowe zdolności oraz czarne poczucie humoru wyrusza z misją wymierzenia sprawiedliwości człowiekowi, który niemal zniszczył mu życie. ',
        'Były żołnierz oddziałów specjalnych zostaje poddany niebezpiecznemu eksperymentowi. Niebawem uwalnia swoje alter ego i rozpoczyna polowanie na człowieka, który niemal zniszczył jego życie.', 'deadpool.jpg'),
       ('Król Lew', 'The Lion King', 1994, true, 4, 'AiKgfZBj-Zc', 'Simba jest bardzo ciekawym świata lwiątkiem a zarazem następcą Mufasy, władcy Lwiej Ziemi. Królem pragnie jednak za wszelką cenę zostać Skaza, brat Mufasy. Nienawiść do bratanka popycha go do uknucia podłej intrygi.
	W jej wyniku Mufasa ginie, a Simba w poczuciu winy opuszcza Lwią Ziemię. Wycieńczonego lwa odnajduje dwójka wesołych przyjaciół - surykatka Timon i guziec Pumba. Przekazują młodemu lwu swą wielką życiową mądrość: hakuna matata – czyli „nie martw się”.
	Simba wiedzie z Timonem i Pumbą beztroskie życie do czasu, gdy spotka Nalę, swą przyjaciółkę z dzieciństwa, która mówi mu o okrucieństwach i zniszczeniach w krainie, rządzonej przez Skazę. Mimo to Simba nie może zdecydować się na powrót, bo ciągle ucieka przed przeszłością...
	Czy duch Mufasy pomoże Simbie podjąć właściwą decyzję? ', 'Historia młodego lwa i jego przyjaciół', 'krol_lew.jpg');
