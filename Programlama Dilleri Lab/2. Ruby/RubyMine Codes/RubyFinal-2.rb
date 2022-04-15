
girdi = gets.chomp

if girdi[0].to_i == 4 or girdi[0].to_i == 5 or girdi[0].to_i == 6
  if girdi.include? "-"
    girdi = girdi.split("-")
    if girdi.length == 4
      toplamHaneSayisi = girdi[0].length + girdi[1].length + girdi[2].length + girdi[3].length
      if girdi[0].length == 4 && girdi[1].length == 4  && girdi[2].length == 4  && girdi[3].length == 4
        yeniGirdi = girdi[0]+girdi[1]+girdi[2]+girdi[3]
        i=0; j=i+1; k=j+1; l=k+1
        12.times do
          if yeniGirdi[i] == yeniGirdi[j] && yeniGirdi[i] == yeniGirdi[k] && yeniGirdi[i] == yeniGirdi[l]
            puts "Geçersiz"
            break
          else
            puts "Geçerli"
            break
          end
        end
      elsif toplamHaneSayisi != 16
        puts "Geçersiz"
      end
      else
      puts "Geçersiz"
    end
  elsif girdi.include? " "
    puts "Geçersiz"
  elsif girdi.length != 16
    puts "Geçersiz"
  else
    puts "Geçerli"
  end
else
  puts "Geçersiz"
end