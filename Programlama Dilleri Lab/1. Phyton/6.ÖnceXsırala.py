"""
Kullanıcıdan alınan satırları(boş satır gelene kadar) önce x içerenleri
sonra diğerlerini sıralayarak ekrana yazdıran programın yazılması istenmektedir.
Girdi metninin bittiğini belirtmek için son satır boş metin olarak gönderilmektedir.
"""
liste1=list()
liste2=list()

while 1:
    girdi=str(input())
    if girdi=="":
        break
    elif girdi.startswith('x'):
        i=0
        liste1.insert(i,girdi)
    else:
        j=0
        liste2.insert(j,girdi)

liste1.sort
liste2.sort

for i in range(len(liste1)):
    print(liste1[i])
for i in range(len(liste2)):
    print(liste2[i])
