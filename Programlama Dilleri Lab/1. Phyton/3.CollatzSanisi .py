

sozluk = dict()
dict1 = {1:"P" , 9: "Y", 0:"T" , 5: "H", 7:"Y" , 4: "P"}
sozluk = dict1


for key, value in sozluk.items():

    for value2 in sorted(sozluk, key=sozluk.get, reverse=True):
        if value == value2:
            print(value, value2)