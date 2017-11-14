for t in 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 
do
sed -i -r -e "15s/t:=.*\;/t:=$t\;/g" demand.zpl 
scip -f s_$t.zpl > t$t.txt
e=`grep "^e#$t" t$t.txt | awk '{print $2 }'`
d=`grep "^d#$t+1" t$t.txt | awk '{print $2}'`
if [ -z "$e" ]
then 	
	e=0
fi
if [ -z "$d" ]
then 	
	d=0
fi
sed -r -e "'$t-1's/0$/'$e'/g" sofars.txt
sed -i '$a\'$t' '$d'' sofars.txt



sed -r -e "$ts/$3/$e" sofars.txt > sofars.txt
sed -r -e "$t+1s/$2/$d" sofars.txt > sofars.txt
#sed '$ c\$1=$t+1,$2=$d' 

done 
