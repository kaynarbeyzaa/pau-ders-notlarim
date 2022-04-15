"""
 Kullanıcıdan alınan metinde en çok tekrar eden 5 kelime ve tekrar etme sayısının
 ekrana yazılması istenmektedir.

 Girdi metni islenmeden önce nokta(.), virgül(,), kesme isareti(’) bos string ile;
 tire isareti(-) ise bir adet bosluk karakteri ile yer degistirmelidir.

 Ayrıca metinler küçük harfe dönüstürülüp islenmelidir.

 Bu problemin çözümü için sözlük yapısı kullanılabilir. Sözlügün anahtar degeri sözcügü,
 degeri ise tekrar sayısını saklayacaktır.

 Programa verilen tüm girdileri(dosya sonu karakterine kadar) okumak için girdi = sys.stdin.read() kullanılabilir.
 Sözlük yapısını degerlere göre tersten sıralayıp anahtar degerlerini almak için
 asagıdaki döngü biçimi kullanılabilir.

for anahtar in sorted(sozluk, key=sozluk.get, reverse=True):
"""
import sys

girdi = sys.stdin.read()

girdi = girdi.replace('.', '')
girdi = girdi.replace(',', '')
girdi = girdi.replace('\'', '')
girdi = girdi.replace('-', ' ')

liste = list()  # girdideki her kelimeyi listenin bir elemanı yapmak için
liste = girdi.lower().split(" ")

sozluk = dict()

for i in range (len(liste)):
    sozluk[liste[i]] = liste.count(liste[i])

#print(sozluk)

kelimeler = []
tekrarSayisi = []

for anahtar in sorted(sozluk, key=sozluk.get, reverse=True):
    kelimeler.append(anahtar)
    tekrarSayisi.append(sozluk[anahtar])
    #print(anahtar, sozluk[anahtar])

k=0
while k<=4:
    print(kelimeler[k]," ",tekrarSayisi[k])
    k+=1




