
girdi = gets.chomp
girdi = girdi.to_i

adım = 0

while girdi != 1
  if girdi % 2 == 0
    girdi = girdi / 2
  else
    girdi = girdi * 3 + 1
  end
  adım+=1
end

puts adım
