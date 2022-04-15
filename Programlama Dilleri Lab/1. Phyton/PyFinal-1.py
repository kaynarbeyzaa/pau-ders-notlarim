liste = list()

while 1:
    girdi=str(input())
    if girdi == "":
        break
    else:
        girdi = girdi.split(" ")

        komut = girdi[0]

        if len(girdi) == 1:

            if komut == "sırala":
                liste.sort()

            elif komut == "cek":
                liste.pop(len(liste) - 1)

            elif komut == "tersçevir":
                liste.reverse()

            elif komut == "yazdır":
                print(liste)

        elif len(girdi) == 2:

            parametre1 = int(girdi[1])

            if komut == "sonaekle":
                liste.append(parametre1)
                print(liste)

            elif komut == "sil":
                x = liste.index(parametre1)
                liste.pop(x)

        elif len(girdi) == 3:

            parametre1 = int(girdi[1])
            parametre2 = int(girdi[2])

            if komut == "ekle":
                liste.insert(parametre1, parametre2)

        else:
            print("yanlış komut girildi")





