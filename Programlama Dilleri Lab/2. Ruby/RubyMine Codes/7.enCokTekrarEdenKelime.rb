
girdi =  gets.chomp

girdi = girdi.gsub('.' , '')
girdi = girdi.gsub(',' , '')
girdi = girdi.gsub('\'' , '')
girdi = girdi.gsub('-' , ' ')

girdi = girdi.downcase.split(" ")
girdi.pop()

sozluk = Hash.new

for i in 0..girdi.length
  sozluk[girdi[i]] = girdi.count(girdi[i])
end

kelimeler = Array.new
tekrar_sayisi = Array.new

sozluk.each do |key, value|
  kelimeler.push(key)
  value = sozluk[key]
  tekrar_sayisi.push(value)
end

sozluk = sozluk.sort_by { |key, value | -value }

adim = 0
sozluk.each do |key, value|
  puts "#{key} #{value}"
  adim+=1
  if adim == 5
    break
  end
end

elsif array[i].length==1
names.push(array[i][j])
elsif array[i].length==2
str=""
str=array[i][0]+" "+array[i][1]
names.push(str)