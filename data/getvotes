#!/bin/bash

#http://www.senate.gov/legislative/LIS/roll_call_votes/vote1122/vote_112_2_00200.xml
#http://www.senate.gov/legislative/LIS/roll_call_votes/vote1011/vote_101_1_00312.xml
#http://www.senate.gov/legislative/LIS/roll_call_votes/vote1012/vote_101_2_0007.xml

RECORDS=`cat records`

for record in $RECORDS; do
	role=`echo $record | awk -F ',' '{print $1}'`
	nvotes=`echo $record | awk -F ',' '{print $2}'`
	echo $role
	for vote in $(seq ${nvotes}); do
		code=$vote
		
		if [[ $vote -lt 10 ]]; then
			code=0${code}
		fi

		if [[ $vote -lt 100 ]]; then
			code=0${code}
		fi
		wget -P ${role} "http://www.senate.gov/legislative/LIS/roll_call_votes/vote${role}1/vote_${role}_1_00${code}.xml"
		wget -P ${role} "http://www.senate.gov/legislative/LIS/roll_call_votes/vote${role}2/vote_${role}_2_00${code}.xml"
	done
done
