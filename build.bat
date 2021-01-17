mkdir LaboratoryAnimalHousing
xcopy src\main\webapp LaboratoryAnimalHousing /E/H/C/I/Y
call mvn clean
call mvn compile dependency:copy-dependencies
xcopy target\dependency LaboratoryAnimalHousing\WEB-INF\lib /E/H/C/I/Y
xcopy target\classes LaboratoryAnimalHousing\WEB-INF\classes /E/H/C/I/Y
xcopy src\main\resources LaboratoryAnimalHousing\WEB-INF\classes /E/H/C/I/Y
pause