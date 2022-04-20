#Kullanıcıdan alınan metnin ilk harfi sabit kalmak koşulu ile içindeki ilk harfle
#aynı olan harfleri “*” sembolü ile değiştiren kodu yazınız. Örneğin google girdisi
#goo*le olarak çıktı verilmelidir

girdi=input("")

yenigirdi=girdi.replace(girdi[0],'*')

print(girdi[0]+yenigirdi[1:])

