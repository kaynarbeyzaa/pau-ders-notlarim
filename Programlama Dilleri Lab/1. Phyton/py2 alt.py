
girdi = input()

sozluk = dict()

for i in range(0, len(girdi)):
    if girdi[i] in sozluk:
            sozluk[girdi[i]] = (girdi[i], sozluk[girdi[i]][1]+1)
    else:
            sozluk[girdi[i]] = (girdi[i], 1)

oSozluk = sorted(sozluk.values(),key=lambda x:(-x[1],x[0]))

print(list(map(lambda x: x[0]+' '+str(x[1]), oSozluk[:3])))
