# Kullanıcıdan alınan iki adet metnin ilk iki harflerini yer değiştirerek birleştiren
# ve ekrana yazan kodu yazınız. Örneğin mixer ve glider girdileri için çıktı glxer
# miider olmalıdır.


def FrekansBul(*listeler):

    enCokTekrarEden = []
    sozluk = dict()

    for liste in listeler:
        for i in liste:
            sozluk[liste[i]] = liste.count(liste[i])

    kelimeler = []
    tekrarSayisi = []

    for anahtar in sorted(sozluk, key=sozluk.get, reverse=True):
        kelimeler.append(anahtar)
        tekrarSayisi.append(sozluk[anahtar])

    print("En Çok Tekrarlayan ", kelimeler[0])