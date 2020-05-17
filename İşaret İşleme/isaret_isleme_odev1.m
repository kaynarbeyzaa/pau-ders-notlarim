%%Soru1-1
y_0_1=dsolve("D2y+3*Dy+2*y=0","y(0)=0","Dy(0)=-5","t")
yt_1=inline(y_0_1) 
figure
fplot(yt_1,[0 30])


%%Soru1-2
y_0_2=dsolve("D2y+4*Dy+40*y=0","y(0)=2","Dy(0)=16.78","t") 
yt_2=inline(y_0_2)
figure
fplot(yt_2,[0 30]) 

%%--

%%Soru2-1
[y, fs] = audioread('laughter.wav');
soundsc(y, fs_1);
spectrogram(y,fs_1)

%%Soru2-2
[y, fs] = audioread('laughter.wav');
fs_2=fs./2
soundsc(y,fs_2)
spectrogram(y,fs_2)

%%Soru2-3
[y, fs] = audioread('laughter.wav');
fs_3 = fs .*2
soundsc(y,fs_3)
spectrogram(y,fs_3)

%%Soru2-4
[y, fs] = audioread('laughter.wav');
fs_4 = fs .* 5
soundsc(y,fs_4)
spectrogram(y,fs_4)