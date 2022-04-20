
liste_1 = Array.new
liste_2 = Array.new

while 1
  girdi = gets.chomp.to_s
  if girdi == ''
    break
  elsif girdi.start_with?('x')
    liste_1.insert(0, girdi)
  else
    liste_2.insert(0, girdi)
  end
end

puts liste_1.sort
puts liste_2.sort