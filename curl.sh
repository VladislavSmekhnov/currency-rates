#!/bin/bash

# Define a function to check and delete the output data file
check_file () {
  # Check if the output data file already exists
  if [ -f "$1" ]; then
    # If it does, delete it
    rm $1
  fi
}

date=$1
output_data_file=data.xml

# Call the function to check and delete the output data file
check_file $output_data_file

# Reformat the date from "YYYY-MM-DD" to "dd/mm/yyyy"
date=$(date -d $date +"%d/%m/%Y")

curl -o $output_data_file https://www.cbr.ru/scripts/XML_daily.asp?date_req=$date &> app.log
