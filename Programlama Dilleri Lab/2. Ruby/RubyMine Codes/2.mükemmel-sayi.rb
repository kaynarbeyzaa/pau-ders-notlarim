
girdi = gets.chomp
girdi = girdi.to_i #girdiyi int değere -sayıya- dönüştürme : dönüştürülmez ise döngü çalışmıyor

tamBolenler = 0

for i in 1..(girdi-1)
  if girdi % i == 0
    tamBolenler += i
    puts tamBolenler
  end
end

if tamBolenler==girdi
  puts "mükemmel"
else
  puts "mükemmel değil"
end