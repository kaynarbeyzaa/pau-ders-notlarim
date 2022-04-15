
girdi = gets.chomp

for i in 1..girdi.length

  if girdi[0] == girdi[i]
    girdi[i] = '*'
    else i+=1
  end
end

puts girdi
