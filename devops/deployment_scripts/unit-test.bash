mvn test
export exitCode=$?
if [ $exitCode -eq 1 ]
then
  exit 1
fi
export coverage=$(awk -F, '{ instructions += $4 + $5; covered += $5 } END { print 100*covered/instructions }' target/site/jacoco/jacoco.csv)
echo ${coverage%.*} '% covered'
