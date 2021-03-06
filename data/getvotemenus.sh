#!/bin/bash

#### If in need of forceful/inconsiderate scraping - use this as your .wgetrc ####
#robots = off
#referer = "http://www.google.com"
#user_agent = "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.6) Gecko/20070725 Firefox/2.0.0.6"
#header = "Accept:text/xml,application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5"
#header = "Accept-Language: en-us,en;q=0.5"
#header = "Accept-Encoding: gzip,deflate"
#header = "Accept-Charset: ISO-8859-1,utf-8;q=0.7,*;q=0.7"
#header = "Keep-Alive: 300" "$@"

#Play nice
#wait = 3
#random_wait = on
#reject = .cgi
#### End .wgetrc ####

for roleCall in {101..112}
do
	#wget -l3 -A '.xml,.htm,.html' -r -Nc $URL
	wget -P votemenus "http://www.senate.gov/legislative/LIS/roll_call_lists/vote_menu_${roleCall}_1.xml"
	wget -P votemenus "http://www.senate.gov/legislative/LIS/roll_call_lists/vote_menu_${roleCall}_2.xml"
done
