
toplam = 0

while 1
  girdi = gets.chomp
  if girdi == ""
    break
  end
  begin
    girdi2 = Float(girdi)
    girdi = Integer(girdi2)

    araToplam = (1000/girdi)
    toplam = toplam + araToplam

  rescue ZeroDivisionError
  rescue ArgumentError
  end
end

puts toplam
