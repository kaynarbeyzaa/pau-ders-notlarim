import os
from typing import TextIO

p1 = input("player 1=")
p2 = input("player 2=")

d1='taş'
d2='kağıt'
d3='makas'

tkm = open("log.txt", "x")

tkm.write("Player 1= " + p1)
tkm.write("Player 2= " + p2)

if p1 != d1 and p1 != d2 and p1 != d3:

    print("oyuncu 1 hatalı girdi")
    tkm.write("oyuncu 1 hatalı girdi")

elif p2 != d1 and p2 != d2 and p2 != d3:

    print("oyuncu 2 hatalı girdi")
    tkm.write("oyuncu 2 hatalı girdi")

else:
    if p1 == d1:
        if p2 == d1:
            print("berabere")
            tkm.write("berabere")
        elif p2 == d2:
            print("ikinci oyuncu kazandı")
            tkm.write("ikinci oyuncu kazandı")
        elif p2 == d3:
            print("birinci oyuncu kazandı")
            tkm.write("birinci oyuncu kazandı")
    if p1 == d2:
        if p2 == d1:
            print("birinci oyuncu kazandı")
            tkm.write("birinci oyuncu kazandı")
        elif p2 == d2:
            print("berabere")
            tkm.write("berabere")
        elif p2 == d3:
            print("ikinci oyuncu kazandı")
            tkm.write("ikinci oyuncu kazandı")
    if p1 == d3:
        if p2 == d1:
            print("ikinci oyuncu kazandı")
            tkm.write("ikinci oyuncu kazandı")
        elif p2 == d2:
            print("birinci oyuncu kazandı")
            tkm.write("birinci oyuncu kazandı")
        elif p2 == d3:
            print("berabere")
            tkm.write("berabere")

tkm.close()


