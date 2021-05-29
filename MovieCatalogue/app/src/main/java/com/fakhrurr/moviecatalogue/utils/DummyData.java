package com.fakhrurr.moviecatalogue.utils;

import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.data.MovieEntity;

import java.util.ArrayList;
import java.util.List;

public class DummyData {
    public DummyData() {}
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
                R.drawable.poster_aquaman));

        tvShowArrayList.add(new MovieEntity(
                "12",
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "Februari 15, 2019",
                "Sci-fi & Fantasy, Komedi, Drama",
                R.drawable.poster_aquaman));

        tvShowArrayList.add(new MovieEntity(
                "13",
                "ナルト 疾風伝",
                "Panah adalah menceritakan kembali petualangan dari legendaris DC pahlawan Green Arrow",
                "Februari 15, 2007",
                "Animasi, Aksi & Petualangan, Sci-fi & Fantasy",
                R.drawable.poster_arrow));

        tvShowArrayList.add(new MovieEntity(
                "14",
                "The Flash",
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
                R.drawable.poster_aquaman));

        movieEntityArrayList.add(new MovieEntity(
                "12",
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "Februari 15, 2019",
                "Sci-fi & Fantasy, Komedi, Drama",
                R.drawable.poster_aquaman));

        movieEntityArrayList.add(new MovieEntity(
                "13",
                "ナルト 疾風伝",
                "Panah adalah menceritakan kembali petualangan dari legendaris DC pahlawan Green Arrow",
                "Februari 15, 2007",
                "Animasi, Aksi & Petualangan, Sci-fi & Fantasy",
                R.drawable.poster_arrow));

        movieEntityArrayList.add(new MovieEntity(
                "14",
                "The Flash",
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
}
