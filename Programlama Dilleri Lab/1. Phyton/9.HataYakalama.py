
toplam = 0

while 1:

    girdi = input("")
    if girdi == "":
        break
    try:
        girdi2 = float(girdi)
        # print("girdi2:", girdi2)
        girdi = int(girdi2)
        # print("girdi:",girdi)
        araToplam = int(1000 / girdi)
        toplam = toplam + araToplam
    except ZeroDivisionError:
        continue
    except (ValueError):
        continue
print(toplam)