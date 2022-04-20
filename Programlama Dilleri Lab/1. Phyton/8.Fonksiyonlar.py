"""
Bu programda kullanıcıdan input('') fonksiyonu ile girdi almanıza gerek yoktur.
Hesaplama için gelen değerler argümanlardadır(n ve *args gibi)
"""
def asal(n):

    n>2
    asal = [p for p in range(2, n) if all(p % y != 0 for y in range(2, p))]
    return asal
    pass



def mukemmel(sayi):

    sayi > 2
    tamBolenler = 1
    for bolen in range(1, sayi):
        if sayi % bolen == 0:
            tamBolenler += bolen

    if tamBolenler == sayi:
        return True
    else:
        return False
    pass

def asal_liste(*args):
    asalMi = []
    for i in args:
        for k in range(2, i):
            if (i % k) == 0:
                asalMi.append(False)
                break
            else:
                asalMi.append(True)
                break
    return asalMi
    pass