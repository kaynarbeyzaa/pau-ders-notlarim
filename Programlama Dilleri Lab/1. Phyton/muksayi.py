
import os

sayi = int(input("bir sayı giriniz:"))


tamBolenler = 0

for bolen in range(1, sayi):
    if sayi % bolen == 0:
        tamBolenler += bolen

if tamBolenler == sayi:
    print("mükemmel")
else:
    print("mükemmel değil")
    
os.system("pause")

