package com.example.projectuts_nmp

object Global {
    val stories =
        arrayListOf(
            Story(1, "Rahasia Terkunci di Perpustakaan Kuno", "NebulaNomad", "Mistery", "Restricted",
                "\"Rahasia Terkunci di Perpustakaan Kuno\" mengisahkan tentang seorang mahasiswa bernama Alex yang secara tak sengaja menemukan sebuah buku kuno yang misterius di perpustakaan universitasnya.",
                "https://x2e5r7b9.rocketcdn.me/wp-content/uploads/2020/01/0-02-05-4b0d7dda8273424508dad4716802c35361d8ca112023d388f23211e595748d75_1c6d9a38157e40.jpg"),
            Story(2, "Dunia Dalam Cermin: Kisah Terbalik yang Misterius", "NebulaNomad", "Mistery", "Public",
                "Alex tak menyangka sebuah cermin kuno pada toko antik tua yang ia temukan akan membawanya ke dunia lain yang misterius. Rahasia apa yang harus ia ungkap agar dapat kembali ke dunia nyata?",
                "https://c0.wallpaperflare.com/preview/537/888/849/travel-beach-women-sky.jpg"),
            Story(3, "Negeri di Awan", "TechnoWhizKid", "Fantasy", "Restricted",
                "Rico menolong seorang anak kecil yang terjatuh di halte. Anak itu mengajaknya pergi ke tempat persembunyiannya jauh di atas gunung untuk melihat rahasia keindahan yang belum pernah ia lihat.",
                "https://images.wallpapersden.com/image/download/cloudy-mountains_a2toaWWUmZqaraWkpJRobWllrWdma2U.jpg"),
            Story(4, "Fantasia", "TwosetViolin", "Drama", "Public",
                "Dua orang sahabat yang selalu berjuang bersama dalam meraih mimpi menghadapi cobaan besar yang mempertaruhkan hidup. Akankah mereka berhasil bangkit kembali dan mempertahankan persahabatan?",
                "https://t3.ftcdn.net/jpg/04/32/66/60/360_F_432666077_2qPtBSHuaLnI65oj5gIzpJxnVRRCRx6J.jpg")
        )

    val genre:Array<Genre> = arrayOf(
        Genre(1, "Action"),
        Genre(2, "Comedy"),
        Genre(3, "Drama"),
        Genre(4, "Horror"),
        Genre(5, "Carton"),
        Genre(6, "Romance"),
        Genre(7, "Fantasy"),
        Genre(8, "Mistery")
    )

    val STORY_ID = "storyId"

    //arraylist semua paragraf
    val paragraphs =
        arrayListOf(
            Paragraph(1, "NebulaNomad", "Pagi itu Alex menikmati waktu di perpustakaan sambil menunggu jam kuliah. Sebenarnya ia bingung ingin membaca buku apa karena di sana hanya ada buku pelajaran."),
            Paragraph(1, "TwosetViolin", "Tiba-tiba Alex melihat secercah cahaya dari sebuah rak buku di ujung ruangan, cahaya itu berkilau keemasan dan seolah memanggil dirinya."),
            Paragraph(1, "TechnoWhizKid", "Alex pun menghampiri asal cahaya tersebut yang ternyata merupakan sebuah buku kuno yang agak usang. Setelah melihat judulnya, Alex pun tertarik untuk membaca buku tersebut."),
            Paragraph(2, "NebulaNomad","Dengan hati berdebar, Alex mengelilingi toko antik tua itu. Matanya tertarik pada cermin kuno yang memancarkan keindahan misterius. Tanpa pikir panjang, ia menyentuh permukaannya, dan dunia seketika terbalik."),
            Paragraph(2, "SolsticeDreamer", "Dalam sekejap, Alex merasa seperti melayang dalam ruang waktu yang tak terbatas, dan sekarang, di hadapannya terbentang dunia yang ajaib dan tak dikenal."),
            Paragraph(2, "AuroraHarmonix", "Di dunia cermin, segalanya tampak sana, tapi seolah ada rahasia yang tersembunyi di balik setiap sudutnya. Alex merasa tak sabar untuk menjelajahinya dan mengungkap misteri di balik cermin ajaib itu."),
            Paragraph(3, "TechnoWhizKid", "Hari ini Rico merasa serba sial. Pagi tadi motor kesayangannya tiba-tiba mogok sehingga ia harus naik bus untuk pergi ke sekolahnya, alhasil ia pun dihukum guru karena terlambat datang ke sekolah."),
            Paragraph(3, "SolsticeDreamer", "Di sekolah ia juga tidak bisa fokus mengerjakan ujian hingga hasil ujiannya buruk. Ia merasa sangat kesal dan memutuskan untuk kabur dari sekolah pada jam istirahat untuk menenangkan pikiran."),
            Paragraph(3, "NebulaNomad", "Tentu saja Rico harus menaiki bus lagi untuk pergi ke tempat lain. Saat menuju ke halte bus, ia melihat seorang anak kecil duduk di sana sambil menangis sendirian."),
            Paragraph(3, "TwosetViolin", "Rico menghibur anak itu hinggu tersenyum kembali, rupanya ia menangis karena lupa membawa uang untuk naik bus. Rico menawarkan bantuan uang, namun anak itu malah mengajaknya pergi ke suatu tempat."),
            Paragraph(4, "TwosetViolin", "Eddy sedang mempersiapkan diri untuk kompetisi musik hari ini. Tiba-tiba ia terkejut melihat anak yang ia temui di kelas Matematikanya kemarin masuk ke ruangan yang sama dengannya."),
            Paragraph(4, "TechnoWhizKid", "Mereka pun otomatis mengenali satu sama lain dan berbincang bersama sebelum kompetisi dimulai. Ternyata mereka memainkan alat musik yang sama sejak kecil yaitu biola.")
        )

    //fungsi untuk memunculkan paragraf yg sesuai id cerbung
    fun selecting(idStory:Int) : ArrayList<Paragraph> {
        var selectedPar = arrayListOf<Paragraph>()
        for (item in paragraphs) {
            if (item.idCerbung == idStory) {
                selectedPar.add(item)
            }
        }
        return selectedPar
    }
}