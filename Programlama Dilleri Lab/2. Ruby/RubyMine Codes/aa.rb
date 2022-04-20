array=Array.new
names=Array.new
numbers=Array.new
hash=Hash.new
while true
  o1=gets.to_s

  if o1.length <= 2
    break
  end
  array<<o1
end

for i in 0...array.length
  array[i]=array[i].split(/ /)
end

for i in 0...array.length
  if array[i].length==5
    for j in 0...array[i].length-4
      names.push(array[i][j])
    end
  elsif array[i].length==6
    str=""
    str=array[i][0]+" "+array[i][1]
    names.push(str)
  end
end
for i in 0...array.length-1
  a=0
  for j in array[i].length-4...array[i].length
    array[i][j]=array[i][j].to_f
    a=a+array[i][j]
  end
  a=a/4
  numbers.push(a)
end

sonGirdi = array[array.length-1].to_s
sonGirdi = sonGirdi.gsub('[','')
sonGirdi = sonGirdi.gsub(']','')
sonGirdi = sonGirdi.gsub('\\n','')
sonGirdi = sonGirdi.gsub('"','')
sonGirdi = sonGirdi.gsub(',','')

index = names.index(sonGirdi)
ort = numbers.values_at(index)
puts ort[0]


