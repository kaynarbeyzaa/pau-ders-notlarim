def ters_faktoryel(girdi)

  Integer(girdi)
  cevap = 1
  if girdi>=0
    for i in 1..(girdi/2)
      cevap=cevap*i
      if cevap==girdi
        return i;
        break
      elsif cevap>girdi
        return raise ArgumentError
        break
      end
    end
  else
    #puts "0'dan küçük sayının faktöriyeli alınamaz"
    return 0
  end
end


def bak_ve_soyle(baslangicDegeri, tekrarSayisi)
  Integer(tekrarSayisi)
  tekrarSayisi = (tekrarSayisi - 1)
  times = 1
  tekrarSayisi.times do
    result = ""
    ilk = baslangicDegeri[0]
    baslangicDegeri = baslangicDegeri[1..-1]+" "
    baslangicDegeri.chars.each do |char|
      if(ilk!=char)
        result+= times.to_s+c
        times = 1
        ilk = char
      else
        times+=1
      end
    end
    baslangicDegeri = result
  end
  return baslangicDegeri
end

