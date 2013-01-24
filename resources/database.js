// Inject data : mongo mercenary resources/database.js

var items = [
    {
        "id": 1,
        "artist_mbid": "2356659d-39a3-4529-8ac4-79a67d924877",
        "artist_name": "Brooke Cook",
        "artist_playmeid": 78,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.41649737185798585,
        "duration": 181.47,
        "end_of_fade_in": 0.40674866177141666,
        "energy": 0.19019201747141778,
        "song_hotttnesss": 0.3413305268622935,
        "song_id": "66a1a9c0-d21f-470e-847e-b47bc14ae87b",
        "title": "Ut augue sed.",
        "track_id": "c86a4436-3e41-4ee6-9472-31710bf59684",
        "year": 2010
    },
    {
        "id": 2,
        "artist_mbid": "443fe11c-d6e4-4910-aa34-62975778d64e",
        "artist_name": "Avery Ogden",
        "artist_playmeid": 89,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.06273719086311758,
        "duration": 222.19,
        "end_of_fade_in": 1.3000802965834737,
        "energy": 0.6542725381441414,
        "song_hotttnesss": 0.46304801758378744,
        "song_id": "ef9d058f-dfea-4c36-81be-947f48734993",
        "title": "Zzril te vulputate.",
        "track_id": "2243d3de-d93c-4b8e-9b7d-cd80a41c9e71",
        "year": 1981
    },
    {
        "id": 3,
        "artist_mbid": "3a50494f-4ea3-4323-9146-822dba57eac4",
        "artist_name": "Mya Gardner",
        "artist_playmeid": 23,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.7399710842873901,
        "duration": 290.27,
        "end_of_fade_in": 0.07921354472637177,
        "energy": 0.18807573290541768,
        "song_hotttnesss": 0.6544342027045786,
        "song_id": "e468ea44-ceca-4fc6-8767-c5a268e3740b",
        "title": "Nulla commodo consequat.",
        "track_id": "427c3af6-304f-43c9-ac80-97c904e266d2",
        "year": 1979
    },
    {
        "id": 4,
        "artist_mbid": "bad06ba0-d8b7-4e7f-9705-b14c52d4e258",
        "artist_name": "Julia Thornton",
        "artist_playmeid": 84,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.18358758930116892,
        "duration": 342.88,
        "end_of_fade_in": 0.017614548560231924,
        "energy": 0.5129978843033314,
        "song_hotttnesss": 0.5845485308673233,
        "song_id": "db0584f7-7d1f-4c57-b7b5-354cb5ae9a5c",
        "title": "Ad sit delenit.",
        "track_id": "341e2912-0553-4519-b5a8-ea9377bea58a",
        "year": 1970
    },
    {
        "id": 5,
        "artist_mbid": "cbf7780c-f63c-4961-9dec-d7a8f5b26686",
        "artist_name": "Caroline Galbraith",
        "artist_playmeid": 48,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.6409729924052954,
        "duration": 171.07,
        "end_of_fade_in": 0.94235725607723,
        "energy": 0.12313166609965265,
        "song_hotttnesss": 0.7519595883786678,
        "song_id": "04a08367-845d-497a-a058-9a15e27489e4",
        "title": "Veniam suscipit odio.",
        "track_id": "9d37cf10-ab50-4edf-b2ce-0f4d571fbb64",
        "year": 1994
    },
    {
        "id": 6,
        "artist_mbid": "8cde751c-588c-445f-b33b-228b751f6ce0",
        "artist_name": "Abigail Milton",
        "artist_playmeid": 71,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.1242529689334333,
        "duration": 334.6,
        "end_of_fade_in": 1.1430909167975187,
        "energy": 0.7482441389001906,
        "song_hotttnesss": 0.08994635217823088,
        "song_id": "c6a3a136-e1f8-407c-9075-38147b2c25b0",
        "title": "Dolore in blandit.",
        "track_id": "c1ecb0c5-a3a7-448e-8ea8-95971c956c2f",
        "year": 1999
    },
    {
        "id": 7,
        "artist_mbid": "8a9a8c89-be32-428d-b710-34d60bfb932c",
        "artist_name": "Chloe Gibbs",
        "artist_playmeid": 78,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.5037844055332243,
        "duration": 247.69,
        "end_of_fade_in": 0.6440798495896161,
        "energy": 0.9878576411865652,
        "song_hotttnesss": 0.48982868646271527,
        "song_id": "461bc5d9-da2f-400e-9c11-c5705bd3bf34",
        "title": "Dolor nonummy consequat.",
        "track_id": "97e9baca-6519-466c-b03a-933da34fd5d4",
        "year": 2003
    },
    {
        "id": 8,
        "artist_mbid": "36bcb8d0-8bec-4b95-af14-a817d4279f7f",
        "artist_name": "Brooklyn Gate",
        "artist_playmeid": 19,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.39316345867700875,
        "duration": 271.69,
        "end_of_fade_in": 0.29018833162263036,
        "energy": 0.6757620254065841,
        "song_hotttnesss": 0.6729945128317922,
        "song_id": "1eb17bc2-3b9e-4273-af0e-a4bcc59a7be7",
        "title": "Ipsum zzril eu.",
        "track_id": "36e82423-c9f9-4a03-a303-3999ec09da5d",
        "year": 2002
    },
    {
        "id": 9,
        "artist_mbid": "f01f595a-257f-479f-b450-7fb6c2348ab6",
        "artist_name": "Sophie Higgins",
        "artist_playmeid": 37,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.5829061332624406,
        "duration": 248.76,
        "end_of_fade_in": 0.07897957833483815,
        "energy": 0.2578183184377849,
        "song_hotttnesss": 0.14151467755436897,
        "song_id": "f244f099-d007-442e-8658-1a04820e3715",
        "title": "Iusto hendrerit aliquip.",
        "track_id": "c0ad5f55-0096-4e6e-b1ea-5b172c3973f0",
        "year": 1993
    },
    {
        "id": 10,
        "artist_mbid": "b04727f0-70fa-460e-8678-ae87fd7531d9",
        "artist_name": "Peyton Cramer",
        "artist_playmeid": 37,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.8155400764662772,
        "duration": 209.69,
        "end_of_fade_in": 0.3288839212618768,
        "energy": 0.43125409819185734,
        "song_hotttnesss": 0.14883880014531314,
        "song_id": "0228881a-d139-4cd5-8dfa-de63f74da18b",
        "title": "Nulla nulla magna.",
        "track_id": "85091c9b-e0fd-4750-8438-2a1b7d5bea76",
        "year": 1983
    },
    {
        "id": 11,
        "artist_mbid": "0a8c606f-8784-4395-bba7-1f439d48e7e2",
        "artist_name": "Grace Milton",
        "artist_playmeid": 31,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.11857536085881293,
        "duration": 167.92000000000002,
        "end_of_fade_in": 1.213476010132581,
        "energy": 0.592051338404417,
        "song_hotttnesss": 0.7558385704178363,
        "song_id": "4f8b07fc-c9cf-4832-8cef-ea23643976b7",
        "title": "Hendrerit dignissim quis.",
        "track_id": "2ab6405d-957c-4cac-92f9-baf111863914",
        "year": 1965
    },
    {
        "id": 12,
        "artist_mbid": "225b345b-283f-430f-827c-01414d97cad8",
        "artist_name": "Mariah Turner",
        "artist_playmeid": 83,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.4953419321682304,
        "duration": 248.28,
        "end_of_fade_in": 1.3965788381174207,
        "energy": 0.5588253121823072,
        "song_hotttnesss": 0.851530778221786,
        "song_id": "131ce65b-6dca-45bf-9e3d-f9388a79eb89",
        "title": "Dolor euismod sit.",
        "track_id": "6706a197-60ce-4363-a347-e22a05c8b8f1",
        "year": 2006
    },
    {
        "id": 13,
        "artist_mbid": "b60c246e-8c4e-44ba-b2fd-9a9997330232",
        "artist_name": "Serenity Gilmore",
        "artist_playmeid": 62,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.049886843422427773,
        "duration": 259.40999999999997,
        "end_of_fade_in": 0.8154680342413485,
        "energy": 0.31858231499791145,
        "song_hotttnesss": 0.5207313275896013,
        "song_id": "78a8536e-9bad-42e7-aadd-ff51f1b3bc98",
        "title": "Wisi wisi ex.",
        "track_id": "5e8e0c74-16f9-4246-9bbf-51b8f7c0dd38",
        "year": 1994
    },
    {
        "id": 14,
        "artist_mbid": "38b1e052-31b3-47ab-b785-3198edb8d635",
        "artist_name": "Isabelle Oldridge",
        "artist_playmeid": 29,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.5621177284047008,
        "duration": 301.68,
        "end_of_fade_in": 1.019163029268384,
        "energy": 0.9880729594733566,
        "song_hotttnesss": 0.5153489534277469,
        "song_id": "539b44da-8dc1-4b95-a529-8e0d708d37ba",
        "title": "In elit dolor.",
        "track_id": "0ff23053-8c0d-4af0-be8d-09f18dc90ced",
        "year": 2001
    },
    {
        "id": 15,
        "artist_mbid": "7161737a-102f-4bf1-b51f-c98654e92fd2",
        "artist_name": "Genesis Thomson",
        "artist_playmeid": 18,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.9552087665069848,
        "duration": 181.32999999999998,
        "end_of_fade_in": 0.12231727922335267,
        "energy": 0.3881328592542559,
        "song_hotttnesss": 0.06997724180109799,
        "song_id": "a3228b5c-de1f-484b-94bf-4bc04dd57829",
        "title": "Nostrud et laoreet.",
        "track_id": "31d176a5-61e6-4a0e-a6c7-dc077f46ad1d",
        "year": 1964
    },
    {
        "id": 16,
        "artist_mbid": "7ccf6c37-9fd9-415e-aba4-e1e4039e39d7",
        "artist_name": "Madeline Gill",
        "artist_playmeid": 97,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.40880550001747906,
        "duration": 157.56,
        "end_of_fade_in": 0.7658167760819197,
        "energy": 0.041738137137144804,
        "song_hotttnesss": 0.690015313681215,
        "song_id": "ba75ec49-5555-4032-a5b2-ab453b0c179e",
        "title": "Consequat ut diam.",
        "track_id": "a916597a-03c9-471b-86c3-7b9e7598b95d",
        "year": 1974
    },
    {
        "id": 17,
        "artist_mbid": "c1597bd5-d462-4b9a-92a4-2cc47d72654c",
        "artist_name": "Samantha Gardner",
        "artist_playmeid": 79,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.9546921055298299,
        "duration": 213.28,
        "end_of_fade_in": 0.5742152957245708,
        "energy": 0.09272459731437266,
        "song_hotttnesss": 0.725850505521521,
        "song_id": "7b053dcc-7915-415f-af48-925207d4394f",
        "title": "Et elit luptatum.",
        "track_id": "9747b212-5948-4fa2-ab91-59e12f7f3b24",
        "year": 1990
    },
    {
        "id": 18,
        "artist_mbid": "df006a16-142d-44c0-98dd-9f167e192da7",
        "artist_name": "Ashley Mercer",
        "artist_playmeid": 85,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.23638912569731474,
        "duration": 329.21000000000004,
        "end_of_fade_in": 0.7664204160682857,
        "energy": 0.6782308779656887,
        "song_hotttnesss": 0.8391957888379693,
        "song_id": "f0c4e45a-e3aa-4abf-98d3-90b6cf043b36",
        "title": "Nulla hendrerit tation.",
        "track_id": "54aa975f-b26a-4c72-893a-092721bb4b66",
        "year": 1998
    },
    {
        "id": 19,
        "artist_mbid": "46d44e64-d8fa-48e0-b408-fa0e4e6dea7f",
        "artist_name": "Sofia Galbraith",
        "artist_playmeid": 51,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.0791141411755234,
        "duration": 295.3,
        "end_of_fade_in": 1.1303749061189592,
        "energy": 0.6421196481678635,
        "song_hotttnesss": 0.2864795762579888,
        "song_id": "6f1523ea-3124-4e78-9eb1-e679d9d11974",
        "title": "Velit et eu.",
        "track_id": "ffd0306d-8423-416a-97b2-d5ed7f1a0111",
        "year": 2008
    },
    {
        "id": 20,
        "artist_mbid": "b1bfe771-0576-4aab-9829-683fdc9bf252",
        "artist_name": "Sophia Davidson",
        "artist_playmeid": 40,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.789843755075708,
        "duration": 138.56,
        "end_of_fade_in": 1.7625969117507339,
        "energy": 0.5340969217941165,
        "song_hotttnesss": 0.09263629908673465,
        "song_id": "5aa8937f-4d83-4cd9-8e48-b1f7a8d5aaec",
        "title": "Volutpat ut iusto.",
        "track_id": "04e2b11e-f87e-4b27-8f3e-e884ae9a92aa",
        "year": 1992
    },
    {
        "id": 21,
        "artist_mbid": "c9af3fbb-1023-4659-920b-2135c05699ca",
        "artist_name": "Bella Gilson",
        "artist_playmeid": 11,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.9118592692539096,
        "duration": 143.84,
        "end_of_fade_in": 1.0738742938265204,
        "energy": 0.8511874624527991,
        "song_hotttnesss": 0.9851211200002581,
        "song_id": "b1c1ce72-7b1d-48ff-a067-1106065ee9d5",
        "title": "Ad qui duis.",
        "track_id": "ecf1a75c-2e5e-4f29-bc24-2e276ec019c4",
        "year": 1968
    },
    {
        "id": 22,
        "artist_mbid": "a10b709a-b350-404a-8f85-7d1d136915a2",
        "artist_name": "Elizabeth Oswald",
        "artist_playmeid": 16,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.09222347033210099,
        "duration": 153.99,
        "end_of_fade_in": 0.6951570324599743,
        "energy": 0.002750556683167815,
        "song_hotttnesss": 0.006367478519678116,
        "song_id": "5d38f7b6-c095-4952-90dc-b87ee9f9822d",
        "title": "Delenit laoreet delenit.",
        "track_id": "9fbaeef0-d8a3-4038-ae1b-ae36d2a52e0f",
        "year": 1950
    },
    {
        "id": 23,
        "artist_mbid": "528f98f4-2b58-4f05-b1bf-3d68bab30ac4",
        "artist_name": "Jessica Carrington",
        "artist_playmeid": 70,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.9872972050216049,
        "duration": 187.39,
        "end_of_fade_in": 1.4654775112867355,
        "energy": 0.8632255855482072,
        "song_hotttnesss": 0.8681974259670824,
        "song_id": "1a5da09c-1ca8-4f80-97af-57615422e62d",
        "title": "Amet consectetuer augue.",
        "track_id": "75902b94-dd40-4c91-909e-b074e28ce19d",
        "year": 1957
    },
    {
        "id": 24,
        "artist_mbid": "be8d513d-c855-437f-ab18-26a18dc428e4",
        "artist_name": "Alexa Goodman",
        "artist_playmeid": 27,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.5578605148475617,
        "duration": 266.11,
        "end_of_fade_in": 1.5027935630641878,
        "energy": 0.9851187851745635,
        "song_hotttnesss": 0.3515438660979271,
        "song_id": "51e30f5a-2e14-44ea-b910-dc169d7161e8",
        "title": "Ut zzril iusto.",
        "track_id": "9f8a78c3-08bf-48b5-a1aa-b83ea1f2db3b",
        "year": 1987
    },
    {
        "id": 25,
        "artist_mbid": "0250a369-ad0e-42ba-a455-4f43b6c7fc42",
        "artist_name": "Peyton Oldridge",
        "artist_playmeid": 69,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.28897269372828305,
        "duration": 127.68,
        "end_of_fade_in": 1.5966787822544575,
        "energy": 0.6955514042638242,
        "song_hotttnesss": 0.722930395975709,
        "song_id": "1488ca0e-c5c3-4a78-867b-8ed32d9097a4",
        "title": "Dolore nonummy duis.",
        "track_id": "aaf5ec8c-407f-45b0-90a9-662348a0cbe1",
        "year": 1956
    },
    {
        "id": 26,
        "artist_mbid": "6fcf9917-4e1e-426f-958e-fe31a611d156",
        "artist_name": "Jocelyn Wood",
        "artist_playmeid": 5,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.34698325861245394,
        "duration": 312.64,
        "end_of_fade_in": 0.35688926884904504,
        "energy": 0.7202648206148297,
        "song_hotttnesss": 0.17502585030160844,
        "song_id": "edd94cc0-1282-487f-a5ac-80c5f91962b3",
        "title": "Nostrud tincidunt adipiscing.",
        "track_id": "b083b0d9-b7a3-4a02-a5c5-75c080e5c556",
        "year": 1957
    },
    {
        "id": 27,
        "artist_mbid": "c2627154-89f8-44a0-b0e5-503cd61b1887",
        "artist_name": "Katherine Osborne",
        "artist_playmeid": 31,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.14191843220032752,
        "duration": 245.26999999999998,
        "end_of_fade_in": 1.6495464476756752,
        "energy": 0.5459484525490552,
        "song_hotttnesss": 0.6292183345649391,
        "song_id": "256825f0-f9b7-44f1-8c23-93e57dcfccec",
        "title": "At vel nonummy.",
        "track_id": "3dc45f1b-86fd-4e97-81a1-fed847aa3ff3",
        "year": 2009
    },
    {
        "id": 28,
        "artist_mbid": "ed5f0f75-fd08-4b79-87dd-417b9c5bbf6f",
        "artist_name": "Camila Brooks",
        "artist_playmeid": 45,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.6016498149838299,
        "duration": 231.93,
        "end_of_fade_in": 0.664659645408392,
        "energy": 0.2453204644843936,
        "song_hotttnesss": 0.39524867036379874,
        "song_id": "5282c642-990b-4f8d-a119-ecaf4cee7580",
        "title": "Ut nonummy aliquam.",
        "track_id": "9c3234b7-d9b1-4e3d-9ac8-acfccc69b5eb",
        "year": 1973
    },
    {
        "id": 29,
        "artist_mbid": "43d8079e-b83f-4123-893c-a8b3f7ea5975",
        "artist_name": "Emma Fulton",
        "artist_playmeid": 50,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.29084270307794213,
        "duration": 169.22,
        "end_of_fade_in": 1.4138596765697002,
        "energy": 0.7692513198126107,
        "song_hotttnesss": 0.8181040370836854,
        "song_id": "5e41afcd-cbfd-4076-a767-7ffa06e9c5b5",
        "title": "Te et commodo.",
        "track_id": "8649320a-540e-477f-9480-cf8e08d6cccb",
        "year": 2008
    },
    {
        "id": 30,
        "artist_mbid": "3881bc93-604a-4f92-ba42-80f16dbfc833",
        "artist_name": "Morgan Oswald",
        "artist_playmeid": 21,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.4568361935671419,
        "duration": 177.05,
        "end_of_fade_in": 1.2907318016514182,
        "energy": 0.9331813312601298,
        "song_hotttnesss": 0.25118594872765243,
        "song_id": "69225f87-4ad6-4891-9932-11e01fa1581c",
        "title": "Blandit eu adipiscing.",
        "track_id": "e472e963-e1c7-41c2-8277-bb686b682ee8",
        "year": 2008
    },
    {
        "id": 31,
        "artist_mbid": "9ffec327-285b-4647-bb36-573e78545b29",
        "artist_name": "Kaitlyn Brown",
        "artist_playmeid": 92,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.873969841748476,
        "duration": 171.03,
        "end_of_fade_in": 1.8658938016742468,
        "energy": 0.972328134579584,
        "song_hotttnesss": 0.8174753945786506,
        "song_id": "ccfc7612-2eec-4730-b81e-206569325aeb",
        "title": "Delenit duis nisl.",
        "track_id": "2b1f8308-8048-4502-a6de-c3784cd92107",
        "year": 1992
    },
    {
        "id": 32,
        "artist_mbid": "ea485be9-18e0-42fd-b558-cb4103f99149",
        "artist_name": "Elizabeth Ogden",
        "artist_playmeid": 81,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.21882953867316246,
        "duration": 121.01,
        "end_of_fade_in": 0.7781604439951479,
        "energy": 0.5744464956223965,
        "song_hotttnesss": 0.5838728002272546,
        "song_id": "9aee5b46-ad9c-43d4-9b95-676cd23fb279",
        "title": "Dolor illum sed.",
        "track_id": "00934ba7-43a9-43e1-896f-c00bd807e793",
        "year": 1998
    },
    {
        "id": 33,
        "artist_mbid": "29952536-1e12-4195-a26d-5f08ce97daca",
        "artist_name": "Sydney Mercer",
        "artist_playmeid": 11,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.8051724752876908,
        "duration": 221.38,
        "end_of_fade_in": 0.195110228843987,
        "energy": 0.5689558773301542,
        "song_hotttnesss": 0.03223853139206767,
        "song_id": "3a1de261-5e47-4d3c-a85e-54e5b472b179",
        "title": "Dolor accumsan duis.",
        "track_id": "14fcd512-323c-4bcb-ab7e-3c08309fbbef",
        "year": 2005
    },
    {
        "id": 34,
        "artist_mbid": "f854221b-8d3d-4795-8ffc-ff24eb6cf690",
        "artist_name": "Bailey Walkman",
        "artist_playmeid": 54,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.20248038112185895,
        "duration": 210.86,
        "end_of_fade_in": 1.2707388987764716,
        "energy": 0.20347438915632665,
        "song_hotttnesss": 0.1779557024128735,
        "song_id": "45624fc0-40b5-4395-8eb6-afa1c5f15915",
        "title": "Lorem minim nisl.",
        "track_id": "f5472eb2-1da5-4436-b12e-b344357c6681",
        "year": 1977
    },
    {
        "id": 35,
        "artist_mbid": "6ce3eb2e-4e8f-497d-8b26-ab4930fc385f",
        "artist_name": "Kayla Wesley",
        "artist_playmeid": 15,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.855439750244841,
        "duration": 191.61,
        "end_of_fade_in": 1.9414818147197366,
        "energy": 0.06112570012919605,
        "song_hotttnesss": 0.5419967025518417,
        "song_id": "9579337c-8f80-4c04-ae02-5db7baa46208",
        "title": "Delenit nonummy consequat.",
        "track_id": "35caf6ea-1d41-4895-91e3-c78294e946da",
        "year": 2000
    },
    {
        "id": 36,
        "artist_mbid": "51af2516-64e4-4977-a597-548f90adbc06",
        "artist_name": "Abigail Hardman",
        "artist_playmeid": 84,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.7042780565097928,
        "duration": 273.74,
        "end_of_fade_in": 1.4434622316621244,
        "energy": 0.07097004097886384,
        "song_hotttnesss": 0.45331947365775704,
        "song_id": "3892af68-0e58-496c-8688-d81abe12a311",
        "title": "Accumsan duis delenit.",
        "track_id": "9715da0d-1920-4244-9381-d5e6c772bdd9",
        "year": 2000
    },
    {
        "id": 37,
        "artist_mbid": "a31f3842-28be-475e-9c13-29d0e0675681",
        "artist_name": "Sydney Freeman",
        "artist_playmeid": 55,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.04552551684901118,
        "duration": 131.7,
        "end_of_fade_in": 0.5462890365161002,
        "energy": 0.5712027722038329,
        "song_hotttnesss": 0.09236917202360928,
        "song_id": "c4845a9b-baed-4f2f-944b-d50631f5e679",
        "title": "Et suscipit volutpat.",
        "track_id": "26d1b536-2ecd-4e78-ad27-0d114be2943e",
        "year": 1972
    },
    {
        "id": 38,
        "artist_mbid": "9d755a50-c928-4ca3-8ead-1319dea2822c",
        "artist_name": "Claire Hamphrey",
        "artist_playmeid": 16,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.8559870119206607,
        "duration": 357.62,
        "end_of_fade_in": 1.53047417383641,
        "energy": 0.9846197084989399,
        "song_hotttnesss": 0.060395234962925315,
        "song_id": "71691e61-6e86-46c1-9932-793c7070e85e",
        "title": "Praesent luptatum accumsan.",
        "track_id": "6190e201-829c-4e63-b7c5-f7604ff50337",
        "year": 1999
    },
    {
        "id": 39,
        "artist_mbid": "5bee30f4-9bb7-4759-8af4-4568601aa3ad",
        "artist_name": "Peyton Ford",
        "artist_playmeid": 53,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.8583274201955646,
        "duration": 161.19,
        "end_of_fade_in": 1.924134693108499,
        "energy": 0.14179383544251323,
        "song_hotttnesss": 0.26303077209740877,
        "song_id": "c9f3f100-f9e6-46dc-882c-46dd62fd46b0",
        "title": "Enim accumsan elit.",
        "track_id": "ef074387-d5d1-4041-9e5f-0fc376098d82",
        "year": 1967
    },
    {
        "id": 40,
        "artist_mbid": "d4a1eef0-16f0-4a5e-b23b-7537c8a957ec",
        "artist_name": "Riley Brown",
        "artist_playmeid": 71,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.5640428541228175,
        "duration": 154.82999999999998,
        "end_of_fade_in": 0.15014256862923503,
        "energy": 0.29618430975824594,
        "song_hotttnesss": 0.4631066706497222,
        "song_id": "9ef88f22-072c-4ba9-a35d-803732a495c8",
        "title": "Velit eros dolore.",
        "track_id": "2ef5534f-4ee7-4dad-a9d8-67ee98810b06",
        "year": 1961
    },
    {
        "id": 41,
        "artist_mbid": "4f289a42-a3b6-481c-90e6-f36660a91f37",
        "artist_name": "Brooklyn WifKinson",
        "artist_playmeid": 23,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.390024054562673,
        "duration": 275.40999999999997,
        "end_of_fade_in": 0.3007708047516644,
        "energy": 0.9896566385868937,
        "song_hotttnesss": 0.27351128309965134,
        "song_id": "f23001fb-7ea9-40a6-bdff-c1fc56ad5b20",
        "title": "Augue duis ut.",
        "track_id": "477068cb-1ca3-4d5d-ae3b-f8261c7eb4c9",
        "year": 1967
    },
    {
        "id": 42,
        "artist_mbid": "8b6e1a04-95bf-43ed-b7a4-1cae4d80f01d",
        "artist_name": "Alexandra Miln",
        "artist_playmeid": 38,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.9840133797843009,
        "duration": 122.64,
        "end_of_fade_in": 1.0309735485352576,
        "energy": 0.86988305603154,
        "song_hotttnesss": 0.4445371583569795,
        "song_id": "2740ea60-cb23-4ff3-a4f9-ede29cb4d6ab",
        "title": "Vel ut eros.",
        "track_id": "d85f91b1-e680-487d-8d6a-a598906f851d",
        "year": 1955
    },
    {
        "id": 43,
        "artist_mbid": "407aef2f-5a85-469a-96c5-24e1caf4ac2b",
        "artist_name": "Sophie Hoggarth",
        "artist_playmeid": 76,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.013229427160695195,
        "duration": 198.14,
        "end_of_fade_in": 1.2000046172179282,
        "energy": 0.0841250098310411,
        "song_hotttnesss": 0.13824651134200394,
        "song_id": "170435b9-2a00-47c1-8048-0c35ac4f0b02",
        "title": "Facilisi ad nibh.",
        "track_id": "6c169ef6-a24d-4ed3-9101-bc565cb727d5",
        "year": 1952
    },
    {
        "id": 44,
        "artist_mbid": "877742e8-3d37-4c7f-bccd-9278aa98cb4d",
        "artist_name": "Trinity Galbraith",
        "artist_playmeid": 57,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.7491489849053323,
        "duration": 126.97,
        "end_of_fade_in": 0.36666030902415514,
        "energy": 0.5887498136144131,
        "song_hotttnesss": 0.4815257703885436,
        "song_id": "8c7e93ba-eada-4e34-91a1-3f4f6edc4476",
        "title": "Delenit feugait in.",
        "track_id": "cbb2dd67-70e6-43ae-993f-0565715e659e",
        "year": 1992
    },
    {
        "id": 45,
        "artist_mbid": "c98edcf3-3c14-452d-850a-384ee95ebe5f",
        "artist_name": "Lauren Conors",
        "artist_playmeid": 33,
        "audio_md5": "bf53f8113508a466cd2d3fda18b06368",
        "danceability": 0.9823640314862132,
        "duration": 298.45,
        "end_of_fade_in": 0.5140393893234432,
        "energy": 0.908686826005578,
        "song_hotttnesss": 0.5850530730094761,
        "song_id": "8e03debe-7204-4b81-9dd1-0ddfd30ae9bf",
        "title": "Autem sit ut.",
        "track_id": "5e4ed3a9-0a0e-4a73-ad5c-232ee0a34026",
        "year": 1990
    }
];

for(i = 0; i < items.length; i++) {
    var item = items[i];
    db.items.save(item);
}