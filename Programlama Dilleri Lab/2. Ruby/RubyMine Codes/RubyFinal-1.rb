
ogrenciler = Hash.new

while 1
  girdi = gets.to_s
  if girdi == ""
    break
  end
  girdi = girdi&.split(" ")

  if girdi.length == 5
    begin
      notOrtalaması = ((girdi[1].to_f+girdi[2].to_f+girdi[3].to_f+girdi[4].to_f)/4)
      ogrenciler[girdi[0]] = notOrtalaması
    rescue ArgumentError
    end
  elsif girdi.length == 6
    begin
      notOrtalaması = ((girdi[2].to_f+girdi[3].to_f+girdi[4].to_f+girdi[5].to_f)/4)
      ogrenciler[girdi[0]+" "+girdi[1]] = notOrtalaması
    rescue ArgumentError
    end
  elsif girdi.length == 1
    puts ogrenciler.values_at(girdi[0])
  elsif girdi.length == 2
    puts ogrenciler.values_at(girdi[0]+" "+girdi[1])
  end
end
