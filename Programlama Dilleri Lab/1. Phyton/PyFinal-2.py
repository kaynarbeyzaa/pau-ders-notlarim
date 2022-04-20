
girdi = str(input())
sozluk = dict()

for i in range (len(girdi)):
    sozluk[girdi[i]] = (girdi[i], girdi.count(girdi[i]))


sirali = sorted(sozluk.values(), key=lambda x:(-x[1], x[0]))


for anahtar, deger in sirali[:3]:
   print("{} = {}".format(anahtar, deger))

