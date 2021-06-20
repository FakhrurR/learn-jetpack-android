package com.fakhrurr.moviecatalogue.utils;

import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.data.MovieEntity;
import com.fakhrurr.moviecatalogue.data.model.movie.detail.DetailMovieResponse;
import com.fakhrurr.moviecatalogue.data.model.movie.detail.GenresItemNowPlaying;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItemNowPlaying;
import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItemTVAiringToday;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.GenresItemTVAiringToday;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DummyData {
    private static final String tvShowData = "[{\"backdrop_path\":\"/6LfVuZBiOOCtqch5Ukspjb9y0EB.jpg\",\"first_air_date\":\"2013-12-02\",\"genre_ids\":[16,35,10765,10759],\"id\":60625,\"name\":\"Rick and Morty\",\"origin_country\":[\"US\"],\"original_language\":\"en\",\"original_name\":\"Rick and Morty\",\"overview\":\"Rick is a mentally-unbalanced but scientifically-gifted old man who has recently reconnected with his family. He spends most of his time involving his young grandson Morty in dangerous, outlandish adventures throughout space and alternate universes. Compounded with Morty's already unstable family life, these events cause Morty much distress at home and school.\",\"popularity\":418.537,\"poster_path\":\"/8kOWDBK6XlPUzckuHDo3wwVRFwt.jpg\",\"vote_average\":8.7,\"vote_count\":4395},{\"backdrop_path\":\"/4LTWJ7WNiSk5SUWhRkHT279026o.jpg\",\"first_air_date\":\"2016-01-21\",\"genre_ids\":[10759,18,10765],\"id\":62643,\"name\":\"DC's Legends of Tomorrow\",\"origin_country\":[\"US\"],\"original_language\":\"en\",\"original_name\":\"DC's Legends of Tomorrow\",\"overview\":\"When heroes alone are not enough ... the world needs legends. Having seen the future, one he will desperately try to prevent from happening, time-traveling rogue Rip Hunter is tasked with assembling a disparate group of both heroes and villains to confront an unstoppable threat — one in which not only is the planet at stake, but all of time itself. Can this ragtag team defeat an immortal threat unlike anything they have ever known?\",\"popularity\":328.024,\"poster_path\":\"/uzQpQGISbtxc047IOssFo5AiDwU.jpg\",\"vote_average\":7.2,\"vote_count\":1622},{\"backdrop_path\":\"/wjw3wrmkjjApu83Y4SxmQ5gP2mZ.jpg\",\"first_air_date\":\"2021-04-11\",\"genre_ids\":[18,16,10759],\"id\":105009,\"name\":\"Tokyo Revengers\",\"origin_country\":[\"JP\"],\"original_language\":\"ja\",\"original_name\":\"東京リベンジャーズ\",\"overview\":\"Takemichi Hanagaki is a freelancer that’s reached the absolute pits of despair in his life. He finds out that the only girlfriend he ever had, in middle school, Hinata Tachibana, had been killed by the ruthless Tokyo Manji Gang. The day after hearing about her death, he’s standing on the station platform and ends up being pushed over onto the tracks by a herd of people. He closes his eyes thinking he’s about to die, but when he opens his eyes back up, he somehow had gone back in time 12 years. Now that he’s back living the best days of his life, Takemichi decides to get revenge on his life.\",\"popularity\":269.839,\"poster_path\":\"/qSEKyf0fWhrCEQ3LTwLqe41eSvR.jpg\",\"vote_average\":8,\"vote_count\":14},{\"backdrop_path\":\"/8vNQ3i2Xa3mrCKn6eq2ce5hhegT.jpg\",\"first_air_date\":\"2019-10-06\",\"genre_ids\":[10765,10759,9648,80],\"id\":89247,\"name\":\"Batwoman\",\"origin_country\":[\"US\"],\"original_language\":\"en\",\"original_name\":\"Batwoman\",\"overview\":\"Kate Kane, armed with a passion for social justice and a flair for speaking her mind, soars onto the streets of Gotham as Batwoman, an out lesbian and highly trained street fighter primed to snuff out the failing city's criminal resurgence. But don't call her a hero yet. In a city desperate for a savior, Kate must overcome her own demons before embracing the call to be Gotham's symbol of hope\",\"popularity\":252.872,\"poster_path\":\"/xjyEpcuDbB1jy0ehNQMBiO8KOdr.jpg\",\"vote_average\":7.3,\"vote_count\":1094},{\"backdrop_path\":\"/xlKKD1TXJvh0YYlVPqqQ3g3ZUjM.jpg\",\"first_air_date\":\"2018-07-01\",\"genre_ids\":[16,10759,10765],\"id\":80020,\"name\":\"Super Dragon Ball Heroes\",\"origin_country\":[\"JP\"],\"original_language\":\"ja\",\"original_name\":\"スーパードラゴンボールヒーローズ\",\"overview\":\"Trunks returns from the future to train with Goku and Vegeta. However, it disappears without warning. Then the mysterious Fu bursts in, telling them that Trunks has been imprisoned in the Prison Planet, a mysterious complex in an unknown place in the universes. The group seeks the dragon balls to free Trunks, but an endless battle awaits them! Will Goku and the others rescue Trunks and escape the Prison Planet?\",\"popularity\":210.987,\"poster_path\":\"/jYeTfpxS3IzgqKkYCjmdCKwq8PW.jpg\",\"vote_average\":7.5,\"vote_count\":1988},{\"backdrop_path\":\"/fPEozMHi64rDQUMJFtojBcCvbrm.jpg\",\"first_air_date\":\"2021-04-11\",\"genre_ids\":[16,35,10759,10765],\"id\":104711,\"name\":\"Edens Zero\",\"origin_country\":[\"JP\"],\"original_language\":\"ja\",\"original_name\":\"エデンズゼロ\",\"overview\":\"At Granbell Kingdom, an abandoned amusement park, Shiki has lived his entire life among machines. But one day, Rebecca and her cat companion Happy appear at the park’s front gates. Little do these newcomers know that this is the first human contact Granbell has had in a hundred years!\\n\\nAs Shiki stumbles his way into making new friends, his former neighbors stir at an opportunity for a robo-rebellion… And when his old homeland becomes too dangerous, Shiki must join Rebecca and Happy on their spaceship and escape into the boundless cosmos.\",\"popularity\":132.49,\"poster_path\":\"/zwj3sFZksoFsKqYPMmqGB95H3XJ.jpg\",\"vote_average\":8,\"vote_count\":3},{\"backdrop_path\":\"/uxmxWA4mmxeAWG8NNiUpGC7W462.jpg\",\"first_air_date\":\"2021-04-11\",\"genre_ids\":[16,35],\"id\":105556,\"name\":\"Don't Toy With Me, Miss Nagatoro\",\"origin_country\":[\"JP\"],\"original_language\":\"ja\",\"original_name\":\"イジらないで、長瀞さん\",\"overview\":\"\\\"A girl in a lower grade just made me cry!\\\" One day, Senpai visits the library after school and becomes the target of a super sadistic junior! The name of the girl who teases, torments, and tantalizes Senpai is \\\"Nagatoro!\\\" She's annoying yet adorable. It's painful, but you still want to be by her side. This is a story about an extremely sadistic and temperamental girl and you'll feel something awaken inside of you.\",\"popularity\":122.97,\"poster_path\":\"/dHSRVAi83iapl4yazkPiyv3atQZ.jpg\",\"vote_average\":7.4,\"vote_count\":9},{\"backdrop_path\":\"/q79U95wgkocoECitZPfRDhZXBNz.jpg\",\"first_air_date\":\"2007-10-14\",\"genre_ids\":[10764],\"id\":14814,\"name\":\"Keeping Up with the Kardashians\",\"origin_country\":[\"US\"],\"original_language\":\"en\",\"original_name\":\"Keeping Up with the Kardashians\",\"overview\":\"A peek inside the exploits and privileged private lives of the blended Kardashian-Jenner family, including sisters Kim, Kourtney and Khloé.\",\"popularity\":105.977,\"poster_path\":\"/nddXOC8wYpIDv7giLzjjqIg8WDA.jpg\",\"vote_average\":5.2,\"vote_count\":260},{\"backdrop_path\":\"/3ILMlmC30QUnYkY3XEBOyJ82Dqu.jpg\",\"first_air_date\":\"2016-04-03\",\"genre_ids\":[10765,10759,35,16],\"id\":65930,\"name\":\"My Hero Academia\",\"origin_country\":[\"JP\"],\"original_language\":\"ja\",\"original_name\":\"僕のヒーローアカデミア\",\"overview\":\"In a world where eighty percent of the population has some kind of super-powered Quirk, Izuku was unlucky enough to be born completely normal. But that won't stop him from enrolling in a prestigious hero academy. Now, he'll get his first taste of brutal rivalry from other schools as he braves the cutthroat, no-holds-barred provisional license exam.\",\"popularity\":102.613,\"poster_path\":\"/phuYuzqWW9ru8EA3HVjE9W2Rr3M.jpg\",\"vote_average\":8.9,\"vote_count\":2974},{\"backdrop_path\":\"/lEWtzTBC6Ks5fdc4RgHRUZxts2w.jpg\",\"first_air_date\":\"2013-04-23\",\"genre_ids\":[35,10759,16,10762],\"id\":45140,\"name\":\"Teen Titans Go!\",\"origin_country\":[\"US\"],\"original_language\":\"en\",\"original_name\":\"Teen Titans Go!\",\"overview\":\"Robin, Starfire, Raven, Beast Boy and Cyborg return in all-new, comedic adventures. They may be super heroes who save the world every day ... but somebody still has to do the laundry!\",\"popularity\":90.371,\"poster_path\":\"/udaLIJ6Na7GOHjvTlyP9JFPTccv.jpg\",\"vote_average\":6.7,\"vote_count\":328},{\"backdrop_path\":\"/en2X3XWGiUwZFe9pH9r06Si3Nbh.jpg\",\"first_air_date\":\"2020-10-11\",\"genre_ids\":[16,9648],\"id\":100281,\"name\":\"Moriarty the Patriot\",\"origin_country\":[\"JP\"],\"original_language\":\"ja\",\"original_name\":\"憂国のモリアーティ\",\"overview\":\"In the late 19th century, the British Empire nobility reigns while its working class suffers at their hands. Sympathetic to their plight, William James Moriarty wants to topple it all. Frustrated by the systemic inequity, Moriarty strategizes to fix the entire nation. Not even consulting detective Sherlock Holmes can stand in his way. It’s time for crime to revolutionize the world!\",\"popularity\":88.417,\"poster_path\":\"/lLcmshfrLg7JUMwMCnp5fuNqtoQ.jpg\",\"vote_average\":6.8,\"vote_count\":8},{\"backdrop_path\":\"/jWXrQstj7p3Wl5MfYWY6IHqRpDb.jpg\",\"first_air_date\":\"1952-12-26\",\"genre_ids\":[10763],\"id\":94722,\"name\":\"Tagesschau\",\"origin_country\":[\"DE\"],\"original_language\":\"de\",\"original_name\":\"Tagesschau\",\"overview\":\"German daily news program, the oldest still existing program on German television.\",\"popularity\":87.467,\"poster_path\":\"/7dFZJ2ZJJdcmkp05B9NWlqTJ5tq.jpg\",\"vote_average\":6.6,\"vote_count\":7},{\"backdrop_path\":\"/rHuXgDmrv4vMKgQZ6pu2E2iLJnM.jpg\",\"first_air_date\":\"2010-07-11\",\"genre_ids\":[35,10764],\"id\":33238,\"name\":\"Running Man\",\"origin_country\":[\"KR\"],\"original_language\":\"ko\",\"original_name\":\"런닝맨\",\"overview\":\"These days, variety entertainment is gradually disappearing. It is one of Korea's representative variety entertainment shows that has been in charge of Sunday evenings for over 10 years. In this program, many stars and members play games and missions together. It is characterized by going around several places. In particular, this program focuses solely on laughter among the many fun elements of entertainment.\\n\\nOpen your eyes! Big fun enters!\\n\\nOpen your mouth!  A big smile enters!\\n\\nOpen your mind! Instructive lesson enters!\",\"popularity\":85.454,\"poster_path\":\"/2Wmmu1MkqxJ48J7aySET9EKEjXz.jpg\",\"vote_average\":8.4,\"vote_count\":106},{\"backdrop_path\":\"/knIHqqoNsDZn2tZrDM3iw3xH9oe.jpg\",\"first_air_date\":\"2021-04-04\",\"genre_ids\":[16,35,10759,10765],\"id\":100567,\"name\":\"Combatants Will Be Dispatched!\",\"origin_country\":[\"JP\"],\"original_language\":\"ja\",\"original_name\":\"戦闘員、派遣します！\",\"overview\":\"Turns out, evil takes initiative! With world domination close at hand, the Kisaragi Corporation turns its sights on interstellar conquest, and who better to take over a magical world than two randomly assigned minions—Combatant Agent Six and his android partner Alice? But Six’s path up the evil corporate ladder won’t be easy—a Demon Lord’s army is hatching its own nefarious plan!\",\"popularity\":83.505,\"poster_path\":\"/tk0LqlgKzc79nWtTmgGz41yu6p3.jpg\",\"vote_average\":7.8,\"vote_count\":4},{\"backdrop_path\":\"/hAX7Rz0vJOwGtGoAIcf9HZsXmcP.jpg\",\"first_air_date\":\"2008-01-28\",\"genre_ids\":[18],\"id\":14069,\"name\":\"In Treatment\",\"origin_country\":[\"US\"],\"original_language\":\"en\",\"original_name\":\"In Treatment\",\"overview\":\"Set within the highly charged confines of individual psychotherapy sessions and centering around Dr. Paul Weston, a psychotherapist who exhibits an insightful, reserved demeanor while treating his patients—but displays a crippling insecurity while counseled by his own therapist.\",\"popularity\":80.992,\"poster_path\":\"/h154oebDAD9sCTlRjvl4Yp9ws9j.jpg\",\"vote_average\":8.1,\"vote_count\":95},{\"backdrop_path\":null,\"first_air_date\":\"1971-04-03\",\"genre_ids\":[10759,10765,10762],\"id\":2661,\"name\":\"Kamen Rider\",\"origin_country\":[\"JP\"],\"original_language\":\"ja\",\"original_name\":\"仮面ライダ\",\"overview\":\"A Japanese anthology series centered around a man who transforms into a bug-themed superhero.\",\"popularity\":80.345,\"poster_path\":\"/o57T19zgZakEpre3d9ddy1UZonp.jpg\",\"vote_average\":5.4,\"vote_count\":53},{\"backdrop_path\":\"/8nzvbgGM1bDqK3fscy86LyOnDcf.jpg\",\"first_air_date\":\"1996-01-08\",\"genre_ids\":[16,35,9648],\"id\":30983,\"name\":\"Case Closed\",\"origin_country\":[\"JP\"],\"original_language\":\"ja\",\"original_name\":\"名探偵コナン\",\"overview\":\"The son of a world famous mystery writer, Jimmy Kudo, has achieved his own notoriety by assisting the local police as a student detective. He has always been able to solve the most difficult of criminal cases using his wits and power of reason.\",\"popularity\":76.833,\"poster_path\":\"/9ve6LW4ltMMpp9WjoR4MGViOp9V.jpg\",\"vote_average\":7.8,\"vote_count\":447},{\"backdrop_path\":\"/odItfoVoACL99EmWmqmWxBCrpXg.jpg\",\"first_air_date\":\"2015-12-05\",\"genre_ids\":[10764,35],\"id\":70672,\"name\":\"Men on a Mission\",\"origin_country\":[\"KR\"],\"original_language\":\"ko\",\"original_name\":\"아는 형님\",\"overview\":\"Male celebs play make-believe as high schoolers, welcoming star transfer students every week and engaging in battles of witty humor and slapstick.\",\"popularity\":75.575,\"poster_path\":\"/a1rnHdqAvEm5NUWJ2SRzBY4Hkt5.jpg\",\"vote_average\":8,\"vote_count\":18},{\"backdrop_path\":\"/lSlL2CAPSDJ9gf2MZX0x2u2inKX.jpg\",\"first_air_date\":\"2021-04-11\",\"genre_ids\":[16,18,10759,10765],\"id\":100565,\"name\":\"86: Eighty Six\",\"origin_country\":[\"JP\"],\"original_language\":\"ja\",\"original_name\":\"８６―エイティシックス―\",\"overview\":\"Called “Juggernaut,” these are the unmanned combat drones developed by the Republic of San Magnolia in answer to the attacks by the autonomous unmanned drones of the neighboring Empire of Giad, the “Legion”. But they’re only unmanned in name. In reality, they are piloted by the Eighty-sixers—those considered to be less than human and treated as mere tools. Determined to achieve his own mysterious ends, Shin, the captain of Spearhead Squadron, which is comprised of Eighty-sixers, continues to fight a hopeless war on a battlefield where only death awaits him.\",\"popularity\":75.461,\"poster_path\":\"/96mUvRlJBYOMBdbn30wtoh7QrpY.jpg\",\"vote_average\":7.7,\"vote_count\":7},{\"backdrop_path\":\"/fOlKY2rpDnoxcWU6a0Z4dpRA61d.jpg\",\"first_air_date\":\"2021-04-03\",\"genre_ids\":[16,18,10765],\"id\":116725,\"name\":\"Vivy -Fluorite Eye's Song-\",\"origin_country\":[\"JP\"],\"original_language\":\"ja\",\"original_name\":\"Vivy -Fluorite Eye's Song-\",\"overview\":\"In the near future, Vivy, a diva-type A.I., went up on stage each day with hopes of putting her heart into her song. One day, the A.I. Matsumoto, who claims to have arrived from 100 years in the future, appears before Vivy with an important request...\",\"popularity\":73.418,\"poster_path\":\"/xRakd62ihUP19NBgWyJzjO26NxE.jpg\",\"vote_average\":8.8,\"vote_count\":5}]";
    private final static String nowPlayData = "[{\"adult\":false,\"backdrop_path\":\"/qi6Edc1OPcyENecGtz8TF0DUr9e.jpg\",\"genre_ids\":[27,9648,53],\"id\":423108,\"original_language\":\"en\",\"original_title\":\"The Conjuring: The Devil Made Me Do It\",\"overview\":\"Paranormal investigators Ed and Lorraine Warren encounter what would become one of the most sensational cases from their files. The fight for the soul of a young boy takes them beyond anything they'd ever seen before, to mark the first time in U.S. history that a murder suspect would claim demonic possession as a defense.\",\"popularity\":4227.714,\"poster_path\":\"/xbSuFiJbbBWCkyCCKIMfuDCA4yV.jpg\",\"release_date\":\"2021-05-25\",\"title\":\"The Conjuring: The Devil Made Me Do It\",\"video\":false,\"vote_average\":8.1,\"vote_count\":2296},{\"adult\":false,\"backdrop_path\":\"/8ChCpCYxh9YXusmHwcE9YzP0TSG.jpg\",\"genre_ids\":[35,80],\"id\":337404,\"original_language\":\"en\",\"original_title\":\"Cruella\",\"overview\":\"In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.\",\"popularity\":5043.806,\"poster_path\":\"/rTh4K5uw9HypmpGslcKd4QfHl93.jpg\",\"release_date\":\"2021-05-26\",\"title\":\"Cruella\",\"video\":false,\"vote_average\":8.6,\"vote_count\":2943},{\"adult\":false,\"backdrop_path\":\"/70AV2Xx5FQYj20labp0EGdbjI6E.jpg\",\"genre_ids\":[80,28],\"id\":637649,\"original_language\":\"en\",\"original_title\":\"Wrath of Man\",\"overview\":\"A cold and mysterious new security guard for a Los Angeles cash truck company surprises his co-workers when he unleashes precision skills during a heist. The crew is left wondering who he is and where he came from. Soon, the marksman's ultimate motive becomes clear as he takes dramatic and irrevocable steps to settle a score.\",\"popularity\":2887.694,\"poster_path\":\"/M7SUK85sKjaStg4TKhlAVyGlz3.jpg\",\"release_date\":\"2021-04-22\",\"title\":\"Wrath of Man\",\"video\":false,\"vote_average\":7.8,\"vote_count\":982},{\"adult\":false,\"backdrop_path\":\"/A0xW7GgeFQoQmPOn7HcHkBQ5nlb.jpg\",\"genre_ids\":[53,28],\"id\":817451,\"original_language\":\"en\",\"original_title\":\"Endangered Species\",\"overview\":\"Jack Halsey takes his wife, their adult kids, and a friend for a dream vacation in Kenya. But as they venture off alone into a wilderness park, their safari van is flipped over by an angry rhino, leaving them injured and desperate. Then, as two of them go in search of rescue, a bloody, vicious encounter with a leopard and a clan of hyenas incites a desperate fight for survival.\",\"popularity\":1716.935,\"poster_path\":\"/ccsSqbpEqr2KK9eMvoeF8ERFCd5.jpg\",\"release_date\":\"2021-05-27\",\"title\":\"Endangered Species\",\"video\":false,\"vote_average\":7,\"vote_count\":31},{\"adult\":false,\"backdrop_path\":\"/z2UtGA1WggESspi6KOXeo66lvLx.jpg\",\"genre_ids\":[878,53,27],\"id\":520763,\"original_language\":\"en\",\"original_title\":\"A Quiet Place Part II\",\"overview\":\"Following the events at home, the Abbott family now face the terrors of the outside world. Forced to venture into the unknown, they realize that the creatures that hunt by sound are not the only threats that lurk beyond the sand path.\",\"popularity\":2266.363,\"poster_path\":\"/4q2hz2m8hubgvijz8Ez0T2Os2Yv.jpg\",\"release_date\":\"2021-05-21\",\"title\":\"A Quiet Place Part II\",\"video\":false,\"vote_average\":7.3,\"vote_count\":294},{\"adult\":false,\"backdrop_path\":\"/9WlJFhOSCPnaaSmsrv0B4zA8iUb.jpg\",\"genre_ids\":[28,80,878,27,53],\"id\":503736,\"original_language\":\"en\",\"original_title\":\"Army of the Dead\",\"overview\":\"Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble: venturing into the quarantine zone to pull off the greatest heist ever attempted.\",\"popularity\":1904.909,\"poster_path\":\"/z8CExJekGrEThbpMXAmCFvvgoJR.jpg\",\"release_date\":\"2021-05-14\",\"title\":\"Army of the Dead\",\"video\":false,\"vote_average\":6.5,\"vote_count\":1614},{\"adult\":false,\"backdrop_path\":\"/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg\",\"genre_ids\":[28,14,12],\"id\":460465,\"original_language\":\"en\",\"original_title\":\"Mortal Kombat\",\"overview\":\"Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.\",\"popularity\":1897.772,\"poster_path\":\"/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg\",\"release_date\":\"2021-04-07\",\"title\":\"Mortal Kombat\",\"video\":false,\"vote_average\":7.5,\"vote_count\":3036},{\"adult\":false,\"backdrop_path\":\"/bwdADfvTcWAkOpX9wDV7fG9XccW.jpg\",\"genre_ids\":[53,18,9648],\"id\":522406,\"original_language\":\"en\",\"original_title\":\"Flashback\",\"overview\":\"Frederick Fitzell is living his best life—until he starts having horrific visions of Cindy, a girl who vanished in high school. After reaching out to old friends with whom he used to take a mystery drug called Mercury, Fredrick realizes the only way to stop the visions lies deep within his own memories, so he embarks on a terrifying mental odyssey to learn the truth.\",\"popularity\":1539.251,\"poster_path\":\"/nc7szo7ChOknEk8qCkABJyNgl5y.jpg\",\"release_date\":\"2021-06-03\",\"title\":\"Flashback\",\"video\":false,\"vote_average\":6.8,\"vote_count\":50},{\"adult\":false,\"backdrop_path\":\"/inJjDhCjfhh3RtrJWBmmDqeuSYC.jpg\",\"genre_ids\":[28,878,12],\"id\":399566,\"original_language\":\"en\",\"original_title\":\"Godzilla vs. Kong\",\"overview\":\"In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.\",\"popularity\":1731.329,\"poster_path\":\"/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg\",\"release_date\":\"2021-03-24\",\"title\":\"Godzilla vs. Kong\",\"video\":false,\"vote_average\":8,\"vote_count\":6048},{\"adult\":false,\"backdrop_path\":\"/jw6ASGRT2gi8EjCImpGtbiJ9NQ9.jpg\",\"genre_ids\":[27],\"id\":632357,\"original_language\":\"en\",\"original_title\":\"The Unholy\",\"overview\":\"Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.\",\"popularity\":1887.621,\"poster_path\":\"/bShgiEQoPnWdw4LBrYT5u18JF34.jpg\",\"release_date\":\"2021-03-31\",\"title\":\"The Unholy\",\"video\":false,\"vote_average\":7,\"vote_count\":983},{\"adult\":false,\"backdrop_path\":\"/7JENyUT8ABxcvrcijDBVpdjgCY9.jpg\",\"genre_ids\":[9648,53,27],\"id\":602734,\"original_language\":\"en\",\"original_title\":\"Spiral: From the Book of Saw\",\"overview\":\"Working in the shadow of an esteemed police veteran, brash Detective Ezekiel “Zeke” Banks and his rookie partner take charge of a grisly investigation into murders that are eerily reminiscent of the city’s gruesome past.  Unwittingly entrapped in a deepening mystery, Zeke finds himself at the center of the killer’s morbid game.\",\"popularity\":1641.249,\"poster_path\":\"/lcyKve7nXRFgRyms9M1bndNkKOx.jpg\",\"release_date\":\"2021-05-12\",\"title\":\"Spiral: From the Book of Saw\",\"video\":false,\"vote_average\":6.4,\"vote_count\":381},{\"adult\":false,\"backdrop_path\":\"/mYM8x2Atv4MaLulaV0KVJWI1Djv.jpg\",\"genre_ids\":[28,80,53],\"id\":804435,\"original_language\":\"en\",\"original_title\":\"Vanquish\",\"overview\":\"Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangsters—or she may never see her child again.\",\"popularity\":893.961,\"poster_path\":\"/AoWY1gkcNzabh229Icboa1Ff0BM.jpg\",\"release_date\":\"2021-04-16\",\"title\":\"Vanquish\",\"video\":false,\"vote_average\":5.9,\"vote_count\":124},{\"adult\":false,\"backdrop_path\":\"/u2J7HxrT9QtzIy37S5q3RdrzxXD.jpg\",\"genre_ids\":[28,80,18],\"id\":615457,\"original_language\":\"en\",\"original_title\":\"Nobody\",\"overview\":\"Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \\\"nobody.\\\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.\",\"popularity\":1233.282,\"poster_path\":\"/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg\",\"release_date\":\"2021-03-26\",\"title\":\"Nobody\",\"video\":false,\"vote_average\":8.4,\"vote_count\":2114},{\"adult\":false,\"backdrop_path\":\"/ouOojiypBE6CD1aqcHPVq7cJf2R.jpg\",\"genre_ids\":[53,18,28,9648],\"id\":578701,\"original_language\":\"en\",\"original_title\":\"Those Who Wish Me Dead\",\"overview\":\"A young boy finds himself pursued by two assassins in the Montana wilderness with a survival expert determined to protecting him - and a forest fire threatening to consume them all.  Download : https://hd.movietv.biz/movie/578701/those-who-wish-me-dead.html\",\"popularity\":1130.103,\"poster_path\":\"/xCEg6KowNISWvMh8GvPSxtdf9TO.jpg\",\"release_date\":\"2021-05-05\",\"title\":\"Those Who Wish Me Dead\",\"video\":false,\"vote_average\":7,\"vote_count\":508},{\"adult\":false,\"backdrop_path\":\"/620hnMVLu6RSZW6a5rwO8gqpt0t.jpg\",\"genre_ids\":[16,35,10751,14],\"id\":508943,\"original_language\":\"en\",\"original_title\":\"Luca\",\"overview\":\"Luca and his best friend Alberto experience an unforgettable summer on the Italian Riviera. But all the fun is threatened by a deeply-held secret: they are sea monsters from another world just below the water’s surface.\",\"popularity\":1336.803,\"poster_path\":\"/eSQvGZPUpDk9oCfi2R6NKzqPAV5.jpg\",\"release_date\":\"2021-06-17\",\"title\":\"Luca\",\"video\":false,\"vote_average\":8.4,\"vote_count\":348},{\"adult\":false,\"backdrop_path\":\"/xPpXYnCWfjkt3zzE0dpCNME1pXF.jpg\",\"genre_ids\":[14,16,28,12,18],\"id\":635302,\"original_language\":\"ja\",\"original_title\":\"劇場版「鬼滅の刃」無限列車編\",\"overview\":\"Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!\",\"popularity\":1036.879,\"poster_path\":\"/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg\",\"release_date\":\"2020-10-16\",\"title\":\"Demon Slayer -Kimetsu no Yaiba- The Movie: Mugen Train\",\"video\":false,\"vote_average\":8.4,\"vote_count\":1219},{\"adult\":false,\"backdrop_path\":\"/5Zv5KmgZzdIvXz2KC3n0MyecSNL.jpg\",\"genre_ids\":[28,53,80],\"id\":634528,\"original_language\":\"en\",\"original_title\":\"The Marksman\",\"overview\":\"Jim Hanson’s quiet life is suddenly disturbed by two people crossing the US/Mexico border – a woman and her young son – desperate to flee a Mexican cartel. After a shootout leaves the mother dead, Jim becomes the boy’s reluctant defender. He embraces his role as Miguel’s protector and will stop at nothing to get him to safety, as they go on the run from the relentless assassins.\",\"popularity\":756.179,\"poster_path\":\"/6vcDalR50RWa309vBH1NLmG2rjQ.jpg\",\"release_date\":\"2021-01-15\",\"title\":\"The Marksman\",\"video\":false,\"vote_average\":7.4,\"vote_count\":581},{\"adult\":false,\"backdrop_path\":\"/xXHZeb1yhJvnSHPzZDqee0zfMb6.jpg\",\"genre_ids\":[28,12,53],\"id\":385128,\"original_language\":\"en\",\"original_title\":\"F9\",\"overview\":\"Dominic Toretto and his crew battle the most skilled assassin and high-performance driver they've ever encountered: his forsaken brother.\",\"popularity\":918.75,\"poster_path\":\"/bOFaAXmWWXC3Rbv4u4uM9ZSzRXP.jpg\",\"release_date\":\"2021-05-19\",\"title\":\"F9\",\"video\":false,\"vote_average\":7.9,\"vote_count\":141},{\"adult\":false,\"backdrop_path\":\"/9ns9463dwOeo1CK1JU2wirL5Yi1.jpg\",\"genre_ids\":[35,10751,16],\"id\":587807,\"original_language\":\"en\",\"original_title\":\"Tom & Jerry\",\"overview\":\"Tom the cat and Jerry the mouse get kicked out of their home and relocate to a fancy New York hotel, where a scrappy employee named Kayla will lose her job if she can’t evict Jerry before a high-class wedding at the hotel. Her solution? Hiring Tom to get rid of the pesky mouse.\",\"popularity\":668.256,\"poster_path\":\"/8XZI9QZ7Pm3fVkigWJPbrXCMzjq.jpg\",\"release_date\":\"2021-02-11\",\"title\":\"Tom & Jerry\",\"video\":false,\"vote_average\":7.2,\"vote_count\":1503},{\"adult\":false,\"backdrop_path\":\"/z8TvnEVRenMSTemxYZwLGqFofgF.jpg\",\"genre_ids\":[28,14,12],\"id\":458576,\"original_language\":\"en\",\"original_title\":\"Monster Hunter\",\"overview\":\"A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.\",\"popularity\":641.985,\"poster_path\":\"/1UCOF11QCw8kcqvce8LKOO6pimh.jpg\",\"release_date\":\"2020-12-03\",\"title\":\"Monster Hunter\",\"video\":false,\"vote_average\":7,\"vote_count\":1753}]";
    private final static String detailAiring = "{\"backdrop_path\":\"/8vNQ3i2Xa3mrCKn6eq2ce5hhegT.jpg\",\"created_by\":[{\"id\":88967,\"credit_id\":\"5cd3f4fe0e0a265dee60bd06\",\"name\":\"Greg Berlanti\",\"gender\":2,\"profile_path\":\"/1T24SiIIDMa9gAmq7QaYwZywq4y.jpg\"},{\"id\":1237436,\"credit_id\":\"5d87f59c172d7f001749c54a\",\"name\":\"Caroline Dries\",\"gender\":1,\"profile_path\":\"/ylpxM6czCrVybGkCQZ3sKA6KpDx.jpg\"}],\"episode_run_time\":[42],\"first_air_date\":\"2019-10-06\",\"genres\":[{\"id\":10765,\"name\":\"Sci-Fi & Fantasy\"},{\"id\":10759,\"name\":\"Action & Adventure\"},{\"id\":9648,\"name\":\"Mystery\"},{\"id\":80,\"name\":\"Crime\"}],\"homepage\":\"https://www.cwtv.com/shows/batwoman\",\"id\":89247,\"in_production\":true,\"languages\":[\"en\"],\"last_air_date\":\"2021-06-13\",\"last_episode_to_air\":{\"air_date\":\"2021-06-13\",\"episode_number\":16,\"id\":2916584,\"name\":\"Rebirth\",\"overview\":\"When a familiar foe descends upon Gotham, Batwoman and Mary find they must rely on each other more than ever. Alice has a has a new mission - and gets an unexpected ally to join her.\",\"production_code\":\"T13.22766\",\"season_number\":2,\"still_path\":\"/gqVOrlzlwEqoQXxTpATGhw09S1N.jpg\",\"vote_average\":5.0,\"vote_count\":1},\"name\":\"Batwoman\",\"next_episode_to_air\":{\"air_date\":\"2021-10-13\",\"episode_number\":1,\"id\":3027721,\"name\":\"\",\"overview\":\"\",\"production_code\":\"\",\"season_number\":3,\"still_path\":null,\"vote_average\":0.0,\"vote_count\":0},\"networks\":[{\"name\":\"The CW\",\"id\":71,\"logo_path\":\"/ge9hzeaU7nMtQ4PjkFlc68dGAJ9.png\",\"origin_country\":\"US\"}],\"number_of_episodes\":39,\"number_of_seasons\":3,\"origin_country\":[\"US\"],\"original_language\":\"en\",\"original_name\":\"Batwoman\",\"overview\":\"Kate Kane, armed with a passion for social justice and a flair for speaking her mind, soars onto the streets of Gotham as Batwoman, an out lesbian and highly trained street fighter primed to snuff out the failing city's criminal resurgence. But don't call her a hero yet. In a city desperate for a savior, Kate must overcome her own demons before embracing the call to be Gotham's symbol of hope\",\"popularity\":252.872,\"poster_path\":\"/xjyEpcuDbB1jy0ehNQMBiO8KOdr.jpg\",\"production_companies\":[{\"id\":27711,\"logo_path\":\"/3e294jszfE6cE8TOogmj0zNd6pL.png\",\"name\":\"Berlanti Productions\",\"origin_country\":\"US\"},{\"id\":105514,\"logo_path\":\"/xuziaSHpTZ2YPT35N8r5PT7jiqL.png\",\"name\":\"Mad Ghost Productions\",\"origin_country\":\"US\"},{\"id\":9993,\"logo_path\":\"/2Tc1P3Ac8M479naPp1kYT3izLS5.png\",\"name\":\"DC Entertainment\",\"origin_country\":\"US\"},{\"id\":1957,\"logo_path\":\"/3T19XSr6yqaLNK8uJWFImPgRax0.png\",\"name\":\"Warner Bros. Television\",\"origin_country\":\"US\"}],\"production_countries\":[{\"iso_3166_1\":\"US\",\"name\":\"United States of America\"}],\"seasons\":[{\"air_date\":\"2019-10-06\",\"episode_count\":20,\"id\":123915,\"name\":\"Season 1\",\"overview\":\"\",\"poster_path\":\"/reY4gJiMSNoL2THKJcPJk1E2KTq.jpg\",\"season_number\":1},{\"air_date\":\"2021-01-17\",\"episode_count\":18,\"id\":156123,\"name\":\"Season 2\",\"overview\":\"\",\"poster_path\":\"/5qazdW8H20AlGpF1opHvGgKFPGD.jpg\",\"season_number\":2},{\"air_date\":\"2021-10-13\",\"episode_count\":1,\"id\":199285,\"name\":\"Season 3\",\"overview\":\"\",\"poster_path\":null,\"season_number\":3}],\"spoken_languages\":[{\"english_name\":\"English\",\"iso_639_1\":\"en\",\"name\":\"English\"}],\"status\":\"Returning Series\",\"tagline\":\"Her time is now.\",\"type\":\"Scripted\",\"vote_average\":7.3,\"vote_count\":1095}";
    private final static String detailNowPlay = "{\"adult\":false,\"backdrop_path\":\"/qi6Edc1OPcyENecGtz8TF0DUr9e.jpg\",\"belongs_to_collection\":{\"id\":313086,\"name\":\"The Conjuring Collection\",\"poster_path\":\"/z5VKhNSQKQyxm0co68HAkCqHnmX.jpg\",\"backdrop_path\":\"/kHZaX0vuhZdbuq0WKU3BpA9WIQ0.jpg\"},\"budget\":39000000,\"genres\":[{\"id\":27,\"name\":\"Horror\"},{\"id\":9648,\"name\":\"Mystery\"},{\"id\":53,\"name\":\"Thriller\"}],\"homepage\":\"http://www.theconjuringmovie.net\",\"id\":423108,\"imdb_id\":\"tt7069210\",\"original_language\":\"en\",\"original_title\":\"The Conjuring: The Devil Made Me Do It\",\"overview\":\"Paranormal investigators Ed and Lorraine Warren encounter what would become one of the most sensational cases from their files. The fight for the soul of a young boy takes them beyond anything they'd ever seen before, to mark the first time in U.S. history that a murder suspect would claim demonic possession as a defense.\",\"popularity\":4227.714,\"poster_path\":\"/xbSuFiJbbBWCkyCCKIMfuDCA4yV.jpg\",\"production_companies\":[{\"id\":12,\"logo_path\":\"/iaYpEp3LQmb8AfAtmTvpqd4149c.png\",\"name\":\"New Line Cinema\",\"origin_country\":\"US\"},{\"id\":11565,\"logo_path\":null,\"name\":\"The Safran Company\",\"origin_country\":\"US\"},{\"id\":76907,\"logo_path\":\"/wChlWsVgwSd4ZWxTIm8PTEcaESz.png\",\"name\":\"Atomic Monster\",\"origin_country\":\"US\"},{\"id\":174,\"logo_path\":\"/IuAlhI9eVC9Z8UQWOIDdWRKSEJ.png\",\"name\":\"Warner Bros. Pictures\",\"origin_country\":\"US\"}],\"production_countries\":[{\"iso_3166_1\":\"US\",\"name\":\"United States of America\"}],\"release_date\":\"2021-05-25\",\"revenue\":111800000,\"runtime\":111,\"spoken_languages\":[{\"english_name\":\"English\",\"iso_639_1\":\"en\",\"name\":\"English\"},{\"english_name\":\"Portuguese\",\"iso_639_1\":\"pt\",\"name\":\"Português\"}],\"status\":\"Released\",\"tagline\":\"The demonic case that shocked America.\",\"title\":\"The Conjuring: The Devil Made Me Do It\",\"video\":false,\"vote_average\":8.1,\"vote_count\":2309}";

    public DummyData() {
    }

    public static List<MovieEntity> generateDummyMovie() {
        ArrayList<MovieEntity> movieEntityArrayList = new ArrayList<>();

        movieEntityArrayList.add(new MovieEntity(
                "1",
                "Alita: Battle Angel (2019)",
                "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu.",
                "14/02/2019 (US)",
                "Aksi, Cerita Fiksi, Petualangan",
                R.drawable.poster_alita));

        movieEntityArrayList.add(new MovieEntity(
                "2",
                "Aquaman (2018)",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "21/12/2018 (US)",
                "Aksi, Petualangan, Fantasi",
                R.drawable.poster_aquaman));

        movieEntityArrayList.add(new MovieEntity(
                "3",
                "A Star Is Born (2018)",
                "Seorang bintang musik country yang karirnya mulai memudar, Jackson Maine (Bradley Cooper) menemukan sebuah talenta yang sangat berbakat di dalam diri dari seorang musisi muda bernama Ally (Lady Gaga). Maine berhasil mengorbitkan Ally menjadi seorang bintang muda yang menjanjikan. Namun keduanya terlibat hubungan yang lebih jauh dari sekedar mentor dan anak didik. Seiring dengan meroketnya karir dari Ally dan dirinya, Maine mengalami dilema mengenai masalah ini.",
                "05/10/2018 (US)",
                "Drama, Percintaan, Musik",
                R.drawable.poster_a_start_is_born));

        movieEntityArrayList.add(new MovieEntity(
                "4",
                "Bohemian Rhapsody (2018)",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "02/11/2018 (US)",
                "Musik, Drama, Sejarah",
                R.drawable.poster_bohemian));

        movieEntityArrayList.add(new MovieEntity(
                "5",
                "Cold Pursuit (2019)",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "08/02/2019 (US)",
                "Aksi, Kejahatan, Cerita Seru",
                R.drawable.poster_cold_persuit));

        movieEntityArrayList.add(new MovieEntity(
                "6",
                "Creed II (2018)",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "21/11/2018 (US)",
                "Drama",
                R.drawable.poster_creed));

        movieEntityArrayList.add(new MovieEntity(
                "7",
                "Hewan Fantastis: Kejahatan Grindelwald (2018)",
                "Gellert Grindelwald telah melarikan diri dari penjara dan telah mulai mengumpulkan pengikut ke tujuannya — meninggikan penyihir di atas semua makhluk non-magis. Satu-satunya yang bisa menghentikannya adalah penyihir yang pernah disebutnya sebagai sahabat terdekatnya, Albus Dumbledore. Namun, Dumbledore akan perlu mencari bantuan dari penyihir yang telah menggagalkan Grindelwald sebelumnya, mantan muridnya, Newt Scamander, yang setuju untuk membantu, tidak menyadari bahaya yang ada di depan. Garis-garis digambar saat cinta dan kesetiaan diuji, bahkan di antara teman-teman dan keluarga sejati, di dunia sihir yang semakin terbagi.",
                "16/11/2018 (US)",
                "Petualangan, Fantasi, Drama",
                R.drawable.poster_crimes));

        movieEntityArrayList.add(new MovieEntity(
                "8",
                "Glass (2019)",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "18/01/2019 (US)",
                "Cerita Seru, Drama, Cerita Fiksi",
                R.drawable.poster_glass));

        movieEntityArrayList.add(new MovieEntity(
                "9",
                "How to Train Your Dragon (2010)",
                "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
                "26/03/2010 (US)",
                "Fantasi, Petualangan, Animasi, Keluarga",
                R.drawable.poster_how_to_train));

        movieEntityArrayList.add(new MovieEntity(
                "10",
                "Avengers: Infinity War (2018)",
                "Karena Avengers dan sekutunya terus melindungi dunia dari ancaman yang terlalu besar untuk ditangani oleh seorang pahlawan, bahaya baru telah muncul dari bayangan kosmik: Thanos. Seorang lalim penghujatan intergalaksi, tujuannya adalah untuk mengumpulkan semua enam Batu Infinity, artefak kekuatan yang tak terbayangkan, dan menggunakannya untuk menimbulkan kehendak memutar pada semua realitas. Segala sesuatu yang telah diperjuangkan oleh Avengers telah berkembang hingga saat ini - nasib Bumi dan keberadaannya sendiri tidak pernah lebih pasti.",
                "27/04/2018 (US)",
                "Petualangan, Aksi, Cerita Fiksi",
                R.drawable.poster_infinity_war));

        return movieEntityArrayList;
    }

    public static List<MovieEntity> generateDummyTVShow() {
        ArrayList<MovieEntity> tvShowArrayList = new ArrayList<>();

        tvShowArrayList.add(new MovieEntity(
                "11",
                "The Arrow",
                "Panah adalah menceritakan kembali petualangan dari legendaris DC pahlawan Green Arrow",
                "Oktober 10, 2012",
                "Kejahatan, Drama, Misteri, Aksi & Petualangan",
                R.drawable.poster_arrow));

        tvShowArrayList.add(new MovieEntity(
                "12",
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "Februari 15, 2019",
                "Sci-fi & Fantasy, Komedi, Drama",
                R.drawable.poster_doom_patrol));

        tvShowArrayList.add(new MovieEntity(
                "13",
                "The Flash",
                "Setelah akselerator partikel menyebabkan badai aneh, Penyelidik CSI Barry Allen disambar petir dan jatuh koma. Beberapa bulan kemudian dia terbangun dengan kekuatan kecepatan super, memberinya kemampuan untuk bergerak melalui Central City seperti malaikat penjaga yang tak terlihat. Meskipun awalnya senang dengan kekuatan barunya, Barry terkejut menemukan bahwa dia bukan satu-satunya \"manusia meta\" yang diciptakan setelah ledakan akselerator - dan tidak semua orang menggunakan kekuatan baru mereka untuk kebaikan. Barry bermitra dengan S.T.A.R. Lab dan mendedikasikan hidupnya untuk melindungi yang tidak bersalah. Untuk saat ini, hanya beberapa teman dekat dan rekan yang tahu bahwa Barry secara harfiah adalah manusia tercepat, tetapi tidak lama sebelum dunia mengetahui apa yang menjadi Barry Allen ... The Flash.",
                "Oktober 7, 2014",
                "Animasi, Aksi & Petualangan, Sci-fi & Fantasy",
                R.drawable.poster_flash));

        tvShowArrayList.add(new MovieEntity(
                "14",
                "The ナルト 疾風伝 (2007)",
                "Naruto Shippuuden adalah kelanjutan dari serial TV animasi asli Naruto. Kisah ini berkisah tentang Uzumaki Naruto yang lebih tua dan sedikit lebih matang dan upayanya untuk menyelamatkan temannya Uchiha Sasuke dari cengkeraman Shinobi seperti ular, Orochimaru. Setelah 2 setengah tahun, Naruto akhirnya kembali ke desanya Konoha, dan mulai mewujudkan ambisinya, meskipun itu tidak akan mudah, karena Ia telah mengumpulkan beberapa musuh (lebih berbahaya), seperti organisasi shinobi. ; Akatsuki.",
                "Oktober 7, 2014",
                "Drama, Sci-fi & Fantasy",
                R.drawable.poster_naruto_shipudden));

        tvShowArrayList.add(new MovieEntity(
                "15",
                "ドラゴンボール",
                "Dahulu kala di pegunungan, seorang master pertempuran yang dikenal sebagai Gohan menemukan seorang bocah aneh yang ia beri nama Goku. Gohan membesarkannya dan melatih Goku dalam seni bela diri sampai dia mati. Bocah muda dan sangat kuat itu sendirian, tetapi mudah dikelola. Kemudian suatu hari, Goku bertemu dengan seorang gadis remaja bernama Bulma, yang pencariannya untuk bola naga membawanya ke rumah Goku. Bersama-sama, mereka berangkat untuk menemukan ketujuh bola naga dalam sebuah petualangan yang akan mengubah hidup Goku selamanya. Lihat bagaimana Goku bertemu teman-teman seumur hidupnya Bulma, Yamcha, Krillin, Master Roshi dan banyak lagi.",
                "Februari 26, 1986",
                "Animasi, Aksi & Petualangan, Sci-fi & Fantasy",
                R.drawable.poster_dragon_ball));

        tvShowArrayList.add(new MovieEntity(
                "16",
                "Fairy Tail: Phoenix Priestess (2012)",
                "The film revolves around a mysterious girl named Éclair who appears before Fairy Tail, the world's most notorious wizard's guild. She lost all of her memories, except for the imperative that she must deliver two Phoenix Stones somewhere. The stones may spell the collapse of the magical world, and Natsu, Lucy, and the rest of the Fairy Tail guild are caught up in the intrigue.",
                "Agustus 18, 2012",
                "Animasi, Aksi & Petualangan, Sci-fi & Fantasy",
                R.drawable.poster_fairytail));

        tvShowArrayList.add(new MovieEntity(
                "17",
                "Gotham (2014)",
                "Semua orang tahu nama Komisaris Gordon. Dia adalah salah satu musuh terbesar dunia kejahatan, seorang pria yang reputasinya identik dengan hukum dan ketertiban. Tapi apa yang diketahui tentang kisah Gordon dan kenaikannya dari detektif pemula ke Komisaris Polisi? Apa yang diperlukan untuk menavigasi berbagai lapisan korupsi yang diam-diam memerintah Kota Gotham, tempat bertelurnya penjahat paling ikonik di dunia? Dan keadaan apa yang menciptakan mereka - persona yang lebih besar dari kehidupan yang akan menjadi Catwoman, The Penguin, The Riddler, Two-Face dan The Joker?",
                "September 22, 2014",
                "Drama, Kejahatan, Sci-fi & Fantasy",
                R.drawable.poster_gotham));

        tvShowArrayList.add(new MovieEntity(
                "18",
                "Hanna (2019)",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "Maret 28, 2019",
                "Aksi & Petualangan, Drama",
                R.drawable.poster_hanna));

        tvShowArrayList.add(new MovieEntity(
                "19",
                "Supergirl (2015)",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "Oktober 26, 2015",
                "Drama, Sci-fi & Fantasy, Aksi & Petualangan",
                R.drawable.poster_supergirl));

        tvShowArrayList.add(new MovieEntity(
                "20",
                "Shameless (2011)",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                "Januari 9, 2011",
                "Drama, Komedi",
                R.drawable.poster_shameless));

        return tvShowArrayList;
    }

    public static List<MovieEntity> generateAllDummyMovies() {
        ArrayList<MovieEntity> movieEntityArrayList = new ArrayList<>();

        movieEntityArrayList.add(new MovieEntity(
                "1",
                "Alita: Battle Angel (2019)",
                "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu.",
                "14/02/2019 (US)",
                "Aksi, Cerita Fiksi, Petualangan",
                R.drawable.poster_alita));

        movieEntityArrayList.add(new MovieEntity(
                "2",
                "Aquaman (2018)",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "21/12/2018 (US)",
                "Aksi, Petualangan, Fantasi",
                R.drawable.poster_aquaman));

        movieEntityArrayList.add(new MovieEntity(
                "3",
                "A Star Is Born (2018)",
                "Seorang bintang musik country yang karirnya mulai memudar, Jackson Maine (Bradley Cooper) menemukan sebuah talenta yang sangat berbakat di dalam diri dari seorang musisi muda bernama Ally (Lady Gaga). Maine berhasil mengorbitkan Ally menjadi seorang bintang muda yang menjanjikan. Namun keduanya terlibat hubungan yang lebih jauh dari sekedar mentor dan anak didik. Seiring dengan meroketnya karir dari Ally dan dirinya, Maine mengalami dilema mengenai masalah ini.",
                "05/10/2018 (US)",
                "Drama, Percintaan, Musik",
                R.drawable.poster_a_start_is_born));

        movieEntityArrayList.add(new MovieEntity(
                "4",
                "Bohemian Rhapsody (2018)",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "02/11/2018 (US)",
                "Musik, Drama, Sejarah",
                R.drawable.poster_bohemian));

        movieEntityArrayList.add(new MovieEntity(
                "5",
                "Cold Pursuit (2019)",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "08/02/2019 (US)",
                "Aksi, Kejahatan, Cerita Seru",
                R.drawable.poster_cold_persuit));

        movieEntityArrayList.add(new MovieEntity(
                "6",
                "Creed II (2018)",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "21/11/2018 (US)",
                "Drama",
                R.drawable.poster_creed));

        movieEntityArrayList.add(new MovieEntity(
                "7",
                "Hewan Fantastis: Kejahatan Grindelwald (2018)",
                "Gellert Grindelwald telah melarikan diri dari penjara dan telah mulai mengumpulkan pengikut ke tujuannya — meninggikan penyihir di atas semua makhluk non-magis. Satu-satunya yang bisa menghentikannya adalah penyihir yang pernah disebutnya sebagai sahabat terdekatnya, Albus Dumbledore. Namun, Dumbledore akan perlu mencari bantuan dari penyihir yang telah menggagalkan Grindelwald sebelumnya, mantan muridnya, Newt Scamander, yang setuju untuk membantu, tidak menyadari bahaya yang ada di depan. Garis-garis digambar saat cinta dan kesetiaan diuji, bahkan di antara teman-teman dan keluarga sejati, di dunia sihir yang semakin terbagi.",
                "16/11/2018 (US)",
                "Petualangan, Fantasi, Drama",
                R.drawable.poster_crimes));

        movieEntityArrayList.add(new MovieEntity(
                "8",
                "Glass (2019)",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "18/01/2019 (US)",
                "Cerita Seru, Drama, Cerita Fiksi",
                R.drawable.poster_glass));

        movieEntityArrayList.add(new MovieEntity(
                "9",
                "How to Train Your Dragon (2010)",
                "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
                "26/03/2010 (US)",
                "Fantasi, Petualangan, Animasi, Keluarga",
                R.drawable.poster_how_to_train));

        movieEntityArrayList.add(new MovieEntity(
                "10",
                "Avengers: Infinity War (2018)",
                "Karena Avengers dan sekutunya terus melindungi dunia dari ancaman yang terlalu besar untuk ditangani oleh seorang pahlawan, bahaya baru telah muncul dari bayangan kosmik: Thanos. Seorang lalim penghujatan intergalaksi, tujuannya adalah untuk mengumpulkan semua enam Batu Infinity, artefak kekuatan yang tak terbayangkan, dan menggunakannya untuk menimbulkan kehendak memutar pada semua realitas. Segala sesuatu yang telah diperjuangkan oleh Avengers telah berkembang hingga saat ini - nasib Bumi dan keberadaannya sendiri tidak pernah lebih pasti.",
                "27/04/2018 (US)",
                "Petualangan, Aksi, Cerita Fiksi",
                R.drawable.poster_infinity_war));

        movieEntityArrayList.add(new MovieEntity(
                "11",
                "The Arrow",
                "Panah adalah menceritakan kembali petualangan dari legendaris DC pahlawan Green Arrow",
                "Oktober 10, 2012",
                "Kejahatan, Drama, Misteri, Aksi & Petualangan",
                R.drawable.poster_arrow));

        movieEntityArrayList.add(new MovieEntity(
                "12",
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "Februari 15, 2019",
                "Sci-fi & Fantasy, Komedi, Drama",
                R.drawable.poster_doom_patrol));

        movieEntityArrayList.add(new MovieEntity(
                "13",
                "The Flash",
                "Setelah akselerator partikel menyebabkan badai aneh, Penyelidik CSI Barry Allen disambar petir dan jatuh koma. Beberapa bulan kemudian dia terbangun dengan kekuatan kecepatan super, memberinya kemampuan untuk bergerak melalui Central City seperti malaikat penjaga yang tak terlihat. Meskipun awalnya senang dengan kekuatan barunya, Barry terkejut menemukan bahwa dia bukan satu-satunya \"manusia meta\" yang diciptakan setelah ledakan akselerator - dan tidak semua orang menggunakan kekuatan baru mereka untuk kebaikan. Barry bermitra dengan S.T.A.R. Lab dan mendedikasikan hidupnya untuk melindungi yang tidak bersalah. Untuk saat ini, hanya beberapa teman dekat dan rekan yang tahu bahwa Barry secara harfiah adalah manusia tercepat, tetapi tidak lama sebelum dunia mengetahui apa yang menjadi Barry Allen ... The Flash.",
                "Oktober 7, 2014",
                "Animasi, Aksi & Petualangan, Sci-fi & Fantasy",
                R.drawable.poster_flash));

        movieEntityArrayList.add(new MovieEntity(
                "14",
                "ナルト 疾風伝 (2007)",
                "Naruto Shippuuden adalah kelanjutan dari serial TV animasi asli Naruto. Kisah ini berkisah tentang Uzumaki Naruto yang lebih tua dan sedikit lebih matang dan upayanya untuk menyelamatkan temannya Uchiha Sasuke dari cengkeraman Shinobi seperti ular, Orochimaru. Setelah 2 setengah tahun, Naruto akhirnya kembali ke desanya Konoha, dan mulai mewujudkan ambisinya, meskipun itu tidak akan mudah, karena Ia telah mengumpulkan beberapa musuh (lebih berbahaya), seperti organisasi shinobi. ; Akatsuki.",
                "Oktober 7, 2014",
                "Drama, Sci-fi & Fantasy",
                R.drawable.poster_naruto_shipudden));

        movieEntityArrayList.add(new MovieEntity(
                "15",
                "ドラゴンボール",
                "Dahulu kala di pegunungan, seorang master pertempuran yang dikenal sebagai Gohan menemukan seorang bocah aneh yang ia beri nama Goku. Gohan membesarkannya dan melatih Goku dalam seni bela diri sampai dia mati. Bocah muda dan sangat kuat itu sendirian, tetapi mudah dikelola. Kemudian suatu hari, Goku bertemu dengan seorang gadis remaja bernama Bulma, yang pencariannya untuk bola naga membawanya ke rumah Goku. Bersama-sama, mereka berangkat untuk menemukan ketujuh bola naga dalam sebuah petualangan yang akan mengubah hidup Goku selamanya. Lihat bagaimana Goku bertemu teman-teman seumur hidupnya Bulma, Yamcha, Krillin, Master Roshi dan banyak lagi.",
                "Februari 26, 1986",
                "Animasi, Aksi & Petualangan, Sci-fi & Fantasy",
                R.drawable.poster_dragon_ball));

        movieEntityArrayList.add(new MovieEntity(
                "16",
                "Fairy Tail: Phoenix Priestess (2012)",
                "The film revolves around a mysterious girl named Éclair who appears before Fairy Tail, the world's most notorious wizard's guild. She lost all of her memories, except for the imperative that she must deliver two Phoenix Stones somewhere. The stones may spell the collapse of the magical world, and Natsu, Lucy, and the rest of the Fairy Tail guild are caught up in the intrigue.",
                "Agustus 18, 2012",
                "Animasi, Aksi & Petualangan, Sci-fi & Fantasy",
                R.drawable.poster_fairytail));

        movieEntityArrayList.add(new MovieEntity(
                "17",
                "Gotham (2014)",
                "Semua orang tahu nama Komisaris Gordon. Dia adalah salah satu musuh terbesar dunia kejahatan, seorang pria yang reputasinya identik dengan hukum dan ketertiban. Tapi apa yang diketahui tentang kisah Gordon dan kenaikannya dari detektif pemula ke Komisaris Polisi? Apa yang diperlukan untuk menavigasi berbagai lapisan korupsi yang diam-diam memerintah Kota Gotham, tempat bertelurnya penjahat paling ikonik di dunia? Dan keadaan apa yang menciptakan mereka - persona yang lebih besar dari kehidupan yang akan menjadi Catwoman, The Penguin, The Riddler, Two-Face dan The Joker?",
                "September 22, 2014",
                "Drama, Kejahatan, Sci-fi & Fantasy",
                R.drawable.poster_gotham));

        movieEntityArrayList.add(new MovieEntity(
                "18",
                "Hanna (2019)",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "Maret 28, 2019",
                "Aksi & Petualangan, Drama",
                R.drawable.poster_hanna));

        movieEntityArrayList.add(new MovieEntity(
                "19",
                "Supergirl (2015)",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "Oktober 26, 2015",
                "Drama, Sci-fi & Fantasy, Aksi & Petualangan",
                R.drawable.poster_supergirl));

        movieEntityArrayList.add(new MovieEntity(
                "20",
                "Shameless (2011)",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                "Januari 9, 2011",
                "Drama, Komedi",
                R.drawable.poster_shameless));

        return movieEntityArrayList;
    }

    public static List<ResultsItemNowPlaying> generateDummyNowPlaying() {
        List<ResultsItemNowPlaying> resultsItemNowPlayingList = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(nowPlayData);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);

                int id = object.getInt("id");
                String title = object.getString("title");
                String releaseDate = object.getString("release_date");
                String description = object.getString("overview");
                int voteAverage = object.getInt("vote_average");
                String originalLanguage = object.getString("original_language");
                String poster = object.getString("poster_path");

                ResultsItemNowPlaying movieResponse = new ResultsItemNowPlaying();
                movieResponse.setId(id);
                movieResponse.setTitle(title);
                movieResponse.setReleaseDate(releaseDate);
                movieResponse.setOverview(description);
                movieResponse.setVoteAverage(voteAverage);
                movieResponse.setPosterPath(poster);

                resultsItemNowPlayingList.add(movieResponse);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return resultsItemNowPlayingList;
    }

    public static List<ResultsItemTVAiringToday> generateDummyTVAiringToday() {
        ArrayList<ResultsItemTVAiringToday> list = new ArrayList<>();
        try {
            JSONArray listArray = new JSONArray(tvShowData);
            for (int i = 0; i < listArray.length(); i++) {
                JSONObject tvShow = listArray.getJSONObject(i);

                int id = tvShow.getInt("id");
                String title = tvShow.getString("name");
                String releaseDate = tvShow.getString("first_air_date");
                String description = tvShow.getString("overview");
                int voteAverage = tvShow.getInt("vote_average");
                String originalLanguage = tvShow.getString("original_language");
                String poster = tvShow.getString("poster_path");

                ResultsItemTVAiringToday tvShowResponse = new ResultsItemTVAiringToday();
                tvShowResponse.setId(id);
                tvShowResponse.setName(title);
                tvShowResponse.setFirstAirDate(releaseDate);
                tvShowResponse.setOverview(description);
                tvShowResponse.setVoteAverage(voteAverage);
                tvShowResponse.setPosterPath(poster);
                list.add(tvShowResponse);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static DetailTVResponse generateDummyDetailTVAiringToday() {
        DetailTVResponse detailTVResponse = new DetailTVResponse();
        try {
            JSONObject tvShow = new JSONObject(detailAiring);
            detailTVResponse.setName(tvShow.getString("name"));
            detailTVResponse.setFirstAirDate(tvShow.getString("first_air_date"));
            detailTVResponse.setVoteAverage(tvShow.getInt("vote_average"));
            detailTVResponse.setOverview(tvShow.getString("overview"));
            JSONArray genres = tvShow.getJSONArray("genres");
            List<GenresItemTVAiringToday> genresItemList = new ArrayList<>();
            for (int gen = 0; gen < genres.length(); gen++) {
                JSONObject objGen = genres.getJSONObject(gen);
                GenresItemTVAiringToday genresItem = new GenresItemTVAiringToday();
                genresItem.setId(objGen.getInt("id"));
                genresItem.setName(objGen.getString("name"));
                genresItemList.add(genresItem);
            }
            detailTVResponse.setGenres(genresItemList);
            detailTVResponse.setPosterPath(tvShow.getString("poster_path"));
            detailTVResponse.setId(tvShow.getInt("id"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return detailTVResponse;
    }

    public static DetailMovieResponse generateDummyDetailNowPlaying() {
        DetailMovieResponse detailMovieResponse = new DetailMovieResponse();
        try {
            JSONObject movie = new JSONObject(detailNowPlay);
            detailMovieResponse.setTitle(movie.getString("title"));
            detailMovieResponse.setReleaseDate(movie.getString("release_date"));
            detailMovieResponse.setVoteAverage(movie.getInt("vote_average"));
            detailMovieResponse.setOverview(movie.getString("overview"));
            JSONArray genres = movie.getJSONArray("genres");
            List<GenresItemNowPlaying> genresItemList = new ArrayList<>();
            for (int gen = 0; gen < genres.length(); gen++) {
                JSONObject objGen = genres.getJSONObject(gen);
                GenresItemNowPlaying genresItem = new GenresItemNowPlaying();
                genresItem.setId(objGen.getInt("id"));
                genresItem.setName(objGen.getString("name"));
                genresItemList.add(genresItem);
            }
            detailMovieResponse.setGenres(genresItemList);
            detailMovieResponse.setPosterPath(movie.getString("poster_path"));
            detailMovieResponse.setId(movie.getInt("id"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return detailMovieResponse;
    }

}
