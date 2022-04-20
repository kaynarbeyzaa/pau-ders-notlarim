
player1 = gets.chomp
player2 = gets.chomp

durum1 = 'taş'
durum2 = 'kağıt'
durum3 = 'makas'

if player1 ==durum1

  if player2 == durum1
    puts "berabere"

  elsif player2 == durum2
    puts "ikinci oyuncu kazandı"

  else
    puts "birinci oyuncu kazandı"
  end
end

if player1 ==durum2

  if player2 == durum1
    puts "birinci oyuncu kazandı"

  elsif player2 == durum2
    puts "berabere"

  else
    puts "ikinci oyuncu kazandı"
  end
end

if player1 ==durum3

  if player2 == durum1
    puts "ikinci oyuncu kazandı"

  elsif player2 == durum2
    puts "birinci oyuncu kazandı"

  else
    puts "berabere"
  end
end

